package interfaceEx01;

public class Refrigerator implements Buyable {

	String name="�����";
	String model;
	String denggub;
	int price;
	
	public Refrigerator(String model, String denggub, int price)
	{
		this.model = model;
		this.denggub = denggub;
		this.price = price;
	}
	@Override
	public int getPrice() {
		System.out.print("�ݾ� : ");
		return price;
	}

	@Override
	public String getModel() {
		System.out.print("�𵨸� : ");
		return model;
	}

	@Override
	public String getMaker() {
		System.out.print("ȿ���� ��� :");
		return denggub;
	}

	@Override
	public String getName() {
		
		return name;
	}

}
