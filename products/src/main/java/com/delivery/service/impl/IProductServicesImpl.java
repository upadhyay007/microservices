package com.delivery.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.delivery.dto.ProductDto;
import com.delivery.entity.Products;
import com.delivery.exception.ProductNotExistsException;
import com.delivery.repository.ProductsRepository;
import com.delivery.service.IProductServices;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IProductServicesImpl implements IProductServices {
	private ProductsRepository productsRepository;
	private ModelMapper modelMapper;

	@Override
	public boolean createProduct(ProductDto productDto) {
		Products products = modelMapper.map(productDto, Products.class);
		long randomProductNumber = 1000000000L + new Random().nextInt(900000000);
		products.setProductUid(randomProductNumber);
		Products save = productsRepository.save(products);
		return (save.getProductId() != null) ? true : false;
	}

	@Override
	public ProductDto fetchProduct(Long productId) {
		// TODO Auto-generated method stub
		Products productDetails = productsRepository.findByProductUid(productId)
				.orElseThrow(() -> new ProductNotExistsException("Product Not Exist"));
		return modelMapper.map(productDetails, ProductDto.class);
	}

	@Override
	public List<ProductDto> fetchProductList(String mobileNumber) {
		return productsRepository.findByMobileNumber(mobileNumber).stream()
				.map(f -> modelMapper.map(f, ProductDto.class)).collect(Collectors.toList());

		/*
		 * List<ProductDto> list = new ArrayList(); findProductListMobileNumber.stream()
		 * .collect(Collectors.mapping(f -> list.add(modelMapper.map(f,
		 * ProductDto.class)), Collectors.toList()));
		 */

	}

	@Override
	public boolean updateProduct(ProductDto productDto) {
		boolean isUpdated = false;
		Products products = productsRepository.findByProductUid(productDto.getProductUid())
				.orElseThrow(() -> new ProductNotExistsException("No product not found"));
		Products productUpdated = modelMapper.map(productDto, Products.class);
		productUpdated.setProductId(products.getProductId());
		productsRepository.save(productUpdated);
		isUpdated = true;

		return isUpdated;
	}

	@Override
	public boolean deleteProduct(ProductDto productDto) {
		Products products = productsRepository.findByProductUid(productDto.getProductUid())
				.orElseThrow(() -> new ProductNotExistsException("No product found"));
		productsRepository.delete(products);
		return true;
	}

}
