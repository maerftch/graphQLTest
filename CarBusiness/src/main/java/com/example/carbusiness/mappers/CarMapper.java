package com.example.carbusiness.mappers;

import com.example.carbusiness.dao.entities.Car;
import com.example.carbusiness.dtos.CarDTO;
import com.example.carbusiness.dtos.CarDTOInput;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private ModelMapper modelMapper=new ModelMapper();

    public Car fromCarDtoToCar(CarDTO carDTO){
        return this.modelMapper.map(carDTO, Car.class);
    }

    public CarDTO fromCarToCarDTO(Car car){
        return this.modelMapper.map(car, CarDTO.class);

    }

    public CarDTO fromCarInputToDto(CarDTOInput carDTOInput){
        return this.modelMapper.map(carDTOInput, CarDTO.class);

    }

    public CarDTOInput fromCarDtoToInput(CarDTO carDTO){
        return this.modelMapper.map(carDTO, CarDTOInput.class);

    }

    public Car fromCarInputToCar(CarDTOInput carDTOInput){
        return this.modelMapper.map(carDTOInput, Car.class);

    }

}
