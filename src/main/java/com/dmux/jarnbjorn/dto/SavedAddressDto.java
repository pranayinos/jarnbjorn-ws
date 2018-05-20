package com.dmux.jarnbjorn.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class SavedAddressDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String address;
	private String landmark;
	private double latitude;
	private double longitude;
	private String name;
	private Long phone;
	private Long userId;

}