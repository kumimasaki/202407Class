package lesson1_3.practice;

public class GroupPractice {

	public static void main(String[] args) {
		int[][] array2D = { { 1, 2, 3, 4 }, { 5, 6, 7 } };

		// 1. すべての偶数を出力
        for (int i = 0; i < array2D.length; i++) {
            for (int j = 0; j < array2D[i].length; j++) {
                if (array2D[i][j] % 2 == 0) {
                    System.out.print(array2D[i][j] + " ");
                }
            }
        }
        System.out.println();
        
        // 2. 逆順出力
        // マイナス1にしている理由：たてれつの長さ「2」で初期化すると、
        // 2つめのfor分で指定しているarray2D[i]でエラーになる
        for (int i = array2D.length - 1; i >= 0; i--) {
            for (int j = array2D[i].length - 1; j >= 0; j--) {
                System.out.print(array2D[i][j] + " ");
            }
        }
        System.out.println();
        
        // 3. 合計
        int sum = 0;
        for (int[] array: array2D) {
            for(int i: array) {
                sum += i;
            }
        }
        System.out.println(sum);
		
	}

}
