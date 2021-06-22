package vabiss.com.userRegister.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import vabiss.com.userRegister.business.abstracts.AuthService;
import vabiss.com.userRegister.core.extensions.secure.TokenManager;
import vabiss.com.userRegister.core.utils.results.Result;
import vabiss.com.userRegister.core.utils.results.SuccessResult;
import vabiss.com.userRegister.entities.dtos.UserDto;
@Service
public class AuthManager implements AuthService {

	  @Autowired
	    private TokenManager tokenManager;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	  
	    public Result login( UserDto userDto) {
	        try {
	        	
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(userDto.getUserName(), userDto.getPassword()));

	            return new SuccessResult(tokenManager.generateToken(userDto.getUserName()));
	        } catch (Exception e) {
	            throw e;
	        }
	    }

}
