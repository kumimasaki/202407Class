package lesson1_2.operator;

public class Ex2 {

	public static void main(String[] args) {
		// 代入演算子
		// 変数の初期化
		int a = 10;
		int total1 = 0;
		total1 = a + total1;
		// 結果を表示
		System.out.println(total1);
		
		int b = 10;
		int total2 = 10;
		// total2 = total2 + b;
		total2 += b;
		// 結果を表示
		System.out.println(total2);
		
		int c = 10;
		int total3 = 20;
		// total3 = total3 - c
		total3 -= c;
		// 結果を表示
		System.out.println(total3);
	}

}
