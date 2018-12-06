package edu.cnm.deepdive.join_me_backend.controller;


import edu.cnm.deepdive.join_me_backend.model.dao.InvitationRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.PersonRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Invitation;
import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Person.class)
@RequestMapping("/people")
public class PersonController {

  private InvitationRepository invitationRepository;
  private PersonRepository personRepository;
  private SquareRepository squareRepository;
  private VertexRepository vertexRepository;
  public static double SOUTH_LAT_LINE = 35.0859000; //farthest south
  public static double MIDDLE_LAT_LINE = 35.0860000; //middle
  public static double NORTH_LAT_LINE = 35.0861000; //farthest north
  public static double EAST_LONG_LINE = -106.6494000; //farthest east
  public static double MIDDLE_LONG_LINE = -106.6495000; //middle
  public static double WEST_LONG_LINE = -106.6496000; //farthest west

  @Autowired
  public PersonController(
      InvitationRepository invitationRepository,
      PersonRepository personRepository,
      SquareRepository squareRepository,
      VertexRepository vertexRepository) {
    this.invitationRepository = invitationRepository;
    this.personRepository = personRepository;
    this.squareRepository = squareRepository;
    this.vertexRepository = vertexRepository;
  }

  //
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> list() {
    return personRepository.findAll();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Person> post(@RequestBody Person person) {
    person.setClosestVertex(vertexRepository.findAll().get(0));
    long personId = personRepository.save(person).getPersonId();
    updateUser(person, personId);
    return ResponseEntity.created(person.getHref()).body(person);
  }

  @GetMapping(value = "{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Person get(@PathVariable("personId") long personId) {
    return personRepository.findById(personId).get();
  }

  @PutMapping(value = "{personId}")
  public ResponseEntity<Person> updatePerson(@RequestBody Person person,
      @PathVariable("personId") long personId) {
    Optional<Person> personOptional = personRepository.findById(personId);
    if (!personOptional.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    person.setPersonId(personId);
    personRepository.save(person);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "{personId}")
  public void deletePerson(@PathVariable("personId") long personId) {
    personRepository.deleteById(personId);
  }

  @GetMapping(value = "{personId}/invitations", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Invitation> getAllInvitationsPerPerson(@PathVariable("personId") long personId) {
//    return personRepository.findById(personId).get().getInvitations();

    Optional<Person> personOptional = personRepository.findById(personId);
    if (personOptional.isPresent()) {
      List<Invitation> tempInvites = personOptional.get().getInvitations();
      List<Invitation> toDeliver = new LinkedList<>();
      for (Invitation invitation :
          tempInvites) {
        if (!invitation.getWasDelivered()) {
          toDeliver.add(invitation);
          invitation.setWasDelivered(true);
        }
      }
      personOptional.get().setInvitations(tempInvites);
      personRepository.save(personOptional.get());
      return toDeliver;
    }
    return new LinkedList<>();
  }

  @GetMapping(value = "{personId}/invitations/{invitationId}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  public Invitation getInvitationPerPerson(@PathVariable("invitationId") long invitationId) {
    return invitationRepository.findById(invitationId).get();
  }

  @PostMapping(value = "{personId}/invitations", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Invitation> addInvitation(@PathVariable("personId") long personId,
      @RequestBody Invitation invitation) {
    Optional<Person> personOptional = personRepository.findById(personId);
    if (!personOptional.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    List<Invitation> tempInvites = personOptional.get().getInvitations();
    tempInvites.add(invitation);
    personOptional.get().setInvitations(tempInvites);
    personRepository.save(personOptional.get());
    return ResponseEntity.created(invitation.getHref()).body(invitation);
  }

  @PutMapping(value = "{personId}/invitations/{invitationId}")
  public ResponseEntity<Invitation> updateInvitation(
      @PathVariable("invitationId") long invitationId) {
    Optional<Invitation> invitationOptional = invitationRepository.findById(invitationId);
    if (invitationOptional.isPresent()) {
      invitationOptional.get().setWillAttend(true);
      invitationRepository.save(invitationOptional.get());
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

//  @DeleteMapping(value = "{personId}/invitations/{invitationId}")
//  public void deleteInvitation(@PathVariable("invitationId") long invitationId){
//    Optional<Invitation> invitationOptional = invitationRepository.findById(invitationId);
//
//    if (invitationOptional.isPresent() ){
//      invitationRepository.deleteById(invitationId);
//    }
//  }

  @GetMapping(value = "{personId}/people", consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Person> getPeopleNearby(@RequestBody Person requesterUser,
      @PathVariable("personId") long personId) {
    Optional<Person> personOptional = personRepository.findById(personId);
    if (personOptional.isPresent()) {
      updateUser(requesterUser, personId);
      List<Person> tempPersons = new LinkedList<>();
      List<Square> tempSquare = personOptional.get().getClosestVertex().getSquares();
      for (Square square :
          tempSquare) {
        tempPersons.addAll(square.getPeople());
      }
      return tempPersons;
    }
    return new LinkedList<>();
  }

//  @PutMapping(value = "{personId}/people", consumes = MediaType.APPLICATION_JSON_VALUE,
//      produces = MediaType.APPLICATION_JSON_VALUE)
//  public List<Person> getPeopleNearby(@RequestBody Person requesterUser,
//      @PathVariable("personId") long personId) {
//    Optional<Person> personOptional = personRepository.findById(personId);
//    if (personOptional.isPresent()) {
//      updateUser(requesterUser, personId);
//      List<Person> tempPersons = new LinkedList<>();
//      List<Square> tempSquare = personOptional.get().getClosestVertex().getSquares();
//      for (Square square :
//          tempSquare) {
//        tempPersons.addAll(square.getPeople());
//      }
//      return tempPersons;
//    }
//    return new LinkedList<>();
//  }

  private void updateUser(Person requesterUser, long personId) {
    requesterUser.setPersonId(personId);
//    personRepository.save(requesterUser);
    updateCurrentSquare(requesterUser);
  }

  private void addToSquare(Person requesterUser) {
//    if (requesterUser.getCurrentSquareId() != 0) {
//      if(!squareRepository.findById(requesterUser.getCurrentSquareId()).get().getPeople().contains(requesterUser)){
//        squareRepository.findById(requesterUser.getCurrentSquareId()).get().getPeople()
//            .add(requesterUser);
//      }
//    }
  }

  private void removeFromSquare(Person requesterUser) {
    Square toRemove = requesterUser.getCurrentSquare();
    requesterUser.setCurrentSquare(null);
  }

  private void updateCurrentSquare(Person requesterUser) {
    int row = 0;
    int col = 0;
    int squareInt = 1;
    double latitude = requesterUser.getLatitude();
    double longitude = requesterUser.getLongitude();
    if (latitude < SOUTH_LAT_LINE) {
      row = 0;
    } else if (latitude < MIDDLE_LAT_LINE) {
      row = 1;
    } else if (latitude < NORTH_LAT_LINE) {
      row = 2;
    } else {
      row = 3;
    }
    if (longitude > EAST_LONG_LINE) {
      col = 4;
    } else if (longitude > MIDDLE_LONG_LINE) {
      col = 3;
    } else if (longitude > WEST_LONG_LINE) {
      col = 2;
    } else {
      col = 1;
    }
    squareInt = 1 * col + 4 * row;

    switch (squareInt) {
      case 1:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_1_ID).get());
        requesterUser
            .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_1_ID).get());
        break;
      case 2:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_2_ID).get());
        if (isLeftOfMid(requesterUser, requesterUser.getCurrentSquare())) {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_1_ID).get());
        } else {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_2_ID).get());
        }
        break;
      case 3:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_3_ID).get());
        if (isLeftOfMid(requesterUser, requesterUser.getCurrentSquare())) {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_2_ID).get());
        } else {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_3_ID).get());
        }
        break;
      case 4:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_4_ID).get());
        requesterUser
            .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_3_ID).get());
        break;
      case 5:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_5_ID).get());
        if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_4_ID).get());
        } else {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_1_ID).get());
        }
        break;
      case 6:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_6_ID).get());
        if (isLeftOfMid(requesterUser, requesterUser.getCurrentSquare())) {
          if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_4_ID).get());
          } else {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_1_ID).get());
          }
        } else {
          if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_5_ID).get());
          } else {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_2_ID).get());
          }
        }
        break;
      case 7:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_7_ID).get());
        if (isLeftOfMid(requesterUser, requesterUser.getCurrentSquare())) {
          if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_5_ID).get());
          } else {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_2_ID).get());
          }
        } else {
          if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_6_ID).get());
          } else {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_3_ID).get());
          }
        }
        break;
      case 8:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_8_ID).get());
        if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_6_ID).get());
        } else {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_3_ID).get());
        }
        break;
      case 9:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_9_ID).get());
        if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_7_ID).get());
        } else {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_4_ID).get());
        }
        break;
      case 10:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_10_ID).get());
        if (isLeftOfMid(requesterUser, requesterUser.getCurrentSquare())) {
          if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_7_ID).get());
          } else {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_4_ID).get());
          }
        } else {
          if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_8_ID).get());
          } else {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_5_ID).get());
          }
        }
        break;
      case 11:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_11_ID).get());
        if (isLeftOfMid(requesterUser, requesterUser.getCurrentSquare())) {
          if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_8_ID).get());
          } else {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_5_ID).get());
          }
        } else {
          if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_9_ID).get());
          } else {
            requesterUser
                .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_6_ID).get());
          }
        }
        break;
      case 12:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_12_ID).get());
        if (isAboveMid(requesterUser, requesterUser.getCurrentSquare())) {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_9_ID).get());
        } else {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_6_ID).get());
        }
        break;
      case 13:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_13_ID).get());
        requesterUser
            .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_7_ID).get());
        break;
      case 14:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_14_ID).get());
        if (isLeftOfMid(requesterUser, requesterUser.getCurrentSquare())) {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_7_ID).get());
        } else {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_8_ID).get());
        }
        break;
      case 15:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_15_ID).get());
        if (isLeftOfMid(requesterUser, requesterUser.getCurrentSquare())) {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_8_ID).get());
        } else {
          requesterUser
              .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_9_ID).get());
        }
        break;
      case 16:
        requesterUser.setCurrentSquare(squareRepository.findById(SquareController.BOX_16_ID).get());
        requesterUser
            .setClosestVertex(vertexRepository.findById(VertexController.VERTEX_9_ID).get());
        break;
    }

    personRepository.save(requesterUser);
  }

  private boolean isLeftOfMid(Person person, Square square) {
    return person.getLongitude()
        < (square.getLongitudeUpperBound() - square.getLongitudeLowerBound()) / 2
        + square.getLongitudeLowerBound();
  }

  private boolean isAboveMid(Person person, Square square) {
    return person.getLatitude()
        > (square.getLatitudeUpperBound() - square.getLatitudeLowerBound()) / 2
        + square.getLatitudeLowerBound();
  }

}
