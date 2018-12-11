package edu.cnm.deepdive.join_me_backend.view;

import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.net.URI;
import java.util.List;

/**
 * The interface Base square.
 */
public interface BaseSquare {

  /**
   * Gets latitude lower bound.
   *
   * @return the latitude lower bound
   */
  double getLatitudeLowerBound();

  /**
   * Gets latitude upper bound.
   *
   * @return the latitude upper bound
   */
  double getLatitudeUpperBound();

  /**
   * Gets longitude lower bound.
   *
   * @return the longitude lower bound
   */
  double getLongitudeLowerBound();

  /**
   * Gets longitude upper bound.
   *
   * @return the longitude upper bound
   */
  double getLongitudeUpperBound();

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
