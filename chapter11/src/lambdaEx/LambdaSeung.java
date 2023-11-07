package lambdaEx;

@FunctionalInterface
interface LambdaInterface1 {
	public void method(String s1, String s2, String s3);
}

@FunctionalInterface
interface LambdaInterface2 {
	public void method(String s1);
}

@FunctionalInterface
interface LambdaInterface3 {
	public void method();
}

@FunctionalInterface
interface LambdaInterface4 {
	public int method(int x, int y);
}

@FunctionalInterface
interface LambdaInterface5 {
	public int method();
}

public class LambdaSeung {

	public static void main(String[] args) {

		LambdaInterface5 li5 = ()->(int)(Math.random()*6);
		System.out.println(li5.method());

		// �Ű������� ���๮������ �ۼ��Ѵ�.(������, ��ȯ��, return Ű���� ����)
		LambdaInterface1 li1 = (String s1, String s2, String s3) 
		-> { System.out.println(s1 + " " + s2 + " " + s3); };
		li1.method("Hello", "java", "World");

		// �Ű������� 1���̰ų� Ÿ���� ���� ��, Ÿ���� ������ �� �ִ�.
		LambdaInterface2 li2 = (s1) -> { System.out.println(s1); };
		li2.method("Hello");

		// ���๮�� 1���� ��, '{}'�� ������ �� �ִ�.
		LambdaInterface2 li3 = (s1) -> System.out.println(s1);
		li3.method("Hello");

		// �Ű������� ���๮�� 1���� ��, '()'�� '{}'�� ������ �� �ִ�.
		LambdaInterface2 li4 = s1 -> System.out.println(s1);
		li4.method("Hello");

		// �Ű������� ������, '()'�� �ۼ��Ѵ�.		
		LambdaInterface3 li7 = () -> System.out.println("no parameter");
		li7.method();

		// ��ȯ���� �ִ� ���
		LambdaInterface4 li6 = (x, y) -> {
			int result = x + y;
			return result;
		};
		System.out.printf("li6.method(10, 20) : %d\n", li6.method(10, 20));

		li6 = (x, y) -> {
			int result = x * y;
			return result;
		};
		System.out.printf("li6.method(10, 20) : %d\n", li6.method(10, 20));

		li6 = (x, y) -> {
     		int result = x - y;
			return result;
		};
		System.out.printf("li6.method(10, 20) : %d\n", li6.method(10, 20));
		
	}

}
