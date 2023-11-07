package innerClass02;

public class OuterClass {

	//멤버 변수
	int num = 10;
	String str1 = "java";
	static String str11 ="world";

	//생성자
	public OuterClass() {
		System.out.println("OuterClass constructor");
	}

	//inner 클래스
	class InnerClass{
		int num = 100;
		String str2 = str1;
         
		public InnerClass() {
			System.out.println("InnerClass constructor");
		}
	}

	// static 클래스		
	static class sInnerClass{
		int num =1000;
		String str3 = str11;

		public sInnerClass() {
			System.out.println("static InnerClass constructor");
		}
	}
}
