package arraylist01;

public class MainClass {

	public static void main(String[] args) {
		Student studentlee = new Student(1001, "Lee");
		studentlee.addSubject("국어", 100);
		studentlee.addSubject("수학", 90);
		studentlee.Showinfo();
		
		System.out.println("================================");
		Student studentpark = new Student(1002, "park");
		studentpark.addSubject("국어", 100);
		studentpark.addSubject("수학", 90);
		studentpark.addSubject("영어", 80);
		studentpark.Showinfo();
	}

}
