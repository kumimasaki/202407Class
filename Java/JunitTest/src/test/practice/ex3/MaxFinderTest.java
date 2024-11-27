package test.practice.ex3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practice.ex3.MaxFinder;

/**
 * MaxFinderTest クラスは、MaxFinder クラスの findMax メソッドに対するユニットテストを実行する。
 */
public class MaxFinderTest {

    // テスト対象の MaxFinder インスタンス
    private final MaxFinder maxFinder = new MaxFinder();

    /**
     * findMax メソッドのテスト。
     * 数値配列に対して、最大値を正しく取得できるかを確認する。
     * また、空の配列や null に対して IllegalArgumentException がスローされるかも確認する。
     */
    @Test
    public void testFindMax() {
        // 配列 {1, 2, 3} の最大値は 3
        assertEquals(3, maxFinder.findMax(new int[]{1, 2, 3}));

        // 配列 {-1, -2, 5, 0} の最大値は 5
        assertEquals(5, maxFinder.findMax(new int[]{-1, -2, 5, 0}));

        // 配列 {100, 1, 2, 3, 4} の最大値は 100
        assertEquals(100, maxFinder.findMax(new int[]{100, 1, 2, 3, 4}));

        // 空の配列に対して IllegalArgumentException をスローすることを確認
        assertThrows(IllegalArgumentException.class, () -> maxFinder.findMax(new int[]{}));

        // null に対して IllegalArgumentException をスローすることを確認
        assertThrows(IllegalArgumentException.class, () -> maxFinder.findMax(null));
    }
}
