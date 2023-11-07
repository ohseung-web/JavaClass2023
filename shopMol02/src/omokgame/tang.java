package omokgame;

import java.util.Scanner;

public class tang extends Sadari {

	
	public void tg() {
		while(true) {
			Scanner scan =new Scanner(System.in);
	        String[] tang = {"탕","수","육"};
	        String [] me = new String [1];
	        String [] com =new String [1];
	        System.out.println("=====================");
			System.out.print("선공을 정해주세요 (com or user) :");
			
			
			String sun = scan.next();
			if(sun.equals("com")) {
				com[0] = tang[0];
			

			}else if(sun.equals("user")){
				System.out.print("user : ");
	      me[0] = scan.next();
	      com[0] = tang[1];
			
		}else {
			System.out.println("=====================");
			System.out.println("게임종료");
			System.out.println("=====================");
			break;
		}
			while(true) {
				if(sun.equals("com")) {
					
					System.out.println("com :"+ com[0]);
					System.out.println();
					System.out.println("user : ");
				      me[0] = scan.next();
						if( me[0].equals(tang[1])&& com[0].equals(tang[0])) {
							com[0] = tang[2];
							continue;
						}
						else if(me[0].equals(tang[2])&& com[0].equals(tang[1])) {
							com[0] = tang[0];
							continue;
						}
						else	if( me[0].equals(tang[0])&& com[0].equals(tang[2])) {
							com[0] = tang[1];
							continue;
						}else {
							System.out.println("=====================");
							System.out.println(list.get(log).getID()+" 님패배ㅋ");
							System.out.println("=====================");
							break;
						}
				}else if(sun.equals("user")){
					System.out.println("com :"+ com[0]);
					System.out.println("user : ");
		      me[0] = scan.next();
				
		      
		  	if( me[0].equals(tang[1])&& com[0].equals(tang[0])) {
				com[0] = tang[2];
				continue;
			}
			else if(me[0].equals(tang[2])&& com[0].equals(tang[1])) {
				com[0] = tang[0];
				continue;
			}
			else	if( me[0].equals(tang[0])&& com[0].equals(tang[2])) {
				com[0] = tang[1];
				continue;
			}else {
				System.out.println("=====================");
				System.out.println(list.get(log).getID()+" 님패배ㅋ");
				System.out.println("=====================");
				break;
			}
			}
				
		
				
			}
		}
		
	
	}
}
