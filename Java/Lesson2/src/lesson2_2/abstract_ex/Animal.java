package lesson2_2.abstract_ex;

public abstract class Animal {
	// メンバ変数
	String name;

	// コンストラクタ
	public Animal(String name) {
		this.name = name;
	}
	
	// 振る舞い：sounds 戻り値無し：引数なし
	// 処理内容：name + " make sounds"をコンソールに出力
	void sounds() {
		System.out.println(name + " make sounds");
	}
	
	// 未実装のメソッド(抽象メソッド)
	public abstract void eat(String food);
}
