package week2_masaki.practice2;

public class Buki implements Item{
	// メンバ変数
	private String name;
	private int attackValue;
	
	// コンストラクタ
	public Buki(String name, int attackValue) {
		this.name = name;
		this.attackValue = attackValue;
	}

	public String getName() {
		return name;
	}

	public int getAttackValue() {
		return attackValue;
	}

	@Override
	public void use() {
		System.out.println(name + "でこうげき!");
		System.out.println("敵に" + attackValue + "のダメージ!");
	}
	
}