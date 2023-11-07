package exception;

public class Main {

	public static void main(String[] args) {

		MainClass004 m04 = new MainClass004();
		
		try {
			m04.firstMethod();
		}catch(java.lang.Exception e) {
			System.out.println(e);
		}
	}

}
