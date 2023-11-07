package scorearraylist;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ScoreArrayList {

	ArrayList<ScoreVo> scorelist = new ArrayList<>();
	//Date date = new Date();
	Calendar today = Calendar.getInstance();
	int year = today.get(Calendar.YEAR);
	int month = today.get(Calendar.MONTH);
	int day = today.get(Calendar.DATE);
	int week = today.get(Calendar.DAY_OF_WEEK);
	
	SimpleDateFormat sd = new SimpleDateFormat("yyy년 MM월 dd일 E요일");


	@Override
	public String toString() {
		String str ="";
		//System.out.println(sd.format(date));
		System.out.println(year+"년 "+(month+1)+"월 "+day+"일 "+week+"요일");
		System.out.println("===========================================================");
		System.out.println("번호    이름     java     jsp     spring    총점     평균   석차");
		System.out.println("===========================================================");

		//석차계산 - 방식1
		
		/*
		 * for(int i=0 ; i<scorelist.size()-1 ; i++) { for(int j=i+1 ;
		 * j<scorelist.size() ; j++) { if(scorelist.get(i).getAvg() >
		 * scorelist.get(j).getAvg()) { // i번째 총점이 크면 j번째 석차를 증가시킨다.
		 * scorelist.get(j).setRank(scorelist.get(j).getRank() + 1);
		 * //System.out.println(scorelist.get(j).getRank()); }
		 * if(scorelist.get(i).getAvg() < scorelist.get(j).getAvg()) { // j번째 총점이 크면 i번째
		 * 석차를 증가시킨다. scorelist.get(i).setRank(scorelist.get(i).getRank() + 1);
		 * //System.out.println(scorelist.get(i).getRank()); } } }
		 */
		//---------------------------------------------------------------------------
		//석차계산 - 방식2
		
				for(int i=0 ; i<scorelist.size() ; i++) {
					for(int j=0 ; j<scorelist.size() ; j++) {
						if(scorelist.get(i).getAvg() < scorelist.get(j).getAvg()) {
//							j번째 평균이 크면 i번째 석차를 증가시킨다.
							scorelist.get(i).setRank(scorelist.get(i).getRank() + 1);
							//System.out.println(scorelist.get(j).getRank());
						}
					}
				}
		// 출력
		for(int i=0;i<scorelist.size();i++) {
			System.out.print(scorelist.get(i).getNo()+"\t");
			System.out.print(scorelist.get(i).getName()+"\t");
			System.out.print(scorelist.get(i).getJava()+"\t");
			System.out.print(scorelist.get(i).getJsp()+"\t");
			System.out.print(scorelist.get(i).getSpring()+"\t");
			System.out.print(scorelist.get(i).getTotal()+"\t");
			System.out.print(String.format("%.2f", scorelist.get(i).getAvg())+"\t");
			System.out.print(scorelist.get(i).getRank()+"\t");
			System.out.println();
		}

		return str;	
	}

	// ArrayList에 add 메서드 작성
	public void addScore(ScoreVo vo) {
		scorelist.add(vo);
	}

}
