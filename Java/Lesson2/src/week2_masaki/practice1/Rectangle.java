package week2_masaki.practice1;

public class Rectangle implements Printx{
	// メンバ変数
	protected double height;
	protected double width;
	
	// コンストラクタ
	public Rectangle(double height, double width) {
		this.height = height;
		this.width = width;
	}
	
	// 面積計算メソッド
	protected double getArea() {
		return height * width;
	}
	
	// 周長計算メソッド
	protected double getPerimeter() {
		return (height + width) * 2;
	}

	@Override
	public void printx() {
		System.out.println("長方形の長さ：" + height
							+ "、幅：" + width
							+ "、面積：" + getArea()
							+ "、周長：" + getPerimeter());
	}
}
