package com.icia.aboard2.service;


import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import com.google.gson.*;
import com.icia.aboard2.dao.*;
import com.icia.aboard2.dto.*;
import com.icia.aboard2.dto.UserDto.*;
import com.icia.aboard2.entity.*;
import com.icia.aboard2.exception.*;

@Service
public class UserService {
	@Autowired
	private UserRepository dao;
	@Autowired
	private Gson gson;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PasswordEncoder encoder;
	
	public void join(CreateUser create) {
		User user = mapper.map(create, User.class);
		user.setPwd(encoder.encode(user.getPwd()));
		dao.insertUser(user);
		dao.insertAuthority(user.getId(), "ROLE_USER");
	}
	public String read(String id) {
		User result = dao.read("hasaway11");
		UserDto.ReadUser user = mapper.map(result, UserDto.ReadUser.class);
		return gson.toJson((user));
	}
	public void update(UpdateUser u) {
		User user = mapper.map(u, User.class);
		if(dao.update(user)==0)
			throw new UserNotFoundException(user.getId());
	}
}

