package com.nida.exceptionhandling;

public class ResponseMessage {
	
	private String errorMessage;
	private String requestedURI;
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getRequestedURL() {
		return requestedURI;
	}
	public void callerURL(final String requestedURI) {
		this.requestedURI = requestedURI;
	}

}
