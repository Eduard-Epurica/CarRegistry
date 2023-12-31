package com.eduard.cardemo.entity;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

@Entity
@Table(name="car")
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="model")
    @NotNull(message="Model is required")
    @Size(min=1,message="Model is required")
    private String model;

    @Column(name="vin")
    @NotNull(message="Vin is required")
    @Size(min=1,message="Vin is required")
    private String vin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_detail_id")
    @Valid
    private CarDetail carDetail;

    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="owner_id")
    @Valid
    private Owner owner;

    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="make_id")
    private Make make;

    @ManyToOne(cascade={CascadeType.DETACH,CascadeType.MERGE,
            CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name="location_id")
    @Valid
    private Location location;


    public Car() {
    }

    public Car(String model, String vin, CarDetail carDetail) {
        this.model = model;
        this.vin = vin;
        this.carDetail = carDetail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public CarDetail getCarDetail() {
        return carDetail;
    }

    public void setCarDetail(CarDetail carDetail) {
        this.carDetail = carDetail;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", vin='" + vin + '\'' +
                ", carDetail=" + carDetail +
                ", owner=" + owner +
                ", make=" + make +
                ", location=" + location +
                '}';
    }
}
