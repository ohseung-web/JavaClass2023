package exception;

public class AutoCloseTest {

	public static void main(String[] args) {

		try(AutoCloseObj auto = new AutoCloseObj()) {
            throw new Exception();
		}catch(Exception e) {
			System.out.println("exception");
		}
		
		try {
			
		}catch(Exception e) {
			
		}
	}
}
