package com.teksystems.capstone.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.dao.UserRoleDAO;
import com.teksystems.capstone.database.entity.User;
import com.teksystems.capstone.database.entity.UserRole;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
	
	public static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private UserRoleDAO userRoleDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("Username " + username + " not found in database.");
		}
		
		List<UserRole> userRoles = userRoleDao.findByUserId(user.getId());
		
		boolean accountIsEnabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		
		Collection<? extends GrantedAuthority> springRoles = buildGrantAuthorities(userRoles);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), accountIsEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, springRoles);
	}
	
	private Collection<? extends GrantedAuthority> buildGrantAuthorities(List<UserRole> userRoles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for (UserRole role: userRoles) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}
		
		// authorities.add(new SimpleGrantedAuthority(UserRoleEnum.USER.toString()));
		
		return authorities;
	}
	
	
	
}
