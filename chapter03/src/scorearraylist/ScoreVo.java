package scorearraylist;

public class ScoreVo {
	public static int cnt; // 객체가 생성될때마다 자동으로 1씩 증가되는 변수
	private int no; // 번호, cnt자동으로 증가하는 값 
	private String name; 
	private int java;
	private int jsp;
	private int spring;
	private int total;//합계
	private double avg;//평균
	private int rank=1;//석차, 석차를 계산할 기억장소는 무조건 1로 초기화
	
	public ScoreVo() {}
	public ScoreVo(String name, int java, int jsp,int spring) {
		
		no = ++cnt;//자동으로 1씩 증가되는 코딩
		this.name = name;
		this.java = java;
		this.jsp = jsp;
		this.spring = spring;
		
		total = java+jsp+spring;
		avg = (double)total/3;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getJsp() {
		return jsp;
	}
	public void setJsp(int jsp) {
		this.jsp = jsp;
	}
	public int getSpring() {
		return spring;
	}
	public void setSpring(int spring) {
		this.spring = spring;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	@Override //재정의 하겠다.
	// Arrays.toString()에서 toString메서드는 최상위 클래스인 Object 클래스의 메서드이다.
	// toString메서드는 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드 이다.
	// 배열에서 toString()메소드는 배열의 값을 [10,20,30] 처럼 출력시켰다.
	// 여기서는 toString()메소드를 Override(오버라이드=재정의)하여 사용하겠다.
	// String.format 표현할 데이터의 타입을 지정 %d(정수), %s(문자열), %f(실수)
	public String toString() {
		return String.format("%d %s %3d %3d %3d %3d %.2f %d", no,name,java,jsp,spring,total,avg,rank);
	}
}
