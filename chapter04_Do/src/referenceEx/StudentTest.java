package referenceEx;

public class StudentTest {

	public static void main(String[] args) {

		Student studentJames = new Student(1001, "James");
		studentJames.setKorea("����", 95);
		studentJames.setMath("����", 95);
		
		Student studentTomas = new Student(1002, "Tomas");
		studentTomas.setKorea("����", 78);
		studentTomas.setMath("����", 100);
		
		studentJames.studentInfo();
		studentTomas.studentInfo();
	}

}
