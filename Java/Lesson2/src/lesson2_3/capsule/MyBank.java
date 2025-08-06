package lesson2_3.capsule;

public class MyBank extends Bank{
	private String name;

	public MyBank(String username, int balanceOfBank, int password) {
		super(username, balanceOfBank, password);
	}

	// オーバーライドについて説明
	@Override
	public void test() {
		System.out.println(balanceOfBank);
	}
	
}
