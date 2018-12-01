package edu.cnm.deepdive.join_me_backend.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.cnm.deepdive.join_me_backend.view.BaseInvitation;
import java.net.URI;
import javax.persistence.Entity;
import org.springframework.stereotype.Component;

@Entity
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Invitation implements BaseInvitation {


  

  @Override
  public int getId() {
    return 0;
  }

  @Override
  public URI getHref() {
    return null;
  }
}
