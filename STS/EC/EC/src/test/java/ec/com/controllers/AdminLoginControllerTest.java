package ec.com.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ec.com.models.entity.Admin;
import ec.com.services.AdminService;
import jakarta.servlet.http.HttpSession;

@SpringBootTest
@AutoConfigureMockMvc
public class AdminLoginControllerTest {
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
		when(adminService.loginCheck("test@test.com", "12345678")).thenReturn(alice);
		// ログインが失敗：　username "Ana"と等しい、　パスワードはどんな値でもいい　false
		when(adminService.loginCheck(eq("ng@test.com"), any())).thenReturn(null);
	}
	
	// ログインページを正しく取得するテスト
	@Test
	public void testGetLoginPage_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.get("/admin/login");
		
		mockMvc.perform(request)
				.andExpect(view().name("admin_login.html"));
	}
	
	// ログインが成功した場合のテスト
	@Test
	public void testLogin_CorrectInfo_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.post("/admin/login/process")
								.param("adminEmail", "test@test.com")
								.param("password", "12345678");
		
		mockMvc.perform(request)
		// ログインエンティティのユーザー名,パスワードが○○であることを確認
//				.andExpect(model().attribute("adminName", "Alice"))
//				.andExpect(model().attribute("adminEmail", "test@test.com"))
				.andExpect(redirectedUrl("/product/list"));
	}
	
	// セッションからEntityを取得してそれがnullでないことのテスト
	@Test
	public void testUserEntityInSession() throws Exception {
	    // テスト用のMockHttpSessionを作成
	    MockHttpSession session = new MockHttpSession();
	    // セッションの設定
		Admin admin = new Admin();
        admin.setAdminId(1L);
        admin.setAdminEmail("test@test.com");
        admin.setAdminName("TEST");
        admin.setPassword("ABCD1234");
        session.setAttribute("loginAdminInfo", admin);
	        
	    // POSTリクエストを作成
		RequestBuilder request = MockMvcRequestBuilders
								.post("/admin/login/process")
								.session(session)
								.param("adminEmail", "test@test.com")
								.param("password", "12345678");
				
		// リクエストを実行してレスポンスを取得
		MvcResult result = mockMvc.perform(request)
							.andExpect(redirectedUrl("/product/list"))
							// ModelAndViewを使っている方はこちら↓
//							.andExpect(view().name("redirect:/blog/list"))
							.andReturn();
		
		// セッションから "admin" を取得して null ではないことを確認
		HttpSession sessionAfterRequest = result.getRequest().getSession();
		Object adminInSession = sessionAfterRequest.getAttribute("loginAdminInfo");
		assertNotNull(adminInSession, "sessionはNULLではない");
	}
	
	
	// ログインが失敗する場合
	@Test
	public void testLogin_IncorrectInfo_Fail() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.post("/admin/login/process")
								.param("adminEmail", "ng@test.com")
								.param("password", "12345678");
		
		mockMvc.perform(request)
				.andExpect(view().name("admin_login.html"));
	}
	
	// 間違ったメールアドレス及び正しいパスワードを指定し、/admin/login/process" へのPOSTリクエストを作成し、リクエストを実行する
	@Test
	public void testUserEntityIsNullInSession() throws Exception {
	    // GETリクエストを送信してセッションを取得
	    HttpSession session = mockMvc.perform(get("/admin/login"))
							.andExpect(status().isOk())
							.andReturn()
							.getRequest()
							.getSession();
	    
	    // セッションからUserEntityを取得してnullであることを検証
	    Object userInSession = session.getAttribute("loginAdminInfo");
	    assertNull(userInSession, "sessionはNULLである");
	}
}
