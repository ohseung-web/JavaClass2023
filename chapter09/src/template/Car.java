package template;

public abstract class Car {

	// 차의 종류에 따라 달리거나 멈추는 기능이 다르기 때문에
	// 하위 클래스에서 구체적으로 구현해야 하므로 추상 메서드로 작성한다.
	public abstract void drive();
	public abstract void stop();
	
	public abstract void wiper();
	
	 //훅 메서드로 구현코드가 존재하진 않지만 하위 클래스에서 필요에 의해 구현하는 메서드를 일컫는다.
	public void washCar() {}
	
	public void startCar() {
		System.out.println("시동을 켭니다.");
	}
	public void turnOff() {
		System.out.println("시동을 끕니다.");
	}
	
	// 차가 시동을 켜서 멈추기까지의 시나리오 메서드(변하지 않는다.) 
	// 변하면 안되는 메서드는 final로 지정하여 재정의 하지 못 하도록 한다.
	// 이를 템플릿 메서드라 칭한다.
	// 템플릿 메서드 : 일련의 과정(=일련의 순서)을 시나리오로 정의 한 것이다.
	public final void run() {
		startCar();
		drive();
		wiper();
		stop();
		washCar(); // 
		turnOff();
	}
}
