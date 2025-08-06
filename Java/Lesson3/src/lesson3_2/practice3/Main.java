package lesson3_2.practice3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// リストの宣言
		List<Book> books = new ArrayList<Book>();
		// データの追加
		books.add(new Book("吾輩は猫である", "夏目漱石", "フィクション"));
		books.add(new Book("銀河鉄道の夜", "宮沢賢治", "ファンタジー"));
		books.add(new Book("こころ", "夏目漱石", "フィクション"));
		
		// 本のジャンルが  「フィクション」の本のみのデータを出力する
		// equals の左側は固定（リテラルや null にならない値）にするのが安全で推奨される書き方
		for(Book b : books) {
			if("フィクション".equals(b.getGenre())) {
				 System.out.println(b);
				 System.out.println("本のジャンルが「フィクション」の本:" + b.getTitle() + "," + b.getAuthor() + "," + b.getGenre());
			}
		}
	}

}
