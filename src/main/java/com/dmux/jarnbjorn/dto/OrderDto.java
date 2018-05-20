package com.dmux.jarnbjorn.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class OrderDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private boolean hasReturn;
	private String specialInstructions;
	private Long orderCreatedTime;
	private String status;
	private List<PickupDto> pickupDtos;
	private List<DeliveryDto> deliveries;

}