package com.delivery.service;

import java.util.List;

import com.delivery.dto.ProductDto;

public interface IProductServices {
	boolean createProduct(ProductDto productDto);

	List<ProductDto> fetchProductList(String productDto);

	boolean updateProduct(ProductDto productDto);

	boolean deleteProduct(ProductDto productDto);

	public ProductDto fetchProduct(Long productId);
}
