package interfaceTest;

public class CaclculatorTest {

	public static void main(String[] args) {

		int num1 = 10;
		int num2 = 2;
		
		Calc calc = new CompleteCalc(); 
		/* �Ʒ� ó�� �ν��Ͻ��ϴ� �͵� �����ϴ�.
		Calculator calc2 = new CompleteCalc();
		CompleteCalc calc3 = new CompleteCalc();
		*/
		// Calc calc1 = new Calc(); �������̽��� �ν��Ͻ� �� �� ����. 
		
		//System.out.println(calc.add(num1, num2));
		calc.description();
		
		int[] arr = {1,2,3,4,5};
		// �ν��Ͻ� ������ ��� ���� �������̽� Ÿ������ ����Ѵ�.
		//int sum = Calc.total(arr);
	    System.out.println(Calc.total(arr));
		
	}

}
