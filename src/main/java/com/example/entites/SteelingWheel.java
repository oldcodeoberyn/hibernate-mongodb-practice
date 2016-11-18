package com.example.entites;

import javax.persistence.*;

/**
 * Created by lex on 16-11-18.
 */
@Entity
@Table(name = "steelingwheel")
public class SteelingWheel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id", nullable = false)
    Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
