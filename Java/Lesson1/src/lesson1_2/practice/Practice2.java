package lesson1_2.practice;
/**
 * problems1-2 三.パリティチェック
 */
public class Practice2 {

	public static void main(String[] args) {
		// 変数の初期化
		int x = 5;
		String[] name = {"偶数", "奇数"};
		// 結果を出力
		System.out.println(x + "は" + name[x % 2] + "です");
	}

}
