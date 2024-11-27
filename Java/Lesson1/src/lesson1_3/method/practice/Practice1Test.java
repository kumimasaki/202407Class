package lesson1_3.method.practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Practice1Test {

    @Test
    public void testCheckParityEven() {
        // 偶数のテスト
        assertEquals("even", Practice1.checkParity(2));
        assertEquals("even", Practice1.checkParity(0));
        assertEquals("even", Practice1.checkParity(-4));
    }

    @Test
    public void testCheckParityOdd() {
        // 奇数のテスト
        assertEquals("odd", Practice1.checkParity(1));
        assertEquals("odd", Practice1.checkParity(-1));
        assertEquals("odd", Practice1.checkParity(-3));
    }

}
