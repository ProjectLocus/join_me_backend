package edu.cnm.deepdive.join_me_backend.view;

import edu.cnm.deepdive.join_me_backend.model.entity.Invitation;
import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import java.net.URI;
import java.util.List;

public interface BaseInvitation {

  int getId();

  URI getHref();

  int getUserSenderId();

  int getUserReceiverId();

  List<Person> getPeople();

  boolean getWasDelivered();

  boolean getWillAttend();

}
