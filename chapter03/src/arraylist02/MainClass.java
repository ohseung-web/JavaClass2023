package arraylist02;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		ArrayList<Tv> tvlist = new ArrayList<>();
		
		tvlist.add(new Tv("TV", "�Ｚ", 1000));
		tvlist.add(new Tv("�ñ״�óTV", "����", 2000));
		tvlist.add(new Tv("����ƮTV", "����", 3000));
		
		
		for(int i=0;i<tvlist.size();i++) {
			Tv tv = tvlist.get(i);
			tv.tvinfo();
			System.out.println("=============");
		}
		
	}

}
