package innerClass02;

public class OuterClass {

	//��� ����
	int num = 10;
	String str1 = "java";
	static String str11 ="world";

	//������
	public OuterClass() {
		System.out.println("OuterClass constructor");
	}

	//inner Ŭ����
	class InnerClass{
		int num = 100;
		String str2 = str1;
         
		public InnerClass() {
			System.out.println("InnerClass constructor");
		}
	}

	// static Ŭ����		
	static class sInnerClass{
		int num =1000;
		String str3 = str11;

		public sInnerClass() {
			System.out.println("static InnerClass constructor");
		}
	}
}
