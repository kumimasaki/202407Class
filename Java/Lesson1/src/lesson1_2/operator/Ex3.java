package lesson1_2.operator;

public class Ex3 {

	public static void main(String[] args) {
		// 前置インクリメント
		// 1:インクリメントする 2：使用する
		int zenchi = 1;
		System.out.println(++zenchi); // ⇒2
		
		// 後置インクリメント
		// 1:使用する 2:インクリメントする
		int kouchi = 1;
		System.out.println(kouchi++); // ⇒1
		System.out.println(kouchi);   // ⇒2

	}

}
