package com.eduard.cardemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="location")
public class Location {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="country")
    private String country;

    @Column(name="postalcode")
    private int postalcode;

    @OneToMany(fetch = FetchType.LAZY,
                mappedBy = "location",
                cascade = {CascadeType.DETACH,CascadeType.MERGE,
                    CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Car> cars;

    public Location(String country, int postalcode) {
        this.country = country;
        this.postalcode = postalcode;
    }

    public Location() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

}
