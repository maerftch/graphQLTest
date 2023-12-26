package com.example.carbusiness.web;

import com.example.carbusiness.dtos.CarDTO;
import com.example.carbusiness.dtos.CarDTOInput;
import com.example.carbusiness.service.CarManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CarGraphQLController {

    @Autowired
    public CarManager carManager;

    @QueryMapping
    public List<CarDTO> getCarByModel(@Argument String model){
        return carManager.getCarByModel(model);
    }
    @QueryMapping
    public List<CarDTO> getCarByModelAndPrice(@Argument String model,@Argument Float price){
        return carManager.getCarByModelAndPrice(model,price);
    }

    @MutationMapping
    public CarDTO deleteCar(@Argument Float id){
        return carManager.deleteCar(id);
    }
    @MutationMapping
    public CarDTO saveCar(@Argument CarDTOInput carDTOInput) {
        return carManager.saveCar(carDTOInput);
    }

}
