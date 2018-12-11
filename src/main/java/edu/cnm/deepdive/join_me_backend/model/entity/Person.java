package edu.cnm.deepdive.join_me_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.join_me_backend.view.BaseInvitation;
import edu.cnm.deepdive.join_me_backend.view.BasePerson;
import edu.cnm.deepdive.join_me_backend.view.BaseSquare;
import edu.cnm.deepdive.join_me_backend.view.BaseVertex;
import io.swagger.annotations.ApiModelProperty;
import java.net.URI;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
  private long personId;

  @NonNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "vertex_id", nullable = false, updatable = true)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private Vertex closestVertex;

  @ManyToMany(fetch = FetchType.EAGER,
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(joinColumns = @JoinColumn(name = "person_id"),
      inverseJoinColumns = @JoinColumn(name = "invitation_id"))
//  @OrderBy("name ASC")
  private List<Invitation> invitations = new LinkedList<>();

  private double latitude;

  private double longitude;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "square_id", updatable = true)
  @OnDelete(action = OnDeleteAction.NO_ACTION)
  private Square currentSquare;

  @Column(name = "display_name")
  private String displayName;

  @Column(name = "user_image_location")
  private String userImageLocation;

  @Column(name = "user_description")
  private String userDescription;

  @Column(name = "google_user_id")
  private String googleUserId;

  @PostConstruct
  private void initEntityLinks(){
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks){
    Person.entityLinks = entityLinks;
  }

  @ApiModelProperty(value = "person_id", required = true, example = "1")
  @Override
  public long getPersonId() {
    return personId;
  }

  public void setPersonId(long personId) {
    this.personId = personId;
  }

  @Override
  public URI getHref() {
    return entityLinks.linkForSingleResource(Square.class, personId).toUri();
  }

  @ApiModelProperty(value = "latitude", required = true, example = "35.0855")
  @Override
  public double getLatitude() {
    return latitude;
  }

  @ApiModelProperty(value = "longitude", required = true, example = "-106.64970")
    @Override
  public double getLongitude() {
    return longitude;
  }

  @ApiModelProperty(value = "display_name", required = true, example = "ARne arNEssoN")
  @Override
  public String getDisplayName() {
    return displayName;
  }

  @ApiModelProperty(value = "user_image_location", required = true, example = "https://myimagehere.com")
  @Override
  public String getUserImageLocation() {
    return userImageLocation;
  }

  @ApiModelProperty(value = "user_description", required = true, example = "This is me. I like coffee. I like dogs. I don't like tater-tots.")
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

  @JsonSerialize(contentAs = BaseSquare.class)
  public Square getCurrentSquare() {
    return currentSquare;
  }

  public void setCurrentSquare(Square currentSquare) {
    this.currentSquare = currentSquare;
  }

  @ApiModelProperty(value = "google_id", required = true, example = "123234345456567")
  @Override
  public String getGoogleUserId() {
    return googleUserId;
  }

  public void setGoogleUserId(String googleUserId) {
    this.googleUserId = googleUserId;
  }
}
