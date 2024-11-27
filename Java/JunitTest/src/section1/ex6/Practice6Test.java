package section1.ex6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Practice6Test {

	@Test
	public void testGetElementAtIndex_WithValidIndex() {
		int[] arr = { 1, 2, 3 };
		// インデックス 1 の要素を取得
		int result = Practice6.getElementAtIndex(arr, 1);
		// 正しい値が返されることを確認
		assertEquals(2, result);
	}

	@Test
	public void testGetElementAtIndex_WithNegativeIndex() {
		int[] arr = { 1, 2, 3 };

		// 負のインデックスを指定した場合に ArrayIndexOutOfBoundsException がスローされることを確認
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Practice6.getElementAtIndex(arr, -1);
		});
	}

	@Test
	public void testGetElementAtIndex_WithOutOfBoundsIndex() {
		int[] arr = { 1, 2, 3 };

		// 配列の長さを超えるインデックスを指定した場合に ArrayIndexOutOfBoundsException がスローされることを確認
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			// インデックスは 0, 1, 2 まで有効
			Practice6.getElementAtIndex(arr, 3); 
		});
	}

}
