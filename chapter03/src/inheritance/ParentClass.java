package inheritance;

public class ParentClass {

	protected int a =10;
	protected int b = 20;
			
	
	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
//»ý¼ºÀÚ
	public ParentClass() {}
	public ParentClass(int a, int b) {
		this.a = a;
		System.out.println("------ParentClass constructor-----");
	}

	public void ParentFun() {
		System.out.println("------ParentFun constructor------");
	}
}
