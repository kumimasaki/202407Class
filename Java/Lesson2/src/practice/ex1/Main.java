package practice.ex1;

public class Main {
	public static void main(String[] args) {
		// 以下の要件に従ってコードを追加してください

		// 1. 生徒のインスタンスを作成し、自己紹介させてください
		Student student = new Student("Taro", 20, "20230001");
		student.introduce();

		// 2. 生徒のインスタンスでrunメソッドを呼び出してください
		student.run();

		// 3. 車のインスタンスを作成し、走らせてください
		Car car = new Car("Toyota");
		car.run();
		System.out.println("The brand name of the car is" + car.getBrand());
	}
}