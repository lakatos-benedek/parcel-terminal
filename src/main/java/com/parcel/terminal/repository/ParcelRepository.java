package com.parcel.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parcel.terminal.model.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Integer> {

}
