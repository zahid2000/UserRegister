package vabiss.com.userRegister.business.abstracts;

import java.util.List;

import vabiss.com.userRegister.core.utils.results.DataResult;
import vabiss.com.userRegister.core.utils.results.Result;
import vabiss.com.userRegister.entities.concretes.User;
import vabiss.com.userRegister.entities.dtos.UserDto;

public interface UserService {

	Result add(UserDto userdDto);
	DataResult<List<User>> getAll();
	DataResult<User> getById(int userId);
	
}
