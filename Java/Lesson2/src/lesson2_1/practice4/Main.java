package lesson2_1.practice4;

public class Main {

	public static void main(String[] args) {
		// 2つインスタンスを作成する。下記を引数として渡す。
		// 1つ目のインスタンス作成：半径 = 2.0
		Circle a = new Circle(2.0);
		// 2つ目のインスタンス作成：半径 = 10.0
		Circle b = new Circle(10.0);

		// 円の面積を求めた結果をコンソールに表示してください。
		double result1 = a.area();
		System.out.println(result1);
		
		System.out.println(b.area());
	}

}
