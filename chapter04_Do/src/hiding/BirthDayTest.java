package hiding;

public class BirthDayTest {

	public static void main(String[] args) {

		Birthday bir = new Birthday();
        // 2������ 28�ϱ����̹Ƿ� �̷���� �ڵ������ �ƴ����� ���������� �ȴ�.
		bir.setMonth(3); 
		bir.setYear(2023);
		bir.setDay(30);
		
		System.out.println(bir.getYear()+"�� "+bir.getMonth()+"�� "+bir.getDay()+"��");
	}

}
