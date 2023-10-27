package com.eduard.cardemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "car_detail")
public class CarDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="current_location")
    private String current_location;

    @Column(name="model_year")
    private int modelYear;

    @Column(name="price")
    private double price;

    @Column(name="color")
    private String color;

    public CarDetail() {
    }

    public CarDetail(String current_location, int modelYear, double price, String color) {
        this.current_location = current_location;
        this.modelYear = modelYear;
        this.price = price;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(String current_location) {
        this.current_location = current_location;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
