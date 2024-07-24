package practice.ex1;

public class Student extends Person implements Runnable {
	// メンバ変数 生徒ID
	private String studentId;

	public Student(String name, int age, String studentId) {
		super(name, age);
		this.studentId = studentId;
	}

	@Override
	public void run() {
		System.out.println(name + " is running");
	}
}