package classpart;

public class Student {
	// --- �ɹ����� ----
	int studentId;
	String studentName;
	String address;
	int grade;

	//---  ������ ----
	/*
	 * public Student() { System.out.println("------- �л����� -------"); }
	 */
	public Student() {}
	public Student(int id, String name) {
		studentId = id;
		studentName = name;
	}

	// --- �޼���(=�Լ�) ------
	public void ShowStudentInfo() {
		System.out.println(studentName+"�� �ּҴ� :"+address+"�Դϴ�.");
	}

	public static void main(String[] args) {
		// Ŭ������ �ν��Ͻ�ȭ�Ͽ� ȣ���ؼ� ����ϴ� ��
		Student studentlee = new Student(); // �ν��Ͻ�ȭ (= ��üȭ)
		studentlee.studentName = "ȫ�浿";
		studentlee.address ="��⵵ ��õ�� �ߵ�";
		studentlee.ShowStudentInfo();
	}
}