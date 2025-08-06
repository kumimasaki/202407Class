package lesson2_2.extends_ex.practice3;

public class Main {

	public static void main(String[] args) {
		// インスタンス作成
		Student student1 = new Student("Alice", 20);
		Student student2 = new Student("Bob", 19);
		// メソッド呼び出し
		student1.study();
		student2.study();
	}
}