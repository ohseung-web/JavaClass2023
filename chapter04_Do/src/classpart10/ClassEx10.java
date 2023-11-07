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
	
	//전교성적 출력
	public void choice1() {
		for(int i=0; i<arHakbun.length; i++) {
			System.out.println((i+1)+"."+arHakbun[i]+"("+arScore[i]+"점)");
		}System.out.println();
		
	}
	
	// 전교1등 성적 출력
	public void choice2() {
	   for(int i=0; i<arScore.length; i++) {
		   if(maxScore >= arScore[i]) {
			   maxScore = arScore[i];
			   maxindex = i;
		   }
	   }
	   System.out.println("1등학생 : "+arHakbun[maxindex]+"학번"+"("+arScore[maxindex]+"점)");
	}
	
	// 전교꼴등 성적 출력
	public void choice3() {
		int minScore = arScore[0];
		for(int i=0; i<arScore.length; i++) {
			if( minScore > arScore[i] ) {
				minScore = arScore[i];
				minindex = i;
			}
		}System.out.println("꼴등학생 : "+arHakbun[minindex]+"학번"+"("+arScore[minindex]+"점)");
	}
	
	// 학번입력 받아 성적 출력
	public void choice4() {
	    Scanner scan = new Scanner(System.in);
	    int chk = -1;
	    System.out.print("학번을 입력하세요 ? ");
	    int hakbun = scan.nextInt();
	    
	    for(int i=0; i<arHakbun.length; i++) {
	    	if(arHakbun[i]==hakbun) {
	    		chk = i;
	    	}
	    }
	    
	    if(chk == -1) {
	    	System.out.println("해당 학번은 존재하지 않습니다.");
	    }else {
	    	System.out.println(arScore[chk]);
	    }
	}
	
	//실행
	public void run() {
		Scanner scan = new Scanner(System.in);
		boolean runChek = true;
		while(runChek) {
			System.out.println("==== "+name+" ====");
			System.out.println("1.전교생 성적확인");
			System.out.println("2.1등학생 성적확인");
			System.out.println("3.꼴등학생 성적확인");
			System.out.println("4.(학번입력받아) 성적확인");
			System.out.println("5.종료");
			System.out.print("메뉴선택 :");
			int select = scan.nextInt();
			
			if(select == 1) { choice1();}
			else if(select == 2) { choice2();}
			else if(select == 3) { choice3();}
			else if(select == 4) { choice4();}
			else {
				System.out.println("종료");
				runChek = false;
				break;
			}
			
		}
	}
}
