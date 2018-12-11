package edu.cnm.deepdive.join_me_backend.controller;


import edu.cnm.deepdive.join_me_backend.model.dao.InvitationRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.PersonRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Invitation;
import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Invitation controller.
 */
@RestController
@ExposesResourceFor(Invitation.class)
@RequestMapping("/invitations")
public class InvitationController {

  private InvitationRepository invitationRepository;
  private PersonRepository personRepository;
  private SquareRepository squareRepository;
  private VertexRepository vertexRepository;

  /**
   * Instantiates a new Invitation controller.
   *
   * @param invitationRepository the invitation repository
   * @param personRepository the person repository
   * @param squareRepository the square repository
   * @param vertexRepository the vertex repository
   */
  @Autowired
  public InvitationController(
      InvitationRepository invitationRepository,
      PersonRepository personRepository,
      SquareRepository squareRepository,
      VertexRepository vertexRepository) {
    this.invitationRepository = invitationRepository;
    this.personRepository = personRepository;
    this.squareRepository = squareRepository;
    this.vertexRepository = vertexRepository;
  }

  /**
   * Gets all invitations.
   *
   * @return the list
   */
  @ApiOperation(value = "Gets all invitations.", notes = "Retrieves all invitations from/to all people.")
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Invitation> list() {
    return invitationRepository.findAll();
  }

  /**
   * Gets single invitation.
   *
   * @param invitationId the invitation id
   * @return the single invitation
   */
  @ApiOperation(value = "Gets an invitation.", notes = "Retrieves the invitation for the given invitationId.")
  @GetMapping(value = "{invitationId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Invitation getSingleInvitation(@ApiParam(value = "Id for the invitation.", required = true) @PathVariable ("invitationId") long invitationId){
    return invitationRepository.findById(invitationId).get();
  }

//  @DeleteMapping(value = "{invitationId}")
//  public void deleteInvitation(@PathVariable ("invitationId") long invitationId){
//    invitationRepository.deleteById(invitationId);
//  }

}
