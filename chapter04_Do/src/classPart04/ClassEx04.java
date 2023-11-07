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

		// 문제1) scores배열에 1~100점 사이의 정수를 5개 저장
		// 예 1) 87, 11, 92, 14, 47

		Ex04 ex04 = new Ex04();
		Random ran = new Random();
		Scanner scan = new Scanner(System.in);
	    Set<Integer> set = new HashSet<>();  // 중복출력 불가
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
		문제2) 전교생의 총점과 평균 출력
		예 2) 총점(251) 평균(50.2)
		
		문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		예 3) 2명
		
		문제4) 인덱스를 입력받아 성적 출력
		정답4) 인덱스 입력 : 1	성적 : 11점
		
		문제5) 성적을 입력받아 인덱스 출력
		정답5) 성적 입력 : 11		인덱스 : 1
		
		문제6) 학번을 입력받아 성적 출력
		정답6) 학번 입력 : 1003	성적 : 45점
		
		문제7) 학번을 입력받아 성적 출력
		          단, 없는학번 입력 시 예외처리
		예 7)
		학번 입력 : 1002		성적 : 11점
		학번 입력 : 1000		해당학번은 존재하지 않습니다.
		
		문제8) 1등학생의 학번과 성적 출력
		정답8) 1004번(98점)
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
		System.out.println("전체 합 :"+ total);
		System.out.println("전체 평균 :" + total/size);
		System.out.println("60점 이상 학생 수 :"+ cnt);
		System.out.println();
		System.out.print("인덱스 입력 :");
		int index = scan.nextInt();
		System.out.println(arr[index]+"점");
		
		System.out.println();
		System.out.print("성적을 입력 :");
		int sc = scan.nextInt();
		int scoreIndex = 0;
		for(int i=0; i<arr.length; i++) {
			if( (int)arr[i] == sc ) {
				scoreIndex = i;
			}
		}
		System.out.println("성적 :"+ sc +", 인덱스 :"+scoreIndex);
		
		System.out.println();
		System.out.print("학번을 입력하세요 :");
		int hak = scan.nextInt();
		int hakIndex =0;
		for(int i=0; i<arr.length; i++) {
			if(ex04.hakbuns[i] == hak) {
				hakIndex = i;
			}
		}
		System.out.println("학번 :"+ hak + ", 성적 :"+ arr[hakIndex]);
		System.out.println();
		
		System.out.print("학번 입력");
		int hakbun = scan.nextInt();
		int chk = -1;
		for(int i=0; i<arr.length; i++) {
			if(ex04.hakbuns[i] == hakbun) {
				chk = i;
			}
		}
		if(chk == -1) {
			System.out.println("존재 하지 않는 학번 입니다.");
		}else {
			System.out.println("학번 :"+ hakbun + ", 성적 :"+ arr[chk]);
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
	   System.out.println("1등 학생의 학번과 성적 출력");
	   System.out.println(ex04.hakbuns[temp]+"("+maxScore+")");
		
	   int sum = 0;
	   for(int i=0;i<10; sum+=i, i++) {
		   System.out.println("sum"+sum);
	   }
	   //System.out.println("sum1"+sum);
	}

}
