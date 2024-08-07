package lesson3_2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class JavaSilver {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("B");
		
//        // Bを削除する
//        list.removeIf(element -> element.equals("B"));
//        // 結果の表示
//        System.out.println("削除後のリスト: " + list);

//		// Setにリストを追加して重複を削除する
//		Set<String> set = new LinkedHashSet<>(list);

		// 削除された重複のないリストを再度作成
//		List<String> uniqueList = new ArrayList<>(set);
		List<String> uniqueList = 
				list.stream()
				.distinct()
				.collect(Collectors.toList());

		// 結果の表示
		System.out.println("重複削除前: " + list);
		System.out.println("重複削除後: " + uniqueList);
	}

}
