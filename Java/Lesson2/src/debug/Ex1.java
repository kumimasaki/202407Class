package debug;

public class Ex1 {
	public static void main(String[] args) {

		String weather = "晴れ";

		if (weather.equals("晴れ")) {
			System.out.println("洗濯物を外に干します");
		} else if (weather.equals("曇り")) {
			System.out.println("乾燥機で乾かします");
		} else {
			System.out.println("洗濯物は干しません");
		}
	}
}
