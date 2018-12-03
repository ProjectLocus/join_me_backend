package edu.cnm.deepdive.join_me_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
  private int id;

  @Column(name = "user_sender_id")
  private int userSenderId;

  @Column(name = "user_receiver_id")
  private int userReceiverId;

  @Column(name = "was_delivered")
  private boolean wasDelivered;

  @Column(name = "will_attend")
  private boolean willAttend;

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

  @Override
  public int getId() {
    return id;
  }

  @Override
  public URI getHref() {
    return entityLinks.linkForSingleResource(Invitation.class, id).toUri();
  }

  @Override
  public int getUserSenderId() {
    return userSenderId;
  }

  @Override
  public int getUserReceiverId() {
    return userReceiverId;
  }

  @JsonSerialize(contentAs = BasePerson.class)
  public List<Person> getPeople() {
    return people;
  }

  public void setUserSenderId(int userSenderId) {
    this.userSenderId = userSenderId;
  }

  public void setUserReceiverId(int userReceiverId) {
    this.userReceiverId = userReceiverId;
  }

  @Override
  public boolean getWasDelivered() {
    return wasDelivered;
  }

  public void setWasDelivered(boolean wasDelivered) {
    this.wasDelivered = wasDelivered;
  }

  @Override
  public boolean getWillAttend() {
    return willAttend;
  }

  public void setWillAttend(boolean willAttend) {
    this.willAttend = willAttend;
  }
}
