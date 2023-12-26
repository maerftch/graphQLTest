package com.example.carbusiness;

import com.example.carbusiness.dao.entities.Car;
import com.example.carbusiness.dao.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CarBusinessApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarBusinessApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CarRepository carRepository){
		return args -> {
			List<Car> carList =  List.of(
					Car.builder().model("x").color("blue").matricul("x").price(10.0F).build(),
					Car.builder().model("y").color("red").matricul("y").price(20.0F).build(),
					Car.builder().model("z").color("pink").matricul("z").price(30.0F).build(),
					Car.builder().model("t").color("green").matricul("t").price(40.0F).build()
			);
			carRepository.saveAll(carList);
			System.out.println("Done Done");
		};
	}

}
