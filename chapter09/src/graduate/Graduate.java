package graduate;

public class Graduate extends Student {

	String 조교유형;
	double 장학금비율;
	
	
	public Graduate(String name, String course, int grade, int credit, String 조교유형, double 장학금비율) {
	 super(name, course, grade, credit);
		if(조교유형.equals("교육 조교") || 조교유형.equals("연구 조교")) {
			this.조교유형 = 조교유형;
		}
		if(장학금비율 > 100 || 장학금비율 < 0) {
			System.out.println("ERROR");
		} else {
			장학금비율 = 장학금비율 / 100;
		}
	}

	@Override
	public String toString() {
		return super.toString()
		+ "\n조교유형 : " + 조교유형
		+ "\n장학금비율 : " + 장학금비율
		+ "\n-------------------";
	}
	
	
}
