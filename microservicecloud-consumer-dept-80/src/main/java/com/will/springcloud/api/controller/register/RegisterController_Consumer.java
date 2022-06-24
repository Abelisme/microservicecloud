package com.will.springcloud.api.controller.register;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.will.springcloud.api.register.entity.Register;

@RestController
public class RegisterController_Consumer {
	private static final String REST_URL_PREFIX = "http://localhost:8002";

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(value = "/register")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/go-register", produces = "application/json;charset=UTF-8")
	public @ResponseBody Map<String, Object> goRegister(@RequestBody Register register) {
		return restTemplate.postForObject(REST_URL_PREFIX + "/go-register", register, Map.class);
	}

}
