package com.deliverycom.delivery.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import com.delivery.controller.ProductsController;

@WebMvcTest(controllers = ProductsController.class)
public class ProductsControllerTest {
	
	@Test
	@DisplayName("CreateProduct")
	void createProduct_when_valid_userdetails() throws Exception {
	}
}
