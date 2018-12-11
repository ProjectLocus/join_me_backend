package edu.cnm.deepdive.join_me_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * The type Join me backend application.
 */
@EnableEntityLinks
@SpringBootApplication
@EnableScheduling
public class JoinMeBackendApplication {

  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    SpringApplication.run(JoinMeBackendApplication.class, args);
  }
}
