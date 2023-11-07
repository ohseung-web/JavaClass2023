package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

public class CollectionMethod {

	public static void main(String[] args) {

		 List list = new ArrayList<>();
		 System.out.println(list);
		
		 Collections.addAll(list, 1,2,3,4,5);
		 Collections.rotate(list, 2); // 오른쪽으로 두 칸씩 이동
		 System.out.println(list); // [4,5,1,2,3]
		 
		 Collections.swap(list, 0, 2); //첫 번째와 세 번째를 교환(swap)
		 System.out.println(list); //[1,5,4,2,3]
		 
		 Collections.shuffle(list); // 저장된 위치의 요소를 임의로 변경
		 System.out.println(list); // 무작위
		 
		 Collections.sort(list); // 오름차순 정렬
		 System.out.println(list); // [1,2,3,4,5]
		 
		 Collections.sort(list, Collections.reverseOrder()); //역순정렬
		 System.out.println(list); //[5.4.3.2.1]
		 
		 Collections.fill(list,9); // list를 9로 채운다.
		 System.out.println(list); //[9,9,9,9,9]
		 
		 //list와 같은 크기의 새로운 list를 생성하고 2로 채운다. 단, 결과는 변경불가
		 List newList = Collections.nCopies(list.size(), 2);
		 System.out.println(newList); // [2,2,2,2,2]
		 
		 System.out.println(Collections.disjoint(list, newList)); //공통요소가 없으면 true
		 
		 Collections.copy(list, newList);
		 System.out.println(newList); //[2,2,2,2,2]
		 System.out.println(list); //[2,2,2,2,2]
		 
		 Collections.replaceAll(list, 2, 1); // 모든 객체를 찾아 2와 같으면 1로 변경한다.
		 System.out.println(list);
		 
		 Enumeration e = Collections.enumeration(list);//리스트를 Enumeration(열거)로 변환한다.
		 
		 ArrayList list2 = Collections.list(e); // Enumeration(열거)를 리스트로 변환한다.
		 
		 System.out.println(e);
		 System.out.println(list2);
		 
		 //-----------------------------------------------------------------------------------
		 Scanner scan = new Scanner(System.in);
		 ArrayList<String> listStr = new ArrayList<>();
		 
		 Collections.addAll(listStr, "포도","사과","포도","귤","멜론");
		 Collections.sort(listStr);
		 System.out.println(listStr);
		 //binarySearch는 반드시 정렬을 먼저 진행해야 한다.
		 System.out.println("Key 입력");
		 String myKey = scan.next();
	     System.out.println(myKey+"의 위치(인덱스값)? : ["+ Collections.binarySearch(listStr, myKey)+"]");
	     /*
	     System.out.println("멜론 위치(인덱스값)? : ["+ Collections.binarySearch(listStr, "멜론")+"]");
	     System.out.println("오렌지 위치(인덱스값)? : ["+ Collections.binarySearch(listStr, "오렌지")+"]");
	     System.out.println("귤 위치(인덱스값)? : ["+ Collections.binarySearch(listStr, "귤")+"]");
		 */
		 
	    //  frequency(빈도) : Collection 안에 있는 객체가 몇번 등장했는지를 리턴해준다.
		 System.out.println(Collections.frequency(listStr, "포도"));
	}

}
