package lesson1_2.array;

public class Practice {

	public static void main(String[] args) {
		// 配列変数「names」を用意
		// 値「"Alice", "Bob", "Charlie"」で初期化してください
		String[] names = {"Alice", "Bob", "Charlie"};
		
		names[1] = "David";
		
		// コンソールに出力：Alice　Bob　Charlie
		System.out.println(names[0]);
		System.out.println(names[1]);
		System.out.println(names[2]);
	}

}
