package com.eduard.cardemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="model")
    private String model;

    @Column(name="vin")
    private String vin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_detail_id")
    private CarDetail carDetail;

    
}
