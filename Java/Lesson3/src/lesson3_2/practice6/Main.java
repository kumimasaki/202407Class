package lesson3_2.practice6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		// リストの作成
		List<Teacher> teacher = new ArrayList<>();
		teacher.add(new Teacher("Sasaki", 50));
		teacher.add(new Teacher("Tanaka", 24));
		teacher.add(new Teacher("Suzuki", 39));

		// 教師の年齢が50歳未満を抽出
		System.out.println(
				teacher.stream()
						.filter(e -> e.getAge() < 50)
						.collect(Collectors.toList()));
	}

}
