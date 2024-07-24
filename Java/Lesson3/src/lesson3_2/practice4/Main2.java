package lesson3_2.practice4;

import java.util.HashMap;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) {
		// (1)インスタンスを作成し、HashMapに格納
		Map<String, Person> personMap = new HashMap<String, Person>();
		personMap.put("田中", new Person("tanaka", 28));
		personMap.put("鈴木", new Person("suzuki", 25));
		personMap.put("井澤", new Person("izawa", 32));
		
		// (2)
		if (personMap.containsKey("井澤")) {
			System.out.println("井澤はいます。");
		} else {
			System.out.println("井澤はいません。");
		}
		
		// (3)
		for(String person : personMap.keySet()) {
			System.out.println(person + "は" + personMap.get(person).getAge() + "歳");
		}
		
		// (4)
		int max = 0;
		for(String person : personMap.keySet()) {
			max = Math.max(max, personMap.get(person).getAge());
		}
		
		System.out.println(max + "歳が最年長です。");
	}

}
