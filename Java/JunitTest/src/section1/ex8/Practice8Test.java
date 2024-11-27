package section1.ex8;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class Practice8Test {

	@Test
	public void testStartsWithPrefix_ValidPrefix_True() {
		String str = "hello world";
		String prefix = "hello";
		assertEquals(100, Practice8.startsWithPrefix(str, prefix));
	}

	@Test
	public void testStartsWithPrefix_ValidPrefix_False() {
		String str = "hello world";
		String prefix = "world";
		assertThat(Practice8.startsWithPrefix(str, prefix), is(0));
	}

	@Test
	public void testStartsWithPrefix_EmptyString_True() {
		String str = "";
		String prefix = "";
		assertThat(Practice8.startsWithPrefix(str, prefix), is(100));
	}

	@Test
	public void testStartsWithPrefix_NullString_False() {
		String str = null;
		String prefix = "hello";
		assertThat(Practice8.startsWithPrefix(str, prefix), is(0));
	}

	@Test
	public void testStartsWithPrefix_NullPrefix_False() {
		String str = "hello world";
		String prefix = null;
		assertThat(Practice8.startsWithPrefix(str, prefix), is(0));
	}

}
