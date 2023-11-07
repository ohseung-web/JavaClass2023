package lambdaEx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaEx {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) {
		    list.add(i);
		}
		
		/*
		// error ������� : ���ǿ� �����ϴ� �����Ͱ� �����Ǹ鼭 index ��ȣ�� ����Ǳ� �����̴�.
		for(int num : list) {
			if(num % 2 == 0) {
				list.remove(num);
			}
			System.out.print(num+" ");
		}
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i) % 2 == 0) {
				list.remove(i);
			}
		}
		*/
		
		
		System.out.println(list);
		list.forEach(System.out::print);
		
		System.out.println();
		list.forEach(i -> System.out.print(i+" "));
		System.out.println();
		
		
		// ���ǿ� �����ϴ� ���Ҹ� ���͸��ؼ� �����Ѵ�.
		list.removeIf(x -> x%2==0 || x%3==0);
		System.out.println(list);
		
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");
		
		map.forEach((k,v) -> System.out.println("{"+k+","+v+"}"));
		System.out.println();
		
		
	}

}
