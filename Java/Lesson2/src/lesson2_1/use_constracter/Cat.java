package lesson2_1.use_constracter;

public class Cat {
	// メンバ変数
	// 名前
	String name;
	// 年齢
	int age;
	
	// コンストラクタ
	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// デフォルトコンストラクタ
	public Cat() {
		this.name = "Masaki";
	}

	public Cat(String name) {
		this.name = name;
	}
	
	
//	// コンストラクタ作成
//	Cat(String name, int age) {
//		// メンバ変数に値を設定
//		this.name = name;
//		this.age = age;
//	}
}
