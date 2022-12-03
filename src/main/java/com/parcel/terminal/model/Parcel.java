package com.parcel.terminal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parcels")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(ignoreUnknown = true, allowGetters = true)
public class Parcel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String size;
	private String password;
	private Date storedUntil;

	public Parcel() {

	}

	public Parcel(String size, String password, Date storedUntil) {
		this.size = size;
		this.password = password;
		this.storedUntil = storedUntil;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getStoredUntil() {
		return storedUntil;
	}

	public void setStoredUntil(Date storedUntil) {
		this.storedUntil = storedUntil;
	}

	@Override
	public String toString() {
		return "Parcel [id=" + id + ", size=" + size + ", password=" + password + ", storedUntil=" + storedUntil + "]";
	}
}