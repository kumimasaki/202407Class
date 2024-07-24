package lesson2_1.object_oriented;

public class Cat {
	// 属性（メンバ変数：登場人物に関する情報を保存する箱）
	// 名前
	String name;
	// 年齢
	int age;
	// 色
	String color;
	
	public Cat(String name, int age, String color) {
		super();
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	public Cat() {
	}

	// 振る舞い（メソッド：登場人物の行動や手順）
	// 食べるメソッド
	void eat(String food) {
		// コンソール出力「food　を食べます」
		System.out.println(food + "を食べます");
		meow();
	}
	
	// 鳴く
	void meow() {
		// ニャー
		System.out.println("ニャー");
	}
	
}
