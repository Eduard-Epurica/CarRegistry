package com.eduard.cardemo.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="make")
public class Make {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="continent")
    private String continent;

    @Column(name="name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "make",
            cascade = {CascadeType.DETACH,CascadeType.MERGE,
                    CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Car> cars;

    public Make() {
    }

    public Make(String continent, String name) {
        this.continent = continent;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
