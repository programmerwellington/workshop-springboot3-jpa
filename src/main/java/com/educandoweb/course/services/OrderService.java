package com.educandoweb.course.services;
import com.educandoweb.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.educandoweb.course.entities.Order;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OrderService {
	
	@Autowired
	//DEPENDENCY
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	
}