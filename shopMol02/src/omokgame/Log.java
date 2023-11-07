package omokgame;



public class Log extends Member{
	String myid;
	 String mypw;
         public void Login() {
        	 
			System.out.println("【ID를 입력하세요】");
			 myid = scan.next();
			System.out.println("【PW를 입력하세요】");
			 mypw =scan.next();
			
			
				for(int i = 0;i<list.size();i++) {
					if(myid.equals(list.get(i).getID())&&mypw.equals(list.get(i).getPW())) {
						
						System.out.println("▼▼▼▼▼▼");
						System.out.println("로그인 성공!");
						System.out.println("▲▲▲▲▲▲");
						log = i;
						  
						
					}
					
				}
				
				
			
		
			   if(log == -1) {
				   System.out.println("▼▼▼▼▼▼▼▼▼▼▼");
					System.out.println("잘못된 회원정보 입니다");
					System.out.println("▲▲▲▲▲▲▲▲▲▲▲");
		         }
			   
			
					
	
				
		}
         public void Logout() {
        	 System.out.println("▼▼▼▼▼▼▼");
			System.out.println("로그아웃 완료!");
			System.out.println("▲▲▲▲▲▲▲");
   
        	 log = -1;
        	 
         }
      

}
