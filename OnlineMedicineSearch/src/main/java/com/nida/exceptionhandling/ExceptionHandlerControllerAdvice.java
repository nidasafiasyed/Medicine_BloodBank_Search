package com.nida.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nida.exception.MedicineNotFoundException;
import com.nida.exception.PharmacyNotFoundException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(MedicineNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseMessage handleMedicineNotFound (final MedicineNotFoundException exception,
		final HttpServletRequest request) {
		
		ResponseMessage error = new ResponseMessage();
		error.setErrorMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		return error;
	}
	
	@ExceptionHandler(PharmacyNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseMessage handleException (final PharmacyNotFoundException exception,
			final HttpServletRequest request) {
			
			ResponseMessage error = new ResponseMessage();
			error.setErrorMessage(exception.getMessage());
			error.callerURL(request.getRequestURI());
			return error;
		}
	

}
