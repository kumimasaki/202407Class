package lesson1_3.if_statement;

public class Ex3 {

	public static void main(String[] args) {
		// 条件演算子
		// 年齢を表す変数を宣言、初期化
		int age = 20;
		
		// 条件演算子（三項演算子）を指標して、年齢が18歳以上かどうかを判定
		// 結果に基づいてメッセージを表示
//		String message = (age >= 18) ? "成人です" : "未成年です";
		
		System.out.println((age >= 18) ? "成人です" : "未成年です");

	}

}
