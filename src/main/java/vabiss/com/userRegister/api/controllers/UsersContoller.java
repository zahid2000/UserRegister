package vabiss.com.userRegister.api.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import vabiss.com.userRegister.business.abstracts.UserService;
import vabiss.com.userRegister.core.utils.results.DataResult;
import vabiss.com.userRegister.core.utils.results.Result;
import vabiss.com.userRegister.entities.concretes.User;
import vabiss.com.userRegister.entities.dtos.UserDto;


@RestController
@RequestMapping("/api/users/")
public class UsersContoller {
	
	private UserService userService;
	
	@Autowired
	public UsersContoller(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@PostMapping("add")
	public ResponseEntity<?> add(@RequestBody UserDto userDto) {
		Result result= this.userService.add(userDto);
		if(result.isSuccess()) {
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		return new ResponseEntity<>(result,HttpStatus.UNPROCESSABLE_ENTITY);
	
	}
	@GetMapping("getAll")
	public ResponseEntity<?> getAll() {
		DataResult<List<User>> result=this.userService.getAll();
		
		if(result.isSuccess()) {
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("getById")
	public ResponseEntity<?> getById(@RequestParam int userId) {
		DataResult<User> result=this.userService.getById(userId);
		if(result.isSuccess()) {
			return new ResponseEntity<>(result,HttpStatus.OK);
		}
		return new ResponseEntity<>(result,HttpStatus.BAD_REQUEST);
	}
}
