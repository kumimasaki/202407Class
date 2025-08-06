package lesson1_2.operator;

public class Ex3 {

	public static void main(String[] args) {
		// 前置インクリメント
		// 1:インクリメントする 2：使用する
		int before = 1;
		System.out.println(++before); // ⇒2
		
		// 後置インクリメント
		// 1:使用する 2:インクリメントする
		int after = 1;
		System.out.println(after++); // ⇒1
		System.out.println(after);   // ⇒2

	}

}
