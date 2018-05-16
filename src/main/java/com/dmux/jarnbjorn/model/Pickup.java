package com.dmux.jarnbjorn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import java.io.Serializable;


/**
 * The persistent class for the pickups database table.
 * 
 */
@Entity
@Table(name="pickups")
@NamedQuery(name="Pickup.findAll", query="SELECT p FROM Pickup p")
public class Pickup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	private int address;

	private int landmark;

	private int latitude;

	private int longitude;

	private int name;

	@Column(name="order_id", nullable=false)
	private int orderId;

	private int phone;

	@Column(name="pickup_time")
	private int pickupTime;

	public Pickup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAddress() {
		return this.address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public int getLandmark() {
		return this.landmark;
	}

	public void setLandmark(int landmark) {
		this.landmark = landmark;
	}

	public int getLatitude() {
		return this.latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return this.longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public int getName() {
		return this.name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getOrderId() {
		return this.orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getPickupTime() {
		return this.pickupTime;
	}

	public void setPickupTime(int pickupTime) {
		this.pickupTime = pickupTime;
	}

}