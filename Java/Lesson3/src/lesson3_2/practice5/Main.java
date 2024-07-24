package lesson3_2.practice5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

		// リストから長さが5文字以上かつ
		// 最初の文字が'e'ではない
		System.out.println(
				fruits.stream()
						.filter(f -> f.length() >= 5 && f.charAt(0) != 'e')
						.collect(Collectors.toList()));

	}

}
