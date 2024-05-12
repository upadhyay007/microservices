package com.delivery.controller;

import static org.mockito.ArgumentMatchers.any;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.delivery.dto.CustomerDto;
import com.delivery.service.IAccountsService;
import com.delivery.service.impl.AccountsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers = AccountsController.class)
@MockBean({ AccountsServiceImpl.class })
public class AccountsControllerWebLayerTest {
	@Autowired
	MockMvc mockMvc;

	@Autowired
	IAccountsService iAccountsService;

	@Test
	@DisplayName("Create_user_on_valid_request")
	void testCreateInAccountMicroservices() throws Exception {
		// Arrange
		CustomerDto customerDto = new CustomerDto();
		customerDto.setName("Anurag Upadhyay");
		customerDto.setEmail("anurag@gmail.com");
		customerDto.setMobileNumber("1234567890");
		 
		RequestBuilder content = MockMvcRequestBuilders.post("/api/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(customerDto));
		Mockito.when(iAccountsService.createAccount(any(CustomerDto.class))).thenReturn(customerDto);
		// Acts

		MvcResult andReturn = mockMvc.perform(content).andReturn();
		String contentAsString = andReturn.getResponse().getContentAsString();
		CustomerDto readValue = new ObjectMapper().readValue(contentAsString, CustomerDto.class);
		 
		
		// Asserts

		Assertions.assertEquals(andReturn.getResponse().getStatus(), 201);
	}
	@Test
	@DisplayName("Create_user_on_valid_request-1")
	void testCreateInAccountMicroservices1() throws Exception {
		// Arrange
		CustomerDto customerDto = new CustomerDto();
		customerDto.setName("Anurag Upadhyay");
		customerDto.setEmail("anurag@gmail.com");
		customerDto.setMobileNumber("1234567890");
		 
		RequestBuilder content = MockMvcRequestBuilders.post("/api/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(customerDto));
		Mockito.when(iAccountsService.createAccount(any(CustomerDto.class))).thenReturn(customerDto);
		// Acts

		MvcResult andReturn = mockMvc.perform(content).andReturn();
		String contentAsString = andReturn.getResponse().getContentAsString();
		CustomerDto readValue = new ObjectMapper().readValue(contentAsString, CustomerDto.class);
		 
		
		// Asserts
		Assertions.assertEquals(readValue.getAccountsDto(),null);
		Assertions.assertNull(readValue.getAccountsDto());
	}
	@Test
	@DisplayName("Create_user_on_valid_request")
	void testCreateInAccountMicroservices2() throws Exception {
		// Arrange
		CustomerDto customerDto = new CustomerDto();
		customerDto.setName("Anurag Upadhyay");
		customerDto.setEmail("anurag@gmail.com");
		customerDto.setMobileNumber("1234567890");
		 
		RequestBuilder content = MockMvcRequestBuilders.post("/api/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(customerDto));
		Mockito.when(iAccountsService.createAccount(any(CustomerDto.class))).thenReturn(customerDto);
		// Acts

		MvcResult andReturn = mockMvc.perform(content).andReturn();
		String contentAsString = andReturn.getResponse().getContentAsString();
		CustomerDto readValue = new ObjectMapper().readValue(contentAsString, CustomerDto.class);
		 
		
		// Asserts

		Assertions.assertEquals(readValue.getName(), customerDto.getName());
	}
	@Test
	@DisplayName("Create_user_on_valid_request")
	void testCreateInAccountMicroservices3() throws Exception {
		// Arrange
		CustomerDto customerDto = new CustomerDto();
		customerDto.setName("Anurag Upadhyay");
		customerDto.setEmail("anurag@gmail.com");
		customerDto.setMobileNumber("1234567890");
		 
		RequestBuilder content = MockMvcRequestBuilders.post("/api/create").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(new ObjectMapper().writeValueAsString(customerDto));
		Mockito.when(iAccountsService.createAccount(any(CustomerDto.class))).thenReturn(customerDto);
		// Acts

		MvcResult andReturn = mockMvc.perform(content).andReturn();
		String contentAsString = andReturn.getResponse().getContentAsString();
		CustomerDto readValue = new ObjectMapper().readValue(contentAsString, CustomerDto.class);
		 
		
		// Asserts

		Assertions.assertEquals(readValue.getMobileNumber(), customerDto.getMobileNumber());
	}
 
}
