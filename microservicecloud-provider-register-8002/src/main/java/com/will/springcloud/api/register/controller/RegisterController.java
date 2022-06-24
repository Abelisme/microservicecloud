package com.will.springcloud.api.register.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.will.springcloud.api.register.entity.Register;
import com.will.springcloud.api.register.service.RegisterService;
import com.will.springcloud.api.register.utils.AesUtils;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response){
        return new ModelAndView("register");
    }

    @RequestMapping(value = "/go-register", produces = "application/json;charset=UTF-8")
    public @ResponseBody Map<String, Object> goRegister(HttpServletRequest request, HttpServletResponse response, @RequestBody Register register){
        Map<String, Object> jsonMap = new HashMap<String, Object>();
        try {
            //encode
            String encryptAddr = AesUtils.encrypt(register.getAddress());
            //save into db
            Register insertRegister = new Register();
            insertRegister.setAddress(encryptAddr);
            int result = registerService.insert(insertRegister);
            jsonMap.put("result", result);
        } catch (SQLException e) {
        	jsonMap.put("errorMsg", "connect issue,please check try again later");
        } catch (Exception e) {
        	if(StringUtils.contains(e.getMessage(), "Failed to obtain JDBC Connection")) {
        		jsonMap.put("errorMsg", "connect issue, please check try again later");
        		return jsonMap;
        	}
            jsonMap.put("errorMsg", e.getMessage());
        } 
        
        return jsonMap;
    }
}
