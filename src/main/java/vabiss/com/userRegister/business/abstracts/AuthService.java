package vabiss.com.userRegister.business.abstracts;

import vabiss.com.userRegister.core.utils.results.Result;
import vabiss.com.userRegister.entities.dtos.UserDto;

public interface AuthService {
	Result login(UserDto userDto);
}
