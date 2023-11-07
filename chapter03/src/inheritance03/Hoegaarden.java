package inheritance03;

public class Hoegaarden extends BeerClass {

	String flavor; // 맛
	int ABV=0; //도수
	
	//생성자
	public Hoegaarden(String model, String flavor) {
		super("밀맥주",model);
		this.model = model;
		this.flavor = flavor;
	}
	
	// 생성자오버로딩(AVB)
	public Hoegaarden(String model, String flavor, int ABV) {
		super("밀맥주",model);
		this.model = model;
		this.flavor = flavor;
		this.ABV = ABV;
	}
	
	//메서드 
	public void flavordrink() {
		System.out.println(model + "맥주의 "+ flavor + "맛을 마십니다.");
	}

	public String getFlavor() {
		return flavor;
	}

	public int getABV() {
		return ABV;
	}
}
