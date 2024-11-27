package section1.ex4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Practice4Test {

	@Test
	public void testCanAccessService_ForAdultMember_True() {
		// 18歳以上かつ会員
		assertTrue(Practice4.canAccessService(20, true));
		assertTrue(Practice4.canAccessService(65, true));
	}

	@Test
	public void testCanAccessService_ForSeniorNonMember_True() {
		// 65歳以上で会員でない
		assertTrue(Practice4.canAccessService(70, false));
	}

	@Test
	public void testCanAccessService_ForYoungMember_True() {
		// 16歳以上で18歳未満かつ会員
		assertTrue(Practice4.canAccessService(16, true));
		assertTrue(Practice4.canAccessService(17, true));
	}

	@Test
	public void testCanAccessService_ForTooYoungMember_False() {
		// 16歳未満で会員
		assertFalse(Practice4.canAccessService(15, true));
	}

	@Test
	public void testCanAccessService_ForNonMemberUnder18_False() {
		// 18歳未満かつ会員でない
		assertFalse(Practice4.canAccessService(10, false));
		assertFalse(Practice4.canAccessService(17, false));
	}

	@Test
	public void testCanAccessService_ForNonMemberAdult_False() {
		// 18歳以上65歳未満かつ会員でない
		assertFalse(Practice4.canAccessService(30, false));
	}
}
