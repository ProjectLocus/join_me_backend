package edu.cnm.deepdive.join_me_backend.view;

import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import java.net.URI;
import java.util.List;

/**
 * The interface Base vertex.
 */
public interface BaseVertex {

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

}
