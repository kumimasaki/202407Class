package net.lighthouseplan.spring.junit.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import net.lighthouseplan.spring.junit.models.Account;
import net.lighthouseplan.spring.junit.repositories.AccountRepository;

@SpringBootTest
public class AccountServiceTest {
	@MockBean
	private AccountRepository repository;
	
	@Autowired
	private AccountService accountService;
	
	@BeforeEach
	public void prepareData() {
		// ユーザーの情報を作成する（Entityの内容を返すので）
		Account alice = new Account(1L, "Alice", "ABC12345");
		// ログイン成功 : usernameがAliceの場合、Entityの内容を返す
		when(repository.findByUsername("Alice")).thenReturn(alice);
		// ログイン失敗 ： usernameがAnaの場合、nullを返す
		when(repository.findByUsername(eq("Ana"))).thenReturn(null);
	}
	
	// ユーザー名とパスワードが一致していてtrueになるテスト
	@Test
	public void testValidateAccount_CorrectInfo_True() {
		assertTrue(accountService.validateAccount("Alice", "ABC12345"));
	}
	
	// ユーザー名が異なり、falseになるテスト
	@Test
	public void testValidateAccount_False() {
		assertFalse(accountService.validateAccount("Ana", "ABC12345"));
	}
	
	// 以降時間があれば
	
	// パスワードが異なり、falseになるテスト
	@Test
	public void testValidateAccount_WrongPassword_ReturnFalse() {
		assertFalse(accountService.validateAccount("Alice", "BBC12321"));
	}
	
	// 登録が成功し、trueが返されるテスト
	@Test
	public void testCreateAccount_NewAccount_True() {
		assertTrue(accountService.createAccount("Ana", "1234"));
	}
	
	// 登録が失敗し、falseが返されるテスト
	@Test
	public void testCreateAccount_ExistingUsername_False() {
		assertFalse(accountService.createAccount("Alice", "ABC12345"));
	}
	
}
