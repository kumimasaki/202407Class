package lesson2_1.static_ex;

public class Main {

	public static void main(String[] args) {
		
//		Cat kitty = new Cat();
//		Cat bob = new Cat();
//		Cat alice = new Cat();
		
		System.out.println(Cat.counter); // ⇒3
		
		Cat.display();
		
		// メソッドの呼び出し
		test();
	}
	
	static void test() {
		
	}
}
