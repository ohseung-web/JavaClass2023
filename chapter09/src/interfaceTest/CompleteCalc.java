package interfaceTest;

public class CompleteCalc extends Calculator {

	// extends는 구현상속이라고 한다.
	@Override
	public int times(int num1, int num2) {
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {
		if(num2 != 0) {
			return num1 / num2;
		}
		return ERROR;
	}

	public void showInfo() {
		System.out.println("Calc 인터페이스를 구현하겠습니다.");
	}

	@Override
	public void description() {
		System.out.println("완벽한 계산기입니다.");
	}
	
	
}
