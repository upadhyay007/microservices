package com.delivery.service.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.delivery.dto.ProductDto;

@FeignClient(name="products")
public interface ProductsFeignClient {
	@GetMapping(value = "/api/products/fetch-all-products", consumes = "application/json")
	public ResponseEntity<List<ProductDto>> fetchProductsList(@RequestParam String mobileNumber);
}
 