package array;
import java.util.*;
public class ArrayExample6 {

	public static void main(String[] args) {
		Scanner scan  = new Scanner(System.in);

		int [] score = new int[5];
		String [] name = {"ȫ�浿","������","���޷�","�����","�ֵ���"};
		int avg =0;
		int cnt = 0;
		int total =0;

		for(int i=0;i<5;i++) {
			System.out.printf("%s�� ������ �Է��ϼ���", name[i]);
			score[i]=scan.nextInt();
			total =total + score[i];
			cnt = cnt + 1;
		}
		for(int j=0;j<5;j++) {
			System.out.printf("%s�� ���� :  %d",name[j],score[j]);
			System.out.println();
		}

		avg = total / cnt;
		System.out.println("---------------------------\n ���� : \t"+ avg);
		scan.close();
	}
}
