package scorearraylist;

public class MainClass {

	public static void main(String[] args) {
		ScoreArrayList score = new ScoreArrayList();
		
		score.addScore(new ScoreVo("ȫ�浿",90,90,85));
		score.addScore(new ScoreVo("������",100,60,85));
		score.addScore(new ScoreVo("���޷�",70,100,75));
		score.addScore(new ScoreVo("�����",90,60,85));
		score.addScore(new ScoreVo("��ö��",99,87,85));
		score.addScore(new ScoreVo("�迵��",76,80,92));
		
		System.out.println(score.toString());
	}

}
