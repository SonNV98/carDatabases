package com.packt.carDatabase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.packt.carDatabase.domain.Car;
import com.packt.carDatabase.domain.CarRepository;
import com.packt.carDatabase.domain.Owner;
import com.packt.carDatabase.domain.OwnerRepository;
import com.packt.carDatabase.domain.User;
import com.packt.carDatabase.domain.UserRepository;

@SpringBootApplication
public class CarDatabaseApplication {

	private static final Logger logger = LoggerFactory.getLogger(CarDatabaseApplication.class);

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private OwnerRepository ownerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarDatabaseApplication.class, args);
		logger.info("Hello Spring Boot");
	}

	// thuc thi code truoc khi und dung duoc bat dau
	@Bean
	CommandLineRunner runner() {
		return args -> {

			Owner ownerOne = new Owner("John", "Johnson");
			ownerRepository.save(ownerOne);
			Owner ownerTwo = new Owner("Mary", "Robinson");
			ownerRepository.save(ownerTwo);

			carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, ownerOne));
			carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, ownerTwo));
			carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, ownerTwo));
			
			userRepository.save(new User("user","$2a$12$.ylPqnTbIE0UVQEC.jSBx.Z9w0JQpPmWzoCvMaZL0iFk1H6nKTtVW","USER"));
			userRepository.save(new User("admin","$2a$12$F8xdw26xEX.HDmAPACg9c.BHo9ki.NeN0DgRIlzoztoBB3r/EDUmu","ADMIN"));
		};
	}

}
