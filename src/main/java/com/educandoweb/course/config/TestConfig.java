package com.educandoweb.course.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.entities.enums.OrderStatus;
import java.util.Arrays;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Order;
import java.time.Instant;
import com.educandoweb.course.repositories.CategoryRepository;

@Configuration
@Profile ("test")
public class TestConfig implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run (String... args) throws Exception {
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		User u1 = new User(null, "Silvia R", "silvia@gmail.com", "88899999", "123");
		User u2 = new User(null, "Amanda A", "amanda@gmail.com", "9879877", "23456");
		
		Order o1 = new Order(null, Instant.parse("2025-11-14T10:01:02Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2025-11-14T10:02:07Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2025-11-14T10:05:33Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
}