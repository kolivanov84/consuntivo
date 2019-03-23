package it.garbi.consuntivo.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import io.jsonwebtoken.ExpiredJwtException;
import it.garbi.consuntivo.entities.User;
import it.garbi.consuntivo.services.UserService;
import it.garbi.consuntivo.utils.UserNotLoggedException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	private static final Logger log = LoggerFactory.getLogger(RestController.class);
	
	@Autowired
    UserService userService;
	
	@RequestMapping("/test")
	public String test(){
		return "CouponService works correctly";
	}
	
	 /**
     * inner class used as the Object tied into the Body of the ResponseEntity.
     * It's important to have this Object because it is composed of server response code and response object.
     * Then, JACKSON LIBRARY automatically convert this JsonResponseBody Object into a JSON response.
     */
    @AllArgsConstructor
    public class JsonResponseBody{
        @Getter @Setter
        private int server;
        @Getter @Setter
        private Object response;
    }

    /*---------------------------------------------------------*/
	
	@RequestMapping(value = "/user/add", method=POST)
    public ResponseEntity<JsonResponseBody> addOperation(HttpServletRequest request, @Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "Error! Invalid format of data."));
        }
        try {
//            loginService.verifyJwtAndGetData(request);
            return ResponseEntity.status(HttpStatus.OK).body(new JsonResponseBody(HttpStatus.OK.value(), userService.saveUser(user)));
        }
//        catch(UserNotLoggedException e1){
//            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new JsonResponseBody(HttpStatus.FORBIDDEN.value(), "User not logged! Login first : " + e1.toString()));
//        }
//        catch(UnsupportedEncodingException e2){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad Request: " + e2.toString()));
//        }
//        catch(ExpiredJwtException e3){
//            return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(new JsonResponseBody(HttpStatus.GATEWAY_TIMEOUT.value(), "Session Expired!: " + e3.toString()));
//        }
        catch(Exception e){
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResponseBody(HttpStatus.BAD_REQUEST.value(), "Bad Request: " + e.toString()));
        }
    }
}
