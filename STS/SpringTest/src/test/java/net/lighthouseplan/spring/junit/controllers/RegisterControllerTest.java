package net.lighthouseplan.spring.junit.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import net.lighthouseplan.spring.junit.services.AccountService;

@SpringBootTest
@AutoConfigureMockMvc
public class RegisterControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountService accountService;
	
	// サービスクラスを使ったデータ作成
	@BeforeEach
	public void prepareData() {
		// 登録できる場合　"Alice", "Alice1234"  true
		when(accountService.createAccount("Alice", "Alice1234")).thenReturn(true);
		// 登録できない場合　名前は"Ana"と等しいこと　パスワードはどんな値でもいい　false
		when(accountService.createAccount(eq("Ana"), any())).thenReturn(false);
	}
	
	// 登録画面が正常表示できるテスト
	@Test
	public void testGetRegisterPage_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.get("/register");
		
		mockMvc.perform(request)
				.andExpect(view().name("register.html"));
	}
	
	// ユーザーの登録が成功するかのテスト
	@Test
	public void testRegister_NewAccount_Succeed() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.post("/register")
								.param("username", "Alice")
								.param("password", "Alice1234");
		
		mockMvc.perform(request)
				.andExpect(view().name("login.html"));
		
        // Verify　指定された引数で1回だけ呼び出されたことを確認
        verify(accountService, times(1)).createAccount("Alice", "Alice1234");
	}
	
	// ユーザーの登録が失敗するかのテスト
	@Test
	public void testRegister_ExistingUsername_Fail() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
								.post("/register")
								.param("username", "Ana")
								.param("password", "1234");

		mockMvc.perform(request)
				.andExpect(model().attribute("error", true))
				.andExpect(view().name("register.html"));
	}
	
}
