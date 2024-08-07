package lesson3_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex4 {
    static Map<String, String> users = new HashMap<>();

    static boolean isUsernameValid(String username) {
        return username.matches("[a-zA-Z0-9]+");
    }

    static boolean isPasswordValid(String password) {
        return password.matches("[a-zA-Z0-9_]{8,}");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username;
        String password;

        while (true) {
            // 最初にユーザー名とパスワードを一度入力させる
            System.out.println("** Please input a username and a password to register: **");
            username = scanner.next();
            password = scanner.next();
            scanner.nextLine();
            while (true) {
                if (users.containsKey(username)) {
                    // ユーザー名がすでに存在する場合は、再入力させる
                    System.out.println("** The username '" + username + "' has been registered. **");
                } else if (!isUsernameValid(username) || !isPasswordValid(password)) {
                    // ユーザー名またはパスワードの形式が正しくない場合は、再入力させる
                    System.out.println("** Your input is not in right format! **");
                } else {
                    // フォーマットが正しければ、入力を終了
                    break;
                }

                // ユーザーに再入力を求める
                System.out.println("** Please input a username and a password again: **");
                username = scanner.next();
                password = scanner.next();
                scanner.nextLine();
            }

            // 登録が成功すると、ユーザーのリストを出力し、次の登録を開始する
            users.put(username, password);
            System.out.println("** Register successfully! **");
            System.out.println("** User list: " + users + ". **");
        }
    }
}
