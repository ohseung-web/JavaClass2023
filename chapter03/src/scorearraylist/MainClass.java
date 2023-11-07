package scorearraylist;

public class MainClass {

	public static void main(String[] args) {
		ScoreArrayList score = new ScoreArrayList();
		
		score.addScore(new ScoreVo("È«±æµ¿",90,90,85));
		score.addScore(new ScoreVo("°³³ª¸®",100,60,85));
		score.addScore(new ScoreVo("Áø´Þ·¡",70,100,75));
		score.addScore(new ScoreVo("±è¹éÇÕ",90,60,85));
		score.addScore(new ScoreVo("ÃÖÃ¶¼ö",99,87,85));
		score.addScore(new ScoreVo("±è¿µÈñ",76,80,92));
		
		System.out.println(score.toString());
	}

}
