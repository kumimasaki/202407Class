package lesson2_3.capsule;

public class Bank {
	// メンバ変数
	// ユーザー名（公開）
	protected String username;
	// 残高（非公開）
	protected int balanceOfBank;
	// パスワード（非公開）
	protected int password;
	
	// コンストラクタ
	public Bank(String username, int balanceOfBank, int password) {
		this.username = username;
		this.balanceOfBank = balanceOfBank;
		this.password = password;
	}
	
	protected void test() {
		
	}

	// getter, setterを追加
	public int getBalanceOfBank() {
		return balanceOfBank;
	}

	public void setBalanceOfBank(int balanceOfBank) {
		this.balanceOfBank = balanceOfBank;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}
	
}
