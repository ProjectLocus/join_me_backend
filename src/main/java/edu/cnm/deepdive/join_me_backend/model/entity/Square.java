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

/**
 * The type Square.
 */
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

  /**
   * Gets people.
   *
   * @return the people
   */
  @JsonSerialize(contentAs = BasePerson.class)
  public List<Person> getPeople() {
    return people;
  }

  /**
   * Gets vertices.
   *
   * @return the vertices
   */
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

  /**
   * Sets vertices.
   *
   * @param vertices the vertices
   */
  public void setVertices(List<Vertex> vertices) {
    this.vertices = vertices;
  }

  /**
   * Sets latitude lower bound.
   *
   * @param latitudeLowerBound the latitude lower bound
   */
  public void setLatitudeLowerBound(double latitudeLowerBound) {
    this.latitudeLowerBound = latitudeLowerBound;
  }

  /**
   * Sets latitude upper bound.
   *
   * @param latitudeUpperBound the latitude upper bound
   */
  public void setLatitudeUpperBound(double latitudeUpperBound) {
    this.latitudeUpperBound = latitudeUpperBound;
  }

  /**
   * Sets longitude lower bound.
   *
   * @param longitudeLowerBound the longitude lower bound
   */
  public void setLongitudeLowerBound(double longitudeLowerBound) {
    this.longitudeLowerBound = longitudeLowerBound;
  }

  /**
   * Sets longitude upper bound.
   *
   * @param longitudeUpperBound the longitude upper bound
   */
  public void setLongitudeUpperBound(double longitudeUpperBound) {
    this.longitudeUpperBound = longitudeUpperBound;
  }

  /**
   * Sets people.
   *
   * @param people the people
   */
  public void setPeople(List<Person> people) {
    this.people = people;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
    this.id = id;
  }
}
