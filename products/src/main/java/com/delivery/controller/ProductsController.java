package com.delivery.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.constants.ProductsConstants;
import com.delivery.dto.ProductDto;
import com.delivery.dto.ResponseDto;
import com.delivery.service.IProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	@Autowired
	private IProductServices iProductServices;

	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createProduct(@RequestBody ProductDto productDto) {
		iProductServices.createProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(
				new ResponseDto<ProductDto>(ProductsConstants.STATUS_201, ProductsConstants.MESSAGE_201, productDto));
	}

	@GetMapping("/fetch-all-products")
	public ResponseEntity<List<ProductDto>> fetchProductList(@RequestParam String mobileNumber) {
		List<ProductDto> fetchProduct = iProductServices.fetchProductList(mobileNumber);

		return ResponseEntity.status(HttpStatus.OK).body(fetchProduct);

	}

	@GetMapping("/fetch")
	public ResponseEntity<ProductDto> fetchProduct(@RequestParam Long productId) {
		ProductDto fetchProduct = iProductServices.fetchProduct(productId);

		return ResponseEntity.status(HttpStatus.OK).body(fetchProduct);

	}

	@PutMapping("/update")
	public ResponseEntity<ResponseDto> updateProduct(@RequestBody ProductDto productDto) {
		boolean updateProduct = iProductServices.updateProduct(productDto);
		if (updateProduct) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto<ProductDto>(ProductsConstants.STATUS_200, ProductsConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
					new ResponseDto<ProductDto>(ProductsConstants.STATUS_417, ProductsConstants.MESSAGE_417_UPDATE));
		}

	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDto> deleteProduct(@RequestBody ProductDto productDto) {
		boolean deleteProduct = iProductServices.deleteProduct(productDto);
		if (deleteProduct) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseDto<ProductDto>(ProductsConstants.STATUS_200, ProductsConstants.MESSAGE_200));
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(
					new ResponseDto<ProductDto>(ProductsConstants.STATUS_417, ProductsConstants.MESSAGE_417_DELETE));
		}

	}
}
