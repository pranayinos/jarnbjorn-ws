package com.dmux.jarnbjorn.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class DeliveryDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;
	private Long deliveryTime;
	private String landmark;
	private double latitude;
	private double longitude;
	private String name;
	private Long phone;

}