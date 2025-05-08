package lesson2_3.capsule.practice8;

public class Casher {
	
	// 合計金額計算メソッド
	public static int payment(int amount, Coupon coupon) {
		int ret = coupon.discount(amount);
		return ret;
	}
}
