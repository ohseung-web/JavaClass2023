package collection.hashMapEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

import collection.Member;

public class HashMapEx02 {

	public static void main(String[] args) {
   
		 Scanner scan = new Scanner(System.in);
		 HashMap<String, Location> hashLocation = new HashMap<>();
		 int cnt = 4;
		 
		 // ������ Location��ü�� ����
		 System.out.println("����, �浵, ������ �Է��Ͻÿ�.");
		 for(int i=0; i<cnt; i++) {
			 System.out.print(">> ");
			 String loca = scan.next();
			 StringTokenizer st = new StringTokenizer(loca,",");
			 String cityName = st.nextToken().trim();
			 Integer Latitude = Integer.parseInt(st.nextToken().trim());
			 Integer Hardness = Integer.parseInt(st.nextToken().trim());
			 
			 Location lc =new Location(cityName,Latitude,Hardness);
			 hashLocation.put(lc.getCityName(), lc);
		 }
		 
		 // hashLocation ����� ��� ���� ���
		System.out.println("-------------------------------------------");
	
		for(String city : hashLocation.keySet()) {
			Location location = hashLocation.get(city);
			System.out.println(location);
		}
		
		/*
		Iterator<String> it = hashLocation.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			Location location = hashLocation.get(key);
			System.out.println(location);
		}
		*/
		System.out.println("------------------------------------------");
		
		// ���� �˻�
		while(true) {
			System.out.print("���� �̸� >> ");
			String city = scan.next();
			
			if(city.equals("�׸�")) {
				System.out.println("���� �˻� ����");
				break;
			}else if(hashLocation.containsKey(city)) {
				System.out.println(hashLocation.get(city));
				continue;
			}else {
				System.out.println(city+"�� �����ϴ�.");
				continue;
			}
//-------------------------------------------------------------------------------------------					
		}
	}

}
