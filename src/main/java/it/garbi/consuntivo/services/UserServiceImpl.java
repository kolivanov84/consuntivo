package it.garbi.consuntivo.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.garbi.consuntivo.dao.UserDao;
import it.garbi.consuntivo.entities.User;
import it.garbi.consuntivo.utils.EncryptionUtils;
import it.garbi.consuntivo.utils.JwtUtils;
import it.garbi.consuntivo.utils.UserNotLoggedException;

public class UserServiceImpl implements UserService{
	
private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	EncryptionUtils encryptionUtils;

	@Override
	public Optional<User> getUserFromDbAndVerifyPassword(Integer id, String password) throws UserNotLoggedException {
		Optional<User> userOptional  = userDao.findById(id);
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			if(encryptionUtils.decrypt(user.getPassword()).equals(password))
				log.info("Autenticazione corretta");
			else {
				log.error("Autenticazione fallita");
				throw new UserNotLoggedException("Autenticazione fallita per l'utente: "+user.getUsername());
			}
				
		}
		return userOptional;
	}

	/**
	 * Metodo per la creazione del Json Web Token
	 */
	@Override
	public String createJwt(String subject, String name, String permission, Date date) throws UnsupportedEncodingException {
		Date expirationDate = date;
		expirationDate.setTime(date.getTime() + (300*1000));
		log.info("Creazione JWT token con scadenza: "+expirationDate.getTime());
		return JwtUtils.generateJwt(subject, expirationDate, name, permission);
	}
	
	
	/**
	 * Verifica validità Json Web Token
	 */
	@Override
	public Map<String, Object> verifyJwtAndGetData(HttpServletRequest request) throws UserNotLoggedException, UnsupportedEncodingException {
		String jwtString = JwtUtils.getJwtFromHttpRequest(request);
		if(jwtString == null)
			throw new UserNotLoggedException("Autenticazione JWT Fallita!");
		
		Map<String, Object> userData = JwtUtils.jwt2Map(jwtString);
		return userData;
	}
	

	/**
	 * Salvataggio nuovo utente
	 */
	@Override
	public User saveUser(User operation) {
		return userDao.save(operation);
	}

}
