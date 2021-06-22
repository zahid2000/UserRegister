package vabiss.com.userRegister.business.concretes;

/*iş kodları yəni servis */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vabiss.com.userRegister.business.abstracts.UserService;
import vabiss.com.userRegister.business.constants.Messages;
import vabiss.com.userRegister.core.business.BusinessEngine;
import vabiss.com.userRegister.core.utils.dtoConverter.ObjectMapper;
import vabiss.com.userRegister.core.utils.results.DataResult;
import vabiss.com.userRegister.core.utils.results.ErrorDataResult;
import vabiss.com.userRegister.core.utils.results.ErrorResult;
import vabiss.com.userRegister.core.utils.results.Result;
import vabiss.com.userRegister.core.utils.results.SuccessDataResult;
import vabiss.com.userRegister.core.utils.results.SuccessResult;
import vabiss.com.userRegister.dataAccess.abstracts.UserDao;
import vabiss.com.userRegister.entities.concretes.User;
import vabiss.com.userRegister.entities.dtos.UserDto;

@Service
public class UserManager implements UserService {

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(UserDto userDto) {
		Result result = BusinessEngine.run(checkUserName(userDto.getUserName()), checkPassword(userDto.getPassword()),checkUserExists(userDto.getUserName()));

		if (result.isSuccess()) {
			this.userDao.save(ObjectMapper.map(userDto, User.class));
			return new SuccessResult(Messages.userAdded);
		}

		return new ErrorResult(result.getMessage());
	}

	@Override 
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), Messages.userListed);
	}

	@Override
	public DataResult<User> getById(int userId) {
		User user = this.userDao.findById(userId);
		if (user == null) {
			return new ErrorDataResult<User>(Messages.userNotFind);
		}
		return new SuccessDataResult<User>(user, Messages.userFind);
	}

	private Result checkUserName(String userName) {
		if (userName.isBlank()) {
			return new ErrorResult(Messages.nameIsNotEmpty);
		}
		return new SuccessResult();
	}

	private Result checkPassword(String password) {
		if (password.isBlank()) {
			return new ErrorResult(Messages.passwordIsNotEmpty);
		}
		return new SuccessResult();
	}
	
	private Result checkUserExists(String userName) {
		if(this.userDao.existsByUserName(userName)) {
			return new ErrorResult(Messages.userExists);
		}
		return new SuccessResult();
	}

}
