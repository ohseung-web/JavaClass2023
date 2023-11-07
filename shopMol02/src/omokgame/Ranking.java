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
		
		System.out.println("『『『『『『『『『『『『『『『『『");
		System.out.println("粂天妊");
		System.out.println("『『『『『『『『『『『『『『『『『");
		
		System.out.println("ID         繊呪        去呪");
		
		for(int i = 0;i<score.length;i++) {
			if(score[i]>0) {
				System.out.println(list.get(i).getID()+"還          "+ score[i]+"繊       " +ranking[i]+"去");
			}
	
		}
		System.out.println("=========================");
	}

}
