package omokgame;

import java.util.*;

public class y {

	public  void update() {
		int wck = -1;
		int wck2=-1;
		// TODO Auto-generated method stub
		int [][] t = new int [11][11];
		int me  =0;
		int com =0;
		int q= 0;
		int s =0;
		int w=0;
		int x=0;
		//       À·³îÀÌÃÊ±âÈ­
		Scanner scan=new Scanner(System.in);
		

		Random ran  = new Random();
		int num =0;
		int num2 =0;
		
		for(int i = 0;i<t.length;i++) {
			for(int j = 0;j<t.length;j++) {
				if(i==0 && j%2==0) {
					t[i][j] = 2;
				}else if(j==0&&i%2 ==0) {
					t[i][j] = 2;
				}else if(i==(t.length-1)&&j%2==0) {
					t[i][j] = 2;
				}else if(j==(t.length-1)&&i%2 ==0) {
					t[i][j] = 2;
				}else if(i == j) {
					t[i][j]=7;
				}
				
				else {
					t[i][j]=1;
				}
				
				
			}
		
		}
		int a= 1;
		int b=9;
		while(true) {
			
			
			t[a][b] =8;
			a =a+1;
			b= b-1;	
			if(b==0) {
				t[5][5] =2;
				break;
			}
	       
		}
		t[2][8] = 0;
		t[3][7] = 0;
		t[7][3] = 0;
		t[8][2] = 0;
		t[2][2] = 0;
		t[3][3] = 0;
		t[7][7] = 0;
		t[8][8] = 0;
		
		
			
		

		
		for(int i = 0;i<t.length;i++) {
			for(int j = 0;j<t.length;j++) {
				if(t[i][j] == 1) {
					System.out.print("¡¡");
				}else if(t[i][j] ==2) {
					System.out.print("¡á");
				}else if(t[i][j] ==7) {
					System.out.print("¢Ù");
				}else if(t[i][j] ==8) {
					System.out.print("¢×");
				}else if(t[i][j] ==0) {
					System.out.print("¢Â");
				} if((j==t.length-1)) {
					System.out.println();
				}
				
				
			}
			
		}
//      À·³îÀÌÃÊ±âÈ­
		while(true) {
		
			
		
			
			
			System.out.println("À·À» ´øÀúÁÖ¼¼¿ä(À¯Àú)");
			num = ran.nextInt(5)+1;
			String user = scan.next();
			
			me = me+num;
			if(me == com) {
				com= 0;
			}
			if (wck ==2) {
				if(me ==6) {
					t[2][8] = 3;
				}else if(me==7) {
					
					t[3][7] = 3;
					
					
				}else if(me==8) {
					t[5][5]=3;
					wck =3;
				}else if(me==9) {
					t[7][3] = 3;
				}else if(me==10) {
					t[8][2] = 3;
				}else if(me>=11) {
					wck=1;
				}
				
			}
			
			if (wck ==-1) {
				if(me >=1 && me<=4 ) {
					t[(t.length-1)+me-(3*me)][(t.length-1)] =3;
					q=(t.length-1)+me-(3*me);
			        s= (t.length-1);
				}else if(me==5){
					t[(t.length-1)+me-(3*me)][(t.length-1)] =3;
					q=(t.length-1)+me-(3*me);
			        s= (t.length-1);
			     wck=2;
				}
				else if(me >=6 && me<=9  ) {
					t[0][(t.length-1+me)-5-3*(me-5)] =3;
					q=0;
			        s=(t.length-1+me)-5-3*(me-5);
				}else if(me ==10) {
					t[0][(t.length-1+me)-5-3*(me-5)] =3;
					q=0;
			        s=(t.length-1+me)-5-3*(me-5);
				}
			else if(me >=11 && me<=14 ) {
					t[me - (me-2) + 2*(me-11)][0] =3;
					q=me - (me-2) + 2*(me-11);
			        s= 0;
				}else if(me==15 ) {
					t[me - (me-2) + 2*(me-11)][0] =3;
					q=me - (me-2) + 2*(me-11);
			        s= 0;
			        wck=3;
				}else if(me >=16 && me<=20) {
					t[(t.length-1)][me - 14 +(me-16)] =3;
					q=(t.length-1);
			        s= me - 14 +(me-16);
				}else if(me>20) {
					System.out.println("À¯Àú½Â");
					break;
				}
			}

			
	
			
		
			if(num ==1) {
				System.out.println("=======µµ=======");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("=======µµ=======");
				
			}else if(num==2) {
				System.out.println("=======°³=======");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("=======°³=======");
			}else if(num==3) {
				System.out.println("=======°É=======");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("=======°É=======");
			}else if(num==4) {
				System.out.println("=======À·=======");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("=======À·=======");
			}else if(num==5) {
				System.out.println("=======¸ð=======");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("=======¸ð=======");
			}
			
			
			for(int i = 0;i<t.length;i++) {
				for(int j = 0;j<t.length;j++) {
					if(t[i][j] == 1) {
						System.out.print("¡¡");
					}else if(t[i][j] ==2) {
						System.out.print("¡á");
					}else if(t[i][j] ==3) {
						System.out.print("³ª");
					}else if(t[i][j] ==4) {
						System.out.print("ÄÄ");
					}
					else if(t[i][j] ==7) {
						System.out.print("¢Ù");
					}else if(t[i][j] ==8) {
						System.out.print("¢×");
					}else if(t[i][j] ==0) {
						System.out.print("¢Â");
					} if((j==t.length-1)) {
						System.out.println();
					}
					
					
				}
				
			}
			t[w][x] = 2;
			if(com == me) {
				me =0;
			}
			System.out.println("ÄÄÇ»ÅÍ°¡ À·À» ´øÁý´Ï´Ù.");
		
			num2 = ran.nextInt(5)+1;
			com = com +num2;
			if(com == me) {
				me= 0;
			}
			int nn =scan.nextInt();
			if (wck2 ==2) {
				if(me ==6) {
					t[2][8] = 4;
				}else if(me==7) {
					
					t[3][7] = 4;
					
					
				}else if(me==8) {
					t[5][5]=4;
					wck =3;
				}else if(me==9) {
					t[7][3] = 4;
				}else if(me==10) {
					t[8][2] = 4;
				}else if(me>=11) {
					wck=1;
				}
				
			}
			if(wck2 ==-1) {
				if(com >=1 && com<=4 ) {
					t[(t.length-1)+com-(3*com)][(t.length-1)] =4;
					w=(t.length-1)+com-(3*com);
			        x= (t.length-1);
				}else if(com ==5) {
					t[(t.length-1)+com-(3*com)][(t.length-1)] =4;
					w=(t.length-1)+com-(3*com);
			        x= (t.length-1);
			        
				}
				else if(com >=6&&com<=9  ) {
					t[0][(t.length-1+com)-5-3*(com-5)] =4;
					w=0;
			        x= (t.length-1+com)-5-3*(com-5);
				}else if(com==10) {
					t[0][(t.length-1+com)-5-3*(com-5)] =4;
					w=0;
			        x= (t.length-1+com)-5-3*(com-5);
			     
				}
				else if(com >=11 && com<=14 ) {
					t[com - (com-2) + 2*(com-11)][0] =4;
					w=com - (com-2) + 2*(com-11);
			        x= 0;
				}	else if(com ==15 ) {
					t[com - (com-2) + 2*(com-11)][0] =4;
					w=com - (com-2) + 2*(com-11);
			        x= 0;
				}
				else if(com>=16 && com<=20 ) {
					t[(t.length-1)][com - 14 +(com-16)] =4;
					w=(t.length-1);
			        x= com - 14 +(com-16);
				}else if(com>20) {
					System.out.println("ÄÄÇ»ÅÍ½Â");
					break;
				}
			}
			if(wck ==2) {
				
			}
			
			
		
			if(num2 ==1) {
				System.out.println("=======µµ=======");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü");
				System.out.println("=======µµ=======");
				
			}else if(num2==2) {
				System.out.println("=======°³=======");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü");
				System.out.println("=======°³=======");
			}else if(num2==3) {
				System.out.println("=======°É=======");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("=======°É=======");
			}else if(num2==4) {
				System.out.println("=======À·=======");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Û¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("=======À·=======");
			}else if(num2==5) {
				System.out.println("=======¸ð=======");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü¡¡¡Ü");
				System.out.println("=======¸ð=======");
			}
			for(int i = 0;i<t.length;i++) {
				for(int j = 0;j<t.length;j++) {
					if(t[i][j] == 1) {
						System.out.print("¡¡");
					}else if(t[i][j] ==2) {
						System.out.print("¡á");
					}else if(t[i][j] ==3) {
						System.out.print("³ª");
					}else if(t[i][j] ==4) {
						System.out.print("ÄÄ");
					}
					else if(t[i][j] ==7) {
						System.out.print("¢Ù");
					}else if(t[i][j] ==8) {
						System.out.print("¢×");
					}else if(t[i][j] ==0) {
						System.out.print("¢Â");
					} if((j==t.length-1)) {
						System.out.println();
					}
					
					
				}
				
			}
			if(me == com) {
				com =0;
			}
			t[q][s] = 2;
			
			
		}
		
		
		
		
	}

}
