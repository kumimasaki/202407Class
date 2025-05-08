package lesson2_3.capsule.practice8;

public class PercentageCoupon implements Coupon {
	// メンバ変数
	public double rate;

	// コンストラクタ
	public PercentageCoupon(double rate) {
		this.rate = rate;
	}

	@Override
	public int discount(int amount) {
		return (int) (amount * rate);
	}
}
