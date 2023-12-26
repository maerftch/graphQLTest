package com.example.carbusiness.service;

import com.example.carbusiness.dao.entities.Car;
import com.example.carbusiness.dtos.CarDTO;
import com.example.carbusiness.dtos.CarDTOInput;

import java.util.List;

public interface CarManager {
    public List<CarDTO> getCarByModel(String model);
    public List<CarDTO> getCarByModelAndPrice(String model,Float price);
    public CarDTO deleteCar(Float id);
    public CarDTO saveCar(CarDTOInput carDTOInput);

}
