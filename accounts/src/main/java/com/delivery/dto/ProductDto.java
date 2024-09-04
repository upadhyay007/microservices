package com.delivery.dto;

import lombok.Data;

@Data
public class ProductDto {
	private long productUid;
	private String productName;
	private String productDesc;
	private String mobileNumber;
	private Long qty;
	private Double price;
	private String type;
	private String days;
	private String time;
	
	
}
