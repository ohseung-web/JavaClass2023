package referenceEx;

public class Student {
	int studentId; //�л�ID
	String studentName; //�л��̸�
	
	Subject korea; //�����ڷ��� ����
	Subject math;
	
	public Student() {
		korea = new Subject(); //�ν��Ͻ�(=��ü����)
		math = new Subject(); //�ν��Ͻ�
	}
		//������ �����ε�
	public Student(int studentId, String studentName) {
		this.studentId = studentId;
		this.studentName = studentName;
		korea = new Subject(); 
		math = new Subject();
	}
		// ��������̸��� ������ �����ϴ� �޼���
	public void setKorea(String name, int score) {
		this.korea.subjectName = name;
		this.korea.score = score;
	}
	// ���а����̸��� ������ �����ϴ� �޼���
	public void setMath(String name, int score) {
		this.math.subjectName = name;
		this.math.score = score;
	}
		// �л����� ����ϴ� �޼���
	public void studentInfo() {
		int total = korea.score + math.score;
		System.out.println(this.studentName +"�л��� ������ "+total+"�Դϴ�.");
	}
}
