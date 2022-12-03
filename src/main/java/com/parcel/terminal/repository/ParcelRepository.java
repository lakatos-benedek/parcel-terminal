package com.parcel.terminal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parcel.terminal.model.Parcel;

@Repository
public interface ParcelRepository extends JpaRepository<Parcel, Integer> {
	@Query("SELECT p FROM Parcel p WHERE p.id=?1 AND p.password=?2")
	Parcel getParcelByIdAndPassword(Integer id, String password);
}
