package referclass02;

public class MainClass {

	public static void main(String[] args) {
		Student studentJames = new Student(1001, "james");
		studentJames.Setkorea("국어", 100);
		studentJames.Setmath("수학", 100);
		
		Student studentTomas = new Student(1002, "Tomas");
		studentTomas.Setkorea("국어", 80);
		studentTomas.Setmath("수학", 90);
		
		studentJames.ShowStudentInfo();
		studentTomas.ShowStudentInfo();
		
	}

}
