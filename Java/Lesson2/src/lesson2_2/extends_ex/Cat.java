package lesson2_2.extends_ex;

// 子クラス（サブクラス）
public class Cat extends Animal implements Runnable{
	// メンバ変数(猫クラス独自のメンバ変数)
	// 色
	String color;
//	int age;

	// コンストラクタ
	public Cat(String name, int age, String color) {
		super(name, age);
		this.color = color;
//		this.age = 10;
	}

	// メソッド（猫独自）
	void meow() {
		// ニャー
		System.out.println("ニャー");
	}
	
	@Override
	void sounds() {
		System.out.println("ニャーと鳴く");
	}

	@Override
	public String toString() {
		return "Cat [color=" + color + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public void run() {
		System.out.println("猫が走る");
	}
	

}
