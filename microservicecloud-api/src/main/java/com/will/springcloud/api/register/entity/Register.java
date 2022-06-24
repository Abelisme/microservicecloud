package com.will.springcloud.api.register.entity;

import lombok.Data;

@Data
//@TableName("register_address")
//@JsonIgnoreProperties(ignoreUnknown = true)
public class Register {
	private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
