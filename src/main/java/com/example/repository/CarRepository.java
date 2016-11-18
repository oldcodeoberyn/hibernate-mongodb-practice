package com.example.repository;

import com.example.entites.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lex on 16-11-18.
 */
public interface CarRepository extends JpaRepository<Car, Long> {
}
