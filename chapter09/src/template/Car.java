package template;

public abstract class Car {

	// ���� ������ ���� �޸��ų� ���ߴ� ����� �ٸ��� ������
	// ���� Ŭ�������� ��ü������ �����ؾ� �ϹǷ� �߻� �޼���� �ۼ��Ѵ�.
	public abstract void drive();
	public abstract void stop();
	
	public abstract void wiper();
	
	 //�� �޼���� �����ڵ尡 �������� ������ ���� Ŭ�������� �ʿ信 ���� �����ϴ� �޼��带 ���´´�.
	public void washCar() {}
	
	public void startCar() {
		System.out.println("�õ��� �մϴ�.");
	}
	public void turnOff() {
		System.out.println("�õ��� ���ϴ�.");
	}
	
	// ���� �õ��� �Ѽ� ���߱������ �ó����� �޼���(������ �ʴ´�.) 
	// ���ϸ� �ȵǴ� �޼���� final�� �����Ͽ� ������ ���� �� �ϵ��� �Ѵ�.
	// �̸� ���ø� �޼���� Ī�Ѵ�.
	// ���ø� �޼��� : �Ϸ��� ����(=�Ϸ��� ����)�� �ó������� ���� �� ���̴�.
	public final void run() {
		startCar();
		drive();
		wiper();
		stop();
		washCar(); // 
		turnOff();
	}
}
