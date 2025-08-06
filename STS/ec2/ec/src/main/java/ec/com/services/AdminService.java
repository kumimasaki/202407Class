package ec.com.services;

import org.springframework.stereotype.Service;

import ec.com.models.dao.AdminDao;
import ec.com.models.dto.AdminDto;
import ec.com.models.entity.Admin;
import ec.com.models.form.AdminLoginForm;
import ec.com.models.form.AdminRegisterForm;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final AdminDao adminDao;

    public AdminDto loginCheck(AdminLoginForm form) {
        Admin admin = adminDao.findByAdminEmailAndPassword(
                form.getAdminEmail(), form.getPassword());
        if (admin == null) {
            return null;
        }
        return convertToDto(admin);
    }

    public void register(AdminRegisterForm form) {
        Admin admin = new Admin(form.getAdminName(), form.getAdminEmail(), form.getPassword());
        adminDao.save(admin);
    }

    private AdminDto convertToDto(Admin admin) {
        AdminDto dto = new AdminDto();
        dto.setAdminId(admin.getAdminId());
        dto.setAdminEmail(admin.getAdminEmail());
        dto.setAdminName(admin.getAdminName());
        return dto;
    }
}
