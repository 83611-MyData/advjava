package com.sunbeam.exception;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class HelpException extends RuntimeException {
	private String msg;
	public HelpException(String msg) {
		this.msg = msg;
	}
}
