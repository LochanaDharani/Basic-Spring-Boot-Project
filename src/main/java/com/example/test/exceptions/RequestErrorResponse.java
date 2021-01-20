package com.example.test.exceptions;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RequestErrorResponse {
    
    private String message;

	public RequestErrorResponse(String message) {
		this.message = message;

    }
    
}
