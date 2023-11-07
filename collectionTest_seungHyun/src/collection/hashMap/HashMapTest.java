package collection.hashMap;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {

		HashMap<String, String> word = new HashMap<>();
		
        String[] key = {"a","b","c","d","e"};
        String[] value = {"apple","banana","candy","dog","english"};
        
        // put(Ű,��) : ���� ArrayList�� add�� ���� ��Ȱ�� �Ѵ�.
        for(int i=0; i<key.length;i++) {
        	word.put(key[i], value[i]);
        }
		System.out.println(word);
		
		// keySet() / values() : Ű, ���� ������ ��ȯ
		System.out.println(word.keySet());
		System.out.println(word.values());
		
		// get()  : Ű�� �Է��ϸ� value�� ��ȯ
		System.out.println(word.get("e"));
		
		// replace()  : Ű���� �ٲܰ��� �����ϸ� ���� �����
		word.replace("c", "coin");
		System.out.println(word.get("c"));
		
		// put()  : ���ο� Ű, �� �߰�
		word.put("f", "flower");
		System.out.println(word);
		
		// containsKey() / containsValue()  : Ű�� ������, ���� ������ ���θ� Ȯ���Ͽ� true/false ��ȯ
		System.out.println(word.containsKey("a"));
		System.out.println(word.containsValue("age"));
		
		// remove() : �ش� key�� value �� ���� / clear() : ��� ����
		System.out.println(word.remove("f"));
		System.out.println(word);
		//word.clear();
		//System.out.println(word);
		
		// isEmpty : HashMap�� null�̸� true ����
		System.out.println("word �ؽø� : "+word.isEmpty());
		
		// Ȯ�� for���� �̿��� ���
		for(String keys : word.keySet()) {
			System.out.println(keys+"="+word.get(keys));
		}
		
		//�ش� �÷����� ��� ��Ҹ� Object Ÿ���� �迭�� ��ȯ��.
		Object[] arr = word.values().toArray();
		Object[] arr2 = word.keySet().toArray();
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}
