package edu.cnm.deepdive.join_me_backend.controller;

import edu.cnm.deepdive.join_me_backend.model.dao.InvitationRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.PersonRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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

/**
 * The type Square controller.
 */
@RestController
@ExposesResourceFor(Square.class)
@RequestMapping("/squares")
public class SquareController {

  /**
   * The constant BOX_1_ID.
   */
  public static final long BOX_1_ID =100001L;
  /**
   * The constant BOX_2_ID.
   */
  public static final long BOX_2_ID =200002L;
  /**
   * The constant BOX_3_ID.
   */
  public static final long BOX_3_ID =300003L;
  /**
   * The constant BOX_4_ID.
   */
  public static final long BOX_4_ID =400004L;
  /**
   * The constant BOX_5_ID.
   */
  public static final long BOX_5_ID =500005L;
  /**
   * The constant BOX_6_ID.
   */
  public static final long BOX_6_ID =600006L;
  /**
   * The constant BOX_7_ID.
   */
  public static final long BOX_7_ID =700007L;
  /**
   * The constant BOX_8_ID.
   */
  public static final long BOX_8_ID =800008L;
  /**
   * The constant BOX_9_ID.
   */
  public static final long BOX_9_ID =900009L;
  /**
   * The constant BOX_10_ID.
   */
  public static final long BOX_10_ID =10000010L;
  /**
   * The constant BOX_11_ID.
   */
  public static final long BOX_11_ID =11000011L;
  /**
   * The constant BOX_12_ID.
   */
  public static final long BOX_12_ID =12000012L;
  /**
   * The constant BOX_13_ID.
   */
  public static final long BOX_13_ID =13000013L;
  /**
   * The constant BOX_14_ID.
   */
  public static final long BOX_14_ID =14000014L;
  /**
   * The constant BOX_15_ID.
   */
  public static final long BOX_15_ID =15000015L;
  /**
   * The constant BOX_16_ID.
   */
  public static final long BOX_16_ID =16000016L;

  private InvitationRepository invitationRepository;
  private PersonRepository personRepository;
  private SquareRepository squareRepository;
  private VertexRepository vertexRepository;
  private double longitudeUpperBound = -106.6493000;
  private double longitudeLowerBound = -106.6497000;
  private double latitudeUpperBound = 35.0862000;
  private double latitudeLowerBound = 35.0858000;

  /**
   * Instantiates a new Square controller.
   *
   * @param invitationRepository the invitation repository
   * @param personRepository the person repository
   * @param squareRepository the square repository
   * @param vertexRepository the vertex repository
   */
  @Autowired
  public SquareController(InvitationRepository invitationRepository,
      PersonRepository personRepository, SquareRepository squareRepository,
      VertexRepository vertexRepository) {
    this.invitationRepository = invitationRepository;
    this.personRepository = personRepository;
    this.squareRepository = squareRepository;
    this.vertexRepository = vertexRepository;
  }

  /**
   * Gets all squares.
   *
   * @return the list
   */
  @ApiOperation(value = "Gets all squares.", notes = "Retrieves all squares in the database.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Square> list() {
    return squareRepository.findAll();
  }

