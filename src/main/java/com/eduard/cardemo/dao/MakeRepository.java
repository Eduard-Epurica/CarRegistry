package com.eduard.cardemo.dao;

import com.eduard.cardemo.entity.Make;
import com.eduard.cardemo.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {

    Make findById(int theId);

    void deleteById(int theId);

    List<Make> findAll();

    Make findByName(String name);
}
