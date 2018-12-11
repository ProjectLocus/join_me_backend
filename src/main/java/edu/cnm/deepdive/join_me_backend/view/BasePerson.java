package edu.cnm.deepdive.join_me_backend.view;

import edu.cnm.deepdive.join_me_backend.model.entity.Invitation;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.net.URI;
import java.util.List;

/**
 * The interface Base person.
 */
public interface BasePerson {

  /**
   * Gets person id.
   *
   * @return the person id
   */
  long getPersonId();

  /**
   * Gets href.
   *
   * @return the href
   */
  URI getHref();

  /**
   * Gets latitude.
   *
   * @return the latitude
   */
  double getLatitude();

  /**
   * Gets longitude.
   *
   * @return the longitude
   */
  double getLongitude();

  /**
   * Gets display name.
   *
   * @return the display name
   */
  String getDisplayName();

  /**
   * Gets user image location.
   *
   * @return the user image location
   */
  String getUserImageLocation();

  /**
   * Gets user description.
   *
   * @return the user description
   */
  String getUserDescription();

  /**
   * Gets google user id.
   *
   * @return the google user id
   */
  String getGoogleUserId();

}
