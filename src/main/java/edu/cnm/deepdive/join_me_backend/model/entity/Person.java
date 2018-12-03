package edu.cnm.deepdive.join_me_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.cnm.deepdive.join_me_backend.view.BasePerson;
import java.net.URI;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.stereotype.Component;

@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Person implements BasePerson {

  private static EntityLinks entityLinks;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "person_id", nullable = false, updatable = false)
  private int id;

  private double latitude;

  private double longitude;

  @Column(name = "display_name")
  private String displayName;

  @Column(name = "user_image_location")
  private String userImageLocation;

  @Column(name = "user_description")
  private String userDescription;

  @PostConstruct
  private void initEntityLinks(){
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks){
    Person.entityLinks = entityLinks;
  }


  @Override
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public URI getHref() {
    return entityLinks.linkForSingleResource(Square.class, id).toUri();
  }

  @Override
  public double getLatitude() {
    return 0;
  }

  @Override
  public double getLongitude() {
    return 0;
  }

  @Override
  public String getDisplayName() {
    return null;
  }

  @Override
  public String getUserImageLocation() {
    return null;
  }

  @Override
  public String getUserDescription() {
    return null;
  }
}
