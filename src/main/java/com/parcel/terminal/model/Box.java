package com.parcel.terminal.model;

import java.util.Optional;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
	private Integer id;
	private String size;
	private Optional<String> parcelId;
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
	public Optional<String> getParcelId() {
		return parcelId;
	}
	public void setParcelId(Optional<String> parcelId) {
		this.parcelId = parcelId;
	}
	@Override
	public String toString() {
		return "Box [id=" + id + ", size=" + size + ", parcelId=" + parcelId + "]";
	}
}
