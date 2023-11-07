package myCalendar;

import java.util.Calendar;

public class CalendarTest {

	private int year;  //����� �Է� "��"
	private int month;  //����� �Է� "��"
	private int lastDay;   //month�� ������ ��
	private int startWeek;  //month�� ���� ����

	Calendar day = Calendar.getInstance();
	String[] week = {"��","��","ȭ","��","��","��","��"};
	int [][] calDisplay = new int[5][7];  // �޷� ����� ��

	CalendarTest(int year, int month){  //�����ڸ� ���� ��, �� �ޱ�
		this.year=year;
		this.month=month;
	}

	// �ʵ忡 �����س��� lastDay�� startWeek ���� ã���ִ� �޼ҵ�
	public void search(){
		//����� �������� ���� �Է���
		day.set(year, month-1,1);
		//�Է¹��� ���� ������ �� �� ���(30��, 31�� ��)
		lastDay = day.getActualMaximum(day.DAY_OF_MONTH);
		//1�̸� �Ͽ���, 2�̸� ������ ...������ �Է� ���� ���� ���ϰ� ����
		startWeek = day.get(day.DAY_OF_WEEK);
	}

	public void calInfo() {

		System.out.println();
		System.out.print("\t\t");
		System.out.print(day.get(Calendar.YEAR)+"Ҵ  ");
		System.out.println(day.get(Calendar.MONTH)+1+ "��");

		// ��ȭ��������� ���� ���
		System.out.println("---------------------------------------");
		for(int i=0;i<week.length; i++) {
			System.out.print(week[i]+"\t");
		}
		System.out.println();
		System.out.println("---------------------------------------");

		// ��ŸƮ ��ġ ����
		// ��(1) ~ ��(7)
		int day = 1;
		int countDay=startWeek; // ���ۿ���

		// ���ۿ��������� tab���� ���� 
		for(int i=0; i<startWeek-1; i++) {
			System.out.print("\t");
		}
		// calDisaplay[5][7]�� �޷� ���
		for(int i=0; i<calDisplay.length; i++) {
			for(int j=0; j<calDisplay[0].length; j++) {

				if(day <= lastDay) {
					calDisplay[i][j] = day++;
				}
				if(calDisplay[i][j] == 0) {
					break;
				}
				System.out.print(calDisplay[i][j]+"\t");

				if( countDay % 7==0 ){  // 7�ϱ��� ������� �����ٷ� ����
					System.out.println();
				}
				countDay++; 
			}
		}
	}


	/*
		// �ʵ��� ������ Ȱ���Ͽ� �޷����·� ������ִ� display()�޼ҵ�
		public void display(){
			System.out.println("��\t��\tȭ\t��\t��\t��\t��");
			//����� �� ��
			int day=1;
			switch(startWeek){
			case 7:System.out.print(" \t");
			case 6: System.out.print(" \t");
			case 5: System.out.print(" \t");
			case 4: System.out.print(" \t");
			case 3: System.out.print(" \t");
			case 2: System.out.print(" \t");
			}
			//��ŸƮ ��ġ ����
			int countDay=startWeek;
			for(int i=1;i<=lastDay;i++){
				System.out.print(i+"\t");
				if(countDay%7==0){
					System.out.println();
				}
				countDay++;
			}
		}

	 */

}


