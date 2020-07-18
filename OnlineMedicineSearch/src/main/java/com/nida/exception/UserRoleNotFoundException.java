package com.nida.exception;

import com.nida.security.model.Role;

public class UserRoleNotFoundException extends RuntimeException {
	
	public UserRoleNotFoundException() {
		super("No role given");
	}

	public UserRoleNotFoundException(Role adminRole) {
		// TODO Auto-generated constructor stub
		super("Role is not given");
	}

}
