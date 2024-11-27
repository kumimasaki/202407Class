package test.practice.ex1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practice.ex1.Calculator;

/**
 * CalculatorTest クラスは、Calculator クラスのメソッドに対するユニットテストを実行する
 */
class CalculatorTest {

    // テスト対象の Calculator インスタンス
    private final Calculator calculator = new Calculator();

    /**
     * add メソッドのテスト
     * 正の数同士の計算と、正の数と負の数の計算結果が正しいかを確認する
     */
    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-1, calculator.add(-1, 0));
    }

    /**
     * subtract メソッドのテスト
     * 正の数同士の計算と、正の数からより大きい正の数を引く計算結果が正しいかを確認する
     */
    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-1, calculator.subtract(2, 3));
    }

    /**
     * multiply メソッドのテスト
     * 正の数同士の計算と、ゼロを含む計算結果が正しいかを確認する
     */
    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(0, calculator.multiply(0, 5));
    }

    /**
     * divide メソッドのテスト
     * 正の数同士の計算結果が正しいかを確認し、0 での除算が
     * IllegalArgumentException をスローするかを確認する
     */
    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
    }
}
