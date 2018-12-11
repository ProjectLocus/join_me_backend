package edu.cnm.deepdive.join_me_backend.model.dao;

import edu.cnm.deepdive.join_me_backend.model.entity.Vertex;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 * The interface Vertex repository.
 */
public interface VertexRepository extends CrudRepository<Vertex, Long> {

  List<Vertex> findAll();

}
