package classpart;

public class StudentTest {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		student1.studentName ="ȫ�浿";
		
		Student student2 = new Student();
		student2.studentName ="�̼���";
		
		System.out.println(student1);
		System.out.println(student2);
		
		Student studentlee = new Student(); 
		studentlee.studentName = "ȫ�浿";
		studentlee.address ="��⵵ ��õ�� �ߵ�";
		studentlee.ShowStudentInfo();
	}

}
