
package de.hska.iwi.vslab.user.userservice;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {

 @Autowired
 private UserRepo repo;

 @RequestMapping(value = "/users", method = RequestMethod.GET)
 public ResponseEntity<Iterable<User>> getUsers() {
	 Iterable<User> allPolls = repo.findAll();
	 return new ResponseEntity<Iterable<User>>(allPolls, HttpStatus.OK);
 }

 @RequestMapping(value = "/users", method = RequestMethod.POST)
 public ResponseEntity<?> addUser(@RequestBody User user) {
	 user = repo.save(user);
	 // Set the location header for the newly created resource
	 HttpHeaders responseHeaders = new HttpHeaders();
   responseHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, null);
	 URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
			 .toUri();
	 responseHeaders.setLocation(newUserUri);
	 return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
 }

 @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
 public ResponseEntity<User> getUser(@PathVariable Long userId) {
	 User user = repo.findById(userId).orElse(null);
	 return new ResponseEntity<>(user, HttpStatus.OK);
 }

 @RequestMapping(value = "/usersByUsername/{username}", method = RequestMethod.GET)
 public ResponseEntity<User> getUserByUserName(@PathVariable String username) {
	 User result = null;
	 Iterable<User> users = repo.findUserByUsername(username);
	for (User user: users) {
		result = user;
	}
	return new ResponseEntity<>(result, HttpStatus.OK);
 }

 @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		user = repo.save(user);
		// Set the location header for the newly created resource
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newProductUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId())
				.toUri();
		responseHeaders.setLocation(newProductUri);
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}

 @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
 public ResponseEntity<User> deleteUser(@PathVariable Long userId) {
	 repo.deleteById(userId);
	 return new ResponseEntity<>(HttpStatus.OK);
 }

}
