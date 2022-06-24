package com.will.springcloud.api.register.service;

import java.sql.SQLException;

import com.will.springcloud.api.register.entity.Register;

public interface RegisterService {
	int insert(Register register) throws SQLException;
}
