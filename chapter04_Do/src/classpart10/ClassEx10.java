package classpart10;

import java.util.Scanner;

public class ClassEx10 {

	String name = "";
	int[] arHakbun = {1001, 1002, 1003, 1004, 1005};
	int[] arScore = { 92, 38, 87, 100, 11};
    int maxScore =0;
    int maxindex =0;
    int minindex =0;
    
	public ClassEx10() {}
	
	//�������� ���
	public void choice1() {
		for(int i=0; i<arHakbun.length; i++) {
			System.out.println((i+1)+"."+arHakbun[i]+"("+arScore[i]+"��)");
		}System.out.println();
		
	}
	
	// ����1�� ���� ���
	public void choice2() {
	   for(int i=0; i<arScore.length; i++) {
		   if(maxScore >= arScore[i]) {
			   maxScore = arScore[i];
			   maxindex = i;
		   }
	   }
	   System.out.println("1���л� : "+arHakbun[maxindex]+"�й�"+"("+arScore[maxindex]+"��)");
	}
	
	// �����õ� ���� ���
	public void choice3() {
		int minScore = arScore[0];
		for(int i=0; i<arScore.length; i++) {
			if( minScore > arScore[i] ) {
				minScore = arScore[i];
				minindex = i;
			}
		}System.out.println("�õ��л� : "+arHakbun[minindex]+"�й�"+"("+arScore[minindex]+"��)");
	}
	
	// �й��Է� �޾� ���� ���
	public void choice4() {
	    Scanner scan = new Scanner(System.in);
	    int chk = -1;
	    System.out.print("�й��� �Է��ϼ��� ? ");
	    int hakbun = scan.nextInt();
	    
	    for(int i=0; i<arHakbun.length; i++) {
	    	if(arHakbun[i]==hakbun) {
	    		chk = i;
	    	}
	    }
	    
	    if(chk == -1) {
	    	System.out.println("�ش� �й��� �������� �ʽ��ϴ�.");
	    }else {
	    	System.out.println(arScore[chk]);
	    }
	}
	
	//����
	public void run() {
		Scanner scan = new Scanner(System.in);
		boolean runChek = true;
		while(runChek) {
			System.out.println("==== "+name+" ====");
			System.out.println("1.������ ����Ȯ��");
			System.out.println("2.1���л� ����Ȯ��");
			System.out.println("3.�õ��л� ����Ȯ��");
			System.out.println("4.(�й��Է¹޾�) ����Ȯ��");
			System.out.println("5.����");
			System.out.print("�޴����� :");
			int select = scan.nextInt();
			
			if(select == 1) { choice1();}
			else if(select == 2) { choice2();}
			else if(select == 3) { choice3();}
			else if(select == 4) { choice4();}
			else {
				System.out.println("����");
				runChek = false;
				break;
			}
			
		}
	}
}
