package com.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.delivery.dto.AccountsContactInfoDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableConfigurationProperties(value = {AccountsContactInfoDto.class})

@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "Delivery Accounts microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Anurag Upadhyay",
						email = "mavensonair@gmail.com",
						url = "https://www.mavensonair.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.eazybytes.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description =  "Delivery Accounts microservice REST API Documentation",
				url = "https://www.mavensonair.com/swagger-ui.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
