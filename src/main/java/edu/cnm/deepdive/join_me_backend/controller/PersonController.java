package edu.cnm.deepdive.join_me_backend.controller;


import edu.cnm.deepdive.join_me_backend.model.dao.InvitationRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.PersonRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Invitation;
import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
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
    return personRepository.findAllByOrderByIdAsc();
  }

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Person> post(@RequestBody Person person) {
    personRepository.save(person);
    return ResponseEntity.created(person.getHref()).body(person);
  }

  @GetMapping(value = "{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Person get(@PathVariable("personId") int personId) {
    return personRepository.findById(personId).get();
  }

  @PutMapping("{personId}")
  public ResponseEntity<Person> updateStudent(@RequestBody Person person, @PathVariable ("personId") int personId) {
    Optional<Person> personOptional = personRepository.findById(personId);
    if (!personOptional.isPresent()){
      return ResponseEntity.notFound().build();
    }
    person.setId(personId);
    personRepository.save(person);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("{personId}")
  public void deletePerson(@PathVariable ("personId") int personId){
    personRepository.deleteById(personId);
  }

  @GetMapping(value = "{personId}/invitations}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Invitation> getAllInvitationsPerPerson(@PathVariable ("personId") int personId){
    return personRepository.findById(personId).get().getInvitations();
  }


}
