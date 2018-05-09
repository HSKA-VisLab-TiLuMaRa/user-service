package de.hska.iwi.vslab.user.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserRepo repo;
  @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
  public ResponseEntity<User> getUser(@PathVariable Long userId) {
    User user = repo.findById(userId).orElse(null);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  public ResponseEntity<String> helloWorld() {
    return new ResponseEntity<>("user", HttpStatus.OK);
  }

}
