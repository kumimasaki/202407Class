package ec.com.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ec.com.models.entity.Admin;
import ec.com.services.AdminService;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminRegisterControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AdminService adminService;
	
	// サービスクラスを使ったデータ作成
	@BeforeEach
	public void prepareData() {
		// ユーザーの情報を作成する（Entityの内容を返すので）
		Admin alice = new Admin(1L, "test@test.com", "Alice", "12345678");
		// ログインが成功：　username "Alice"、　password "12345678"　true
		when(adminService.createAdmin("test@test.com", "Alice", "12345678")).thenReturn(true);
		// ログインが失敗：　username "Ana"と等しい、　パスワードはどんな値でもいい　false
		when(adminService.createAdmin(eq("ng@test.com"), any(), any())).thenReturn(false);
	}
	
	// 登録画面が正常表示できるテスト
	@Test
	public void testGetRegisterPage_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.get("/admin/register");
		
		mockMvc.perform(request)
				.andExpect(view().name("admin_register.html"));
	}
	
	// ユーザーの登録が成功するかのテスト
	@Test
	public void testRegister_NewAccount_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.post("/admin/register/process")
								.param("adminName", "Alice")
								.param("adminEmail", "test@test.com")
								.param("password", "12345678");
		
		mockMvc.perform(request)
				.andExpect(view().name("admin_login.html"));
		
        // Verify　指定された引数で1回だけ呼び出されたことを確認
        verify(adminService, times(1)).createAdmin("test@test.com", "Alice", "12345678");
	}
	
	// ユーザーの登録が失敗するかのテスト
	@Test
	public void testRegister_ExistingUsername_Fail() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.post("/admin/register/process")
								.param("adminName", "Alice")
								.param("adminEmail", "ng@test.com")
								.param("password", "12345678");

		mockMvc.perform(request)
//				.andExpect(model().attribute("error", true))
				.andExpect(view().name("admin_register.html"));
	}
}
