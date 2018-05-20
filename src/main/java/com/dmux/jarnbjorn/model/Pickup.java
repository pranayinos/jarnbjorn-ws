package com.dmux.jarnbjorn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;

import lombok.Data;

/**
 * The persistent class for the pickups database table.
 * 
 */
@Data
@Entity
@Table(name="pickups")
@NamedQuery(name="Pickup.findAll", query="SELECT p FROM Pickup p")
public class Pickup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	private String address;

	private String landmark;

	private double latitude;

	private double longitude;

	private String name;

	private Long phone;

	@Column(name="pickup_time")
	private Long pickupTime;

}