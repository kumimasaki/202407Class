package lesson2_1.practice6;

public class Main {

	public static void main(String[] args) {
		Student[] students = new Student[2];
		students[0] = new Student("タロウ", 80, 75, 90);
		students[1] = new Student("ハナコ", 90, 70, 80);
		System.out.println("成績表");
		for (int i = 0; i < students.length; i++) {
			students[i].show();
		}
//		for(Student student : students) {
//			student.show();
//		}

	}

}
