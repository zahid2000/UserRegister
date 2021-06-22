package vabiss.com.userRegister.core.extensions.secure;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import vabiss.com.userRegister.dataAccess.abstracts.UserDao;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		vabiss.com.userRegister.entities.concretes.User user = this.userDao.findByUserName(username);
		
		if (user != null) {
			user.setPassword(this.passwordEncoder.encode(user.getPassword()));
			return new User(username, user.getPassword(), new ArrayList<>());
		}
		throw new UsernameNotFoundException(username);
	}
}
