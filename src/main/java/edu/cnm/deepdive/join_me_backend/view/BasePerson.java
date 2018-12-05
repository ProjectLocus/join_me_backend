package edu.cnm.deepdive.join_me_backend.view;

import edu.cnm.deepdive.join_me_backend.model.entity.Invitation;
import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.net.URI;
import java.util.List;

public interface BasePerson {

  long getId();

  URI getHref();

  double getLatitude();

  double getLongitude();

  String getDisplayName();

  String getUserImageLocation();

  String getUserDescription();

}
