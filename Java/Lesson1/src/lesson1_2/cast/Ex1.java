package lesson1_2.cast;

public class Ex1 {

	public static void main(String[] args) {
		// 小さい型を大きい型に入れる
		double weight;
		int a = 20;
		// double型のweightに int型のaを代入
		weight = a;
		System.out.println(weight);
		
		
		// 大きい型を小さい型に入れる
		double height = 150.5;
		// int型のbに double型のheightを代入
		int b = (int) height;
		System.out.println(b);

	}

}
