package lesson3_2.list_ex;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {
		// リストの宣言
		List<String> studentNames = new ArrayList<String>();
		// データの挿入
		studentNames.add("Alice");
		studentNames.add("Bob");
		studentNames.add("Carol");
		// 要素を指定して追加
		studentNames.add(3, "Dave");
		// データの削除
		studentNames.remove(1);

	}

}
