
package de.hska.iwi.vslab.user.userservice;

import java.net.URI;

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
public class RoleController {

 @Autowired
 private RoleRepo repo;

 @RequestMapping(value = "/roles", method = RequestMethod.GET)
 public ResponseEntity<Iterable<Role>> getRoles() {
	 Iterable<Role> allPolls = repo.findAll();
	 return new ResponseEntity<Iterable<Role>>(allPolls, HttpStatus.OK);
 }

 @RequestMapping(value = "/roles", method = RequestMethod.POST)
 public ResponseEntity<?> addRole(@RequestBody Role role) {
	 role = repo.save(role);
	 // Set the location header for the newly created resource
	 HttpHeaders responseHeaders = new HttpHeaders();
	 URI newRoleUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(role.getId())
			 .toUri();
	 responseHeaders.setLocation(newRoleUri);
	 return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
 }

 @RequestMapping(value = "/roles/{roleId}", method = RequestMethod.GET)
 public ResponseEntity<Role> getRole(@PathVariable Long roleId) {
	 Role role = repo.findById(roleId).orElse(null);
	 return new ResponseEntity<>(role, HttpStatus.OK);
 }

 @RequestMapping(value = "/roles/{roleId}", method = RequestMethod.PUT)
 public ResponseEntity<?> updateRole(@RequestBody Role role) {
	 role = repo.save(role);
	 // Set the location header for the newly created resource
	 HttpHeaders responseHeaders = new HttpHeaders();
	 URI newRoleUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(role.getId())
			 .toUri();
	 responseHeaders.setLocation(newRoleUri);
	 return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
 }

 @RequestMapping(value = "/roles/{roleId}", method = RequestMethod.DELETE)
 public ResponseEntity<Role> deleteRole(@PathVariable Long roleId) {
	 repo.deleteById(roleId);
	 return new ResponseEntity<>(HttpStatus.OK);
 }

}
