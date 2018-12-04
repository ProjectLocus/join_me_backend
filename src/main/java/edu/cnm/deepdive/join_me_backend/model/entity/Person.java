package edu.cnm.deepdive.join_me_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.join_me_backend.view.BaseInvitation;
import edu.cnm.deepdive.join_me_backend.view.BasePerson;
import edu.cnm.deepdive.join_me_backend.view.BaseVertex;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
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
  private long id;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "vertex_id", nullable = false, updatable = true)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private Vertex closestVertex;

  @ManyToMany(fetch = FetchType.LAZY,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(joinColumns = @JoinColumn(name = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "invitation_id"))
//  @OrderBy("name ASC")
  private List<Invitation> invitations = new LinkedList<>();

  private double latitude;

  private double longitude;

  private long currentSquareId;

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
  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  @JsonSerialize(contentAs = BaseVertex.class)
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

  @JsonSerialize(contentAs = BaseInvitation.class)
  public List<Invitation> getInvitations() {
    return invitations;
  }

  public void setInvitations(
      List<Invitation> invitations) {
    this.invitations = invitations;
  }

  @Override
  public long getCurrentSquareId() {
    return currentSquareId;
  }

  public void setCurrentSquareId(long currentSquareId) {
    this.currentSquareId = currentSquareId;
  }
}
