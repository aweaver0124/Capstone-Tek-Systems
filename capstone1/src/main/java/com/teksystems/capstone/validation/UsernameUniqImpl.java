package com.teksystems.capstone.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.teksystems.capstone.database.dao.UserDAO;
import com.teksystems.capstone.database.entity.User;

public class UsernameUniqImpl implements ConstraintValidator<UsernameUnique, String>{
	
	public static final Logger LOG = LoggerFactory.getLogger(UsernameUniqImpl.class);
	
	@Autowired
	private UserDAO userDao;
	
	@Override
	public void initialize(UsernameUnique constraintAnnotation) {}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		
		User user = userDao.findByUsername(value);
		return (user == null);
	}

	

}
