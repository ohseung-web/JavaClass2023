package graduate;

public class UnderGraduate extends Student {
	
	private String group;
	public UnderGraduate(String name, String course, int grade, int credit, String group) {
		super(name, course, grade, credit);
		this.group = group;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\n소속 동아리명 : " + group+ "\n-------------------";
	}
	

}
