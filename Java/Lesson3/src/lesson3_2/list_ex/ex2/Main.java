package lesson3_2.list_ex.ex2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// リストの宣言
		List<Cat> cats = new ArrayList<Cat>();
		// データを追加
		cats.add(new Cat("Kitty", 2));
		cats.add(new Cat("Bob", 5));
		System.out.println(cats);
		
		// toStringを使わない方法
		System.out.println(cats.get(0).getName());
		System.out.println(cats.get(0).getAge());
		
		for(Cat a : cats) {
			System.out.println(a.getName());
		}
	}

}
