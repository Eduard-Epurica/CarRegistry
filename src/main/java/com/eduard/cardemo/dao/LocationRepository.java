package com.eduard.cardemo.dao;

import com.eduard.cardemo.entity.Location;
import com.eduard.cardemo.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    Location findById(int theId);

    void deleteById(int theId);

    Location findByPostCode(String postCode);
}
