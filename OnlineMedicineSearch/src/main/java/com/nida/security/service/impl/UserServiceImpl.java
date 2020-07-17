package com.nida.security.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nida.security.dao.UserDao;
import com.nida.security.model.User;
import com.nida.security.model.UserDto;
import com.nida.security.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {	
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
		});
		return authorities;
	
	}

	@Override
	public User save(UserDto user) {
		// TODO Auto-generated method stub
		  User newUser = new User();
		    newUser.setUsername(user.getUsername());
		    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setEmail(user.getEmail());
	        return userDao.save(newUser);
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
	}

	@Override
	public User findOne(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).get();
	}

}
