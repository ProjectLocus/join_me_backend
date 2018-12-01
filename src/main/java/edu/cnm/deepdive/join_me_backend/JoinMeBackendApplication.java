package edu.cnm.deepdive.join_me_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableEntityLinks
@SpringBootApplication
@EnableScheduling
public class JoinMeBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(JoinMeBackendApplication.class, args);
  }
}
