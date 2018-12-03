package edu.cnm.deepdive.join_me_backend.controller;


import edu.cnm.deepdive.join_me_backend.model.dao.InvitationRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.PersonRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.util.List;
import java.util.NoSuchElementException;
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
@ExposesResourceFor(Vertex.class)
@RequestMapping("/vertices")
public class VertexController {

  private InvitationRepository invitationRepository;
  private PersonRepository personRepository;
  private SquareRepository squareRepository;
  private VertexRepository vertexRepository;

  @Autowired
  public VertexController(InvitationRepository invitationRepository,
      PersonRepository personRepository, SquareRepository squareRepository,
      VertexRepository vertexRepository) {
    this.invitationRepository = invitationRepository;
    this.personRepository = personRepository;
    this.squareRepository = squareRepository;
    this.vertexRepository = vertexRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Vertex> list(){
    return vertexRepository.findAll();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
  produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Vertex> post(@RequestBody Vertex vertex){
    vertexRepository.save(vertex);
    return ResponseEntity.created(vertex.getHref()).body(vertex);
  }

  @GetMapping(value = "{vertexId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Vertex get(@PathVariable("vertexId") int vertexId){
    return vertexRepository.findById(vertexId).get();
  }

  @GetMapping(value = "{vertexId}", produces = MediaType.TEXT_HTML_VALUE)
  public String getHTML(@PathVariable("vertexId") int vertexId){
    return "<html><body>" + vertexRepository.findById(vertexId).get().getId() + "</body></html>";
  }

  @DeleteMapping(value = "{vertexId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("vertexId") int vertexId){
    vertexRepository.deleteById(vertexId);
  }

  @GetMapping(value = "{vertexId}/squares", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Square> squareList(@PathVariable("vertexId") int vertexId) {
    return get(vertexId).getSquares();
  }

  @PostMapping(value = "{vertexId}/squares", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Square> postSquare(@PathVariable("vertexId") int vertexId,
      @RequestBody Vertex partialSquare){
    Square square = squareRepository.findById(partialSquare.getId()).get();
    Vertex vertex = get(vertexId);
    vertex.getSquares().add(square);
    vertexRepository.save(vertex);
    return ResponseEntity.created(square.getHref()).body(square);
  }

  @DeleteMapping(value = "{vertexId}/squares/{squareId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteSquare(@PathVariable("vertexId") int vertexId, @PathVariable("squareId") int squareId){
    Vertex vertex = get(vertexId);
    Square square = squareRepository.findById(squareId).get();
    if (vertex.getSquares().remove(square)){
      vertexRepository.save(vertex);
    } else {
      throw new NoSuchElementException();
    }
  }

  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

  //make a get mapping to return all person associated with vertex, by calling the get persons via squares


}
