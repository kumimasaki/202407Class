package section1.ex7;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Practice7Test {

	@Test
	public void testGetLength() {
		String str = "Hello, World!";

		// assertAll を使って複数のアサーションをまとめて確認
		assertAll("文字列の長さの確認",
			() -> assertEquals(13, Practice7.getLength(str), "長さが正しくありません"),
			() -> assertEquals(0, Practice7.getLength(""), "空文字列の長さは0であるべきです"),
			() -> assertEquals(5, Practice7.getLength("Hello"), "長さが正しくありません"));
	}

}
