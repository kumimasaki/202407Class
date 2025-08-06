package debug;

public class Ex {
	public static void main(String[] args) {
		
		String s1 = getBanana();
		System.out.println(s1 + "が食べたい");
		
		String s2 = getStrawberry();
		System.out.println(s2 + "が食べたい");
	}
	
	public static String getBanana() {
		return "バナナ";
	}
	
	public static String getStrawberry() {
		return "イチゴ";
	}
}
