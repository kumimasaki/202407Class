package lesson1_3.do_while_statement;

public class Ex1 {

	public static void main(String[] args) {
		// 変数の初期化
		int i = 3;
		// 条件を満たしていなくても必ず一回は実行される処理
		do {
			// 変数iを出力
			System.out.println(i);
			// iを1ずつ加算
			i++;
		} while (i < 5);

	}

}
