package com.dmux.jarnbjorn.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * The persistent class for the order database table.
 * 
 */
@Data
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Long id;

	@Setter(AccessLevel.NONE)
	private boolean hasReturn;

	@Lob
	@Column(name="special_instructions", columnDefinition = "TEXT")
	private String specialInstructions;

	@Column(name="order_created_time")
	private Long orderCreatedTime;

	@Column(nullable=false, length=31)
	private String status;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id", nullable=false)
	private List<Pickup> pickups;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id", nullable=false)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Delivery> deliveries;

	public Order() {
		this.orderCreatedTime = System.currentTimeMillis();
	}
}