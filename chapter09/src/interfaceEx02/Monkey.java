package interfaceEx02;

public class Monkey implements Animal{

	@Override
	public void eat(String bab) {
		System.out.println("�����̴� "+bab+"�� �Ծ��.");
	}

	@Override
	public void work(String move) {
		System.out.println("�����̴� "+move+"�ɾ��.");
	}

	@Override
	public void sleep(String zzz) {
		System.out.println("�����̴� "+zzz+"�ڿ�.");
	}

}
