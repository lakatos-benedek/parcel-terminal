package com.parcel.terminal.model;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "boxes")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class Box {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String size;
	private Integer parcelId;

	public Box() {

	}

	public Box(String size, Integer parcelId) {
		this.size = size;
		this.parcelId = parcelId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getParcelId() {
		return parcelId;
	}

	public void setParcelId(Integer parcelId) {
		this.parcelId = parcelId;
	}

	@Override
	public String toString() {
		return "Box [id=" + id + ", size=" + size + ", parcelId=" + parcelId + "]";
	}
}
