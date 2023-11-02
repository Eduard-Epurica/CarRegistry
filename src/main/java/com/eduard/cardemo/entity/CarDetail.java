package com.eduard.cardemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "car_detail")
public class CarDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="type")
    private String type;

    @Column(name="model_year")
    @NotNull(message = "Model Year is Required")
    private Integer modelYear;


    @Column(name="price")
    @NotNull(message = "Price is Required")
    private Double price;

    @Column(name="color")
    @NotNull(message = "Color is Required")
    private String color;

    public CarDetail() {
    }

    public CarDetail(String type, Integer modelYear, Double price, String color) {
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
