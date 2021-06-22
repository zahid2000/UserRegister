package vabiss.com.userRegister.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import vabiss.com.userRegister.entities.concretes.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findById(int userId);
	boolean existsByUserName(String userName);
}
