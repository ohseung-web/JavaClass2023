package abstractTest;

public abstract class Computer {
     
	// 추상(abstract) 클래스를 작성하는 이유 : 어떻게 구현해야 할지 구체적 방법을 모를 때
	//                                                               각 하위 클래스에서 알아서 구현해야 할 때 
	// public void display(); // 구현은 안하고 선언만 하겠다는 의미, 구현코드가 없으면 추상메서드가 된다.
	// public void display(){ body} => body가 존재한다.  구현코드가 없을 뿐이지 구현부가 있다,
	// 하위 클래스가 각자 알아서 구현해야되는 경우는 추상(abstract)메서드로 작성한다.
	
	public abstract void display();
	public abstract  void typing();
	
	
	// 모두 동통으로 구현해야되는 경우는 메서드로 작성한다.
	public void turnOn() {
		System.out.println("전원을 켭니다.");
	}
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}
}
