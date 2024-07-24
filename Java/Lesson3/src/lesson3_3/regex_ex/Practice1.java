package lesson3_3.regex_ex;

import java.util.regex.Pattern;

public class Practice1 {

	public static void main(String[] args) {
		// isUsernameValidの呼び出し
		System.out.println(isUsernameValid("Alice1234"));
		System.out.println(isUsernameValid("%&_"));
		// isPasswordValidの呼び出し
		System.out.println(isPasswordValid("abc___1234"));
		System.out.println(isPasswordValid("abc_"));
	}
	
	// isUsernameValidメソッド
	public static boolean isUsernameValid(String userName) {
		return userName.matches("[a-zA-Z0-9]+");
	}
	
	// isPasswordValidメソッド
	public static boolean isPasswordValid(String password) {
		return Pattern.matches("[a-zA-Z0-9_]{8,}", password);
	}
}
