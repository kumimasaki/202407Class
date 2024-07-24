package practice.ex1;

public class Car implements Runnable {
	// メンバ変数 ブランド名
	private String brand;

	public Car(String brand) {
		this.brand = brand;
	}

	@Override
	public void run() {
		System.out.println(brand + " cars on the road.");
	}

	// ゲッター
	public String getBrand() {
		return brand;
	}

	// セッター
	public void setBrand(String brand) {
		this.brand = brand;
	}

}