package com.delivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long productId;

	@Column(name = "product_uuid")
	private Long productUid;

	@Column(name = "account_id")
	private String accountNumber;

	@Column(name = "mobile_No")
	private String mobileNumber;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "product_desc")
	private String productDesc;

	@Column(name = "product_qty")
	private Long qty;
	
	@Column(name = "product_price")
	private Double price;
	
	@Column(name = "product_type")
	@Enumerated(EnumType.STRING)
	private ItemType type;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "deliveys_days")
	private DeliveryDays days;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "timings")
	private DeliveryTimes time;

}
