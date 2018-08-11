package com.ld.net.spider.demo.ws.service.impl;

import org.springframework.stereotype.Service;

import com.ld.net.spider.demo.ws.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
	@Override
	public String getStr(){
		return "{\"age\":13}";
	}
}
