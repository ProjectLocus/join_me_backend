package edu.cnm.deepdive.join_me_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.cnm.deepdive.join_me_backend.view.BaseSquare;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "square_id", nullable = false, updatable = false)
  private int id;

//  @NonNull
//  @Column(nullable = false)
//  private Vertex nWVertex;
//
//  @NonNull
//  @Column(nullable = false)
//  private Vertex nEVertex;
//
//  @NonNull
//  @Column(nullable = false)
//  private Vertex sEVertex;
//
//  @NonNull
//  @Column(nullable = false)
//  private Vertex sWVertex;



//  private List<Person> people;



  @ManyToMany(fetch = FetchType.LAZY,
  cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
  @JoinTable(joinColumns = @JoinColumn(name = "square_id"),
  inverseJoinColumns = @JoinColumn(name = "vertex_id"))
  @OrderBy("name ASC")
  private List<Vertex> vertices = new LinkedList<>();

  @PostConstruct
  private void initEntityLinks(){
    String ignore = entityLinks.toString();
  }

  @Autowired
  private void setEntityLinks(EntityLinks entityLinks){
    Square.entityLinks = entityLinks;
  }

//  @Override
//  public List<Person> getPeople() {
//    return people;
//  }

  @Override
  public List<Vertex> getVertices() {
    return vertices;
  }

//  @Override
//  public Vertex getNWVertex() {
//    return nWVertex;
//  }
//
//  @Override
//  public Vertex getNEVertex() {
//    return nEVertex;
//  }
//
//  @Override
//  public Vertex getSEVertex() {
//    return sEVertex;
//  }
//
//  @Override
//  public Vertex getSWVertex() {
//    return sWVertex;
//  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public URI getHref() {
    return entityLinks.linkForSingleResource(Square.class, id).toUri();
  }

//  public void setnWVertex(Vertex nWVertex) {
//    this.nWVertex = nWVertex;
//  }
//
//  public void setnEVertex(Vertex nEVertex) {
//    this.nEVertex = nEVertex;
//  }
//
//  public void setsEVertex(Vertex sEVertex) {
//    this.sEVertex = sEVertex;
//  }
//
//  public void setsWVertex(Vertex sWVertex) {
//    this.sWVertex = sWVertex;
//  }

//  public void setPeople(List<Person> people) {
//    this.people = people;
//  }

  public void setVertices(List<Vertex> vertices) {
    this.vertices = vertices;
  }
}
