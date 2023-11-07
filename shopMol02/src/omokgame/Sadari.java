package omokgame;

import java.util.Random;
import java.util.Scanner;

public class Sadari extends game{
int num3;
	public void game2() {
		int [][] sadari = new int [16][16] ;
		int g=0;
		int h=0;
Scanner scan =new Scanner(System.in);
		
		Random ran = new Random();
		while(true) {
			System.out.println("============");
			System.out.println("¸î¸íÇÒÁö °í¸£¼¼¿ä¤»3~5");
			 num3= scan.nextInt();
			if(num3 ==3) {
				sadari= new int [16][11];
				 g= ran.nextInt(3)+1;
    		     h= ran.nextInt(3)+1;
			}else if(num3 ==4) {
				sadari= new int [16][16];
				g= ran.nextInt(4)+1;
   		     h= ran.nextInt(4)+1;
			}else if(num3 ==5) {
				  g= ran.nextInt(5)+1;
	    		     h= ran.nextInt(5)+1;
				sadari= new int [16][21];
			}else {
				System.out.println("Àß¸øµÈ ¹øÈ£ÀÔ´Ï´Ù.");
				continue;
			}
			break;
		}
		
			
			
		
		
		int a =0;
		int b =0;
		int c=0;
		int d=0;
		int e=0;
		int f=0;
	
		int nn =0;
		int nn2 = 0;
		
	/*	 a = ran.nextInt(13)+2; 
		 b= ran.nextInt(13)+2; 
		 c= ran.nextInt(13)+2; 
		 d= ran.nextInt(13)+2; 
		 e= ran.nextInt(13)+2; 
		 f = ran.nextInt(13)+2; */
		
		
		
	     
	    if(h ==1) {
	    	a= 2;
	    	b = 14;
	    	c = 4;
	    		d= 12;
	    	    e= 6;
	        f = 10;
	        nn = 3;
	        nn2 =13;
	    	
	    }else if (h ==2) {
	    	a= 2;
	    	b = 12;
	    	c = 5;
	    		d= 8;
	    	    e= 11;
	        f = 14;
	        nn = 4;
	        nn2 =9;
	    	
	    }else if (h ==3) {
	       	a=12;
	    	b = 5;
	    	c = 3;
	    		d= 9;
	    	    e= 6;
	        f = 13;
	        nn = 4;
	        nn2 =11;
	    	
	    }else if (h ==4) {
	    	a= 4;
	    	b = 10;
	    	c = 6;
	    		d= 12;
	    	    e= 9;
	        f = 3;
	        nn = 7;
	        nn2 =11;
	    	
	    }else if (h ==5) {
	    	a= 7;
	    	b = 11;
	    	c = 3;
	    		d= 13;
	    	    e= 5;
	        f = 10;
	        nn = 8;
	        nn2 =13;
	    	
	    }else if (h ==6) {
	    	a= 2;
	    	b = 14;
	    	c = 4;
	    		d= 12;
	    	    e= 8;
	        f = 10;
	        nn = 14;
	        nn2 =2;
	    	
	    }
	     int s1 = -1;
	     int s2  = -1;
	     int s3 = -1 ;
	     int s4 = -1;
	     int s5 =-1;
	     int s6= -1;
	     int dang = -1;
	     
	 
		
		for(int i =0 ;i<sadari.length;i++) {
			
			for(int j =0 ;j<sadari[i].length;j++) {
				
				if(j==0||j%5==0) {
					sadari[i][j] = 1;
				}else {
					sadari[i][j] =0;
				}
	
			}
			
		}
		if(num3 ==3) {
			while(true) {
				if(a!=b && a!=c && a!=d &a!=e && a!=f && b!=c &&b!=d && b!=e && b!=f 
						&&c!=d && c!=e && c!=f &&d!=e &&d!=f && e!=f) {
					for(int i =0 ;i<sadari.length;i++) {
						
						for(int j =0 ;j<sadari[i].length;j++) {
							if((i==a || i ==b) && j>=1  && j<=4) {
								sadari[i][j]  =2;
							}else if((i==c || i ==d) && j>=6  && j<=9) {
								sadari[i][j]  =2;
							}else if((i==a || i ==b) && (j ==0 || j==5)) {
								sadari[i][j]  =3;
							}else if((i==c || i ==d)&& (j ==5 || j==10)) {
								sadari[i][j]  =3;
							}
						
						}
						
					}
					
					
					
					break;
				}else {
					continue;
				}
			
			}
			
		}else if(num3 ==4) {
			while(true) {
				if(a!=b && a!=c && a!=d &a!=e && a!=f && b!=c &&b!=d && b!=e && b!=f 
						&&c!=d && c!=e && c!=f &&d!=e &&d!=f && e!=f) {
					for(int i =0 ;i<sadari.length;i++) {
						
						for(int j =0 ;j<sadari[i].length;j++) {
							if((i==a || i ==b) && j>=1  && j<=4) {
								sadari[i][j]  =2;
							}else if((i==c || i ==d) && j>=6  && j<=9) {
								sadari[i][j]  =2;
							}else if((i==e || i ==f) && j>=11  && j<=14) {
								sadari[i][j]  =2;
							}else if((i==a || i ==b) && (j ==0 || j==5)) {
								sadari[i][j]  =3;
							}else if((i==c || i ==d)&& (j ==5 || j==10)) {
								sadari[i][j]  =3;
							}else if((i==e || i ==f)&& (j ==10 || j==15)) {
								sadari[i][j]  =3;
							}
						
						}
						
					}
					
					
					
					break;
				}else {
					continue;
				}
			
			}
		}else if(num3 ==5) {
			while(true) {
				if(a!=b && a!=c && a!=d &a!=e && a!=f && b!=c &&b!=d && b!=e && b!=f 
						&&c!=d && c!=e && c!=f &&d!=e &&d!=f && e!=f) {
					for(int i =0 ;i<sadari.length;i++) {
						
						for(int j =0 ;j<sadari[i].length;j++) {
							if((i==a || i ==b) && j>=1  && j<=4) {
								sadari[i][j]  =2;
							}else if((i==c || i ==d) && j>=6  && j<=9) {
								sadari[i][j]  =2;
							}else if((i==e || i ==f) && j>=11  && j<=14) {
								sadari[i][j]  =2;
							}else if((i==nn || i ==nn2) && j>=16  && j<=19) {
								sadari[i][j]  =2;
							}else if((i==a || i ==b) && (j ==0 || j==5)) {
								sadari[i][j]  =3;
							}else if((i==c || i ==d)&& (j ==5 || j==10)) {
								sadari[i][j]  =3;
							}else if((i==e || i ==f)&& (j ==10 || j==15)) {
								sadari[i][j]  =3;
							}else if((i==nn || i ==nn2)&& (j ==15 || j==20)) {
								sadari[i][j]  =3;
							}
						
						}
						
					}
					
					
					
					break;
				}else {
					continue;
				}
			
			}
			
		}
	
		
		///////////»ç´Ù¸®¸¸µë
		
		while(true) {
			if(num3 ==3) {
				System.out.println("=======»ç´Ù¸®°ÔÀÓ=========");
				System.out.println("¨ç¡¡¡¡¡¡¡¡¨è¡¡¡¡¡¡¡¡¨é");
				
			}else if(num3 ==4) {
				System.out.println("=======»ç´Ù¸®°ÔÀÓ=========");
				System.out.println("¨ç¡¡¡¡¡¡¡¡¨è¡¡¡¡¡¡¡¡¨é¡¡¡¡¡¡¡¡¨ê");
				
			}else if(num3 ==5) {
				System.out.println("=======»ç´Ù¸®°ÔÀÓ=========");
				System.out.println("¨ç¡¡¡¡¡¡¡¡¨è¡¡¡¡¡¡¡¡¨é¡¡¡¡¡¡¡¡¨ê¡¡¡¡¡¡¡¡¨ë");
				
			}

		for(int i =0 ;i<sadari.length;i++) {
				
				for(int j =0 ;j<sadari[i].length;j++) {
					
					if(sadari[i][j] ==1) {
						System.out.print("¤Ó");
					}else if(sadari[i][j] == 0) {
						System.out.print("¡¡");
				
					}else if (sadari[i][j]==2) {
						System.out.print("¤Ñ");
					}else if (sadari[i][j]==3) {
						System.out.print("¡Ú");
					}
					if(j==sadari[i].length-1) {
						System.out.println();
					}
					
		
				}
				
			}
		if(num3 ==3) {
			
			System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿");
			
		}else if(num3 ==4) {
			
			System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿");
			
		}else if(num3 ==5) {
			
			System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿");
			
		}
		
		System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
		System.out.println("¹øÈ£¸¦ ¼±ÅÃÇØ ÁÖ¼¼¿ä(1~»ç¶÷¼ö,´Ù¸¥¹øÈ£ÀÏ½Ã °ÔÀÓÁ¾·á) ");
		System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
		 int num = scan.nextInt();
		System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
		int ck2 =-1;
		if(num >=1 && num<=5) {
			
		}else {
			ck2=2;
			
		}
		if(ck2 ==2) {
			break;
		}
		///////////»ç´Ù¸®°ÔÀÓ ¸Þ´º
		int ck =-1;
		int find = 0;
	    
	    		 if(num ==1) {
	    			 find = 0;
	    			 s1 = num;
	    		 }else if(num==2) {
	    			 find = 5;
	    			 s2 = num;
	    		 }else if(num==3) {
	    			 find = 10;
	    			 s3 = num;
	    		 }else if(num==4) {
	    			 find = 15;
	    			 s4 = num;
	    		 }else if(num==5) {
	    			 find = 20;
	    			 s5 = num;
	    		 }
	    		 
	    		   if(num3 ==3) {
		    		    
		    	    	   if(g == s1 ) {
			    		    	 dang = 1;
			    		     }else if(g == s2) {
			    		    	 dang = 2;
			    		     }else if(g == s3) {
			    		    	 dang = 3;
			    		     }
		    	     }else if (num3==4) {
		    		     
		    	    	   if(g == s1 ) {
			    		    	 dang = 1;
			    		     }else if(g == s2) {
			    		    	 dang = 2;
			    		     }else if(g == s3) {
			    		    	 dang = 3;
			    		     }else if(g == s4 ) {
			    		    	 dang = 4;
			    		     }
		    	    	 
		    	     }else if (num3==5) {
		    		   
		    	    	   if(g == s1 ) {
			    		    	 dang = 1;
			    		     }else if(g == s2) {
			    		    	 dang = 2;
			    		     }else if(g == s3) {
			    		    	 dang = 3;
			    		     }else if(g == s4 ) {
			    		    	 dang = 4;
			    		     }else if(g == s5 ) {
			    		    	 dang = 5;
			    		     }
		    	     }
	    		 int star  = 0;
	             int xxx = 0;
	    		 while(true) {
	    			 while(true) {


	    					for(int i =xxx ;i<sadari.length;i++) {
	    					
	    							     if(sadari[i][find] == 3) {
	    							    	  star = i;
	    	    					    	
	    	    					    
	    	    					    	  break;
	    	    					      } if(sadari[i][find] != 3) {
	    	    					    	  star = 0;
	    	    					      }
	    							 
	    						
	    					}
	    					
	    					break;
	    					
	    				}
	    			 
	    	
	    			
							

	    				/*while(true) {
							   if((find -1)>0 &&find+1<sadari[0].length && sadari[star][find-1] != 2&& sadari[star][find+1] != 2 ) {
							    	  sadari[star][find] = 4;
							
							    	  xxx =star;
							   
							    	  break;
							    	
							      }else {
							    	  break;
							      }
								
							
						}*/

	    			 
	    			  for(int a1 =xxx ;a1<star;a1++) {
				    		 
		    			  sadari [a1][find] = 4;
		    			  
		    	  }
	    		
	    				
	    						while(true) {
	    							   if((find -1)>0 && sadari[star][find-1] == 2) {
	    							    	  sadari[star][find] = 4;
	    							    	  sadari[star][find -1] = 4;
	    							    	  sadari[star][find -2] = 4;
	    							    	  sadari[star][find -3] = 4;
	    							    	  sadari[star][find -4] = 4;
	    							    	  sadari[star][find -5] = 4;
	    							    	  xxx =star;
	    							    	  find = find -5;
	    							    	  break;
	    							    	
	    							      }else {
	    							    	  break;
	    							      }
	    								
	    							
	    						}
	    					   
	    					
	    						while(true) {
	    							 if( find+1<sadari[0].length&& sadari[star][find+1] == 2 ) {
	    						    	  sadari[star][find] = 4;
	    						    	  sadari[star][find +1] = 4;
	    						    	  sadari[star][find +2] = 4;
	    						    	  sadari[star][find +3] = 4;
	    						    	  sadari[star][find +4] = 4;
	    						    	  sadari[star][find + 5] = 4;
	    						    	  xxx =star;
	    						    	  find = find +5;
	    						    	  break;
	    						      }
	    							else {
	    							    	  break;
	    							      }
	    								
	    							
	    						}
	    				
	    						
	    				
	    						 if(star == 0  ) {
	    		    				 for(int i = xxx ;i<sadari.length;i++) {
	    		    					 sadari[i][find] = 4;
	    		    					 
	    		    					 
	    		    				 }
	    		    				
	    		    				star = 0;
	    		    				break;
	    		    				
	    		 }
	    					
	    			
	    						 
	    		 }
	    		
	    			
	    			for(int i =0 ;i<sadari.length;i++) {
	    				
	    				for(int j =0 ;j<sadari[i].length;j++) {
	    					
	    					if(sadari[i][j] ==1) {
	    						System.out.print("¤Ó");
	    					}else if(sadari[i][j] == 0) {
	    						System.out.print("¡¡");
	    				
	    					}else if (sadari[i][j]==2) {
	    						System.out.print("¤Ñ");
	    					}else if (sadari[i][j]==3) {
	    						System.out.print("¡Ú");
	    					}else if (sadari[i][j]==4) {
	    						System.out.print("¢¾");
	    					}
	    					if(j==(sadari[i].length -1)) {
	    						System.out.println();
	    					}
	    					

	    				}
	    				
	    			}
	    			if(num3==3) {
	    				 if(star == 0 &&num == dang) {
	    	   				 if(sadari[sadari.length-1][0] == 4) {
	    	   					System.out.println("¨Û¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä");
	    	   				 }else if(sadari[sadari.length-1][5] == 4) {
	    	   					System.out.println("¨ä¡¡¡¡¡¡¡¡¨Û¡¡¡¡¡¡¡¡¨ä");
	    		   				 }else if(sadari[sadari.length-1][10] == 4) {
	    		   					System.out.println("¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨Û"); 
	    		   				 }
	    	   				System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 System.out.println("ÃàÇÏÇÕ´Ï´Ù.("+ num +"¹ø )"+list.get(log).getID()+  "´Ô ´çÃ·!(50Á¡ È¹µæ)");
	    					 System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 score[log] = score[log]+50;
	    					
	    					 
	    					 ck=1;
	    				
	    				 }else if (star == 0 &&num != dang){
	    					 if(sadari[sadari.length-1][0] == 4) {
	    						 System.out.println("¨ä¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿"); 
	    		   				 }else if(sadari[sadari.length-1][5] == 4) {
	    		   					System.out.println("£¿¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡£¿"); 
	    			   				 }else if(sadari[sadari.length-1][10] == 4) {
	    			   					System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡¨ä");	 
	    			   				 }
	    					 System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 System.out.println("¾ÈÅ¸±õ½À´Ï´Ù.("+ num +"¹ø )"+list.get(log).getID()+  "´Ô ²Î!(-10Á¡ È¹µæ)");
	    					 System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 score[log] = score[log]-10;
	    					
	    				 }
	    			}
	    			else if(num3 ==5) {
	    				 if(star == 0 &&num == dang) {
	    	   				 if(sadari[sadari.length-1][0] == 4) {
	    	   					System.out.println("¨Û¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä");
	    	   				 }else if(sadari[sadari.length-1][5] == 4) {
	    	   					System.out.println("¨ä¡¡¡¡¡¡¡¡¨Û¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä");
	    		   				 }else if(sadari[sadari.length-1][10] == 4) {
	    		   					System.out.println("¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨Û¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä"); 
	    		   				 }else if(sadari[sadari.length-1][15] == 4) {
	    		   					System.out.println("¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨Û¡¡¡¡¡¡¡¡¨ä"); 
	    		   				 }else if(sadari[sadari.length-1][20] == 4) {
		    		   					System.out.println("¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡¨Û"); 
		    		   				 }
	    	   				
	    	   				System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 System.out.println("ÃàÇÏÇÕ´Ï´Ù.("+ num +"¹ø )"+list.get(log).getID()+  "´Ô ´çÃ·!(50Á¡ È¹µæ)");
	    					 System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 score[log] = score[log]+50;
	    					
	    					 
	    					 ck=1;
	    				
	    				 }else if (star == 0 &&num != dang){
	    					 if(sadari[sadari.length-1][0] == 4) {
	    						 System.out.println("¨ä¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿"); 
	    		   				 }else if(sadari[sadari.length-1][5] == 4) {
	    		   					System.out.println("£¿¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿"); 
	    			   				 }else if(sadari[sadari.length-1][10] == 4) {
	    			   					System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿");	 
	    			   				 }else if(sadari[sadari.length-1][15] == 4) {
	    			   					System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡£¿");	 
	    			   				 }else if(sadari[sadari.length-1][20] == 4) {
		    			   					System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡¨ä");	 
		    			   				 }
	    					 System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 System.out.println("¾ÈÅ¸±õ½À´Ï´Ù.("+ num +"  ¹ø )"+list.get(log).getID()+  "´Ô ²Î!(-10Á¡ È¹µæ)");
	    					 System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 score[log] = score[log]-10;
	    					
	    				 }
	    			}else if(num3==4) {
	    				 if(star == 0 &&num == dang) {
	    	   				 if(sadari[sadari.length-1][0] == 4) {
	    	   					System.out.println("¨Û¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿");
	    	   				 }else if(sadari[sadari.length-1][5] == 4) {
	    	   					System.out.println("£¿¡¡¡¡¡¡¡¡¨Û¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿");
	    		   				 }else if(sadari[sadari.length-1][10] == 4) {
	    		   					System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡¨Û¡¡¡¡¡¡¡¡£¿"); 
	    		   				 }else if(sadari[sadari.length-1][15] == 4) {
	    		   					System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡¨Û"); 
	    		   				 }
	    	   				
	    	   				System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 System.out.println("ÃàÇÏÇÕ´Ï´Ù.("+ num +"  ¹ø )"+list.get(log).getID()+  "´Ô ´çÃ·!(50Á¡ È¹µæ)");
	    					 System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 score[log] = score[log]+50;
	    					
	    					 
	    					 ck=1;
	    				
	    				 }else if (star == 0 &&num != dang){
	    					 if(sadari[sadari.length-1][0] == 4) {
	    						 System.out.println("¨ä¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿"); 
	    		   				 }else if(sadari[sadari.length-1][5] == 4) {
	    		   					System.out.println("£¿¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿"); 
	    			   				 }else if(sadari[sadari.length-1][10] == 4) {
	    			   					System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡¨ä¡¡¡¡¡¡¡¡£¿");	 
	    			   				 }else if(sadari[sadari.length-1][15] == 4) {
	    			   					System.out.println("£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡£¿¡¡¡¡¡¡¡¡¨ä");	 
	    			   				 }
	    					 System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 System.out.println("¾ÈÅ¸±õ½À´Ï´Ù.("+ num +"  ¹ø )"+list.get(log).getID()+  "´Ô ²Î!(-10Á¡ È¹µæ)");
	    					 System.out.println("¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û¡Û");
	    					 score[log] = score[log]-10;
	    					
	    				 }
	    			}
	   	
	    			//°á°ú
	    			 if(ck ==1) {
		    			 break;
		    		 }
		    		 
	    			for(int i =0 ;i<sadari.length;i++) {
	    				
	    				for(int j =0 ;j<sadari[i].length;j++) {
	    					
	    					if(j==0||j%5==0) {
	    						sadari[i][j] = 1;
	    					}else {
	    						sadari[i][j] =0;
	    					}
	    		
	    				}
	    				
	    			}
	    			
	    			if(num3 ==3) {
	    				while(true) {
	    					if(a!=b && a!=c && a!=d &a!=e && a!=f && b!=c &&b!=d && b!=e && b!=f 
	    							&&c!=d && c!=e && c!=f &&d!=e &&d!=f && e!=f) {
	    						for(int i =0 ;i<sadari.length;i++) {
	    							
	    							for(int j =0 ;j<sadari[i].length;j++) {
	    								if((i==a || i ==b) && j>=1  && j<=4) {
	    									sadari[i][j]  =2;
	    								}else if((i==c || i ==d) && j>=6  && j<=9) {
	    									sadari[i][j]  =2;
	    								}else if((i==a || i ==b) && (j ==0 || j==5)) {
	    									sadari[i][j]  =3;
	    								}else if((i==c || i ==d)&& (j ==5 || j==10)) {
	    									sadari[i][j]  =3;
	    								}
	    							
	    							}
	    							
	    						}
	    						
	    						
	    						
	    						break;
	    					}else {
	    						continue;
	    					}
	    				
	    				}
	    				
	    			}else if(num3 ==4) {
	    				while(true) {
	    					if(a!=b && a!=c && a!=d &a!=e && a!=f && b!=c &&b!=d && b!=e && b!=f 
	    							&&c!=d && c!=e && c!=f &&d!=e &&d!=f && e!=f) {
	    						for(int i =0 ;i<sadari.length;i++) {
	    							
	    							for(int j =0 ;j<sadari[i].length;j++) {
	    								if((i==a || i ==b) && j>=1  && j<=4) {
	    									sadari[i][j]  =2;
	    								}else if((i==c || i ==d) && j>=6  && j<=9) {
	    									sadari[i][j]  =2;
	    								}else if((i==e || i ==f) && j>=11  && j<=14) {
	    									sadari[i][j]  =2;
	    								}else if((i==a || i ==b) && (j ==0 || j==5)) {
	    									sadari[i][j]  =3;
	    								}else if((i==c || i ==d)&& (j ==5 || j==10)) {
	    									sadari[i][j]  =3;
	    								}else if((i==e || i ==f)&& (j ==10 || j==15)) {
	    									sadari[i][j]  =3;
	    								}
	    							
	    							}
	    							
	    						}
	    						
	    						
	    						
	    						break;
	    					}else {
	    						continue;
	    					}
	    				
	    				}
	    			}else if(num3 ==5) {
	    				while(true) {
	    					if(a!=b && a!=c && a!=d &a!=e && a!=f && b!=c &&b!=d && b!=e && b!=f 
	    							&&c!=d && c!=e && c!=f &&d!=e &&d!=f && e!=f) {
	    						for(int i =0 ;i<sadari.length;i++) {
	    							
	    							for(int j =0 ;j<sadari[i].length;j++) {
	    								if((i==a || i ==b) && j>=1  && j<=4) {
	    									sadari[i][j]  =2;
	    								}else if((i==c || i ==d) && j>=6  && j<=9) {
	    									sadari[i][j]  =2;
	    								}else if((i==e || i ==f) && j>=11  && j<=14) {
	    									sadari[i][j]  =2;
	    								}else if((i==nn || i ==nn2) && j>=16  && j<=19) {
	    									sadari[i][j]  =2;
	    								}else if((i==a || i ==b) && (j ==0 || j==5)) {
	    									sadari[i][j]  =3;
	    								}else if((i==c || i ==d)&& (j ==5 || j==10)) {
	    									sadari[i][j]  =3;
	    								}else if((i==e || i ==f)&& (j ==10 || j==15)) {
	    									sadari[i][j]  =3;
	    								}else if((i==nn || i ==nn2)&& (j ==15 || j==20)) {
	    									sadari[i][j]  =3;
	    								}
	    							
	    							}
	    							
	    						}
	    						
	    						
	    						
	    						break;
	    					}else {
	    						continue;
	    					}
	    				
	    				}
	    				
	    			}
	    					
	    					
	    					
	    		
	    			//ÃÊ±âÈ­
	    		 
	    		
		}
	}
}
