package vabiss.com.userRegister.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vabiss.com.userRegister.business.abstracts.AuthService;
import vabiss.com.userRegister.entities.dtos.UserDto;

@RestController
@RequestMapping("/api/auth/")
public class AuthConroller {

	@Autowired
	private AuthService authService;

	@PostMapping("login")
	public ResponseEntity<?> login(@RequestBody UserDto userDto) {

		return ResponseEntity.ok(this.authService.login(userDto));

	}
}
