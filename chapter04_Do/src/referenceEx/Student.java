package referenceEx;

public class Student {
	int studentId; //학생ID
	String studentName; //학생이름
	
	Subject korea; //참조자료형 선언
	Subject math;
	
	public Student() {
		korea = new Subject(); //인스턴스(=객체생성)
		math = new Subject(); //인스턴스
	}
		//생성자 오버로딩
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		korea = new Subject(); 
		math = new Subject();
	}
		// 국어과목이름과 점수를 정의하는 메서드
	public void setKorea(String name, int score) {
		this.korea.subjectName = name;
		this.korea.score = score;
	}
	// 수학과목이름과 점수를 정의하는 메서드
	public void setMath(String name, int score) {
		this.math.subjectName = name;
		this.math.score = score;
	}
		// 학생총점 출력하는 메서드
	public void studentInfo() {
		int total = korea.score + math.score;
		System.out.println(this.studentName +"학생의 총점은 "+total+"입니다.");
	}
}
