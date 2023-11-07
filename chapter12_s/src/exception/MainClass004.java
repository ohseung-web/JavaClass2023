package exception;

public class MainClass004 {

	public void firstMethod() throws java.lang.Exception{
		secondMethod();
	}
	
	public void secondMethod() throws java.lang.Exception{
		thirdMethod();
	}
	
	public void thirdMethod() throws java.lang.Exception{
		System.out.println("10 / 0"+(10/0));
	}
}
