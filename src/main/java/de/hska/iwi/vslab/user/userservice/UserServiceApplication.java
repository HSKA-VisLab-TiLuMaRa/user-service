package de.hska.iwi.vslab.user.userservice;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {

	@Autowired
	private UserRepo userRepository;

	@Autowired
	private RoleRepo roleRepository;

	@PostConstruct
	public void generateTestData() {
		userRepository.save(new User(1000L,"Alice", "password"));
		userRepository.save(new User(1001L,"Bob", "password"));
		roleRepository.save(new Role(1000L,"Admin", 1L));
		roleRepository.save(new Role(1001L,"User", 2L));
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}
