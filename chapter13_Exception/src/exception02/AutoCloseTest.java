package exception02;

public class AutoCloseTest {

	public static void main(String[] args) {

		try(AutoCloseObj auto = new AutoCloseObj()) {
           throw new java.lang.Exception(); // exception�� �߻����Ѷ�
		}catch(java.lang.Exception e) {
			System.out.println("exception");
		} 
	}
}
