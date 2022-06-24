package com.will.springcloud.api.register.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.will.springcloud.api.register.dao.RegisterMapper;
import com.will.springcloud.api.register.entity.Register;
import com.will.springcloud.api.register.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterMapper mapper;

    @Override
    public int insert(Register register) throws SQLException{
        int result = mapper.insert(register);
        
        return result;
    }

}
