package lesson2_3.capsule.practice8;


public class VolumeCoupon implements Coupon {
    // メンバ変数
	public int volume;

	// コンストラクタ
    public VolumeCoupon(int volume) {
        this.volume = volume;
    }

    @Override
    public int discount(int amount) {
        return amount - volume;
    }
}