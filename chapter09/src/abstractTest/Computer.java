package abstractTest;

public abstract class Computer {
     
	// �߻�(abstract) Ŭ������ �ۼ��ϴ� ���� : ��� �����ؾ� ���� ��ü�� ����� �� ��
	//                                                               �� ���� Ŭ�������� �˾Ƽ� �����ؾ� �� �� 
	// public void display(); // ������ ���ϰ� ���� �ϰڴٴ� �ǹ�, �����ڵ尡 ������ �߻�޼��尡 �ȴ�.
	// public void display(){ body} => body�� �����Ѵ�.  �����ڵ尡 ���� ������ �����ΰ� �ִ�,
	// ���� Ŭ������ ���� �˾Ƽ� �����ؾߵǴ� ���� �߻�(abstract)�޼���� �ۼ��Ѵ�.
	
	public abstract void display();
	public abstract  void typing();
	
	
	// ��� �������� �����ؾߵǴ� ���� �޼���� �ۼ��Ѵ�.
	public void turnOn() {
		System.out.println("������ �մϴ�.");
	}
	public void turnOff() {
		System.out.println("������ ���ϴ�.");
	}
}
