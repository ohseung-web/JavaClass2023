package seung_Ex;

@FunctionalInterface //�Լ��� �������̽�
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
		
		// �ν��Ͻ�ȭ(=��üȭ)
		MyNumberEx mynum = new MyNumberEx();
		System.out.println(mynum.getMaxNumber(25, 5));
		
		// ���� �������̽��� �ν��Ͻ��� �Ҽ� ����. �׷��� �ν��Ͻ��� �ϸ� �͸�Ŭ������ ���ǵǾ� ����.
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
		
		//�Ű����� 1���϶��� ��ȣ(), �߰�ȣ{} ��� ���� ����
		lambdaInterface2 lamface2 = s1 -> System.out.println(s1);
		lamface2.method("java World");
		
		//�Ű������� ���� ���� �ݵ�� ( ) -> ��ȣ �Է��Ѵ�.
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
