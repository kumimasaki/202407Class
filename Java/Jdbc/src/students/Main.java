package students;

public class Main {

	public static void main(String[] args) {
		// インスタンス作成
		StudentDao dao = new StudentDaoImpl();
		
		// saveメソッドの呼び出し
		System.out.println(dao.save(new StudentDto(1, "Alice", 19, "Java", "Female")));
	}

}
