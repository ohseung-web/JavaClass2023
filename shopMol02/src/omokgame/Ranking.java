package omokgame;

public class Ranking extends tang {
	
	public void ranking() {
		for(int i = 0;i<ranking.length;i++) {
			ranking [i] = 1;
		}
		for(int i = 0;i<ranking.length;i++) {
			for(int j = 0;j<ranking.length;j++) {
				if(score[i]>score[j]) {
					ranking [j]  = ranking [j]+1; 
				}
			}
		}
		
		System.out.println("�ءءءءءءءءءءءءءءءء�");
		System.out.println("��ŷǥ");
		System.out.println("�ءءءءءءءءءءءءءءءء�");
		
		System.out.println("ID         ����        ���");
		
		for(int i = 0;i<score.length;i++) {
			if(score[i]>0) {
				System.out.println(list.get(i).getID()+"��          "+ score[i]+"��       " +ranking[i]+"��");
			}
	
		}
		System.out.println("=========================");
	}

}
