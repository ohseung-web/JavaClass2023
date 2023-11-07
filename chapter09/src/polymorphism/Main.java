package polymorphism;

public class Main {

	public static void main(String[] args) {

		int a=10;
		double b=0.2;
		int c=0;
		//c=(int)(a*b);
		
		c = (int)(c + ((double)a*b));
		//c += (a*b);
		System.out.println(c);
	}

}
