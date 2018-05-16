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
 * The persistent class for the deliveries database table.
 * 
 */
@Entity
@Table(name="deliveries")
@NamedQuery(name="Delivery.findAll", query="SELECT d FROM Delivery d")
public class Delivery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	private int address;

	@Column(name="delivery_time")
	private int deliveryTime;

	private int landmark;

	private int latitude;

	private int longitude;

	private int name;

	@Column(name="order_id", nullable=false)
	private int orderId;

	private int phone;

	public Delivery() {
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

	public int getDeliveryTime() {
		return this.deliveryTime;
	}

	public void setDeliveryTime(int deliveryTime) {
		this.deliveryTime = deliveryTime;
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

}