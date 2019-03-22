package it.garbi.consuntivo.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	@RequestMapping("/test")
	public String test(){
		return "CouponService works correctly";
	}
}
