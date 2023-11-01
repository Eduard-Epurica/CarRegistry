package com.eduard.cardemo.dao;

import com.eduard.cardemo.entity.CarDetail;
import com.eduard.cardemo.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDetailRepository extends JpaRepository<CarDetail, Long> {

    public void deleteById(int theId);

    public CarDetail findById(int theId);

}
