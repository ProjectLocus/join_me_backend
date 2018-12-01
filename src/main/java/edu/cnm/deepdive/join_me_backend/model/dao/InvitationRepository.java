package edu.cnm.deepdive.join_me_backend.model.dao;

import edu.cnm.deepdive.join_me_backend.model.entity.Invitation;
import edu.cnm.deepdive.join_me_backend.model.entity.Square;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface InvitationRepository extends CrudRepository<Invitation, Integer> {

  List<Square> findAllByOrderByIdAsc();

}
