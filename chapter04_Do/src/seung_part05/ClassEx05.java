package seung_part05;

public class ClassEx05 {

	int[] answer = {1,2,3,4,5}; //���蹮�� ������
	int[] hgd = new int[5]; //���蹮�� ����
	int cnt = 0; // ���䰳��
	int score = 0; // ����
	String ling =""; // �۸� ��� ����
	String ns =""; //X�� ��� ����
	
	//������
	public ClassEx05() {}
	
	public void answerInfo() { // ������, ����, ����ǥ ��¸޼���
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
		System.out.print("����ǥ =");
		for(int i=0; i<answer.length; i++) {
			if(answer[i] == hgd[i]) {
				System.out.print(ling+" ");
			}else {
				System.out.print(ns+" ");
			}
		}System.out.println();
	}
	
	public void TotalScore() { // ���� ��¸޼���
		System.out.println("���� : "+ score + "��");
	}
	
	
}
