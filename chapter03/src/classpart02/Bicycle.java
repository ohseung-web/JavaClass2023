package classpart02;

public class Bicycle {
	//  �Ӽ� 
	String color;
	int price;

	//������ : ��, �������� �̸��� Ŭ������ �̸��� ���ƾ� �Ѵ�.
	public Bicycle() {
		System.out.println("Bicycle constructor - I");
	}

	public Bicycle(String c, int p) {
		System.out.println("Bicycle constructor - II");

		color = c;
		price = p;
	}

	//  ���
	public void info() {
		System.out.println("-- info --");
		System.out.println("color : " + color);
		System.out.println("price : " + price);
	}
}
