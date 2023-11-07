package exception02;

public class AutoCloseTest {

	public static void main(String[] args) {

		try(AutoCloseObj auto = new AutoCloseObj()) {
           throw new java.lang.Exception(); // exception을 발생시켜라
		}catch(java.lang.Exception e) {
			System.out.println("exception");
		} 
	}
}
