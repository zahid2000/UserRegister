package vabiss.com.userRegister.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vabiss.com.userRegister.business.abstracts.AccounService;
import vabiss.com.userRegister.core.utils.results.DataResult;
import vabiss.com.userRegister.core.utils.results.Result;
import vabiss.com.userRegister.entities.dtos.UserDto;

@RestController
@RequestMapping("/api/account/")
public class AccountController {
	@Autowired
	private AccounService accounService;






	@PostMapping("signUp")
	public ResponseEntity<?> signUp(@RequestBody UserDto userDto) {
		
		
		Result result = this.accounService.signUp(userDto);
		if (result.isSuccess()) {
			
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(result, HttpStatus.UNPROCESSABLE_ENTITY);
		
	}

	@GetMapping("me")
	public ResponseEntity<?> getAccount(@RequestParam int id) {
		DataResult<String> result = this.accounService.getAccount(id);
		if (result.isSuccess()) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		}
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
}
