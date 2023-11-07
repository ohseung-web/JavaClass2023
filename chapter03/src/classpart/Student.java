package classpart;

public class Student {
	// --- 맴버변수 ----
	int studentId;
	String studentName;
	String address;
	int grade;

	//---  생성자 ----
	/*
	 * public Student() { System.out.println("------- 학생정보 -------"); }
	 */
	public Student() {}
	public Student(int id, String name) {
		studentId = id;
		studentName = name;
	}

	// --- 메서드(=함수) ------
	public void ShowStudentInfo() {
		System.out.println(studentName+"의 주소는 :"+address+"입니다.");
	}

	public static void main(String[] args) {
		// 클래스를 인스턴스화하여 호출해서 출력하는 곳
		Student studentlee = new Student(); // 인스턴스화 (= 객체화)
		studentlee.studentName = "홍길동";
		studentlee.address ="경기도 부천시 중동";
		studentlee.ShowStudentInfo();
	}
}