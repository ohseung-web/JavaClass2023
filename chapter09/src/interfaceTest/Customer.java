package interfaceTest;

public class Customer implements Buy, Sell {

	@Override
	public void sell() {
     System.out.println("�Ǹ��ϱ�");		
	}

	@Override
	public void buy() {
		System.out.println("�����ϱ�");		
	}

	// ���� �̸��� default �޼���� ������ �Ͽ� ����Ѵ�.
	@Override
	public void order() {
		System.out.println("���� �Ǹ� �ֹ�");
	}

}
