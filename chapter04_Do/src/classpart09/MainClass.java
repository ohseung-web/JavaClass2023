package classpart09;

public class MainClass {

	public static void main(String[] args) {

		ClassEx9 ce9 = new ClassEx9();
		int[] arr = new int[5];
		
		System.out.print("�л�����=");
		ce9.test(arr);
		System.out.println();
		
		int tot = ce9.total(arr);
		System.out.print("�л�����="+tot);
		System.out.println();

		double avg = ce9.avgInfo(arr);
		System.out.print("�л���ü���="+avg);
		System.out.println();
		
		int first = ce9.firstPlace(arr);
		System.out.print("1�� ���� = "+first);
		System.out.println();
		
		int last = ce9.lastPlace(arr);
		System.out.print("�õ� ���� = "+last);
	}

}
