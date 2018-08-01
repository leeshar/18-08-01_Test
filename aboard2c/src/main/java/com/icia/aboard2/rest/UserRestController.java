package com.icia.aboard2.rest;


import javax.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import com.icia.aboard2.dto.UserDto.*;
import com.icia.aboard2.rest_service.*;
import com.icia.aboard2.util.*;

import lombok.*;

@RestController
public class UserRestController {
	@Autowired
	private UserRestService service;
	
	@PostMapping("/user/idCheck")
	public ResponseEntity<Void> idCheck(@NonNull String id) {
		boolean result = service.idCheck(id);
		if(result)
			return new ResponseEntity<>(HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@PostMapping("/user/changePwd")
	public ResponseEntity<Void> changePwd(@Valid ChangeUserPwd user, BindingResult results) throws BindException {
		ABoard2Util.throwBindException(results);
		service.pwdChange(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	// 이름 변경 : irumChange
	@PostMapping("/user/changeIrum")
	public ResponseEntity<Void> changeIrum(@Valid ChangeIrum user, BindingResult results) throws BindException {
		ABoard2Util.throwBindException(results);
		service.irumChange(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}






