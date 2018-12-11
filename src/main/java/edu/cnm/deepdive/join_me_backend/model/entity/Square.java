package edu.cnm.deepdive.join_me_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Square implements BaseSquare {

  private static EntityLinks entityLinks;

  @Id
  @Column(name = "square_id", nullable = false, updatable = false, unique = true)
  private long id;

  private double latitudeLowerBound;
  private double latitudeUpperBound;
  private double longitudeLowerBound;
  private double longitudeUpperBound;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "currentSquare")
  private List<Person> people = new LinkedList<>();


  @ManyToMany(fetch = FetchType.LAZY, mappedBy = "squares",
  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//  @OrderBy("name ASC")
  private List<Vertex> vertices = new LinkedList<>();

  @PostConstruct
  private void initEntityLinks(){
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks){
    Square.entityLinks = entityLinks;
  }

  @JsonSerialize(contentAs = BasePerson.class)
  public List<Person> getPeople() {
    return people;
  }

  @JsonSerialize(contentAs = BaseVertex.class)
  public List<Vertex> getVertices() {
    return vertices;
  }

  @Override
  public double getLatitudeLowerBound() {
    return latitudeLowerBound;
  }

  @Override
  public double getLatitudeUpperBound() {
    return latitudeUpperBound;
  }

  @Override
  public double getLongitudeLowerBound() {
    return longitudeLowerBound;
  }

  @Override
  public double getLongitudeUpperBound() {
    return longitudeUpperBound;
  }

  @ApiModelProperty(value = "square_id", required = true, example = "3")
  @Override
  public long getId() {
    return id;
  }

  @Override
  public URI getHref() {
    return entityLinks.linkForSingleResource(Square.class, id).toUri();
  }

  public void setVertices(List<Vertex> vertices) {
    this.vertices = vertices;
  }

  public void setLatitudeLowerBound(double latitudeLowerBound) {
    this.latitudeLowerBound = latitudeLowerBound;
  }

  public void setLatitudeUpperBound(double latitudeUpperBound) {
    this.latitudeUpperBound = latitudeUpperBound;
  }

  public void setLongitudeLowerBound(double longitudeLowerBound) {
    this.longitudeLowerBound = longitudeLowerBound;
  }

  public void setLongitudeUpperBound(double longitudeUpperBound) {
    this.longitudeUpperBound = longitudeUpperBound;
  }

  public void setPeople(List<Person> people) {
    this.people = people;
  }

  public void setId(long id) {
    this.id = id;
  }
}
