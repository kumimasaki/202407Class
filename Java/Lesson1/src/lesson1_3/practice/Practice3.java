package lesson1_3.practice;

public class Practice3 {

	public static void main(String[] args) {
		// if文練習問題3
		
		// 三角形の3辺の長さ side1, side2, side3 が与えられたとき、
		// それが正三角形、二等辺三角形、不等辺三角形のどれであるかを判定し、
		// 結果を出力するプログラムを作成
		int side1 = 3;
		int side2 = 3;
		int side3 = 4;
		if (side1 == side2 && side2 == side3) {
			System.out.println("正三角形です");
		} else if (side1 == side2 || side1 == side3 || side2 == side3) {
			System.out.println("二等辺三角形です");
		} else {
			System.out.println("不等辺三角形です");
		}

	}

}
