package lambda;

interface PrintString{
	void showString(String str);
}

public class TestLambda {

	public static void main(String[] args) {
		
		PrintString reStr = returnString(); // 변수로 변환받기
		reStr.showString("hello ");        // 메서드 호출 
		
        PrintString lambdstr = s -> System.out.println(s);
        lambdstr.showString("hello lamda_1");
        showMyString(lambdstr);
	}

	public static void showMyString(PrintString p) {
		p.showString("hello lamda_2");
	}
	
	public static PrintString returnString() {
		return s -> System.out.println(s+" world");
	}
}
