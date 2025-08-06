package lesson2_1.practice6;

public class Student {
	String name;
	int japanese;
	int math;
	int english;

	Student(String name, int japanese, int math, int english) {
		this.name = name;
		this.japanese = japanese;
		this.math = math;
		this.english = english;
	}

	void show() {
		System.out.println(name + ":" + japanese + "," + math + "," + english);
	}
}