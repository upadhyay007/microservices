package com.delivery.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
}
