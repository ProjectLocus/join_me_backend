package edu.cnm.deepdive.join_me_backend.controller;


import edu.cnm.deepdive.join_me_backend.model.dao.InvitationRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.PersonRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Invitation;
import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ExposesResourceFor(Person.class)
@RequestMapping("/people")
public class PersonController {

  private InvitationRepository invitationRepository;
  private PersonRepository personRepository;
  private SquareRepository squareRepository;
  private VertexRepository vertexRepository;
  private double firstLatLine = 35.0859000;
  private double secondLatLine = 35.0860000;
  private double thirdLatLine = 35.0861000;
  private double firstLongLine = -106.6494000;
  private double secondLongLine = -106.6495000;
  private double thirdLongLine = -106.6496000;

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
    //todo: set vertex to person and update position
    person.setClosestVertex(vertexRepository.findAll().get(0));
    personRepository.save(person);
    return ResponseEntity.created(person.getHref()).body(person);
  }

  @GetMapping(value = "{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Person get(@PathVariable("personId") long personId) {
    return personRepository.findById(personId).get();
  }

  @PutMapping(value = "{personId}")
  public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable ("personId") long personId) {
    Optional<Person> personOptional = personRepository.findById(personId);
    if (!personOptional.isPresent()){
      return ResponseEntity.notFound().build();
    }
    person.setId(personId);
    personRepository.save(person);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping(value = "{personId}")
  public void deletePerson(@PathVariable ("personId") long personId){
    personRepository.deleteById(personId);
  }

  @GetMapping(value = "{personId}/invitations", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Invitation> getAllInvitationsPerPerson(@PathVariable ("personId") long personId){
//    return personRepository.findById(personId).get().getInvitations();

    Optional<Person> personOptional = personRepository.findById(personId);
    if (personOptional.isPresent()){
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
  public Invitation getInvitationPerPerson(@PathVariable ("invitationId") long invitationId){
    return invitationRepository.findById(invitationId).get();
  }

  @PostMapping(value = "{personId}/invitations", consumes = MediaType.APPLICATION_JSON_VALUE,
  produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Invitation> addInvitation(@PathVariable("personId") long personId,
      @RequestBody Invitation invitation){
    Optional<Person> personOptional = personRepository.findById(personId);
    if (!personOptional.isPresent()){
      return ResponseEntity.notFound().build();
    }
    List<Invitation> tempInvites = personOptional.get().getInvitations();
    tempInvites.add(invitation);
    personOptional.get().setInvitations(tempInvites);
    personRepository.save(personOptional.get());
    return ResponseEntity.created(invitation.getHref()).body(invitation);
  }

  @PutMapping(value = "{personId}/invitations/{invitationId}")
  public ResponseEntity<Invitation>  updateInvitation(@PathVariable("invitationId") long invitationId){
    Optional<Invitation> invitationOptional = invitationRepository.findById(invitationId);
    if (invitationOptional.isPresent()){
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
      @PathVariable ("personId") long personId){
    Optional<Person> personOptional = personRepository.findById(personId);
    if (personOptional.isPresent() ){
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

  private void updateUser(Person requesterUser, long personId) {
    requesterUser.setId(personId);
    removeFromSquare(requesterUser);
    updateCurrentSquare(requesterUser);
    addToSquare(requesterUser);
    personRepository.save(requesterUser);
  }

  private void addToSquare(Person requesterUser) {
    if(requesterUser.getCurrentSquareId()!=0){
      squareRepository.findById(requesterUser.getCurrentSquareId()).get().getPeople().add(requesterUser);
    }
  }

  private void removeFromSquare(Person requesterUser) {
    if(requesterUser.getCurrentSquareId()!= 0){
      squareRepository.findById(requesterUser.getCurrentSquareId()).get().getPeople().remove(requesterUser);
    }
  }

  private void updateCurrentSquare(Person requesterUser) {
    int row = 0;
    int col = 0;
    int squareInt = 1;
    double latitude = requesterUser.getLatitude();
    double longitude = requesterUser.getLongitude();
    if(latitude< firstLatLine){
      row = 0;
    }else {
      if(latitude< secondLatLine){
        row = 1;
      }else if(latitude< thirdLatLine){
        row = 2;
      }else{
        row = 3;
      }
    }
    if(longitude> firstLongLine){
      col = 4;
    }else if(longitude> secondLongLine){
      col = 3;
    }else if(longitude> thirdLongLine){
      col = 2;
    }else{
      col = 1;
    }
    squareInt = 1*col + 4*row;

    switch(squareInt){
      case 1:
        requesterUser.setCurrentSquareId(100001L);
        requesterUser.setClosestVertex(vertexRepository.findById(1001L).get());
        break;
      case 2:
        requesterUser.setCurrentSquareId(200002L);
        if(isLeftOfMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          requesterUser.setClosestVertex(vertexRepository.findById(1001L).get());
        }else{
          requesterUser.setClosestVertex(vertexRepository.findById(2002L).get());
        }
        break;
      case 3:
        requesterUser.setCurrentSquareId(300003L);
        if(isLeftOfMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          requesterUser.setClosestVertex(vertexRepository.findById(2002L).get());
        }else{
          requesterUser.setClosestVertex(vertexRepository.findById(3003L).get());
        }
        break;
      case 4:
        requesterUser.setCurrentSquareId(400004L);
        requesterUser.setClosestVertex(vertexRepository.findById(3003L).get());
        break;
      case 5:
        requesterUser.setCurrentSquareId(500005L);
        if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          requesterUser.setClosestVertex(vertexRepository.findById(4004L).get());
        }else{
          requesterUser.setClosestVertex(vertexRepository.findById(1001L).get());
        }
        break;
      case 6:
        requesterUser.setCurrentSquareId(600006L);
        if(isLeftOfMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
            requesterUser.setClosestVertex(vertexRepository.findById(4004L).get());
          }else{
            requesterUser.setClosestVertex(vertexRepository.findById(1001L).get());
          }
        }else{
          if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
            requesterUser.setClosestVertex(vertexRepository.findById(5005L).get());
          }else{
            requesterUser.setClosestVertex(vertexRepository.findById(2002L).get());
          }
        }
        break;
      case 7:
        requesterUser.setCurrentSquareId(700007L);
        if(isLeftOfMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
            requesterUser.setClosestVertex(vertexRepository.findById(5005L).get());
          }else{
            requesterUser.setClosestVertex(vertexRepository.findById(2002L).get());
          }
        }else{
          if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
            requesterUser.setClosestVertex(vertexRepository.findById(6006L).get());
          }else{
            requesterUser.setClosestVertex(vertexRepository.findById(3003L).get());
          }
        }
        break;
      case 8:
        requesterUser.setCurrentSquareId(800008L);
        if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          requesterUser.setClosestVertex(vertexRepository.findById(6006L).get());
        }else{
          requesterUser.setClosestVertex(vertexRepository.findById(3003L).get());
        }
        break;
      case 9:
        requesterUser.setCurrentSquareId(900009L);
        if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          requesterUser.setClosestVertex(vertexRepository.findById(7007L).get());
        }else{
          requesterUser.setClosestVertex(vertexRepository.findById(4004L).get());
        }
        break;
      case 10:
        requesterUser.setCurrentSquareId(10000010L);
        if(isLeftOfMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
            requesterUser.setClosestVertex(vertexRepository.findById(7007L).get());
          }else{
            requesterUser.setClosestVertex(vertexRepository.findById(4004L).get());
          }
        }else{
          if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
            requesterUser.setClosestVertex(vertexRepository.findById(8008L).get());
          }else{
            requesterUser.setClosestVertex(vertexRepository.findById(5005L).get());
          }
        }
        break;
      case 11:
        requesterUser.setCurrentSquareId(11000011L);
        if(isLeftOfMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
            requesterUser.setClosestVertex(vertexRepository.findById(8008L).get());
          }else{
            requesterUser.setClosestVertex(vertexRepository.findById(5005L).get());
          }
        }else{
          if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
            requesterUser.setClosestVertex(vertexRepository.findById(9009L).get());
          }else{
            requesterUser.setClosestVertex(vertexRepository.findById(6006L).get());
          }
        }
        break;
      case 12:
        requesterUser.setCurrentSquareId(12000012L);
        if(isAboveMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          requesterUser.setClosestVertex(vertexRepository.findById(9009L).get());
        }else{
          requesterUser.setClosestVertex(vertexRepository.findById(6006L).get());
        }
        break;
      case 13:
        requesterUser.setCurrentSquareId(13000013L);
        requesterUser.setClosestVertex(vertexRepository.findById(2002L).get());
        break;
      case 14:
        requesterUser.setCurrentSquareId(14000014L);
        if(isLeftOfMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          requesterUser.setClosestVertex(vertexRepository.findById(7007L).get());
        }else{
          requesterUser.setClosestVertex(vertexRepository.findById(8008L).get());
        }
        break;
      case 15:
        requesterUser.setCurrentSquareId(15000015L);
        if(isLeftOfMid(requesterUser, squareRepository.findById(requesterUser.getCurrentSquareId()).get())){
          requesterUser.setClosestVertex(vertexRepository.findById(8008L).get());
        }else{
          requesterUser.setClosestVertex(vertexRepository.findById(9009L).get());
        }
        break;
      case 16:
        requesterUser.setCurrentSquareId(16000016L);
        requesterUser.setClosestVertex(vertexRepository.findById(9009L).get());
        break;
    }
  }

  private boolean isLeftOfMid(Person person, Square square){
    return person.getLongitude()
        < (square.getLongitudeUpperBound() - square.getLongitudeLowerBound()) / 2
        + square.getLongitudeLowerBound();
  }

  private boolean isAboveMid(Person person, Square square){
    return person.getLatitude()
        > (square.getLatitudeUpperBound() - square.getLatitudeLowerBound()) / 2
        + square.getLatitudeLowerBound();
  }

}
