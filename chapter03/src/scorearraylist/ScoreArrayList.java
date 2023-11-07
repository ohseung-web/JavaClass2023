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
	
	SimpleDateFormat sd = new SimpleDateFormat("yyy�� MM�� dd�� E����");


	@Override
	public String toString() {
		String str ="";
		//System.out.println(sd.format(date));
		System.out.println(year+"�� "+(month+1)+"�� "+day+"�� "+week+"����");
		System.out.println("===========================================================");
		System.out.println("��ȣ    �̸�     java     jsp     spring    ����     ���   ����");
		System.out.println("===========================================================");

		//������� - ���1
		
		/*
		 * for(int i=0 ; i<scorelist.size()-1 ; i++) { for(int j=i+1 ;
		 * j<scorelist.size() ; j++) { if(scorelist.get(i).getAvg() >
		 * scorelist.get(j).getAvg()) { // i��° ������ ũ�� j��° ������ ������Ų��.
		 * scorelist.get(j).setRank(scorelist.get(j).getRank() + 1);
		 * //System.out.println(scorelist.get(j).getRank()); }
		 * if(scorelist.get(i).getAvg() < scorelist.get(j).getAvg()) { // j��° ������ ũ�� i��°
		 * ������ ������Ų��. scorelist.get(i).setRank(scorelist.get(i).getRank() + 1);
		 * //System.out.println(scorelist.get(i).getRank()); } } }
		 */
		//---------------------------------------------------------------------------
		//������� - ���2
		
				for(int i=0 ; i<scorelist.size() ; i++) {
					for(int j=0 ; j<scorelist.size() ; j++) {
						if(scorelist.get(i).getAvg() < scorelist.get(j).getAvg()) {
//							j��° ����� ũ�� i��° ������ ������Ų��.
							scorelist.get(i).setRank(scorelist.get(i).getRank() + 1);
							//System.out.println(scorelist.get(j).getRank());
						}
					}
				}
		// ���
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

	// ArrayList�� add �޼��� �ۼ�
	public void addScore(ScoreVo vo) {
		scorelist.add(vo);
	}

}
