package com.example.entites;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lex on 16-11-18.
 */
@Entity
@Table(name = "car")
@SequenceGenerator(name = "carSequence", sequenceName = "CAR_SQ", initialValue = 1, allocationSize = 2)
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "brand")
    String brand;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "car")
    SteelingWheel steelingWheel;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "car")
    List<Wheel> wheels;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public SteelingWheel getSteelingWheel() {
        return steelingWheel;
    }

    public void setSteelingWheel(SteelingWheel steelingWheel) {
        this.steelingWheel = steelingWheel;
    }

    public List<Wheel> getWheels() {
        return wheels;
    }

    public void setWheels(List<Wheel> wheels) {
        this.wheels = wheels;
    }
}
