package blog.com.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import blog.com.model.entity.UserEntity;

public interface UserDao extends JpaRepository<UserEntity, Long> {
	UserEntity save(UserEntity userEntity);
	
	UserEntity findByEmail(String email);

	UserEntity findByEmailAndPassword(String email,String password);
}
