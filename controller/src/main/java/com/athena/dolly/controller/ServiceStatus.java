package com.athena.dolly.controller;

/**
 * Represent the status and message that will be returned from service
 * 
 * @author Tran Ho
 * 
 */
public class ServiceStatus {
	private Status status;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ServiceStatus(Status s, String msg) {
		status = s;
		message = msg;
	}

	public enum Status {
		DONE, FAILED, ERROR,
	}
}
