package section1.ex2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Practice2Test {

	// 3文字以上
	@Test
	public void testIsLengthThreeOrMore_WithLongString_True() {
		assertTrue(Practice2.isLengthThreeOrMore("hello"));
	}

	// 3文字
	@Test
	public void testIsLengthThreeOrMore_WithThreeCharString_True() {
		assertTrue(Practice2.isLengthThreeOrMore("abc"));
	}

	// 2文字
	@Test
	public void testIsLengthThreeOrMore_WithShortString_False() {
		assertFalse(Practice2.isLengthThreeOrMore("ab"));
	}

	// 空文字
	@Test
	public void testIsLengthThreeOrMore_WithEmptyString_False() {
		assertFalse(Practice2.isLengthThreeOrMore(""));
	}

	// null
	@Test
	public void testIsLengthThreeOrMore_WithNull_False() {
		assertFalse(Practice2.isLengthThreeOrMore(null));
	}

}
