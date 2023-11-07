package interfaceTest;

public class CaclculatorTest {

	public static void main(String[] args) {

		int num1 = 10;
		int num2 = 2;
		
		Calc calc = new CompleteCalc(); 
		/* 아래 처럼 인스턴스하는 것도 가능하다.
		Calculator calc2 = new CompleteCalc();
		CompleteCalc calc3 = new CompleteCalc();
		*/
		// Calc calc1 = new Calc(); 인터페이스는 인스턴스 할 수 없다. 
		
		//System.out.println(calc.add(num1, num2));
		calc.description();
		
		int[] arr = {1,2,3,4,5};
		// 인스턴스 생성과 상관 없이 인터페이스 타입으로 사용한다.
		//int sum = Calc.total(arr);
	    System.out.println(Calc.total(arr));
		
	}

}
