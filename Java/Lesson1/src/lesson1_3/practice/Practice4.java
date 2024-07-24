package lesson1_3.practice;

public class Practice4 {

	public static void main(String[] args) {
		// for文練習問題4
		// 1から20までの整数の合計を計算し、その結果を出力するプログラム
		int sum = 0;
		for (int i = 1; i <= 20; i++) {
			sum += i; // sum = sum + i;
		}
		System.out.println("合計：" + sum);
	}

}
