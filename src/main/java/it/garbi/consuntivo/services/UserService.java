package it.garbi.consuntivo.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import it.garbi.consuntivo.entities.User;
import it.garbi.consuntivo.utils.UserNotLoggedException;


public interface UserService {
	
	Optional<User> getUserFromDbAndVerifyPassword(Integer id, String password)throws UserNotLoggedException;

    String createJwt(String subject, String name, String permission, Date date) throws UnsupportedEncodingException;

    Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws UserNotLoggedException, UnsupportedEncodingException;
    
    User saveUser(User operation);
}
