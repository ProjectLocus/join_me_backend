package edu.cnm.deepdive.join_me_backend.view;

import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.net.URI;

public interface BasePerson {

  int getId();

  URI getHref();

  double getLatitude();

  double getLongitude();

  String getDisplayName();

  String getUserImageLocation();

  String getUserDescription();

  Vertex getClosestVertex();

}
