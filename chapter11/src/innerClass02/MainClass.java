package innerClass02;

public class MainClass {

	public static void main(String[] args) {
         
		OuterClass outerclass = new OuterClass();
		System.out.println("outerclass.num : "+ outerclass.num);
		System.out.println("outerclass.str1 : "+ outerclass.str1);
		System.out.println();
		
	
		// 멤버 inner 클래스
		OuterClass.InnerClass in = outerclass.new InnerClass();
		System.out.println("in.num : "+ in.num);
		System.out.println("in.str2 : "+ in.str2);
		System.out.println();
	
		
		// static inner 클래스
		OuterClass.sInnerClass  sin = new OuterClass.sInnerClass();
		System.out.println("sin.num : "+ sin.num);
		System.out.println("sin.str3 : "+ sin.str3);
		System.out.println();
		
	}

}
