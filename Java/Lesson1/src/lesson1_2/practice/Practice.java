package lesson1_2.practice;

public class Practice {

	public static void main(String[] args) {
		// 問題1
		// 変数名 hobby 値：読書 初期化してください
		String hobby = "読書";
		// 変数名 readTime 値：2.5(doubleを使用）初期化してください
		double readTime = 2.5;
		// 実行結果（コンソールに出力）
		// 「私の趣味は読書で2.5時間を使って趣味を楽しみます」
		System.out.println("私の趣味は" + hobby + "で" + readTime + "時間を使って趣味を楽しみます");
		
		// 問題2
		// 配列変数 scores 値：44,55,77でscoresを初期化してください
		int[] scores = {44, 55, 77};
		
		int[] scores2 = new int[3];
		scores2[0] = 44;
		scores2[1] = 55;
		scores2[2] = 77;
		// 実行結果（コンソールに出力）
		// 「私の数学の点数は55」
		System.out.println("私の数学の点数は" + scores[1]);

	}

}
