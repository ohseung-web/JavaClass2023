package inheritance03;

public class BeerMain {

	public static void main(String[] args) {

		//호가든맥주, 레몬맛 객체 생성
		Hoegaarden hoeg = new Hoegaarden("호가든","레몬" , 3);
		
		//BeerClass로 부터 상속받은 필드
		System.out.println("타입 :"+hoeg.getType());
		System.out.println("알콜도수 :"+hoeg.getABV());
		//Hoegaarden 클래스로 부터 상속받은 필드
		System.out.println("맛 :"+hoeg.getFlavor());
		//Hoegaarden 클래스 메서드 호출
		hoeg.flavordrink();
	}

}
