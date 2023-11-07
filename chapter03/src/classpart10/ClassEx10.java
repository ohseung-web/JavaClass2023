package classpart10;
import java.util.*;
public class ClassEx10 {
	//	맴버변수 -------------------------------
	Scanner scan = new Scanner(System.in);
	String name = "";

	int[] arHakbun = {1001, 1002, 1003, 1004, 1005};
	int[] arScore  = {  92,   38,   87,  100,   11};
	// 메서드(=함수) -- 전교성적 출력 함수
	public void choice1() {
		for(int i=0; i<arHakbun.length; i++) {
			System.out.println((i+1) + "." + arHakbun[i] + "학번(" + arScore[i] + "점)");
		}
	}
	//  ------- 전교1등 성적 출력 함수 ---------------------
	public void choice2() {
		int maxScore = 0;
		int maxIdx = 0;
		for(int i=0; i<arScore.length; i++) {
			if(maxScore < arScore[i]) {
				maxScore = arScore[i];
				maxIdx = i;
			}
		}
		System.out.println("1등 학생 = " + arHakbun[maxIdx] + "학번(" + arScore[maxIdx] + "점)");		
	}

	//	-------------- 전교 꼴동 성적 출력 함수 ----------------------
	public void choice3() {
		int minScore = arScore[0];
		int minIdx = 0;
		for(int i=0; i<arScore.length; i++) {
			if(minScore > arScore[i]) {
				minScore = arScore[i];
				minIdx = i;
			}
		}
		System.out.println("꼴등 학생 = " + arHakbun[minIdx] + "학번(" + arScore[minIdx] + "점)");
	}

	//	--------------------- 학번 입력 받아 성적 출력 함수 -------------
	//	단, 존재 하지 않는 학번 예외처리 할 것
	public void choice4() {

		System.out.print("학번을 입력하세요 : ");
		int hakbun = scan.nextInt();

		int idx = -1;
		for(int i=0; i<arHakbun.length; i++) {
			if(arHakbun[i] == hakbun) {
				idx = i;
			}
		}

		if(idx == -1) {
			System.out.println("해당 학번은 존재하지 않습니다.");
		}else {
			System.out.println(arScore[idx]);
		}
	}
	//	메뉴와  위의 함수 모두 출력하는 함수 ---------------------------------------
	public void run() {
		while(true) {
			// 메뉴 출력
			System.out.println("=== 메가IT 고등학교 ===");
			System.out.println("1.전교생 성적확인");
			System.out.println("2.1등학생 성적확인");
			System.out.println("3.꼴등학생 성적확인");
			System.out.println("4.(학번을 입력받아)성적확인하기");
			System.out.println("5.종료하기");

			// 메뉴 선택
			System.out.print("메뉴 선택 : ");
			int select = scan.nextInt();

			if(select == 1) { choice1(); }
			else if(select == 2) { choice2(); }
			else if(select == 3) { choice3(); }
			else if(select == 4) { choice4(); }
			else if(select == 5) {
				System.out.println("프로그램 종료");
				break;
			}
		}

	}
}
