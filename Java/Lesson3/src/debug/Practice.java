package debug;

public class Practice {

    public static void main(String[] args) {
    	//	main の左の灰色エリアをクリックしてブレークポイントを置く
    	//	デバッグ実行（右クリック → [デバッグ]）
    	//	F6（ステップオーバー）で少しずつ処理を見る
    	//	変数ビューで i や total の中身を確認
    	
        int[] scores = {70, 85, 40, 90, 60};
        int total = 0;

        for (int i = 0; i <= scores.length; i++) { // ← わざと「=」つけてある
            System.out.println("i: " + i); // ← i の確認
            total += scores[i];           // ← ここでエラーになる可能性あり
        }

        System.out.println("合計点: " + total);
    }
}
