package referenceEx;

public class StudentTest {

	public static void main(String[] args) {

		Student studentJames = new Student(1001, "James");
		studentJames.setKorea("±¹¾î", 95);
		studentJames.setMath("¼÷ÇÐ", 95);
		
		Student studentTomas = new Student(1002, "Tomas");
		studentTomas.setKorea("±¹¾î", 78);
		studentTomas.setMath("¼÷ÇÐ", 100);
		
		studentJames.studentInfo();
		studentTomas.studentInfo();
	}

}
