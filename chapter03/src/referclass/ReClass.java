package referclass;

class MyInteger {
	int a;

	public MyInteger(int a) {
		this.a = a;
	}
}

public class ReClass {

	public static void main(String[] args) {
		int a = 10;
		Integer i = 10;
		
		float b = 10.1f;
		Float f = 10.1F;

		double d = 10.1;
		Double dd = 10.11; 
		
		MyInteger ii = new MyInteger(100);
        System.out.println(i);
        System.out.println(f);
        System.out.println(dd);
        System.out.println(ii.a);
	}

}
