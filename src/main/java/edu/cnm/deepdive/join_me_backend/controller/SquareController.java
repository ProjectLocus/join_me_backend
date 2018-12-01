package edu.cnm.deepdive.join_me_backend.controller;



import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.util.List;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Square.class)
@RequestMapping("/squares")
public class SquareController {

//  private InvitationRepository invitationRepository;
//  private PersonRepository personRepository;
  private SquareRepository squareRepository;
  private VertexRepository vertexRepository;

  @Autowired
  public SquareController(

      SquareRepository squareRepository,
      VertexRepository vertexRepository) {
//    this.invitationRepository = invitationRepository;
//    this.personRepository = personRepository;
    this.squareRepository = squareRepository;
    this.vertexRepository = vertexRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Square> list() {
    return squareRepository.findAllByOrderByIdAsc();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Square> post(@RequestBody Square square) {
    squareRepository.save(square);
    return ResponseEntity.created(square.getHref()).body(square);
  }

  @GetMapping(value = "{squareId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Square get(@PathVariable("squareId") long squareId) {
    return squareRepository.findById(squareId).get();
  }

  @Transactional
  @DeleteMapping(value = "{squareId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("squareId") long squareId) {
    Square square = get(squareId);
    List<Vertex> vertices = square.getVertices();
    for (Vertex vertex : vertices) {
      vertex.getSquares().remove(square);
    }
    vertexRepository.saveAll(vertices);
    squareRepository.delete(square);
  }

  // TODONE Add controller method to return list of Student instances for a specified projectId.
  @GetMapping("{squareId}/vertices")
  public List<Vertex> vertexList (@PathVariable("squareId") long squareId) {
    return get(squareId).getVertices();
  }

  @PostMapping(value = "{squareId}/vertices", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Square> postVertex(@PathVariable("squareId") long squareId,
      @RequestBody Vertex partialVertex) {
    Square square = get(squareId);
    Vertex vertex = vertexRepository.findById(partialVertex.getId()).get();
    vertex.getSquares().add(square);
    vertexRepository.save(vertex);
    return ResponseEntity.created(square.getHref()).body(square);
  }

  @DeleteMapping(value = "{squareId}/vertices/{vertexId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteVertex(@PathVariable("squareId") long squareId,
      @PathVariable("vertexId") long vertexId) {
    Square square = get(squareId);
    Vertex vertex = vertexRepository.findById(vertexId).get();
    if (square.getVertices().remove(vertex)){
      squareRepository.save(square);
    }else{
      throw new NoSuchElementException();
    }
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

}
