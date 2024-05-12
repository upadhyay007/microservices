package com.delivery.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseDto<T> {
	private String statusCode;
	private String statusMsg;
	private T responseObject;
	private List<T> responseList;
	
	public ResponseDto(String statusCode, String statusMsg, T response) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
		this.responseObject = response;
	}
 
	public ResponseDto(String statusMsg, List<T> responseList) {
		super();
		this.statusMsg = statusMsg;
		this.responseList = responseList;
	}

	public ResponseDto(String statusCode, String statusMsg) {
		super();
		this.statusCode = statusCode;
		this.statusMsg = statusMsg;
	}
	
}
