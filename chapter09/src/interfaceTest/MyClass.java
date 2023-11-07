package interfaceTest;

public class MyClass implements MyInterface {

	@Override
	public void x() {
		System.out.println("x();");
	}

	@Override
	public void y() {
		System.out.println("y();");
		
	}

	@Override
	public void myMethod() {
		System.out.println("mymethod();");
		
	}
	
	
	public static void main(String[] args) {
		MyClass myclass = new MyClass();
		X xclass = myclass;
		xclass.x();
	}

}
