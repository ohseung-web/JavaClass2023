package lambda;

@FunctionalInterface //컴파일 오류를 막기위해 에터테이션 입력
public interface MyNumber {

	//함수형 인터페이스인 경우 메서드는 딱 하나만 선언한다. 
	int getMaxNumber(int num1, int num2);
}
