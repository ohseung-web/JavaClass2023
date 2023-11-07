package inheritance03;

public class BeerClass {
String type;
String model;


//생성자
public BeerClass() {}
public BeerClass(String type, String model) {
	this.type = type;
	this.model = model;
}

//메소드
public void drink() {
	System.out.println("마십니다.!!");
}
public void mix() {
	System.out.println("섞습니다.!!");
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
