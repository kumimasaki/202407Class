package lesson1_2.operator;

public class Ex5 {

	public static void main(String[] args) {
		// 論理演算子
		// 変数の初期化
		int a = 7;
		int b = 4;
		
		// 論理積(&&)
		System.out.println(a < 9 && b > 3); // true
		System.out.println(a < 9 && b > 7); // false
		
		// 論理和（||）
		System.out.println(a < 9 || b > 3); // true
		System.out.println(a < 9 || b > 7); // true
		System.out.println(a < 1 || b > 7); // false
		
		// 否定（!）
		System.out.println(!(a < 9)); // false
		System.out.println(!(a < 1)); // true
		
		
		
		// 変数の初期化
		int x = 1;
		int y = 2;
		
		System.out.println(x < y || x > y + 1 && x < 0);
	}

}
