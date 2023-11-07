package interfaceTest;

public interface Calc {

	// 구현코드가 하나도 없다.
	// 클래스 생성시 힙에어리어에 메모리가 잡히는 것이 멤버변수이다.
	// 인터페이스에서 멤버 변수는 public static final인 상수로 지정된다.
	 public static final double PI = 3.14;
	 int ERROR = -999999999;
			 
	
	// interface 키워드 안에 작성이되면 무조건 abstract 메서드이다.
	// 컴파일될 때 public abstract 키워드가 들어 간다.

   public abstract	int add(int num1, int num2);
	int substract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	// 그러므로 인터페이스에는 상수와 추상메서드가 선언된다.
	// 인터페이스는 인스턴스화 할 수 없다.
	
	// 디폴트 메서드 : 기본 구현을 가지는 메서드로 , 구현코드에서 재정의 할 수 있음
	default void description() {
		System.out.println("점수 계산기를 구현 합니다.");
		myMethod();
	}
	// 정적 메서드 : 인스턴스 생성과 상관없이 인터페이스 타입으로 사용할 수 있음
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
	
	// private 메서드 : 인터페이스 내부에서만 사용 가능, 구현한 클래스에서 사용하거나 재정의 할 수 없음
	// private 메서드는 default 메서드에서 호출가능
	private void myMethod() {
		System.out.println("private 메서드 입니다.");
	}
	
	// private static 메서드는 static 메서드에서 호출가능
	private static void myStaticMethod() {
		System.out.println("myStaticMethod 메서드 입니다.");
	}
}
