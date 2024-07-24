package lesson2_1.object_oriented;
// 設計書を実行するクラス
public class Main {

	public static void main(String[] args) {
		// インスタンス作成
		Cat alice = new Cat();
		// 名前
		alice.name = "アリス";
		// 年齢
		alice.age = 5;
		// 色（白）
		alice.color = "白";
		// 名前をコンソールに表示
		System.out.println(alice.name);
		// 年齢をコンソールに表示
		System.out.println(alice.age);
		// 色をコンソールに表示
		System.out.println(alice.color);
		// メソッドの呼び出し
		alice.eat("キャットフード");
		
		
		// Dog設計書を使ってインスタンス作成
		// 変数名：bob
		Dog bob = new Dog();
		// 値を設定：bobのname「BOB」,age「3」
		bob.name = "BOB";
		bob.age = 3;
		// コンソールにname, ageを表示してください。
		System.out.println(bob.name);
		System.out.println(bob.age);
		// eatメソッドの呼び出し
		bob.eat("ドッグフード");
	}

}
