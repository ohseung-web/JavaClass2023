package inheritance03;

public class BeerMain {

	public static void main(String[] args) {

		//ȣ�������, ����� ��ü ����
		Hoegaarden hoeg = new Hoegaarden("ȣ����","����" , 3);
		
		//BeerClass�� ���� ��ӹ��� �ʵ�
		System.out.println("Ÿ�� :"+hoeg.getType());
		System.out.println("���ݵ��� :"+hoeg.getABV());
		//Hoegaarden Ŭ������ ���� ��ӹ��� �ʵ�
		System.out.println("�� :"+hoeg.getFlavor());
		//Hoegaarden Ŭ���� �޼��� ȣ��
		hoeg.flavordrink();
	}

}
