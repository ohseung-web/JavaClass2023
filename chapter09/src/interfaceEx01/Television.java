package interfaceEx01;

public class Television  implements Buyable{

	//�������
	String name="�ڷ�����";
	String model;
	String maker;
	int price;
	
	//������
	public Television(String model, String maker, int price)
	{
		this.model = model;
		this.maker = maker;
		this.price = price;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getPrice() {
		System.out.print("�ݾ� :");
		return price;
	}

	@Override
	public String getModel() {
		System.out.print("�𵨸� : ");
		return model;
	}

	@Override
	public String getMaker() {
		System.out.print("����Ŀ :");
		return maker;
	}

}
