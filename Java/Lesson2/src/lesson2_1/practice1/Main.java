package lesson2_1.practice1;

public class Main {

	public static void main(String[] args) {
		// 以下を引数にしてインスタンスを2つ作成する
		// 「コーヒー 120」
		// 「オレンジジュース 150」
		Item coffee = new Item("コーヒー", 120);
		Item orange = new Item("オレンジジュース", 150);
		
		// displayメソッドを2回呼び出してください
		// 実行結果
		// コーヒー：120円
		// オレンジジュース：150円
		coffee.display();
		orange.display();
	}

}
