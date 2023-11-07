package classPart04;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

class Ex04 {
	
	int[] hakbuns = {1001, 1002, 1003, 1004, 1005};
	int[] scores = new int[5];

}

public class ClassEx04 {

	public static void main(String[] args) {

		// ����1) scores�迭�� 1~100�� ������ ������ 5�� ����
		// �� 1) 87, 11, 92, 14, 47

		Ex04 ex04 = new Ex04();
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
	    Set<Integer> set = new HashSet<>();  // �ߺ���� �Ұ�
		int size = ex04.hakbuns.length;
	    
		for(int i=0; i<size; i++) {
		     ex04.scores[i] = ran.nextInt(100)+1;
		    set.add(ex04.scores[i]);
		}

		Object[] arr = set.toArray();
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		/*
		System.out.print("[");
		for(Integer num : set) {
			  System.out.print(num+ " ");
		}
		System.out.print("]");
		*/
		System.out.println();
		
	/*	
		����2) �������� ������ ��� ���
		�� 2) ����(251) ���(50.2)
		
		����3) ������ 60�� �̻��̸� �հ�. �հݻ� �� ���
		�� 3) 2��
		
		����4) �ε����� �Է¹޾� ���� ���
		����4) �ε��� �Է� : 1	���� : 11��
		
		����5) ������ �Է¹޾� �ε��� ���
		����5) ���� �Է� : 11		�ε��� : 1
		
		����6) �й��� �Է¹޾� ���� ���
		����6) �й� �Է� : 1003	���� : 45��
		
		����7) �й��� �Է¹޾� ���� ���
		          ��, �����й� �Է� �� ����ó��
		�� 7)
		�й� �Է� : 1002		���� : 11��
		�й� �Է� : 1000		�ش��й��� �������� �ʽ��ϴ�.
		
		����8) 1���л��� �й��� ���� ���
		����8) 1004��(98��)
	*/	

		int total = 0;
		double avg = 0.0;
		int cnt = 0;
		
		for(int i=0; i<size; i++) {
			total += ex04.scores[i];
			if(ex04.scores[i] >= 60) {
				cnt ++;
			}
		}
		System.out.println("��ü �� :"+ total);
		System.out.println("��ü ��� :" + total/size);
		System.out.println("60�� �̻� �л� �� :"+ cnt);
		System.out.println();
		System.out.print("�ε��� �Է� :");
		int index = scan.nextInt();
		System.out.println(arr[index]+"��");
		
		System.out.println();
		System.out.print("������ �Է� :");
		int sc = scan.nextInt();
		int scoreIndex = 0;
		for(int i=0; i<arr.length; i++) {
			if( (int)arr[i] == sc ) {
				scoreIndex = i;
			}
		}
		System.out.println("���� :"+ sc +", �ε��� :"+scoreIndex);
		
		System.out.println();
		System.out.print("�й��� �Է��ϼ��� :");
		int hak = scan.nextInt();
		int hakIndex =0;
		for(int i=0; i<arr.length; i++) {
			if(ex04.hakbuns[i] == hak) {
				hakIndex = i;
			}
		}
		System.out.println("�й� :"+ hak + ", ���� :"+ arr[hakIndex]);
		System.out.println();
		
		System.out.print("�й� �Է�");
		int hakbun = scan.nextInt();
		int chk = -1;
		for(int i=0; i<arr.length; i++) {
			if(ex04.hakbuns[i] == hakbun) {
				chk = i;
			}
		}
		if(chk == -1) {
			System.out.println("���� ���� �ʴ� �й� �Դϴ�.");
		}else {
			System.out.println("�й� :"+ hakbun + ", ���� :"+ arr[chk]);
		}
	   System.out.println();
	   int temp = 0;
	   int maxScore = 0;
	   for(int i=0; i<arr.length-1; i++) {
			   if(maxScore<(int)arr[i]) {
				   maxScore = (int)arr[i];
				   temp = i;
		   }
	   }
	   System.out.println("1�� �л��� �й��� ���� ���");
	   System.out.println(ex04.hakbuns[temp]+"("+maxScore+")");
		
	   int sum = 0;
	   for(int i=0;i<10; sum+=i, i++) {
		   System.out.println("sum"+sum);
	   }
	   //System.out.println("sum1"+sum);
	}

}
