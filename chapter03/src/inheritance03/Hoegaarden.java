package inheritance03;

public class Hoegaarden extends BeerClass {

	String flavor; // ��
	int ABV=0; //����
	
	//������
	public Hoegaarden(String model, String flavor) {
		super("�и���",model);
		this.model = model;
		this.flavor = flavor;
	}
	
	// �����ڿ����ε�(AVB)
	public Hoegaarden(String model, String flavor, int ABV) {
		super("�и���",model);
		this.model = model;
		this.flavor = flavor;
		this.ABV = ABV;
	}
	
	//�޼��� 
	public void flavordrink() {
		System.out.println(model + "������ "+ flavor + "���� ���ʴϴ�.");
	}

	public String getFlavor() {
		return flavor;
	}

	public int getABV() {
		return ABV;
	}
}
