package section1.ex5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

	@Test
	public void testGetUsername_WithNull() {
		// ユーザー名が null の場合
		User user = new User();
		// 第二引数は、テストが失敗した際に表示されるメッセージ
		assertNull(user.getUsername(), "ユーザー名が null であることを確認");
	}

	@Test
	public void testGetUsername_WithNotNull() {
		// ユーザー名が設定されている場合
		User user = new User("Alice");
		assertNotNull(user.getUsername(), "ユーザー名が null ではないことを確認");
	}

}
