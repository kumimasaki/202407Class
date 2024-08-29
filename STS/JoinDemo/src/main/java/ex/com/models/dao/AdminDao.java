package ex.com.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex.com.models.entity.AdminEntity;
@Repository
public interface AdminDao extends JpaRepository<AdminEntity, Long> {
	AdminEntity save(AdminEntity adminEntity);
	
	AdminEntity findByAdminEmail(String adminEmail);
	
	AdminEntity findByAdminEmailAndPassword(String adminEmail,String password);
}
