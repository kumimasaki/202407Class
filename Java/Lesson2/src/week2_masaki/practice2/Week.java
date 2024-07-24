package week2_masaki.practice2;

public enum Week {
	MON("月曜日"),TUE("火曜日"),WED("水曜日"),THR("木曜日"),FRI("金曜日"),SAT("土曜日"),SUN("日曜日");
	
	private String japaneseName;

	private Week(String japaneseName) {
		this.japaneseName = japaneseName;
	}

	public String getJapaneseName() {
		return japaneseName;
	}
}
