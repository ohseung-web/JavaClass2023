package graduate;

public class Graduate extends Student {

	String ��������;
	double ���бݺ���;
	
	
	public Graduate(String name, String course, int grade, int credit, String ��������, double ���бݺ���) {
	 super(name, course, grade, credit);
		if(��������.equals("���� ����") || ��������.equals("���� ����")) {
			this.�������� = ��������;
		}
		if(���бݺ��� > 100 || ���бݺ��� < 0) {
			System.out.println("ERROR");
		} else {
			���бݺ��� = ���бݺ��� / 100;
		}
	}

	@Override
	public String toString() {
		return super.toString()
		+ "\n�������� : " + ��������
		+ "\n���бݺ��� : " + ���бݺ���
		+ "\n-------------------";
	}
	
	
}
