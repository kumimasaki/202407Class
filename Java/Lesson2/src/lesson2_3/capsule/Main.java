package lesson2_3.capsule;

public class Main {

	public static void main(String[] args) {
		// インスタンス作成
		Bank bank = new Bank("Alice", 1200, 1234);
		
		// ユーザー名を表示
		System.out.println(bank.username);
//		// 残高を表示
//		System.out.println(bank.balanceOfBank);
//		// パスワードを表示
//		System.out.println(bank.password);
		
		// 残高を取得して表示
		System.out.println(bank.getBalanceOfBank());
		// 残高に「10000」を再設定
		bank.setBalanceOfBank(10000);
		System.out.println(bank.getBalanceOfBank());
		
		// パスワードに「12345678」を再設定
		bank.setPassword(12345678);
		// パスワードを取得して表示
		System.out.println(bank.getPassword());
	}

}
