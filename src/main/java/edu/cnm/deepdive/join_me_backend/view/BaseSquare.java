package edu.cnm.deepdive.join_me_backend.view;

import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.net.URI;
import java.util.List;

public interface BaseSquare {

  double getLatitudeLowerBound();

  double getLatitudeUpperBound();

  double getLongitudeLowerBound();

  double getLongitudeUpperBound();

  long getId();

  URI getHref();

}
