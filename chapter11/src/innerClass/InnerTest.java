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
			//num += 10;  // �ܺ� Ŭ������ �ν��Ͻ� ������ ��� �Ұ�
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
		
		// private���� �����Ǿ� ���� ���� �� OutClass ���ξ� �ִ� Inclass �� �����϶� ��� �ǹ̷�
		// �Ʒ�ó�� �ν��Ͻ� �� �� �ִ�.
	//	OutClass.Inclass inclass = outclass.new Inclass();
	///	inclass.inTest();
		
	//	OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
	//	sInClass.inTest();
		OutClass.InStaticClass.sTest();
	}

}
