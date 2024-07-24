package lesson3_2.practice2;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// ArrayListを使用して、整数のリストを作成します。
		List<Integer> list = new ArrayList<Integer>();
		
		// リストに以下の値を追加します：15, 20, 30, 45, 55。
		list.add(15);
        list.add(20);
        list.add(30);
        list.add(45);
        list.add(55);
		
		// リストから偶数の要素をすべて削除します。
        for(int i = 0; i < list.size(); i++) {
        	if(list.get(i) % 2 == 0) {
        		list.remove(i);
        		i--; // インデックスを調整
        	}
        	System.out.println(list.get(i));
        }
        
		// リストの全要素の合計を計算して表示します。
        int sum = 0;
        for(int num : list) {
        	sum += num;
        }
        
        System.out.println("リストの全要素の合計: " + sum);

	}

}
