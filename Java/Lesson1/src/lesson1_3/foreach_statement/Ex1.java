package lesson1_3.foreach_statement;

public class Ex1 {

	public static void main(String[] args) {
		// 整数型の配列を初期化
		int[] array = {20, 30, 40};
		// 拡張for文
		for (int a : array) {
			// 変数aを出力
			System.out.println(a);
		}
		
		String[] test = {"AA", "BB", "CC"};
		System.out.println(test[1]);
		
		for(String a : test) {
			System.out.println(a);
		}
	}

}
