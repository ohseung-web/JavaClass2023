package collection.hashMapEx.capitalGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Game {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();
	HashMap<String, String> hashCapital = new HashMap<>();
 
	public Game() {
		addNation();	
	}

	// ���� �̸� ���� �޼���
	public void addNation() {
		hashCapital.put("�ѱ�","����");	
		hashCapital.put("�׸���","���׳�");	
		hashCapital.put("ȣ��","�õ��");	
		hashCapital.put("�̱�","������DC");	
		hashCapital.put("����","����");	
		hashCapital.put("�Ϻ�","����");
		hashCapital.put("�߱�","����¡");	
		hashCapital.put("�ε�","������");	
		hashCapital.put("�߽���", "�߽��ڽ�Ƽ");
		hashCapital.put("������", "������");
		hashCapital.put("������", "�ĸ�");
		hashCapital.put("����", "������");
	}

	// game �޴� �޼���
		public void gameMenu() {
			
			boolean run = true;
			System.out.println("*** ���� ���߱� ������ �����մϴ�. ***");
			
			while(run) {
				System.out.print("�Է� : 1,  ���� : 2,  ���� : 3 >>");
				int select = scan.nextInt();
				
				switch(select) {
				case 1:
					insertNation();
					break;
				case 2:
					gameStart();
					break;
				case 3:
					System.out.println("������ �����մϴ�.");
					run = false;
					break;
				}
			}
		}
	
	
	// ���� �߰� �޼���
	public void insertNation() {
		
		int cnt = hashCapital.size();
		System.out.println("���� "+cnt+"�� ������ ������ �ԷµǾ� �ֽ��ϴ�.");

		while(true) {
			System.out.print("����� ���� �Է�"+(cnt+1)+" >>");
			String nation = scan.next();
			if(nation.equals("�׸�")) {
				break;
			}
			String capital = scan.next();
		
			if(hashCapital.containsKey(nation)) {
				System.out.println(nation + "�� �̹� �ֽ��ϴ�.");
				continue;
			}
			hashCapital.put(nation, capital);
		}
	}
	
	// ���� Start �޼���
  public void gameStart() {
	 
	  while(true) {
		  //  toArray() : �� �޼ҵ�� �÷��� ���·� �Ǿ��ִ� �͵��� ��ü�迭�� ��ȯ���ش�.
		   // Set<String> keys = hashCapital.keySet();
	     	    Object[] arr = hashCapital.keySet().toArray(); // ��ĳ����
		  //  String[] arr =(String[])hashCapital.keySet().toArray(); �ٿ�ĳ����
		    int index = ran.nextInt(arr.length); 
		    
		  // ������ ������ �����Ѵ�.
		       String question =(String)arr[index];
			   String answer = hashCapital.get(question);
			   
			// ������ ����Ѵ�.
				  System.out.print(question+"�� ������ ?");
				  
				  String userAnswer = scan.next();
				  if(userAnswer.equals("�׸�")) {
					  break;
				  }
				  else if(answer.equals(userAnswer)) {
					  System.out.println("����!!");
				  }else {
					  System.out.println("�ƴմϴ�.!!");
					  continue;
				  }
	  }
	  
  }
	
	

	//-----------------------------------------------------------------------------------------
		
	}

