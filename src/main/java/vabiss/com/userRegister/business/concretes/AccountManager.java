package vabiss.com.userRegister.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vabiss.com.userRegister.business.abstracts.AccounService;
import vabiss.com.userRegister.business.abstracts.UserService;
import vabiss.com.userRegister.core.utils.dtoConverter.ObjectMapper;
import vabiss.com.userRegister.core.utils.results.DataResult;
import vabiss.com.userRegister.core.utils.results.ErrorDataResult;
import vabiss.com.userRegister.core.utils.results.Result;
import vabiss.com.userRegister.core.utils.results.SuccessDataResult;
import vabiss.com.userRegister.entities.concretes.User;
import vabiss.com.userRegister.entities.dtos.UserDto;

@Service
public class AccountManager implements AccounService {

	private UserService userService;

	@Autowired
	public AccountManager(UserService userService) {
		super();
		this.userService = userService;
	}

	@Override
	public Result signUp(UserDto userDto) {
		return this.userService.add(userDto);
	}

	@Override
	public DataResult<String> getAccount(int id) {
		
		if(this.userService.getById(id).isSuccess()) {
			return new SuccessDataResult<String>(this.userService.getById(id).getData().getUserName(),this.userService.getById(id).getMessage());
		}
				
		return new ErrorDataResult<String>(null,this.userService.getById(id).getMessage());
	}

}
