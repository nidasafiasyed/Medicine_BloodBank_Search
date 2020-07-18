package com.nida.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;



public interface UserDetailsService {
	
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
