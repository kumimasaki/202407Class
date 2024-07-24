package lesson3_3.scanner_ex;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		try(Scanner scanner = new Scanner(System.in)){
			System.out.println("名前を入力してEnterを押してください");
			String name = scanner.nextLine();
			System.out.println("年齢を入力してEnterを押してください");
			int age = scanner.nextInt();
			System.out.println("あなたの名前は" + name + "で年齢は" + age + "歳です。");
		} catch(InputMismatchException e) {
			e.printStackTrace();
		}

	}

}
