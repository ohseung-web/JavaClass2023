package referclass02;

public class Student {
	int studentID;
	String studentName;
	
	/*
	 * int koreascore; int mathscore; String koreasubject; String mathsubject;
	 */
   
	// 사용자가 직접 작성한 참조자료형으로 선언한다.
	Subject korea;
	Subject math;

	public Student() { //생성자 호출시 직접 인스턴스하여 생성한다.
		korea = new Subject();
		math = new Subject();
	}
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		
		korea = new Subject();
		math = new Subject();
	}
	// 국어, 수학 점수를 세팅하는 메서드 작성
	public void Setkorea(String name,int score) {
		korea.setSubjectName(name);
		korea.setScore(score);
	}
	public void Setmath(String name,int score) {
		math.setSubjectName(name);
		math.setScore(score);
	}
	//각 학생 과목 총점을 출력하는 메서드
	public void ShowStudentInfo() {
		int total = korea.getScore()+math.getScore();
		System.out.println(studentName+"학생의 총점은 "+total+"입니다.");
	}
}
