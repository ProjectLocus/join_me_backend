package edu.cnm.deepdive.join_me_backend.view;

import edu.cnm.deepdive.join_me_backend.model.entity.Person;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import java.net.URI;
import java.util.List;

public interface BaseVertex {

  double getLatitude();

  double getLongitude();

  int getId();

  URI getHref();

}
