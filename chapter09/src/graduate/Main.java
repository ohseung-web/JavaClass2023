package graduate;

public class Main {

	public static void main(String[] args) {
		Student st01 = new Student("Lia", "Biology", 3, 16);
		System.out.println(st01.toString() + "\n--------------------");
		UnderGraduate st02 = new UnderGraduate("Kim", "Math", 1, 19, "Great Guitar");
		System.out.println(st02.toString());
		
		Graduate st03 = new Graduate("John", "Economy", 4, 12, "교육 조교", 78);
		Graduate st04 = new Graduate("Mike", "Economy", 4, 15, "연구 조교", 75);
		Graduate st05 = new Graduate("Harry", "Economy", 4, 10, "-", 20);
		System.out.println(st03.toString());
		System.out.println(st04.toString());
		System.out.println(st05.toString());
	}

}
