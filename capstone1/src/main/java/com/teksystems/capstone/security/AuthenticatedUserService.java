package com.teksystems.capstone.security;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.User;

import lombok.ToString;


@Component
@ToString
public class AuthenticatedUserService {

	@Autowired
	private UserDAO userDao;
	
	public String getCurrentUsername() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null && context.getAuthentication() != null) {
			final org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) context.getAuthentication().getPrincipal();
			return principal.getUsername();
		} else {
			return null;
		}
	}
	
	public boolean isUserInRole(String role) {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null && context.getAuthentication() != null) {
			Collection<? extends GrantedAuthority> authorities = context.getAuthentication().getAuthorities();
			for (GrantedAuthority auth: authorities) {
				if (auth.getAuthority().equals(role)) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public User getCurrentUser() {
		ServletRequestAttributes at = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpSession session = at.getRequest().getSession(true);
		User user = (User) session.getAttribute("user");
		if (user == null) {
			user = userDao.findByUsername(getCurrentUsername());
			session.setAttribute("user", user);
		}
		
		return user;
	}
	
	public boolean isAuthenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof AnonymousAuthenticationToken) {
			return false;
		}
		
		return (auth != null && auth.isAuthenticated());
	}
}
