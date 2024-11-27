package test.practice.ex2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import practice.ex2.FizzBuzz;

/**
 * FizzBuzzTest クラスは、FizzBuzz クラスの fizzBuzz メソッドに対するユニットテストを実行する。
 */
class FizzBuzzTest {

    // テスト対象の FizzBuzz インスタンス
    private final FizzBuzz fizzBuzz = new FizzBuzz();

    /**
     * fizzBuzz メソッドのテスト。
     * 1 から 15 までの数値に対して FizzBuzz のルールが正しく適用されるかを確認する。
     */
    @Test
    public void testFizzBuzz() {
        // 1 は "1"
        assertEquals("1", fizzBuzz.fizzBuzz(1));
        // 2 は "2"
        assertEquals("2", fizzBuzz.fizzBuzz(2));
        // 3 は "Fizz"
        assertEquals("Fizz", fizzBuzz.fizzBuzz(3));
        // 4 は "4"
        assertEquals("4", fizzBuzz.fizzBuzz(4));
        // 5 は "Buzz"
        assertEquals("Buzz", fizzBuzz.fizzBuzz(5));
        // 6 は "Fizz"
        assertEquals("Fizz", fizzBuzz.fizzBuzz(6));
        // 7 は "7"
        assertEquals("7", fizzBuzz.fizzBuzz(7));
        // 8 は "8"
        assertEquals("8", fizzBuzz.fizzBuzz(8));
        // 9 は "Fizz"
        assertEquals("Fizz", fizzBuzz.fizzBuzz(9));
        // 10 は "Buzz"
        assertEquals("Buzz", fizzBuzz.fizzBuzz(10));
        // 11 は "11"
        assertEquals("11", fizzBuzz.fizzBuzz(11));
        // 12 は "Fizz"
        assertEquals("Fizz", fizzBuzz.fizzBuzz(12));
        // 13 は "13"
        assertEquals("13", fizzBuzz.fizzBuzz(13));
        // 14 は "14"
        assertEquals("14", fizzBuzz.fizzBuzz(14));
        // 15 は "FizzBuzz"
        assertEquals("FizzBuzz", fizzBuzz.fizzBuzz(15));
    }
}
