package ec.com.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.models.entity.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Long> {
    Admin findByAdminEmailAndPassword(String adminEmail, String password);
    Admin findByAdminEmail(String adminEmail);
}
