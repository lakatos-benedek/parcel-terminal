package com.parcel.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcel.terminal.model.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Integer> {

}
