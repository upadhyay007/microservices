package com.delivery.dto;

import com.delivery.entity.DeliveryDays;
import com.delivery.entity.DeliveryTimes;
import com.delivery.entity.ItemType;

import lombok.Data;

@Data
public class ProductDto {
	private long productUid;
	private String productName;
	private String productDesc;
	private String mobileNumber;
	private Long qty;
	private Double price;
	private ItemType type;
	private DeliveryDays days;
	private DeliveryTimes time;

}
