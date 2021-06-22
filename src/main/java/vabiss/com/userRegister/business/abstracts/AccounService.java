package vabiss.com.userRegister.business.abstracts;

import vabiss.com.userRegister.core.utils.results.DataResult;
import vabiss.com.userRegister.core.utils.results.Result;
import vabiss.com.userRegister.entities.dtos.UserDto;

public interface AccounService {
Result signUp(UserDto userDto);
DataResult<String> getAccount(int id);
}
