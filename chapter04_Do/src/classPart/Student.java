package classPart;

public class Student {

	//�������
	int studentID;
	String studentName;
	String address;
	int grade;
	int num1;
	int num2;
	
	public String getStudentName() {
		return studentName;
	}
	
	
	// ������
	public Student() {
		System.out.println("------------  student information -------------");
	}
	
	//�޼���
	public void showStudentInfo() {
		System.out.println(studentName + "�� �ּҴ� "+ address + "�Դϴ�.");
	}
	
	public static void main(String[] args) {

		Student  studentLee = new Student();
		
		studentLee.studentName ="ȫ�浿";
		studentLee.address ="����Ư���� ������";
		studentLee.showStudentInfo();
		
	}


}
