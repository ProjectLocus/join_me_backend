package edu.cnm.deepdive.join_me_backend.controller;

import edu.cnm.deepdive.join_me_backend.model.dao.InvitationRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.PersonRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.util.LinkedList;
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

  private InvitationRepository invitationRepository;
  private PersonRepository personRepository;
  private SquareRepository squareRepository;
  private VertexRepository vertexRepository;

  @Autowired
  public SquareController(InvitationRepository invitationRepository,
      PersonRepository personRepository, SquareRepository squareRepository,
      VertexRepository vertexRepository) {
    this.invitationRepository = invitationRepository;
    this.personRepository = personRepository;
    this.squareRepository = squareRepository;
    this.vertexRepository = vertexRepository;
  }

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Square> list() {
    return squareRepository.findAll();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Square>> post() {
    List<Square> grid = new LinkedList<>();
    Square sq1 = new Square();
    sq1.setId(100001);
    sq1.setLatitudeLowerBound(35.0858000);
    sq1.setLatitudeUpperBound(35.0859000);
    sq1.setLongitudeLowerBound(-106.6497000);
    sq1.setLongitudeUpperBound(-106.6496000);
    grid.add(sq1);

    Square sq2 = new Square();
    sq2.setId(200002);
    sq2.setLatitudeLowerBound(35.0858000);
    sq2.setLatitudeUpperBound(35.0859000);
    sq2.setLongitudeLowerBound(-106.6496000);
    sq2.setLongitudeUpperBound(-106.6495000);
    grid.add(sq2);

    Square sq3 = new Square();
    sq3.setId(300003);
    sq3.setLatitudeLowerBound(35.0858000);
    sq3.setLatitudeUpperBound(35.0859000);
    sq3.setLongitudeLowerBound(-106.6495000);
    sq3.setLongitudeUpperBound(-106.6494000);
    grid.add(sq3);

    Square sq4 = new Square();
    sq4.setId(400004);
    sq4.setLatitudeLowerBound(35.0858000);
    sq4.setLatitudeUpperBound(35.0859000);
    sq4.setLongitudeLowerBound(-106.6494000);
    sq4.setLongitudeUpperBound(-106.6493000);
    grid.add(sq4);

    Square sq5 = new Square();
    sq5.setId(500005);
    sq5.setLatitudeLowerBound(35.0859000);
    sq5.setLatitudeUpperBound(35.0860000);
    sq5.setLongitudeLowerBound(-106.6497000);
    sq5.setLongitudeUpperBound(-106.6496000);
    grid.add(sq5);

    Square sq6 = new Square();
    sq6.setId(600006);
    sq6.setLatitudeLowerBound(35.0859000);
    sq6.setLatitudeUpperBound(35.0860000);
    sq6.setLongitudeLowerBound(-106.6496000);
    sq6.setLongitudeUpperBound(-106.6495000);
    grid.add(sq6);

    Square sq7 = new Square();
    sq7.setId(700007);
    sq7.setLatitudeLowerBound(35.0859000);
    sq7.setLatitudeUpperBound(35.0860000);
    sq7.setLongitudeLowerBound(-106.6495000);
    sq7.setLongitudeUpperBound(-106.6494000);
    grid.add(sq7);

    Square sq8 = new Square();
    sq8.setId(800008);
    sq8.setLatitudeLowerBound(35.0859000);
    sq8.setLatitudeUpperBound(35.0860000);
    sq8.setLongitudeLowerBound(-106.6494000);
    sq8.setLongitudeUpperBound(-106.6493000);
    grid.add(sq8);

    Square sq9 = new Square();
    sq9.setId(900009);
    sq9.setLatitudeLowerBound(35.0860000);
    sq9.setLatitudeUpperBound(35.0861000);
    sq9.setLongitudeLowerBound(-106.6497000);
    sq9.setLongitudeUpperBound(-106.6496000);
    grid.add(sq9);

    Square sq10 = new Square();
    sq10.setId(10000010);
    sq10.setLatitudeLowerBound(35.0860000);
    sq10.setLatitudeUpperBound(35.0861000);
    sq10.setLongitudeLowerBound(-106.6496000);
    sq10.setLongitudeUpperBound(-106.6495000);
    grid.add(sq10);

    Square sq11 = new Square();
    sq11.setId(11000011);
    sq11.setLatitudeLowerBound(35.0860000);
    sq11.setLatitudeUpperBound(35.0861000);
    sq11.setLongitudeLowerBound(-106.6495000);
    sq11.setLongitudeUpperBound(-106.6494000);
    grid.add(sq11);

    Square sq12 = new Square();
    sq12.setId(12000012);
    sq12.setLatitudeLowerBound(35.0860000);
    sq12.setLatitudeUpperBound(35.0861000);
    sq12.setLongitudeLowerBound(-106.6494000);
    sq12.setLongitudeUpperBound(-106.6493000);
    grid.add(sq12);

    Square sq13 = new Square();
    sq13.setId(13000013);
    sq13.setLatitudeLowerBound(35.0861000);
    sq13.setLatitudeUpperBound(35.0862000);
    sq13.setLongitudeLowerBound(-106.6497000);
    sq13.setLongitudeUpperBound(-106.6496000);
    grid.add(sq13);

    Square sq14 = new Square();
    sq14.setId(14000014);
    sq14.setLatitudeLowerBound(35.0861000);
    sq14.setLatitudeUpperBound(35.0862000);
    sq14.setLongitudeLowerBound(-106.6496000);
    sq14.setLongitudeUpperBound(-106.6495000);
    grid.add(sq14);

    Square sq15 = new Square();
    sq15.setId(15000015);
    sq15.setLatitudeLowerBound(35.0861000);
    sq15.setLatitudeUpperBound(35.0862000);
    sq15.setLongitudeLowerBound(-106.6495000);
    sq15.setLongitudeUpperBound(-106.6494000);
    grid.add(sq15);

    Square sq16 = new Square();
    sq16.setId(16000016);
    sq16.setLatitudeLowerBound(35.0861000);
    sq16.setLatitudeUpperBound(35.0862000);
    sq16.setLongitudeLowerBound(-106.6494000);
    sq16.setLongitudeUpperBound(-106.6493000);
    grid.add(sq16);

    squareRepository.saveAll(grid);
    return ResponseEntity.noContent().build();
  }

  @GetMapping(value = "{squareId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Square get(@PathVariable("squareId") int squareId) {
    return squareRepository.findById(squareId).get();
  }

  @Transactional
  @DeleteMapping(value = "{squareId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("squareId") int squareId) {
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
  public List<Vertex> vertexList (@PathVariable("squareId") int squareId) {
    return get(squareId).getVertices();
  }

  @PostMapping(value = "{squareId}/vertices", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Square> postVertex(@PathVariable("squareId") int squareId,
      @RequestBody Vertex partialVertex) {
    Square square = get(squareId);
    Vertex vertex = vertexRepository.findById(partialVertex.getId()).get();
    vertex.getSquares().add(square);
    vertexRepository.save(vertex);
    return ResponseEntity.created(square.getHref()).body(square);
  }

  @DeleteMapping(value = "{squareId}/vertices/{vertexId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteVertex(@PathVariable("squareId") int squareId,
      @PathVariable("vertexId") int vertexId) {
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

  //todo: make a get mapping to return all persons attached to the square

  //todo: make a delete mapping to delete a specific person attached to the square

}
