package vabiss.com.userRegister.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vabiss.com.userRegister.core.extensions.secure.TokenManager;
import vabiss.com.userRegister.entities.dtos.UserDto;

@RestController
@RequestMapping("/api/auth/")
public class AuthConroller {

    @Autowired
    private TokenManager tokenManager;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody UserDto userDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDto.getUserName(), userDto.getPassword()));

            return ResponseEntity.ok(tokenManager.generateToken(userDto.getUserName()));
        } catch (Exception e) {
            throw e;
        }
    }
}
