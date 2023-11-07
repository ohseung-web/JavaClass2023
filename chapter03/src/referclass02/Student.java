package referclass02;

public class Student {
	int studentID;
	String studentName;
	
	/*
	 * int koreascore; int mathscore; String koreasubject; String mathsubject;
	 */
   
	// ����ڰ� ���� �ۼ��� �����ڷ������� �����Ѵ�.
	Subject korea;
	Subject math;

	public Student() { //������ ȣ��� ���� �ν��Ͻ��Ͽ� �����Ѵ�.
		korea = new Subject();
		math = new Subject();
	}
	public Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
		
		korea = new Subject();
		math = new Subject();
	}
	// ����, ���� ������ �����ϴ� �޼��� �ۼ�
	public void Setkorea(String name,int score) {
		korea.setSubjectName(name);
		korea.setScore(score);
	}
	public void Setmath(String name,int score) {
		math.setSubjectName(name);
		math.setScore(score);
	}
	//�� �л� ���� ������ ����ϴ� �޼���
	public void ShowStudentInfo() {
		int total = korea.getScore()+math.getScore();
		System.out.println(studentName+"�л��� ������ "+total+"�Դϴ�.");
	}
}
