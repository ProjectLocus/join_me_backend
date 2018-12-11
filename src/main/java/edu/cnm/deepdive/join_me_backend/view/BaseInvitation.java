package edu.cnm.deepdive.join_me_backend.view;

import edu.cnm.deepdive.join_me_backend.model.entity.Invitation;
import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import java.net.URI;
import java.util.List;

/**
 * The interface Base invitation.
 */
public interface BaseInvitation {

  /**
   * Gets id.
   *
   * @return the id
   */
  long getId();

  /**
   * Gets href.
   *
   * @return the href
   */
  URI getHref();

  /**
   * Gets user sender id.
   *
   * @return the user sender id
   */
  long getUserSenderId();

  /**
   * Gets user receiver id.
   *
   * @return the user receiver id
   */
  long getUserReceiverId();

  /**
   * Gets was delivered.
   *
   * @return the was delivered
   */
  boolean getWasDelivered();

  /**
   * Gets will attend.
   *
   * @return the will attend
   */
  boolean getWillAttend();

  /**
   * Gets degrees remaining.
   *
   * @return the degrees remaining
   */
  int getDegreesRemaining();

  /**
   * Gets date.
   *
   * @return the date
   */
  String getDate();


  /**
   * Gets description.
   *
   * @return the description
   */
  String getDescription();


  /**
   * Gets title.
   *
   * @return the title
   */
  String getTitle();


  /**
   * Gets location.
   *
   * @return the location
   */
  String getLocation();

}
