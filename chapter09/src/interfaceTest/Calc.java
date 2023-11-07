package interfaceTest;

public interface Calc {

	// �����ڵ尡 �ϳ��� ����.
	// Ŭ���� ������ ������ �޸𸮰� ������ ���� ��������̴�.
	// �������̽����� ��� ������ public static final�� ����� �����ȴ�.
	 public static final double PI = 3.14;
	 int ERROR = -999999999;
			 
	
	// interface Ű���� �ȿ� �ۼ��̵Ǹ� ������ abstract �޼����̴�.
	// �����ϵ� �� public abstract Ű���尡 ��� ����.

   public abstract	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	// �׷��Ƿ� �������̽����� ����� �߻�޼��尡 ����ȴ�.
	// �������̽��� �ν��Ͻ�ȭ �� �� ����.
	
	// ����Ʈ �޼��� : �⺻ ������ ������ �޼���� , �����ڵ忡�� ������ �� �� ����
	default void description() {
		System.out.println("���� ���⸦ ���� �մϴ�.");
		myMethod();
	}
	// ���� �޼��� : �ν��Ͻ� ������ ������� �������̽� Ÿ������ ����� �� ����
	static int total(int[] arr) {
		int total = 0;
		for(int i=0;i<=arr.length;i++) {
			total += i;
		//	System.out.print(arr[i]+" ");
		//	System.out.print(i+" ");
		}
		//System.out.println();
		//myStaticMethod();
		//System.out.println(total);
		return total;
		
	}
	
	// private �޼��� : �������̽� ���ο����� ��� ����, ������ Ŭ�������� ����ϰų� ������ �� �� ����
	// private �޼���� default �޼��忡�� ȣ�Ⱑ��
	private void myMethod() {
		System.out.println("private �޼��� �Դϴ�.");
	}
	
	// private static �޼���� static �޼��忡�� ȣ�Ⱑ��
	private static void myStaticMethod() {
		System.out.println("myStaticMethod �޼��� �Դϴ�.");
	}
}
