package inheritance;

public class ChildClass extends ParentClass {

	int a = 25;
	int b = 35;
	
	//»ý¼ºÀÚ
	public ChildClass() {
   // super();
	/*   System.out.println("----ChildClass constructor-----");
		System.out.println(this.a);
		System.out.println(this.b);
		System.out.println(super.a);
		System.out.println(super.b);
	  */
	}
	public void ChildFun() {
		System.out.println("----ChildFun Start-----");
	}
}
