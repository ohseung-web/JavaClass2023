package omokgame;



public class Log extends Member{
	String myid;
	 String mypw;
         public void Login() {
        	 
			System.out.println("��ID�� �Է��ϼ��䡽");
			 myid = scan.next();
			System.out.println("��PW�� �Է��ϼ��䡽");
			 mypw =scan.next();
			
			
				for(int i = 0;i<list.size();i++) {
					if(myid.equals(list.get(i).getID())&&mypw.equals(list.get(i).getPW())) {
						
						System.out.println("�������");
						System.out.println("�α��� ����!");
						System.out.println("�������");
						log = i;
						  
						
					}
					
				}
				
				
			
		
			   if(log == -1) {
				   System.out.println("������������");
					System.out.println("�߸��� ȸ������ �Դϴ�");
					System.out.println("������������");
		         }
			   
			
					
	
				
		}
         public void Logout() {
        	 System.out.println("��������");
			System.out.println("�α׾ƿ� �Ϸ�!");
			System.out.println("��������");
   
        	 log = -1;
        	 
         }
      

}
