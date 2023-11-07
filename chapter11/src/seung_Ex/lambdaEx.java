package seung_Ex;

@FunctionalInterface //함수형 인터페이스
interface lambdaInterface1{
	public void method(String s1, String s2, String s3 );
}
interface lambdaInterface2{
	public void method(String s1);
}

interface lambdaInterface3{
	public void method();
}
interface lambdaInterface4{
	public void method(int x, int y);
}
interface lambdaInterface5{
	public int method(int x, int y);
}

@FunctionalInterface
interface MyNumber{
  public int getMaxNumber(int x, int y);
}

public class lambdaEx {

	public static void main(String[] args) {
		
		// 인스턴스화(=객체화)
		MyNumberEx mynum = new MyNumberEx();
		System.out.println(mynum.getMaxNumber(25, 5));
		
		// 원래 인터페이스는 인스턴스를 할수 없다. 그러나 인스턴스를 하면 익명클래스로 정의되어 진다.
		MyNumber mm = new MyNumber() {
			
			@Override
			public int getMaxNumber(int x, int y) {
				return x+y;
			}
		};
        System.out.println(mm.getMaxNumber(10, 20));
        
        //-----------------------------------------------------------------
		
		lambdaInterface1 lamface1= (s1,s2,s3)->{System.out.println(s1+" "+s2+" "+s3);};
		lamface1.method("java", "coding", "funny");
		
		//매개변수 1개일때는 괄호(), 중괄호{} 모두 생략 가능
		lambdaInterface2 lamface2 = s1 -> System.out.println(s1);
		lamface2.method("java World");
		
		//매개변수가 없을 때는 반드시 ( ) -> 괄호 입력한다.
		lambdaInterface3 lamface3 = () -> System.out.println("no parameter");
		lamface3.method();

		lambdaInterface4 lamface4 = (x,y) -> {System.out.println(x>=y?x:y);};
		lamface4.method(50, 60);
		
		// return 
		lambdaInterface5 lamface5 = (x,y) -> {
		  int result = x + y;
		  return result;
		};
		System.out.printf("lamface5.method(15, 25) : %d\n",lamface5.method(15, 25));
		
		lamface5 = (x,y)->{
			int result = x -y;
			return result;
		};
		System.out.printf("lamface5.method(15, 25) : %d\n",lamface5.method(15, 25));
		lamface5 = (x,y)->{
			int result = x*y;
			return result;
		};
		System.out.printf("lamface5.method(15, 25) : %d\n",lamface5.method(15, 25));
	}

}
