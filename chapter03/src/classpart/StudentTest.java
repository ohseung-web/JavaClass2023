package classpart;

public class StudentTest {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		student1.studentName ="홍길동";
		
		Student student2 = new Student();
		student2.studentName ="이순신";
		
		System.out.println(student1);
		System.out.println(student2);
		
		Student studentlee = new Student(); 
		studentlee.studentName = "홍길동";
		studentlee.address ="경기도 부천시 중동";
		studentlee.ShowStudentInfo();
	}

}
