package arrayEx01;
import java.util.*;
public class ArrayExample05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
		int[] scores  = {  87,   11,   45,   98,   23};
		
		System.out.println("�й��� �Է��ϼ��� :");
		int hak = scan.nextInt();
		int check = -1; //����ó���� ���� üũŰ
		for(int i=0;i<hakbuns.length;i++) {
			if(hakbuns[i]==hak) {
				check = i;
			}
		}
		if(check != -1) {
			System.out.println("���� :"+scores[check]+"��");
		}else {
			System.out.println("�ش��й��� �������� �ʽ��ϴ�.");
		}
	}

}
