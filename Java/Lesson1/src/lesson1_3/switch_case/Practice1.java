package lesson1_3.switch_case;

public class Practice1 {

	public static void main(String[] args) {
		// 変数 month を用意 値：1~12

		// 12, 1, 2：冬
//		// 3，4，5 春
//		//　6，7，8　夏
//		//　9,10,11 秋
		// 変数 int month 1~12
		int month = 1;
		// 12,1,2 冬
		// 3，4，5 春
		// 6，7，8 夏
		// 9,10,11 秋
		switch (month) {
		case 12, 1, 2:
			System.out.println("冬");
			break;
		case 3, 4, 5:
			System.out.println("春");
			break;
		case 6, 7, 8:
			System.out.println("夏");
			break;
		case 9, 10, 11:
			System.out.println("秋");
			break;
		}

	}

}
