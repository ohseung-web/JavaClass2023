package classPart;

public class Student {

	//멤버변수
	int studentID;
	String studentName;
	String address;
	int grade;
	int num1;
	int num2;
	
	public String getStudentName() {
		return studentName;
	}
	
	
	// 생성자
	public Student() {
		System.out.println("------------  student information -------------");
	}
	
	//메서드
	public void showStudentInfo() {
		System.out.println(studentName + "의 주소는 "+ address + "입니다.");
	}
	
	public static void main(String[] args) {

		Student  studentLee = new Student();
		
		studentLee.studentName ="홍길동";
		studentLee.address ="서울특별시 강남구";
		studentLee.showStudentInfo();
		
	}


}
