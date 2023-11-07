package lambdaEx;

import java.util.Arrays;

import lambda.Cal;
import lambda.SeungInterface;

interface Print{
	void show(String name, int score);
}
interface Print02{
	int show(int x);
}
interface Print03{
	public int show();
}

public class LambdaEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// �ν��Ͻ�ȭ �ϴ� ���
		LambdaEx01 lamex = new LambdaEx01();
		System.out.println(lamex.max(15, 45));
		lamex.printVar("ȫ�浿", 95);
		System.out.println(lamex.square(5));
		System.out.println(lamex.roll());
		System.out.println();

		
		// ���ٽ� �̿��ϴ� ���
		Lam02ex lam = (a,b) -> a>b?a:b;
		System.out.println(lam.getNum(15, 35));

		Print pr = printshow();
		pr.show("������", 90);

		Print02 pr02 = x -> x*x;
		System.out.println(pr02.show(6));
		
		
		int arr[] = new int[5];
		Arrays.setAll(arr, (i) -> (int)(Math.random()*5)+1);
		for(int n : arr) {
			System.out.print(n+" ");
		}
		System.out.println();
		
						
		Print03 pr03 = () -> (int)(Math.random()*6);
        System.out.println(pr03.show());
      
		
		// ���ٽ��� �Ϲ� Ŭ������ �ۼ��ؼ� Main����ϴ� ���
		Cal cal = new Cal();
		SeungInterface se = cal.Show();
		se.getCal(15,28);
		
			
		

	}	

	public static Print printshow() {
		return (String name, int i) -> System.out.println(name+"="+i);  	
	}


}
