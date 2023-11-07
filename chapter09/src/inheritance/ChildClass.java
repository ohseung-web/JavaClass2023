package inheritance;

public class ChildClass extends ParentClass{
     
	int a =5;
	int b=6;
      	
	public ChildClass() {
		super();
		System.out.println("ChildClass Constructor");
	}
	public void Chidfun() {
		this.b =12;
		super.a = 35; 
		System.out.println("Childfun START");
	}
}
