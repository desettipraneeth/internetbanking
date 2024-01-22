package com.os.constants;

import lombok.Getter;

@Getter
public enum CustomErrorCodes {

	EMPID_NOT_FOUND("201", "Emp id not found in db.");

	private String errorCode;
	private String errorMessage;

	private CustomErrorCodes(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}

}
