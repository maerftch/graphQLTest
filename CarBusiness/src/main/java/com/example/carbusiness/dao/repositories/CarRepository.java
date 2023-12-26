package com.example.carbusiness.dao.repositories;

import com.example.carbusiness.dao.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Float> {
    public List<Car> findAllByModel(String model);
    public List<Car> findAllByModelAndPrice(String model,Float price);
}
