package arraylist02;
import java.util.*;

public class Tv {
	private String name;
	private String brand;
	private int price;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Tv() {}
	public Tv(String name, String brand, int price) {
		this.name = name;
		this.brand = brand;
		this.price = price;
	}
	
	public void tvinfo() {
		System.out.println("제품이름 :"+name);
		System.out.println("제조사 :"+brand);
		System.out.println("금 액 :"+price);
	}
}
