package lesson2_5.try_catch;

public class Ex1 {

	public static void main(String[] args) {
		// 配列の初期化
		int[] arr = {1, 2, 3};
		String a = null;
		
		// 試したい処理
		try {
			System.out.println(a.length());
			
			System.out.println("Hello");
			// 2. 割り算の処理
			System.out.println(3/0);
			
			// 1. 添え字の番号をわざと間違えて実行
			System.out.println(arr[5]);
		} catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			// エラーが起きてしまったときにしたい処理
			System.out.println("添え字の番号、もしくは変数の中身に間違いがあります");
		} catch(ArithmeticException e) {
			// エラーが起きてしまったときにしたい処理
			System.out.println("割り算の処理を見直してください");
		} finally {
			System.out.println("絶対に実行されるコード！");
		}
	}
}
