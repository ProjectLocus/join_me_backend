package edu.cnm.deepdive.join_me_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import edu.cnm.deepdive.join_me_backend.view.BasePerson;
import java.net.URI;
import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
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

  @NonNull
//  @JsonView(Nested.class)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "vertex_id", nullable = false, updatable = true)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private Vertex closestVertex;

  //todo:  add list of invitations

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
    return latitude;
  }

    @Override
  public double getLongitude() {
    return longitude;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public String getUserImageLocation() {
    return userImageLocation;
  }

  @Override
  public String getUserDescription() {
    return userDescription;
  }

  @Override
  public Vertex getClosestVertex() {
    return closestVertex;
  }

  public void setClosestVertex(Vertex closestVertex) {
    this.closestVertex = closestVertex;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public void setUserImageLocation(String userImageLocation) {
    this.userImageLocation = userImageLocation;
  }

  public void setUserDescription(String userDescription) {
    this.userDescription = userDescription;
  }
}
