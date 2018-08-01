package com.icia.aboard2.rest_service;

import org.modelmapper.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import com.icia.aboard2.dao.*;
import com.icia.aboard2.dto.UserDto.*;
import com.icia.aboard2.entity.*;
import com.icia.aboard2.entity.User;
import com.icia.aboard2.exception.*;

@Service
public class UserRestService {
	@Autowired
	private UserRepository dao;
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private PasswordEncoder encoder;
	
	public void pwdChange(ChangeUserPwd u) {
		String pwd = dao.getPwd(u.getId());
		if(pwd==null)								// 비밀번호가 null -> 유저가 없다
			throw new UserNotFoundException(u.getId());
		if(!encoder.matches(u.getOldPwd(), pwd))	// 비밀번호가 틀리다
			throw new InvalidPasswordException();
		User user = new User();
		user.setId(u.getId());
		user.setPwd(encoder.encode(u.getNewPwd()));
		dao.pwdChange(user);
	}
	
	public void irumChange(ChangeIrum u) {
		User user = mapper.map(u, User.class);
		if(dao.irumChange(user)==0)
			throw new UserNotFoundException(user.getId());
	}
	
	public boolean idCheck(String id) {
		return dao.idCheck(id)==null? true: false;
	}

}
