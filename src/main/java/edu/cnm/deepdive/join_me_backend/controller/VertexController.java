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
  public ResponseEntity<Vertex> post(){

    try {
      List<Square> adjacentSquares = new LinkedList<>();
      List<Vertex> grid = new LinkedList<>();

      Vertex v1 = new Vertex();
      v1.setLatitude(35.0859000);
      v1.setLongitude(-106.6496000);
      v1.setId(1001);
      adjacentSquares.add(squareRepository.findById(100001).get());
      adjacentSquares.add(squareRepository.findById(200002).get());
      adjacentSquares.add(squareRepository.findById(500005).get());
      adjacentSquares.add(squareRepository.findById(600006).get());
      v1.setSquares(adjacentSquares);
      grid.add(v1);

      adjacentSquares = new LinkedList<>();
      Vertex v2 = new Vertex();
      v2.setLatitude(35.0859000);
      v2.setLongitude(-106.6495000);
      v2.setId(2002);
      adjacentSquares.add(squareRepository.findById(300003).get());
      adjacentSquares.add(squareRepository.findById(200002).get());
      adjacentSquares.add(squareRepository.findById(700007).get());
      adjacentSquares.add(squareRepository.findById(600006).get());
      v2.setSquares(adjacentSquares);
      grid.add(v2);

      adjacentSquares = new LinkedList<>();
      Vertex v3 = new Vertex();
      v3.setLatitude(35.0859000);
      v3.setLongitude(-106.6494000);
      v3.setId(3003);
      adjacentSquares.add(squareRepository.findById(300003).get());
      adjacentSquares.add(squareRepository.findById(400004).get());
      adjacentSquares.add(squareRepository.findById(700007).get());
      adjacentSquares.add(squareRepository.findById(800008).get());
      v3.setSquares(adjacentSquares);
      grid.add(v3);

      adjacentSquares = new LinkedList<>();
      Vertex v4 = new Vertex();
      v4.setLatitude(35.0860000);
      v4.setLongitude(-106.6496000);
      v4.setId(4004);
      adjacentSquares.add(squareRepository.findById(500005).get());
      adjacentSquares.add(squareRepository.findById(600006).get());
      adjacentSquares.add(squareRepository.findById(900009).get());
      adjacentSquares.add(squareRepository.findById(10000010).get());
      v4.setSquares(adjacentSquares);
      grid.add(v4);

      adjacentSquares = new LinkedList<>();
      Vertex v5 = new Vertex();
      v5.setLatitude(35.0860000);
      v5.setLongitude(-106.6495000);
      v5.setId(5005);
      adjacentSquares.add(squareRepository.findById(700007).get());
      adjacentSquares.add(squareRepository.findById(600006).get());
      adjacentSquares.add(squareRepository.findById(11000011).get());
      adjacentSquares.add(squareRepository.findById(10000010).get());
      v5.setSquares(adjacentSquares);
      grid.add(v5);

      adjacentSquares = new LinkedList<>();
      Vertex v6 = new Vertex();
      v6.setLatitude(35.0860000);
      v6.setLongitude(-106.6494000);
      v6.setId(6006);
      adjacentSquares.add(squareRepository.findById(700007).get());
      adjacentSquares.add(squareRepository.findById(800008).get());
      adjacentSquares.add(squareRepository.findById(11000011).get());
      adjacentSquares.add(squareRepository.findById(12000012).get());
      v6.setSquares(adjacentSquares);
      grid.add(v6);

      adjacentSquares = new LinkedList<>();
      Vertex v7 = new Vertex();
      v7.setLatitude(35.0861000);
      v7.setLongitude(-106.6496000);
      v7.setId(7007);
      adjacentSquares.add(squareRepository.findById(900009).get());
      adjacentSquares.add(squareRepository.findById(10000010).get());
      adjacentSquares.add(squareRepository.findById(13000013).get());
      adjacentSquares.add(squareRepository.findById(14000014).get());
      v7.setSquares(adjacentSquares);
      grid.add(v7);

      adjacentSquares = new LinkedList<>();
      Vertex v8 = new Vertex();
      v8.setLatitude(35.0861000);
      v8.setLongitude(-106.6495000);
      v8.setId(8008);
      adjacentSquares.add(squareRepository.findById(11000011).get());
      adjacentSquares.add(squareRepository.findById(10000010).get());
      adjacentSquares.add(squareRepository.findById(15000015).get());
      adjacentSquares.add(squareRepository.findById(14000014).get());
      v8.setSquares(adjacentSquares);
      grid.add(v8);

      adjacentSquares = new LinkedList<>();
      Vertex v9 = new Vertex();
      v9.setLatitude(35.0861000);
      v9.setLongitude(-106.6494000);
      v9.setId(9009);
      adjacentSquares.add(squareRepository.findById(11000011).get());
      adjacentSquares.add(squareRepository.findById(12000012).get());
      adjacentSquares.add(squareRepository.findById(15000015).get());
      adjacentSquares.add(squareRepository.findById(16000016).get());
      v9.setSquares(adjacentSquares);
      grid.add(v9);
      vertexRepository.saveAll(grid);
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }

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
