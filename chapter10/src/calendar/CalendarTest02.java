package calendar;
import java.util.Calendar;

public class CalendarTest02 {

	public static void main(String[] args) {

      final String[] DAY_OF_WEEK = {"", "��", "��", "ȭ", "��", "��", "��", "��"};
        
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        
         date1.set(1945, Calendar.AUGUST, 15);
        date2.set(2023,2-1,15);
        System.out.println("date1�� " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] +"�����̰�, \n"
                + "date2(����)�� " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] +"����. " );
        
        long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/ 1000; 
        System.out.println("date1���� ���ݱ��� " + difference + "�ʰ� ������, \n"
                + "��(day)�� ����ϸ� " + difference/(24*60*60) +"���� ������. ");
    }
    
	
    private static String toString(Calendar date) {
        return date.get(Calendar.YEAR)+ "�� " + (date.get(Calendar.MONTH)+1) +"�� " + date.get(Calendar.DATE) +"�� ";
    }
		
	}

