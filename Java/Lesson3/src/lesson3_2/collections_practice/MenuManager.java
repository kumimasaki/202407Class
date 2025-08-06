package lesson3_2.collections_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuManager {
	
	//	map = {
	//	  "sandwich" : ["ハンバーガー", "チーズバーガー"],
	//	  "drink"    : ["コーラ", "ミネラルウォーター"],
	//	  "sidemenu" : ["ポテト", "ナゲット"]
	//	}
	private Map<String, List<String>> map = new HashMap<>();

	public MenuManager() {
		// サンドイッチメニューの登録
		List<String> list = new ArrayList<>();
		list.add("ハンバーガー");
		list.add("チーズバーガー");
		list.add("ダブルチーズバーガー");
		map.put("sandwich", list);

		// ドリンクメニューの登録
		list = new ArrayList<>();
		list.add("コーラ");
		list.add("オレンジジュース");
		list.add("ミネラルウォーター");
		map.put("drink", list);

		// サイドメニューの登録
		list = new ArrayList<>();
		list.add("フライドポテト");
		list.add("チキンナゲット");
		list.add("フレンチサラダ");
		map.put("sidemenu", list);
	}

	// ここに searchMenu を作成する。
	public void searchMenu(String menu) {
		// map.keySet() は Map<String, List<String>> の全てのキー（カテゴリ名）を取得
		// for文で、それぞれのカテゴリ（key）を1つずつ順番に取り出して処理
		for (String key : map.keySet()) {
			// map.get(key) は、現在のカテゴリに対応するメニュー一覧（List<String>） を取得
			if (map.get(key).contains(menu)) {
				System.out.println(menu + "は" + key + "に含まれています。");
				// 見つかった時点でメソッドを終了させる
				return;
			}
		}
		System.out.println("該当するメニューはありません。");
	}

	// ここに setMenu を作成する。
	public void setMenu(String category, String menu) {
		// map.get(category):指定したカテゴリに対応するメニュー一覧（List）を取得
		map.get(category).add(menu);
	}

	// ここに showMenu を作成する。
	public void showMenu(String category) {
		System.out.println(map.get(category));
	}
}