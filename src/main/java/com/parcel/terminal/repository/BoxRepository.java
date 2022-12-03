package com.parcel.terminal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.parcel.terminal.model.Box;

@Repository
public interface BoxRepository extends JpaRepository<Box, Integer> {
	@Query("SELECT COUNT(*) FROM Box b WHERE b.size=?1 AND (b.parcelId IS NULL OR b.parcelId ='')")
	Integer countEmptyBoxes(String size);

	@Query("SELECT b FROM Box b WHERE b.size=?1 AND (b.parcelId IS NULL OR b.parcelId ='')")
	List<Box> getEmptyBoxesBySize(String size);

	@Query("SELECT b FROM Box b WHERE b.parcelId=?1")
	Box getBoxFromParcelId(Integer parcelId);

	@Query("SELECT b.id FROM Box b WHERE (b.parcelId IS NULL OR b.parcelId ='')")
	List<Integer> getEmptyBoxes();
}
