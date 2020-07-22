package com.nida.exceptionhandling;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.nida.exception.UserRoleNotFoundException;
import com.nida.exception.BloodBankNotFoundException;
import com.nida.exception.BloodNotFoundException;
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
	public @ResponseBody ResponseMessage handlePharmacyNotFound(final PharmacyNotFoundException exception,
			final HttpServletRequest request) {
			
			ResponseMessage error = new ResponseMessage();
			error.setErrorMessage(exception.getMessage());
			error.callerURL(request.getRequestURI());
			return error;
		}
	
	@ExceptionHandler(BloodNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseMessage handleBloodNotFound (final BloodNotFoundException exception,
			final HttpServletRequest request) {
			
			ResponseMessage error = new ResponseMessage();
			error.setErrorMessage(exception.getMessage());
			error.callerURL(request.getRequestURI());
			return error;
		}
	
	@ExceptionHandler(BloodBankNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseMessage handleBloodBankNotFound (final BloodBankNotFoundException exception,
			final HttpServletRequest request) {
			
			ResponseMessage error = new ResponseMessage();
			error.setErrorMessage(exception.getMessage());
			error.callerURL(request.getRequestURI());
			return error;
		}
	
	@ExceptionHandler(UserRoleNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ResponseMessage handleUserRoleNotFound (final UserRoleNotFoundException exception,
			final HttpServletRequest request) {
			
			ResponseMessage error = new ResponseMessage();
			error.setErrorMessage(exception.getMessage());
			error.callerURL(request.getRequestURI());
			return error;
		}
	

}
