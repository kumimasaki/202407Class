package section1.ex3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Practice3Test {

	@Test
    public void testCalculate_WithPositiveNumber() {
        // 正の整数の二乗が期待通りかを確認
        assertEquals(25, Practice3.calculate(5));
        assertEquals(4, Practice3.calculate(2));
    }

    @Test
    public void testSquareWithNegativeNumber() {
        // 負の整数の二乗が期待通りかを確認
        assertEquals(25, Practice3.calculate(-5));
        assertEquals(4, Practice3.calculate(-2));
    }

    @Test
    public void testSquareWithZero() {
        // 0の二乗が期待通りかを確認
        assertEquals(0, Practice3.calculate(0));
    }

}
