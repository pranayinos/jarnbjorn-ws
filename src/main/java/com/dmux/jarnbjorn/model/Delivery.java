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
 * The persistent class for the deliveries database table.
 * 
 */
@Entity
@Data
@Table(name="deliveries")
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	private String address;

	@Column(name="delivery_time")
	private Long deliveryTime;

	private String landmark;

	private double latitude;

	private double longitude;

	private String name;

	private Long phone;

}