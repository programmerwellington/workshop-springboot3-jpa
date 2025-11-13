package com.educandoweb.course.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.entities.User;
import java.util.Arrays;

@Configuration
@Profile ("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run (String... args) throws Exception {
		User u1 = new User(null, "Silvia R", "silvia@gmail.com", "88899999", "123");
		User u2 = new User(null, "Amanda A", "amanda@gmail.com", "9879877", "23456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		
	}
}