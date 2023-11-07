package calendar;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {

		Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH)+1; // get()�� 0~30���� ��������
        int date = today.get(Calendar.DATE);
        
        int woy = today.get(Calendar.WEEK_OF_YEAR);
        int wom = today.get(Calendar.WEEK_OF_MONTH);
        
        int doy = today.get(Calendar.DAY_OF_YEAR);
        int dom = today.get(Calendar.DAY_OF_MONTH);
        int dow = today.get(Calendar.DAY_OF_WEEK);
        
        int hour12 = today.get(Calendar.HOUR);
        int hour24 = today.get(Calendar.HOUR_OF_DAY);
        int minute = today.get(Calendar.MINUTE);
        int second = today.get(Calendar.SECOND);
        
        int milliSecond = today.get(Calendar.MILLISECOND);
        int timeZone = today.get(Calendar.ZONE_OFFSET);
        int lastDate = today.getActualMaximum(Calendar.DATE);
        
        System.out.println("������ " + year +"�� " + month + "��" + date +"��");
        System.out.println("������ ������ " + woy +"°��, �̹����� " + wom + "°��. " + date +"��");
        System.out.println("������ �̹� ���� " + doy +"������, �̹� ���� " + dom + "��. ������ " + dow +"�� (1:�Ͽ���)");
        System.out.println("���� �ð��� " + hour12 +":"+ minute + ":"+ second +", 24�ð����� ǥ���ϸ� " + hour24+":"+ minute + ":"+ second);
        System.out.println("������ " + year +"�� " + month + "��" + date +"��");
        System.out.println("1000���� 1�� (0~999): " + milliSecond);
        System.out.println("timeZone (-12~+12): " + timeZone/(60*60*1000)); // 1000���� 1�ʸ� �ð����� ǥ���ϱ� ���� 60*60*1000
        System.out.println("�� ���� ������ ��: " + lastDate);
		
	}

}
