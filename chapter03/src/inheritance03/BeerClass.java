package inheritance03;

public class BeerClass {
String type;
String model;


//������
public BeerClass() {}
public BeerClass(String type, String model) {
	this.type = type;
	this.model = model;
}

//�޼ҵ�
public void drink() {
	System.out.println("���ʴϴ�.!!");
}
public void mix() {
	System.out.println("�����ϴ�.!!");
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

}
