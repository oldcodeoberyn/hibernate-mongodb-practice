package com.example.repository;

import com.example.entites.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by lex on 16-11-18.
 */
public interface WheelRepository extends JpaRepository<Wheel, Long> {
}
