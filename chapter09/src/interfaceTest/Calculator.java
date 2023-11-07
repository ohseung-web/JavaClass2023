package interfaceTest;

public  abstract class Calculator implements Calc {

	// implements 는 인터페이스 타입을 상속했다. 라고 표현한다.
	
	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int substract(int num1, int num2) {
		return num1 - num2;
	}

	
}
