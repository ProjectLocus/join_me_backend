package edu.cnm.deepdive.join_me_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.cnm.deepdive.join_me_backend.view.BaseInvitation;
import edu.cnm.deepdive.join_me_backend.view.BasePerson;
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
public class Invitation implements BaseInvitation {

  private static EntityLinks entityLinks;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "invitation_id", nullable = false, updatable = false)
  private long id;

  @Column(name = "user_sender_id")
  private long userSenderId;

  @Column(name = "user_receiver_id")
  private long userReceiverId;

  @Column(name = "was_delivered")
  private boolean wasDelivered;

  @Column(name = "will_attend")
  private boolean willAttend;

  @Column(name = "degrees_remaining")
  private int degreesRemaining;

  @Column(name = "date")
  private String date;

  @Column(name = "description")
  private String description;

  @Column(name = "title")
  private String title;

  @Column(name = "location")
  private String location;

  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "invitations",
      cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//  @OrderBy(value = "person_id")
  private List<Person> people = new LinkedList<>();

  @PostConstruct
  private void initEntityLinks(){
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks) {Invitation.entityLinks = entityLinks;}

  @ApiModelProperty(value = "invitation_id", required = true, example = "111")
  @Override
  public long getId() {
    return id;
  }

  @Override
  public URI getHref() {
    return entityLinks.linkForSingleResource(Invitation.class, id).toUri();
  }

  @ApiModelProperty(value = "user_sender_id", required = true, example = "13")
  @Override
  public long getUserSenderId() {
    return userSenderId;
  }

  @ApiModelProperty(value = "user_receiver_id", required = true, example = "2")
  @Override
  public long getUserReceiverId() {
    return userReceiverId;
  }

  @JsonSerialize(contentAs = BasePerson.class)
  public List<Person> getPeople() {
    return people;
  }

  public void setUserSenderId(long userSenderId) {
    this.userSenderId = userSenderId;
  }

  public void setUserReceiverId(long userReceiverId) {
    this.userReceiverId = userReceiverId;
  }

  @ApiModelProperty(value = "was_delivered", required = true, example = "false")
  @Override
  public boolean getWasDelivered() {
    return wasDelivered;
  }

  public void setWasDelivered(boolean wasDelivered) {
    this.wasDelivered = wasDelivered;
  }

  @ApiModelProperty(value = "will_attend", required = true, example = "false")
  @Override
  public boolean getWillAttend() {
    return willAttend;
  }

  public void setWillAttend(boolean willAttend) {
    this.willAttend = willAttend;
  }

  @ApiModelProperty(value = "degrees_remaining", required = false, example = "The number of times the invitation can be reused.")
  @Override
  public int getDegreesRemaining() {
    return degreesRemaining;
  }

  public void setDegreesRemaining(int degreesRemaining) {
    this.degreesRemaining = degreesRemaining;
  }

  @ApiModelProperty(value = "date", required = true, example = "A string representation of the date for the really fun event.")
  @Override
  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  @ApiModelProperty(value = "description", required = true, example = "This is a description of the really fun event someone is being invited to attend.")
  @Override
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @ApiModelProperty(value = "title", required = true, example = "This is the title of my invitation.")
  @Override
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @ApiModelProperty(value = "location", required = true, example = "A string representation of the location of the event.")
  @Override
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }
}
