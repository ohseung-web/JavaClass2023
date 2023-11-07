package arrylist;
import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
		
      ArrayList<Integer> number = new ArrayList<>();
      // add(E element)메서드는 배열의 값입력
      number.add(10);
      number.add(20);
      number.add(30);
      number.add(40);
      number.add(50);
      
      //  add(index, E element)메서는 index의 위치에 값 삽입
      number.add(1, 60);//
      System.out.println(number);//배열출력
      
      //remove(index)메서드는 배열의 값 삭제
      number.remove(1);
      System.out.println(number);
      
      //set(index, value) : ArrayList의 index번째 위치에 value를 수정한다.
      number.set(1, 25);
      System.out.println(number);
      
      //배열의 크기출력
      System.out.println(number.size());
      
      //지정한 index의 값을 출력
      System.out.println(number.get(3));
      
      //indexOf(Object o)는 인자로 객체를 받습니다. 
      //리스트의 앞쪽부터 인자와 동일한 객체가 있는지 찾으며, 존재한다면 그 인덱스를 리턴합니다. 
      //존재하지 않는다면 -1을 리턴합니다.
      System.out.println(number.indexOf(30)); 
      // 30은 존재하므로 index번호 2출력
      System.out.println(number.indexOf(60)); 
      // 60은 존재하지 않으므로 -1 출력
      
      // for문으로 출력하는 방법
      for(int i=0;i<number.size();i++) {
    	  System.out.print(number.get(i)+" ");
      }
      System.out.println();
      System.out.println("==========================");
      /*
		 * # 향상된 for문
		 *   1) 배열이나 ArrayList 전체 데이터를 대상으로 작업할 경우 사용한다.
		 *   2) 구조
		 *   	for(자료형 변수명 : 배열 or ArrayList){
		 *   		 반복할 문장;
		 *   	}
		 */
      
      // number의 0번째 값을 num에 저장한 후 반복을 시작하며
      // number의 마지막 값을 num에 저장한 후 반복한 다음 종료된다.
      for(int num : number) {
			System.out.println(num);
		}
      
      
      //Clear 이 메소드는 이전에 무슨 작업을 하건 말건 상관없이 무조건 깔.끔. 하게 비워줍니다.
      number.clear();
      System.out.println(number);
      
      // 배열이 비어있는 지 확인하는 메서드 isEmpty
      // 비어 있으면 true, 아니면 false가 출력된다.
      if(number.isEmpty()) {
    	  System.out.println("배열의 값이 모두 Null");
      };
      
	}

}
