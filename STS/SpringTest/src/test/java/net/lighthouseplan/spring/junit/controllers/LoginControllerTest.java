package net.lighthouseplan.spring.junit.controllers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.http.HttpSession;

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
import net.lighthouseplan.spring.junit.models.Admin;
import net.lighthouseplan.spring.junit.services.AccountService;

@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountService accountService;
	
	// サービスクラスを使ったデータ作成
	@BeforeEach
	public void prepareData() {
		// ログインが成功：　username "Alice"、　password "12345678"　true
		when(accountService.validateAccount("Alice", "12345678")).thenReturn(true);
		// ログインが失敗：　username "Ana"と等しい、　パスワードはどんな値でもいい　false
		when(accountService.validateAccount(eq("Ana"), any())).thenReturn(false);
	}
	
	// ログインページを正しく取得するテスト
	@Test
	public void testGetLoginPage_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.get("/login");
		
		mockMvc.perform(request)
				.andExpect(view().name("login.html"));
	}
	
	// ログインが成功した場合のテスト
	// ログインが成功したら「hello.html」に遷移して、入力された値が渡されているかのテスト
	@Test
	public void testLogin_CorrectInfo_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.post("/login")
								.param("username", "Alice")
								.param("password", "12345678");
		
		mockMvc.perform(request)
				.andExpect(model().attribute("name", "Alice"))
				.andExpect(view().name("hello.html"));
	}
	
	// ログインが失敗した場合のテスト
	@Test
	public void testLogin_IncorrectInfo_Fail() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.post("/login")
								.param("username", "Ana")
								.param("password", "1234");

		mockMvc.perform(request)
				.andExpect(model().attribute("error", true))
				.andExpect(view().name("login.html"));		
	}
	
	// セッションからEntityを取得してそれがnullでないことを検証
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
        session.setAttribute("admin", admin);
        // POSTリクエストを作成
		RequestBuilder request = MockMvcRequestBuilders
				.post("/login")
				.session(session)
				.param("username", "Alice")
				.param("password", "12345678");
		// リクエストを実行してレスポンスを取得
		MvcResult result = mockMvc.perform(request)
		        .andExpect(view().name("hello.html"))
		        .andReturn();
		// セッションから "admin" を取得して null ではないことを確認
		HttpSession sessionAfterRequest = result.getRequest().getSession();
		Object adminInSession = sessionAfterRequest.getAttribute("admin");
		assertNotNull(adminInSession, "NULLではない");
    }
    
    // "/user/login" へのGETリクエストを作成し、セッションからログインユーザーエンティティを取得し、それがnullであることを検証
    @Test
    public void testUserEntityIsNullInSession() throws Exception {
        // GETリクエストを送信してセッションを取得
        HttpSession session = mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andReturn()
                .getRequest()
                .getSession();
        
        // セッションからUserEntityを取得してnullであることを検証
        Object userInSession = session.getAttribute("admin");
        assertNull(userInSession, "UserEntity should be null in a new session");
        
		RequestBuilder request = MockMvcRequestBuilders
				.get("/login");
		
		mockMvc.perform(request)
				.andExpect(view().name("login.html"))
				.andExpect(model().attributeDoesNotExist("error"));
    }
	
}
