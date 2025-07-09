package com.example.demo.vo.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
	private int code;
	private String message;
	private T data;
	
	public static <T> ApiResponse<T> success(T data){
		
		return ApiResponse.<T>builder()
				.code(200) 
				.message("성공") 
				.data(data) 
				.build();
	}
	
	public static <T> ApiResponse<T> error(String message, int code){
		return ApiResponse.<T>builder()
				.code(code)
				.message(message)
				.data(null)
				.build();
	}
}