  /**
   * Initializes the grid with squares.
   *
   * @return the response entity
   */
  @ApiOperation(value = "Initializes squares.", notes = "Causes pre-set squares to be added to the database. After a database wipe, this must be the first thing added to a new database.")
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<List<Square>> post() {
    List<Square> grid = new LinkedList<>();
    Square sq1 = new Square();
    sq1.setId(BOX_1_ID);
    sq1.setLatitudeLowerBound(latitudeLowerBound);
    sq1.setLatitudeUpperBound(PersonController.SOUTH_LAT_LINE);
    sq1.setLongitudeLowerBound(longitudeLowerBound);
    sq1.setLongitudeUpperBound(PersonController.WEST_LONG_LINE);
    grid.add(sq1);

    Square sq2 = new Square();
    sq2.setId(BOX_2_ID);
    sq2.setLatitudeLowerBound(latitudeLowerBound);
    sq2.setLatitudeUpperBound(PersonController.SOUTH_LAT_LINE);
    sq2.setLongitudeLowerBound(PersonController.WEST_LONG_LINE);
    sq2.setLongitudeUpperBound(PersonController.MIDDLE_LONG_LINE);
    grid.add(sq2);

    Square sq3 = new Square();
    sq3.setId(BOX_3_ID);
    sq3.setLatitudeLowerBound(latitudeLowerBound);
    sq3.setLatitudeUpperBound(PersonController.SOUTH_LAT_LINE);
    sq3.setLongitudeLowerBound(PersonController.MIDDLE_LONG_LINE);
    sq3.setLongitudeUpperBound(PersonController.EAST_LONG_LINE);
    grid.add(sq3);

    Square sq4 = new Square();
    sq4.setId(BOX_4_ID);
    sq4.setLatitudeLowerBound(latitudeLowerBound);
    sq4.setLatitudeUpperBound(PersonController.SOUTH_LAT_LINE);
    sq4.setLongitudeLowerBound(PersonController.EAST_LONG_LINE);
    sq4.setLongitudeUpperBound(longitudeUpperBound);
    grid.add(sq4);

    Square sq5 = new Square();
    sq5.setId(BOX_5_ID);
    sq5.setLatitudeLowerBound(PersonController.SOUTH_LAT_LINE);
    sq5.setLatitudeUpperBound(PersonController.MIDDLE_LAT_LINE);
    sq5.setLongitudeLowerBound(longitudeLowerBound);
    sq5.setLongitudeUpperBound(PersonController.WEST_LONG_LINE);
    grid.add(sq5);

    Square sq6 = new Square();
    sq6.setId(BOX_6_ID);
    sq6.setLatitudeLowerBound(PersonController.SOUTH_LAT_LINE);
    sq6.setLatitudeUpperBound(PersonController.MIDDLE_LAT_LINE);
    sq6.setLongitudeLowerBound(PersonController.WEST_LONG_LINE);
    sq6.setLongitudeUpperBound(PersonController.MIDDLE_LONG_LINE);
    grid.add(sq6);

    Square sq7 = new Square();
    sq7.setId(BOX_7_ID);
    sq7.setLatitudeLowerBound(PersonController.SOUTH_LAT_LINE);
    sq7.setLatitudeUpperBound(PersonController.MIDDLE_LAT_LINE);
    sq7.setLongitudeLowerBound(PersonController.MIDDLE_LONG_LINE);
    sq7.setLongitudeUpperBound(PersonController.EAST_LONG_LINE);
    grid.add(sq7);

    Square sq8 = new Square();
    sq8.setId(BOX_8_ID);
    sq8.setLatitudeLowerBound(PersonController.SOUTH_LAT_LINE);
    sq8.setLatitudeUpperBound(PersonController.MIDDLE_LAT_LINE);
    sq8.setLongitudeLowerBound(PersonController.EAST_LONG_LINE);
    sq8.setLongitudeUpperBound(longitudeUpperBound);
    grid.add(sq8);

    Square sq9 = new Square();
    sq9.setId(BOX_9_ID);
    sq9.setLatitudeLowerBound(PersonController.MIDDLE_LAT_LINE);
    sq9.setLatitudeUpperBound(PersonController.NORTH_LAT_LINE);
    sq9.setLongitudeLowerBound(longitudeLowerBound);
    sq9.setLongitudeUpperBound(PersonController.WEST_LONG_LINE);
    grid.add(sq9);

    Square sq10 = new Square();
    sq10.setId(BOX_10_ID);
    sq10.setLatitudeLowerBound(PersonController.MIDDLE_LAT_LINE);
    sq10.setLatitudeUpperBound(PersonController.NORTH_LAT_LINE);
    sq10.setLongitudeLowerBound(PersonController.WEST_LONG_LINE);
    sq10.setLongitudeUpperBound(PersonController.MIDDLE_LONG_LINE);
    grid.add(sq10);

    Square sq11 = new Square();
    sq11.setId(BOX_11_ID);
    sq11.setLatitudeLowerBound(PersonController.MIDDLE_LAT_LINE);
    sq11.setLatitudeUpperBound(PersonController.NORTH_LAT_LINE);
    sq11.setLongitudeLowerBound(PersonController.MIDDLE_LONG_LINE);
    sq11.setLongitudeUpperBound(PersonController.EAST_LONG_LINE);
    grid.add(sq11);

    Square sq12 = new Square();
    sq12.setId(BOX_12_ID);
    sq12.setLatitudeLowerBound(PersonController.MIDDLE_LAT_LINE);
    sq12.setLatitudeUpperBound(PersonController.NORTH_LAT_LINE);
    sq12.setLongitudeLowerBound(PersonController.EAST_LONG_LINE);
    sq12.setLongitudeUpperBound(longitudeUpperBound);
    grid.add(sq12);

    Square sq13 = new Square();
    sq13.setId(BOX_13_ID);
    sq13.setLatitudeLowerBound(PersonController.NORTH_LAT_LINE);
    sq13.setLatitudeUpperBound(latitudeUpperBound);
    sq13.setLongitudeLowerBound(longitudeLowerBound);
    sq13.setLongitudeUpperBound(PersonController.WEST_LONG_LINE);
    grid.add(sq13);

    Square sq14 = new Square();
    sq14.setId(BOX_14_ID);
    sq14.setLatitudeLowerBound(PersonController.NORTH_LAT_LINE);
    sq14.setLatitudeUpperBound(latitudeUpperBound);
    sq14.setLongitudeLowerBound(PersonController.WEST_LONG_LINE);
    sq14.setLongitudeUpperBound(PersonController.MIDDLE_LONG_LINE);
    grid.add(sq14);

    Square sq15 = new Square();
    sq15.setId(BOX_15_ID);
    sq15.setLatitudeLowerBound(PersonController.NORTH_LAT_LINE);
    sq15.setLatitudeUpperBound(latitudeUpperBound);
    sq15.setLongitudeLowerBound(PersonController.MIDDLE_LONG_LINE);
    sq15.setLongitudeUpperBound(PersonController.EAST_LONG_LINE);
    grid.add(sq15);

    Square sq16 = new Square();
    sq16.setId(BOX_16_ID);
    sq16.setLatitudeLowerBound(PersonController.NORTH_LAT_LINE);
    sq16.setLatitudeUpperBound(latitudeUpperBound);
    sq16.setLongitudeLowerBound(PersonController.EAST_LONG_LINE);
    sq16.setLongitudeUpperBound(longitudeUpperBound);
    grid.add(sq16);

    squareRepository.saveAll(grid);
    return ResponseEntity.noContent().build();
  }

