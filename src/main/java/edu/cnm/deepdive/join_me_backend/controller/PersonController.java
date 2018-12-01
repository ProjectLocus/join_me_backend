package edu.cnm.deepdive.join_me_backend.controller;


import edu.cnm.deepdive.join_me_backend.model.dao.SquareRepository;
import edu.cnm.deepdive.join_me_backend.model.dao.VertexRepository;
import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@ExposesResourceFor(Person.class)
//@RequestMapping("/people")
public class PersonController {

//  private InvitationRepository invitationRepository;
//  private PersonRepository personRepository;
  private SquareRepository squareRepository;
  private VertexRepository vertexRepository;


}
