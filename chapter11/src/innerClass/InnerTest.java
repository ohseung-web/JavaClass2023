package innerClass;

class OutClass{
	
	private int num = 10;
	private static int sNum = 20;
	 private Inclass inclass;
	
	public OutClass(){
		inclass = new Inclass();
	}
	
	private class Inclass{
	     int inNum = 200;
	     //static int sInNum = 100;
	     
	     void inTest() {
	    	 System.out.println(num);
	    	 System.out.println(sNum);
	     }
	}
	
	public void ustinInTest() {
		inclass.inTest();
	}
	
	static class InStaticClass{
		int iNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			//num += 10;  // 외부 클래스에 인스턴스 변수는 사용 불가
			sNum += 10;
			System.out.println(sNum);
			System.out.println(iNum);
			System.out.println(sInNum);
		}
		
		static void sTest() {
			System.out.println(sNum);
			System.out.println(sInNum);
		}
	}
	
}


public class InnerTest {

	public static void main(String[] args) {
      
		OutClass outclass = new OutClass();
		outclass.ustinInTest();
		
		// private으로 지정되어 있지 않을 때 OutClass 내부애 있는 Inclass 를 생성하라 라는 의미로
		// 아래처럼 인스턴스 할 수 있다.
	//	OutClass.Inclass inclass = outclass.new Inclass();
	///	inclass.inTest();
		
	//	OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
	//	sInClass.inTest();
		OutClass.InStaticClass.sTest();
	}

}
