package calendar;
import java.util.Calendar;

public class CalendarTest02 {

	public static void main(String[] args) {

      final String[] DAY_OF_WEEK = {"", "일", "월", "화", "수", "목", "금", "토"};
        
        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();
        
         date1.set(1945, Calendar.AUGUST, 15);
        date2.set(2023,2-1,15);
        System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] +"요일이고, \n"
                + "date2(오늘)는 " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] +"요일. " );
        
        long difference = (date2.getTimeInMillis() - date1.getTimeInMillis())/ 1000; 
        System.out.println("date1부터 지금까지 " + difference + "초가 지났고, \n"
                + "일(day)로 계산하면 " + difference/(24*60*60) +"일이 지났다. ");
    }
    
	
    private static String toString(Calendar date) {
        return date.get(Calendar.YEAR)+ "년 " + (date.get(Calendar.MONTH)+1) +"월 " + date.get(Calendar.DATE) +"일 ";
    }
		
	}

