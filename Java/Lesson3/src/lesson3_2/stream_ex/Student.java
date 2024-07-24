package lesson3_2.stream_ex;

public class Student {
	// メンバ変数
	// 名前
	private String name;
	// 点数
	private int score;

	// コンストラクタ
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
}
