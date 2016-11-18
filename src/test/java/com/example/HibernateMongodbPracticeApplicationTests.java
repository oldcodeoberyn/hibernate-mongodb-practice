package com.example;

import com.example.entites.Car;
import com.example.entites.SteelingWheel;
import com.example.entites.Wheel;
import com.example.repository.CarRepository;
import com.example.repository.SteelingWheelRepository;
import com.example.repository.WheelRepository;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HibernateMongodbPracticeApplicationTests {

    @Autowired
    CarRepository carRepository;
    @Autowired
    SteelingWheelRepository steelingWheelRepository;
    @Autowired
    WheelRepository wheelRepository;

    @Test
    public void contextLoads() {
        for (int i = 0; i < 10; i++) {
            Car benz = new Car();
            benz.setBrand("BENZ");
            SteelingWheel steelingWheel = new SteelingWheel();
            steelingWheel.setCar(benz);
            steelingWheelRepository.saveAndFlush( steelingWheel);
            Wheel wheel1 = new Wheel();
            wheel1.setCar(benz);
            Wheel wheel2 = new Wheel();
            wheel2.setCar(benz);
            Wheel wheel3 = new Wheel();
            wheel3.setCar(benz);
            Wheel wheel4 = new Wheel();
            wheel4.setCar(benz);
            List<Wheel> wheels = Lists.newArrayList(wheel1, wheel2, wheel3, wheel4);
            wheelRepository.save( wheels );
            wheelRepository.flush();
            benz.setSteelingWheel(steelingWheel);
            benz.setWheels(wheels);
            carRepository.saveAndFlush(benz);
        }
        System.out.println("**********************start*************************");
        carRepository.findAll();
        System.out.println("**********************end*************************");
    }

}
