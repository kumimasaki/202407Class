package blog.com.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.com.model.dao.UserDao;
import blog.com.model.entity.UserEntity;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;

	public boolean createAccount(String userName, String email, String password) {
		LocalDateTime registerDate = LocalDateTime.now();
		UserEntity userEntity = userDao.findByEmail(email);
		if (userEntity == null) {
			userDao.save(new UserEntity(userName, email, password, registerDate));
			return true;
		} else {
			/** UserEntityが見つかった場合、falseを返します。 **/
			return false;
		}
	}

	public UserEntity loginAccount(String email, String password) {
		UserEntity userEntity = userDao.findByEmailAndPassword(email, password);
		if (userEntity == null) {
			return null;
		} else {
			return userEntity;
		}
	}
	
}
