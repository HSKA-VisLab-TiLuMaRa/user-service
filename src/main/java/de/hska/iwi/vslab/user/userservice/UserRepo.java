package de.hska.iwi.vslab.user.userservice;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends
 org.springframework.data.repository.CrudRepository<User, Long> { 
    @Query("SELECT t FROM User t where t.username = :username") 
    Iterable<User> findUserByUsername(@Param("username") String username);
 }
