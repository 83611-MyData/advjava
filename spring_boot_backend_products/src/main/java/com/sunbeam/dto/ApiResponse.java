package com.sunbeam.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class ApiResponse {
	
	private String msg;
	private LocalDate date;
	public ApiResponse(String msg) {
		this.msg = msg;
		this.date=LocalDate.now();
	}
}
