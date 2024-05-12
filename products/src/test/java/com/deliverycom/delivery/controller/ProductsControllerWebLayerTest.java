package com.deliverycom.delivery.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.delivery.controller.ProductsController;
import com.delivery.dto.ProductDto;
import com.delivery.service.IProductServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@Disabled
@WebMvcTest(controllers = ProductsController.class)
public class ProductsControllerWebLayerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	IProductServices iProductServices;

	@Test
	@DisplayName("CreateProduct")
	void createProduct_when_valid_userdetails() throws Exception {
		// Arrange
		ProductDto productDto = new ProductDto();
		productDto.setMobileNumber("1234567890");
		productDto.setProductName("Milk");
		productDto.setProductDesc("Pure Milk");
		when(iProductServices.createProduct(any(ProductDto.class))).thenReturn(true);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/products/create")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(productDto));
		// Act
		MvcResult andReturn = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = andReturn.getResponse();

		// Assert

		Assertions.assertEquals(200, response.getStatus());
	}
}
