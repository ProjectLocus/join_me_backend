package edu.cnm.deepdive.join_me_backend.controller;


import edu.cnm.deepdive.join_me_backend.model.dao.InvitationRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.PersonRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import io.swagger.annotations.ApiOperation;
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

  public static final long VERTEX_1_ID =1001L;
  public static final long VERTEX_2_ID =2002L;
  public static final long VERTEX_3_ID =3003L;
  public static final long VERTEX_4_ID =4004L;
  public static final long VERTEX_5_ID =5005L;
  public static final long VERTEX_6_ID =6006L;
  public static final long VERTEX_7_ID =7007L;
  public static final long VERTEX_8_ID =8008L;
  public static final long VERTEX_9_ID =9009L;

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

  @ApiOperation(value = "Gets all vertices.", notes = "Retrieves all vertices in the database.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Vertex> list(){
    return vertexRepository.findAll();
  }

  @ApiOperation(value = "Initializes vertices in a new database.", notes = "Initializes vertices in a new database. This is the second operation that must be performed after wiping a database.  Squares should always be initialized first, and people and invitations should not be added until both squares and vertices are already present (in that order).")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
  produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Vertex> post(){

    try {
      List<Square> adjacentSquares = new LinkedList<>();
      List<Vertex> grid = new LinkedList<>();

      Vertex v1 = new Vertex();
      v1.setLatitude(35.0859000);
      v1.setLongitude(-106.6496000);
      v1.setId(VERTEX_1_ID);
      adjacentSquares.add(squareRepository.findById(100001L).get());
      adjacentSquares.add(squareRepository.findById(200002L).get());
      adjacentSquares.add(squareRepository.findById(500005L).get());
      adjacentSquares.add(squareRepository.findById(600006L).get());
      v1.setSquares(adjacentSquares);
      grid.add(v1);

      adjacentSquares = new LinkedList<>();
      Vertex v2 = new Vertex();
      v2.setLatitude(35.0859000);
      v2.setLongitude(-106.6495000);
      v2.setId(VERTEX_2_ID);
      adjacentSquares.add(squareRepository.findById(300003L).get());
      adjacentSquares.add(squareRepository.findById(200002L).get());
      adjacentSquares.add(squareRepository.findById(700007L).get());
      adjacentSquares.add(squareRepository.findById(600006L).get());
      v2.setSquares(adjacentSquares);
      grid.add(v2);

      adjacentSquares = new LinkedList<>();
      Vertex v3 = new Vertex();
      v3.setLatitude(35.0859000);
      v3.setLongitude(-106.6494000);
      v3.setId(VERTEX_3_ID);
      adjacentSquares.add(squareRepository.findById(300003L).get());
      adjacentSquares.add(squareRepository.findById(400004L).get());
      adjacentSquares.add(squareRepository.findById(700007L).get());
      adjacentSquares.add(squareRepository.findById(800008L).get());
      v3.setSquares(adjacentSquares);
      grid.add(v3);

      adjacentSquares = new LinkedList<>();
      Vertex v4 = new Vertex();
      v4.setLatitude(35.0860000);
      v4.setLongitude(-106.6496000);
      v4.setId(VERTEX_4_ID);
      adjacentSquares.add(squareRepository.findById(500005L).get());
      adjacentSquares.add(squareRepository.findById(600006L).get());
      adjacentSquares.add(squareRepository.findById(900009L).get());
      adjacentSquares.add(squareRepository.findById(10000010L).get());
      v4.setSquares(adjacentSquares);
      grid.add(v4);

      adjacentSquares = new LinkedList<>();
      Vertex v5 = new Vertex();
      v5.setLatitude(35.0860000);
      v5.setLongitude(-106.6495000);
      v5.setId(VERTEX_5_ID);
      adjacentSquares.add(squareRepository.findById(700007L).get());
      adjacentSquares.add(squareRepository.findById(600006L).get());
      adjacentSquares.add(squareRepository.findById(11000011L).get());
      adjacentSquares.add(squareRepository.findById(10000010L).get());
      v5.setSquares(adjacentSquares);
      grid.add(v5);

      adjacentSquares = new LinkedList<>();
      Vertex v6 = new Vertex();
      v6.setLatitude(35.0860000);
      v6.setLongitude(-106.6494000);
      v6.setId(VERTEX_6_ID);
      adjacentSquares.add(squareRepository.findById(700007L).get());
      adjacentSquares.add(squareRepository.findById(800008L).get());
      adjacentSquares.add(squareRepository.findById(11000011L).get());
      adjacentSquares.add(squareRepository.findById(12000012L).get());
      v6.setSquares(adjacentSquares);
      grid.add(v6);

      adjacentSquares = new LinkedList<>();
      Vertex v7 = new Vertex();
      v7.setLatitude(35.0861000);
      v7.setLongitude(-106.6496000);
      v7.setId(VERTEX_7_ID);
      adjacentSquares.add(squareRepository.findById(900009L).get());
      adjacentSquares.add(squareRepository.findById(10000010L).get());
      adjacentSquares.add(squareRepository.findById(13000013L).get());
      adjacentSquares.add(squareRepository.findById(14000014L).get());
      v7.setSquares(adjacentSquares);
      grid.add(v7);

      adjacentSquares = new LinkedList<>();
      Vertex v8 = new Vertex();
      v8.setLatitude(35.0861000);
      v8.setLongitude(-106.6495000);
      v8.setId(VERTEX_8_ID);
      adjacentSquares.add(squareRepository.findById(11000011L).get());
      adjacentSquares.add(squareRepository.findById(10000010L).get());
      adjacentSquares.add(squareRepository.findById(15000015L).get());
      adjacentSquares.add(squareRepository.findById(14000014L).get());
      v8.setSquares(adjacentSquares);
      grid.add(v8);

      adjacentSquares = new LinkedList<>();
      Vertex v9 = new Vertex();
      v9.setLatitude(35.0861000);
      v9.setLongitude(-106.6494000);
      v9.setId(VERTEX_9_ID);
      adjacentSquares.add(squareRepository.findById(11000011L).get());
      adjacentSquares.add(squareRepository.findById(12000012L).get());
      adjacentSquares.add(squareRepository.findById(15000015L).get());
      adjacentSquares.add(squareRepository.findById(16000016L).get());
      v9.setSquares(adjacentSquares);
      grid.add(v9);
      vertexRepository.saveAll(grid);
      return ResponseEntity.noContent().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }

  }

  @ApiOperation(value = "Gets a vertex.", notes = "Retrieves a vertex from the database, according to vertexId.")
  @GetMapping(value = "{vertexId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Vertex get(@PathVariable("vertexId") long vertexId){
    return vertexRepository.findById(vertexId).get();
  }

  @GetMapping(value = "{vertexId}", produces = MediaType.TEXT_HTML_VALUE)
  public String getHTML(@PathVariable("vertexId") long vertexId){
    return "<html><body>" + vertexRepository.findById(vertexId).get().getId() + "</body></html>";
  }

  @ApiOperation(value = "Deletes a vertex.", notes = "Deletes a vertex, according to vertexId.")
  @DeleteMapping(value = "{vertexId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable("vertexId") long vertexId){
    vertexRepository.deleteById(vertexId);
  }

  @ApiOperation(value = "Gets the squares associated with a vertex.", notes = "Gets the squares associated with a vertex, according to vertexId.")
  @GetMapping(value = "{vertexId}/squares", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Square> squareList(@PathVariable("vertexId") long vertexId) {
    return get(vertexId).getSquares();
  }

  @ApiOperation(value = "Adds squares to a vertex.", notes = "Adds squares to a vertex, according to vertexId.")
  @PostMapping(value = "{vertexId}/squares", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Square> postSquare(@PathVariable("vertexId") long vertexId,
      @RequestBody Vertex partialSquare){
    Square square = squareRepository.findById(partialSquare.getId()).get();
    Vertex vertex = get(vertexId);
    vertex.getSquares().add(square);
    vertexRepository.save(vertex);
    return ResponseEntity.created(square.getHref()).body(square);
  }

  @ApiOperation(value = "Deletes a square from a vertex.", notes = "Deletes a square from a vertex, according to squareId and vertexId.")
  @DeleteMapping(value = "{vertexId}/squares/{squareId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteSquare(@PathVariable("vertexId") long vertexId, @PathVariable("squareId") long squareId){
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

}
