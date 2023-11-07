package scorearraylist;

public class ScoreVo {
	public static int cnt; // ��ü�� �����ɶ����� �ڵ����� 1�� �����Ǵ� ����
	private int no; // ��ȣ, cnt�ڵ����� �����ϴ� �� 
	private String name; 
	private int java;
	private int jsp;
	private int spring;
	private int total;//�հ�
	private double avg;//���
	private int rank=1;//����, ������ ����� �����Ҵ� ������ 1�� �ʱ�ȭ
	
	public ScoreVo() {}
	public ScoreVo(String name, int java, int jsp,int spring) {
		
		no = ++cnt;//�ڵ����� 1�� �����Ǵ� �ڵ�
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
	
	@Override //������ �ϰڴ�.
	// Arrays.toString()���� toString�޼���� �ֻ��� Ŭ������ Object Ŭ������ �޼����̴�.
	// toString�޼���� ��ü�� ������ �ִ� ������ ������ ���ڿ��� ����� �����ϴ� �޼ҵ� �̴�.
	// �迭���� toString()�޼ҵ�� �迭�� ���� [10,20,30] ó�� ��½��״�.
	// ���⼭�� toString()�޼ҵ带 Override(�������̵�=������)�Ͽ� ����ϰڴ�.
	// String.format ǥ���� �������� Ÿ���� ���� %d(����), %s(���ڿ�), %f(�Ǽ�)
	public String toString() {
		return String.format("%d %s %3d %3d %3d %3d %.2f %d", no,name,java,jsp,spring,total,avg,rank);
	}
}
