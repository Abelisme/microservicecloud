package com.will.springcloud.api.register.dao;

import org.apache.ibatis.annotations.Mapper;

import com.will.springcloud.api.register.entity.Register;

@Mapper
public interface RegisterMapper {
	int insert(Register register);

    Register getRegister(String address);
}
