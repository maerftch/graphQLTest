package com.example.carbusiness.service;

import com.example.carbusiness.dao.entities.Car;
import com.example.carbusiness.dao.repositories.CarRepository;
import com.example.carbusiness.dtos.CarDTO;
import com.example.carbusiness.dtos.CarDTOInput;
import com.example.carbusiness.mappers.CarMapper;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarManagerAction implements CarManager{
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;


    @Override
    public List<CarDTO> getCarByModel(String model) {
        List<Car> cars= carRepository.findAllByModel(model);
        return cars.stream().map(carMapper::fromCarToCarDTO).toList();
    }


    @Override
    public List<CarDTO> getCarByModelAndPrice(String model, Float price) {
        List<Car> cars= carRepository.findAllByModelAndPrice(model,price);
        return cars.stream().map(carMapper::fromCarToCarDTO).toList();
    }


    @Override
    public CarDTO deleteCar(Float id) {
        CarDTO carDTO= carMapper.fromCarToCarDTO(carRepository.getById(id));
        carRepository.deleteById(id);
        return carDTO;
    }


    @Override
    public CarDTO saveCar(CarDTOInput carDTOInput) {
        Car car = carMapper.fromCarInputToCar(carDTOInput);

        if(!(carRepository.existsById(car.getId_Car())))
            car = carRepository.save(car);

        return carMapper.fromCarToCarDTO(car);
    }
}
