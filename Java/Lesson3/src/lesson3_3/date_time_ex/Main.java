package lesson3_3.date_time_ex;

import java.time.LocalDateTime;

public class Main {

	public static void main(String[] args) {
		// 今日の日付・時刻を取得
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);

		// 曜日の取得
		System.out.println(now.getDayOfWeek());
		
		// 日付を足す
		now = now.plusDays(10);
		System.out.println(now);
	}

}
