package ec.com.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ec.com.models.dao.AdminDao;
import ec.com.models.entity.Admin;

@SpringBootTest
public class AdminServiceTest {
	@MockBean
	private AdminDao adminDao;
	
	@Autowired
	private AdminService adminService;
	
	@BeforeEach
	public void prepareData() {
		// ユーザーの情報を作成する（Entityの内容を返すので）
		Admin alice = new Admin(1L, "test@test.com", "Alice", "12345678");
		// 登録処理用
		// 登録成功
		when(adminDao.findByAdminEmail(eq("test@test.com"))).thenReturn(null);
		// 登録失敗
		when(adminDao.findByAdminEmail("ng@test.com")).thenReturn(alice);
		// ログイン処理用
		// ログイン成功
		when(adminDao.findByAdminEmailAndPassword("test@test.com", "12345678")).thenReturn(alice);
		// ログイン失敗
		when(adminDao.findByAdminEmailAndPassword(eq("ng@test.com"), any())).thenReturn(null);
	}
	
	// ユーザー名とパスワードが一致していてtrueになるテスト
	@Test
	public void testLoginCheck_CorrectInfo_Succeed() {
		assertNotNull(adminService.loginCheck("test@test.com", "12345678"));
	}
	
	// メールアドレスが異なり、falseになるテスト
	@Test
	public void testLoginCheck_WrongAdminMain_Fail() {
		assertNull(adminService.loginCheck("ng@test.com", "12345678"));
	}
	
	// 登録成功
	@Test
	public void testCreateAccount_NewAccount_True() {
		assertTrue(adminService.createAdmin("test@test.com", "Alice", "12345678"));
	}
	
	// 登録失敗
	@Test
	public void testCreateAccount_ExistingUsername_False() {
		assertFalse(adminService.createAdmin("ng@test.com", "Alice", "12345678"));
	}
	
}
