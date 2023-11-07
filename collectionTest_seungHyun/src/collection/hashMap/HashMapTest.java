package collection.hashMap;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<String, String> word = new HashMap<>();
		
        String[] key = {"a","b","c","d","e"};
        String[] value = {"apple","banana","candy","dog","english"};
        
        // put(키,값) : 저장 ArrayList의 add와 같은 역활을 한다.
        for(int i=0; i<key.length;i++) {
        	word.put(key[i], value[i]);
        }
		System.out.println(word);
		
		// keySet() / values() : 키, 값을 별도로 반환
		System.out.println(word.keySet());
		System.out.println(word.values());
		
		// get()  : 키를 입력하면 value값 반환
		System.out.println(word.get("e"));
		
		// replace()  : 키값과 바꿀값을 제공하면 값이 변경됨
		word.replace("c", "coin");
		System.out.println(word.get("c"));
		
		// put()  : 새로운 키, 값 추가
		word.put("f", "flower");
		System.out.println(word);
		
		// containsKey() / containsValue()  : 키가 같은지, 값이 같은지 여부를 확인하여 true/false 반환
		System.out.println(word.containsKey("a"));
		System.out.println(word.containsValue("age"));
		
		// remove() : 해당 key의 value 값 삭제 / clear() : 모두 삭제
		System.out.println(word.remove("f"));
		System.out.println(word);
		//word.clear();
		//System.out.println(word);
		
		// isEmpty : HashMap이 null이면 true 리턴
		System.out.println("word 해시맵 : "+word.isEmpty());
		
		// 확장 for문을 이용한 출력
		for(String keys : word.keySet()) {
			System.out.println(keys+"="+word.get(keys));
		}
		
		//해당 컬렉션의 모든 요소를 Object 타입의 배열로 반환함.
		Object[] arr = word.values().toArray();
		Object[] arr2 = word.keySet().toArray();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
