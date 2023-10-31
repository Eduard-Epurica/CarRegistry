package com.eduard.cardemo.dao;

import com.eduard.cardemo.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

    Owner findOwnerById(int theId);

    void deleteOwnerById(int theId);
    Owner findByFirstNameAndLastName(String firstName, String lastName);


}
