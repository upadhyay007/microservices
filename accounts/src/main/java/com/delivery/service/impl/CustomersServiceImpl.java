package com.delivery.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.delivery.dto.AccountsDto;
import com.delivery.dto.CustomerDetailsDto;
import com.delivery.dto.LoansDto;
import com.delivery.dto.ProductDto;
import com.delivery.entity.Accounts;
import com.delivery.entity.Customer;
import com.delivery.exception.ResourceNotFoundException;
import com.delivery.mapper.AccountsMapper;
import com.delivery.mapper.CustomerMapper;
import com.delivery.repository.AccountsRepository;
import com.delivery.repository.CustomerRepository;
import com.delivery.service.ICustomersService;
import com.delivery.service.client.ProductsFeignClient;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService{
    private AccountsRepository accountsRepository;
    private CustomerRepository customerRepository;
    private ProductsFeignClient productsFeignClient;
    //private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     *  @param correlationId - Correlation ID value generated at Edge server
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<List<ProductDto>> productsDtoResponseEntity = productsFeignClient.fetchProductsList(mobileNumber);
        customerDetailsDto.setProductDto(productsDtoResponseEntity.getBody());

        //ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        //customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}
