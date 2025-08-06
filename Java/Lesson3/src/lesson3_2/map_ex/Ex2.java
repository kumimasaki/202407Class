package lesson3_2.map_ex;

import java.util.HashMap;
import java.util.Map;

public class Ex2 {

	public static void main(String[] args) {
		// マップの宣言
		Map<String, Integer> students = new HashMap<String, Integer>();
		// データの追加
		students.put("Alice", 80);
		students.put("Bob", 100);
		students.put("Alice", 30);
		students.put(null, 50);
		
		System.out.println(students);
	}

}
