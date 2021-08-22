package com.packt.carDatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.packt.carDatabase.domain.Car;
import com.packt.carDatabase.domain.CarRepository;

@RestController
public class CarController {
	
	@Autowired
	private CarRepository carRepository;
	@RequestMapping("/cars")
	public Iterable<Car> getCars() {
		try {
			return carRepository.findAll();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
