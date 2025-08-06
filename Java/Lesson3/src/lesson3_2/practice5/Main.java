package lesson3_2.practice5;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// リストの作成
		List<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("banana");
		fruits.add("cherry");
		fruits.add("date");
		fruits.add("elderberry");
		fruits.add("fig");
		fruits.add("grape");

		//		List<String> fruits2 = List.of("apple", "banana", "cherry", 
		//				"date", "elderberry", "fig", "grape");

		// リストから長さが5文字以上かつ
		// 最初の文字が'e'ではない
		fruits.stream()
				.filter(f -> f.length() >= 5 && f.charAt(0) != 'e')
				.forEach(e -> System.out.println(e));

//		.filter(f -> f.length() >= 5 && !f.startsWith("e"))
		
//		System.out.println(
//				fruits.stream()
//						.filter(f -> f.length() >= 5 && f.charAt(0) != 'e')
//						.collect(Collectors.toList()));

	}

}
