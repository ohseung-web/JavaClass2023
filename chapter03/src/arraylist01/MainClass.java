package arraylist01;

public class MainClass {

	public static void main(String[] args) {
		Student studentlee = new Student(1001, "Lee");
		studentlee.addSubject("����", 100);
		studentlee.addSubject("����", 90);
		studentlee.Showinfo();
		
		System.out.println("================================");
		Student studentpark = new Student(1002, "park");
		studentpark.addSubject("����", 100);
		studentpark.addSubject("����", 90);
		studentpark.addSubject("����", 80);
		studentpark.Showinfo();
	}

}
