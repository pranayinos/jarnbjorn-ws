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
 * The persistent class for the saved_address database table.
 * 
 */
@Data
@Entity
@Table(name="saved_address")
@NamedQuery(name="SavedAddress.findAll", query="SELECT s FROM SavedAddress s")
public class SavedAddress implements Serializable {
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

	@Column(name="user_id", nullable=false)
	private Long userId;

}