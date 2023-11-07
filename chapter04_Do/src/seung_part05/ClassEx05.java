package seung_part05;

public class ClassEx05 {

	int[] answer = {1,2,3,4,5}; //시험문제 정답지
	int[] hgd = new int[5]; //시험문제 정답
	int cnt = 0; // 정답개수
	int score = 0; // 성적
	String ling =""; // ○를 담는 변수
	String ns =""; //X를 담는 변수
	
	//생성자
	public ClassEx05() {}
	
	public void answerInfo() { // 정답지, 정답, 정오표 출력메서드
		System.out.print("answer =");
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i]+" ");
		}
		System.out.println();
		System.out.print("hgd =");
		for(int num : hgd) {
			System.out.print(num+" ");
		}
		System.out.println();
		System.out.print("정오표 =");
		for(int i=0; i<answer.length; i++) {
			if(answer[i] == hgd[i]) {
				System.out.print(ling+" ");
			}else {
				System.out.print(ns+" ");
			}
		}System.out.println();
	}
	
	public void TotalScore() { // 성적 출력메서드
		System.out.println("성적 : "+ score + "점");
	}
	
	
}
