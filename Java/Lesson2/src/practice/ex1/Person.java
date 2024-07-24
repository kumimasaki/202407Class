package practice.ex1;

public class Person {
	// メンバ変数
	// 名前
	protected String name;
	// 年齢
	protected int age;

	// コンストラクタ
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	// 自己紹介メソッドの作成
	public void introduce() {
		System.out.println("My name is " + name + ". I am" + age + " years old.");
	}
}