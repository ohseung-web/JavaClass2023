package classpart08;

public class MainClass {

	public static void main(String[] args) {

		ClassEx8 ce8 = new ClassEx8(30,6);
		int x = ce8.x;
		int y = ce8.y;
		
		System.out.println(ce8.Plus(x,y));
		System.out.println(ce8.multiply(x,y));
		System.out.println(ce8.subtract(x,y));
		System.out.println(ce8.divide(x,y));
		
	}

}
