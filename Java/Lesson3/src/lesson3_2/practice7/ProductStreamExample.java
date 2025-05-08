package lesson3_2.practice7;

import java.util.ArrayList;
import java.util.List;

public class ProductStreamExample {
    public static void main(String[] args) {
    	// 商品情報のリストを作成
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 100000, 5));
        products.add(new Product("Phone", "Electronics", 80000, 10));
        products.add(new Product("Desk", "Furniture", 30000, 15));
        products.add(new Product("Chair", "Furniture", 15000, 20));
        products.add(new Product("Monitor", "Electronics", 20000, 8));
        products.add(new Product("Cupboard", "Furniture", 40000, 12));
        products.add(new Product("Headphones", "Electronics", 15000, 25));

        // 1. 在庫が 10 未満の商品をリスト作成
        System.out.println("在庫が10未満の商品:");
        products.stream()
                .filter(p -> p.getStock() < 10)
                .forEach(p -> System.out.println(p.getName() + ": " + p.getStock()));

        // 2. "Electronics" カテゴリーの商品を価格順（昇順）に並べる
        System.out.println("\n\"Electronics\" カテゴリーの商品（価格順）:");
        products.stream()
                .filter(p -> "Electronics".equals(p.getCategory()))
                .sorted((p1, p2) -> p1.getPrice() - p2.getPrice()) // 単純に価格で並べる
                .forEach(p -> System.out.println(p.getName() + ": " + p.getPrice()));

        // 3. 最も高い価格の商品を見つける
        System.out.println("\n最も高い価格の商品:");
        Product mostExpensive = products.stream()
                                        .max((p1, p2) -> p1.getPrice() - p2.getPrice()) // 価格で最大を取得
                                        .orElse(null); // nullの場合の処理
        if (mostExpensive != null) {
            System.out.println(mostExpensive.getName() + ": " + mostExpensive.getPrice());
        }

        // 4. 全商品の価格の合計を計算
        System.out.println("\n全商品の価格の合計:");
        int totalPrice = products.stream()
                                 .mapToInt(p -> p.getPrice()) // mapToIntを使って直接intに変換
                                 .sum(); // sumメソッドを使って合計
        System.out.println(totalPrice);
    }
}