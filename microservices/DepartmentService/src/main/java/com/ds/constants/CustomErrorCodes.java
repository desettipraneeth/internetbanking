package com.ds.constants;

import lombok.Getter;

@Getter
public enum CustomErrorCodes {

	DEPID_NOT_FOUND("101", "Dep id not found in db.");

	private String errorCode;
	private String errorMessage;

	private CustomErrorCodes(String errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}

}
