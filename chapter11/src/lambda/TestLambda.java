package lambda;

interface PrintString{
	void showString(String str);
}

public class TestLambda {

	public static void main(String[] args) {
		
		PrintString reStr = returnString(); // ������ ��ȯ�ޱ�
		reStr.showString("hello ");        // �޼��� ȣ�� 
		
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
