package jdbc_ex1;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.cj.jdbc.Driver;


public class SQLInjection {
	public static void main(String[] args) {
		test1("Alice");
		test1("Bob");
		// SQL インジェクション
		String h = "HACKED";
		test1("'; UPDATE account SET password = 'HACKED");
	}

	/*JDBC使用手順
	 * 1：Driverの登録
	 * 2：DBの接続準備
	 * 3：データベースの操作を実行
	 * 4：DBの接続を切る
	 * */
	public static void test1(String username) {
		//1:ドライバの登録
		Driver driver = null;
		try {
			driver = new Driver();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		//ファイルのパスの設定
		String propertyPath = "src/jdbc_ex1/jdbc.properties";
		//2:DBの接続準備
		Properties properties = new Properties();
		try {
			properties.load(new FileReader(propertyPath));
		} catch (IOException e) {
			System.err.println("Failed to read the property file: " + propertyPath);
			e.printStackTrace();
			return;
		}
		//データベースのアドレスの設定
		String url = properties.getProperty("url");
		Properties info = new Properties();
		info.setProperty("user", properties.getProperty("user"));
		info.setProperty("password", properties.getProperty("password"));

		String sql = "SELECT password FROM account WHERE username = '" + username + "'";

		try (//リンクの作成
				Connection con = driver.connect(url, info);
				//SQLの実行
				Statement smt = con.createStatement();) {

			ResultSet rs = smt.executeQuery(sql);

			if (rs.next()) {
				System.out.println("The password of " + username + " is '" + rs.getString("password") + "'.");
			} else {
				System.out.println("There is no user called '" + username + "'.");
			}

		} catch (SQLException e) { // データベース操作時の例外処理
			System.err.println("Error happened when I try to access the database: " + properties.getProperty("url"));
			e.printStackTrace();
		}
	}

}