  /**
   * Gets a square.
   *
   * @param squareId the square id
   * @return the square
   */
  @ApiOperation(value = "Gets a square.", notes = "Retrieves a square according to squareId.")
  @GetMapping(value = "{squareId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Square get(@ApiParam(value = "Id for the square.", required = true)@PathVariable("squareId") long squareId) {
    return squareRepository.findById(squareId).get();
  }

  /**
   * Deletes a square.
   *
   * @param squareId the square id
   */
  @ApiOperation(value = "Deletes a square.", notes = "Deletes a square according to squareId.")
  @Transactional
  @DeleteMapping(value = "{squareId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@ApiParam(value = "Id for the square.", required = true)@PathVariable("squareId") long squareId) {
    Square square = get(squareId);
    List<Vertex> vertices = square.getVertices();
    for (Vertex vertex : vertices) {
      vertex.getSquares().remove(square);
    }
    vertexRepository.saveAll(vertices);
    squareRepository.delete(square);
  }

  /**
   * Get vertices associated with a square.
   *
   * @param squareId the square id
   * @return the list
   */
  @ApiOperation(value = "Gets vertices associated with a square.", notes = "Retrieves the vertices associated with a squareId.")
  @GetMapping("{squareId}/vertices")
  public List<Vertex> vertexList (@ApiParam(value = "Id for the square.", required = true)@PathVariable("squareId") long squareId) {
    return get(squareId).getVertices();
  }

  /**
   * Adds square to a vertex.
   *
   * @param squareId the square id
   * @param partialVertex the partial vertex
   * @return the response entity
   */
  @ApiOperation(value = "Adds square to vertex.", notes = "Adds the square, by squareId, to the passed vertex.")
  @PostMapping(value = "{squareId}/vertices", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Square> postVertex(@ApiParam(value = "Id for the square.", required = true)@PathVariable("squareId") long squareId,
      @ApiParam(value = "Vertex object.", required = true)@RequestBody Vertex partialVertex) {
    Square square = get(squareId);
    Vertex vertex = vertexRepository.findById(partialVertex.getId()).get();
    vertex.getSquares().add(square);
    vertexRepository.save(vertex);
    return ResponseEntity.created(square.getHref()).body(square);
  }

  /**
   * Delete vertex from a square.
   *
   * @param squareId the square id
   * @param vertexId the vertex id
   */
  @ApiOperation(value = "Removes a vertex from a square.", notes = "Deletes a vertex from a square, according to vertexId and squareId.")
  @DeleteMapping(value = "{squareId}/vertices/{vertexId}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteVertex(@ApiParam(value = "Id for the square.", required = true)@PathVariable("squareId") long squareId,
      @ApiParam(value = "Id for the vertex.", required = true)@PathVariable("vertexId") long vertexId) {
    Square square = get(squareId);
    Vertex vertex = vertexRepository.findById(vertexId).get();
    if (square.getVertices().remove(vertex)){
      squareRepository.save(square);
    }else{
      throw new NoSuchElementException();
    }
  }

  /**
   * Exists to handle Not found errors via annotations.
   */
  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resource not found")
  @ExceptionHandler(NoSuchElementException.class)
  public void notFound() {
  }

}
