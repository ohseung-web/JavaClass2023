package omokgame;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class game extends Omokpan {
	int ck =-1;
	int nck =-1;
    
	int bs;
	int ws;
	int bx;
	int by;
	int ax;
	int ay;
	
	public void Game() {
		 
		while(true) {
			while(true) {
				
				System.out.println("===========================");
				System.out.println(list.get(log).getID()+"�� �ٵϵ��� ���� X��ǥ�� �Է��ϼ���(1~13,�ƴҽ� ��������)");
				System.out.println("===========================");
				 ax =scan.nextInt();
				 if(ax >=1 && ax<=13 ) {
					 ax=ax;
					 
				 }else {
					 ck=2;
				 	break;
				 }
				System.out.println("===========================");
				System.out.println(list.get(log).getID()+"�� �ٵϵ��� ���� X��ǥ�� �Է��ϼ���(1~13,�ƴҽ� ��������)");
				System.out.println("===========================");
				 ay =scan.nextInt();
				
				 if(ay >=1 && ay<=13 ) {
					 ay=ay;
					 
				 }else {
					 ck=2;
				 	break;
				 }
				 
				if(omok[ax-1][ay-1] == 1) {
					omok[ax-1][ay-1] = 2;
					
				}else {
					System.out.println();
					System.out.println("���ڸ��� ������ �����ϴ١�");
					System.out.println();
					continue;
				}
				
			
			
				System.out.println("[ 1][ 2 ][ 3][4 ][5 ][6 ][7 ][8 ][9 ][10][11][12][13]");
				for(int i =0;i<omok.length;i++) {
					for(int j =0;j<omok.length;j++) {
						if(omok[i][j] == 1) {
							System.out.print("[��]");
							
						}else if(omok[i][j] == 2) {
							System.out.print("[��]");
						}else if(omok[i][j] == 3) {
							System.out.print("[��]");
						}
						
						
					}
					
					 if(omok[i][0] == omok[i][0] ) {
						 System.out.println("["+(i+1)+"]");
					}
				}
				
				
				
				for(int i =0;i<omok.length-5;i++) {
					for(int j =0;j<omok.length;j++) {
						if(omok[i][j] == 2 && omok[i+1][j] == 2 && omok[i+2][j] == 2 && omok[i+3][j] == 2 && omok[i+4][j] == 2 ) {
							System.out.println("==============");
							System.out.println("BINGO!");
							System.out.println(list.get(log).getID()+"�� �¸�!");
							System.out.println("===============");
							score[log] = score[log] +10;
							ck=1;
							break;
						}
					}
						
				}
				
				
				
				
				
				for(int i =0;i<omok.length;i++) {
					for(int j =0;j<omok.length-5;j++) {
						if(omok[i][j] == 2 && omok[i][j+1] == 2 && omok[i][j+2] == 2 && omok[i][j+3] == 2 && omok[i][j+4] == 2 ) {
							System.out.println("==============");
							System.out.println("BINGO!");
							System.out.println(list.get(log).getID()+"�� �¸�!");
							System.out.println("===============");
							ck=1;
							score[log] = score[log] +10;
							break;
							
						}
					}
						
				}
	
				

			
	
				

		
	
				for(int i =0;i<omok.length-4;i++) {
					for(int j =0;j<omok.length-4;j++) {
						if(omok[i][j] == 2 && omok[i+1][j+1] == 2 && omok[i+2][j+2] == 2 && omok[i+3][j+3] == 2 && omok[i+4][j+4] == 2 ) {
							System.out.println("==============");
							System.out.println("BINGO!");
							System.out.println(list.get(log).getID()+"�� �¸�!");
							System.out.println("===============");
							ck=1;
							score[log] = score[log] +10;
							break;
						}
					}
						
				}
				
				for(int i =0;i<omok.length-4;i++) {
					for(int j =omok.length-1;j>=3;j--) {
						if(omok[i][j] == 2 && omok[i+1][j-1] == 2 && omok[i+2][j-2] == 2 && omok[i+3][j-3] == 2 && omok[i+4][j-4] == 2 ) {
							System.out.println("==============");
							System.out.println("BINGO!");
							System.out.println(list.get(log).getID()+"�� �¸�!");
							System.out.println("===============");
							ck=1;
							score[log] = score[log] +10;
							break;
						}
					}
						
				}
				
				
				
				
				
				
				
				
				
				
				
				break;
				
			}
			
			if(ck==1) {
				System.out.println("�������!");
				bs = bs+1;
				ck=-1;
				break;
			}	if(ck==2) {
				ck = -1;
				break;
			}
			
			while(true) {
				
				bx=random.nextInt(13)+1;
				by=random.nextInt(13)+1;
				
				if(bx < ax+2 && bx >ax-2&&by < ay+2 && by >ay - 2) {
					
					if(omok[bx-1][by-1]== 1 && bx !=ax && by !=ay)  {
					
omok[bx-1][by-1] =3;
						while(true) {
							for(int i =0;i<omok.length-5;i++) {
								for(int j =0;j<omok.length;j++) {
									if(omok[i][j] == 2 && omok[i+1][j] == 2 && omok[i+2][j] == 2 &&  	omok[i+3][j] == 1&& i+3<14) {
									
										omok[i+3][j] = 3;
										
										omok[bx-1][by-1] =1;
										bx = i+3; 
										by = j;
										nck=1;
									}else	 if(omok[i][j] == 2 && omok[i+1][j] == 2 && omok[i+2][j] == 2 &&  	omok[i+3][j] == 1&& i>=11) {
										
										omok[i-1][j] = 3;
										omok[bx-1][by-1] =1;
										bx = i-1; 
										by = j;
										nck=1;
									}
								}
									
							}
							if(nck==1) {
								nck =-1;
								break;
							}
						for(int i =0;i<omok.length;i++) {
							for(int j =0;j<omok.length-5;j++) {
								if(omok[i][j] == 2 && omok[i][j+1] == 2 && omok[i][j+2] == 2  &&omok[i][j+3] == 1  ) {
									omok[i][j+3] = 3;
									omok[bx-1][by-1] =1;
									bx = i; 
									by = j+3;
									nck=1;
								}
							}
								
						}
						if(nck==1) {
							nck =-1;
							break;
						}
						for(int i =0;i<omok.length-4;i++) {
							for(int j =0;j<omok.length-4;j++) {
								if(omok[i][j] == 2 && omok[i+1][j+1] == 2 && omok[i+2][j+2] == 2 &&omok[i+3][j+3] ==1 ) {
									omok[i+3][j+3] = 3;
									omok[bx-1][by-1] =1;
									bx = i+3; 
									by = j+3;
								nck=1;
								}
							}
						
								
						}
						if(nck==1) {
							nck =-1;
							break;
						}
						for(int i =0;i<omok.length-4;i++) {
							for(int j =omok.length-1;j>=3;j--) {
								if(omok[i][j] == 2 && omok[i+1][j-1] == 2 && omok[i+2][j-2] == 2 && omok[i+3][j-3] == 1) {
									omok[i+3][j-3] = 3;
									
									omok[bx-1][by-1] =1;
									bx = i+3; 
									by = j-3;
								nck=1;	
								}
							}
								
						}
						if(nck==1) {
							nck =-1;
							break;
						}			
						//3������
						 for(int i =0;i<omok.length-5;i++) {
							 if(i-1>=0) {
								 
								 for(int j =0;j<omok.length;j++) {
										if(omok[i][j] == 2 && omok[i+1][j] == 2 && omok[i+2][j] == 2 && omok[i+3][j] == 2 && omok[i-1][j] == 1 ) {
											omok[i-1][j] = 3;
											omok[bx-1][by-1] =1;
											bx = i-1; 
											by = j;
											nck=1;
										}
									}
							
							 }
								
									
							}
						 if(nck==1) {
								nck =-1;
								break;
							}
						 for(int i =0;i<omok.length;i++) {
								for(int j =0;j<omok.length-5;j++) {
									if(j-1>=0) {
										if(omok[i][j] == 2 && omok[i][j+1] == 2 && omok[i][j+2] == 2 && omok[i][j+3] == 2 && omok[i][j-1] == 1 ) {
											omok[i][j-1]  = 3;
											omok[bx-1][by-1] =1;
											bx = i; 
											by = j-1;
										nck=1;
										}
										
									}
									
								}
									
							}
						
						 if(nck==1) {
								nck =-1;
								break;
							}
							for(int i =0;i<omok.length-4;i++) {
								
								for(int j =0;j<omok.length-4;j++) {
									if(j-1>=0&&i-1>=0) {
										
										if(omok[i][j] == 2 && omok[i+1][j+1] == 2 && omok[i+2][j+2] == 2 && omok[i+3][j+3] == 2 && omok[i-1][j-1] == 1 ) {
											omok[i-1][j-1] = 3 ;
											omok[bx-1][by-1] =1;
											bx = i-1; 
											by = j-1;
										nck=1;
										}
									}
								
								}
									
							}
							if(nck==1) {
								nck =-1;
								break;
							}
							for(int i =0;i<omok.length-4;i++) {
								for(int j =omok.length-1;j>=3;j--) {
									if(i-1>=0) {
										if(omok[i][j] == 2 && omok[i+1][j-1] == 2 && omok[i+2][j-2] == 2 && omok[i+3][j-3] == 2 && omok[i-1][j+1] == 1 ) {
											omok[i-1][j+1]  =3;
												omok[bx-1][by-1] =1;
												bx = i-1; 
												by = j+1;
										nck=1;
										}
									}
								
								}
									
							}
							if(nck==1) {
								nck =-1;
								break;
							}
							//4������
							 for(int i =0;i<omok.length-5;i++) {
								 if(i-1>=0) {
									 
									 for(int j =0;j<omok.length;j++) {
											if(omok[i][j] == 2 && omok[i+1][j] == 2 && omok[i+3][j] == 2 && omok[i+4][j] == 2 && omok[i+2][j] == 1 ) {
												omok[i+2][j] = 3;
												omok[bx-1][by-1] =1;
												bx = i+2; 
												by = j;
												nck=1;
											}
										}
								
								 }
									
										
								}
							 if(nck==1) {
									nck =-1;
									break;
								}
							 for(int i =0;i<omok.length;i++) {
									for(int j =0;j<omok.length-5;j++) {
										if(j-1>=0) {
											if(omok[i][j] == 2 && omok[i][j+1] == 2 && omok[i][j+3] == 2 && omok[i][j+4] == 2 && omok[i][j+2] == 1 ) {
												omok[i][j+2]  = 3;
												omok[bx-1][by-1] =1;
												bx = i; 
												by = j+2;
												nck=1;
											}
											
										}
										
									}
										
								}
							 if(nck==1) {
									nck =-1;
									break;
								}
								for(int i =0;i<omok.length-4;i++) {
									
									for(int j =0;j<omok.length-4;j++) {
										if(j-1>=0&&i-1>=0) {
											
											if(omok[i][j] == 2 && omok[i+1][j+1] == 2 && omok[i+3][j+3] == 2 && omok[i+4][j+4] == 2 && omok[i+2][j+2] == 1 ) {
												omok[i+2][j+2] = 3 ;
												omok[bx-1][by-1] =1;
												bx = i+2; 
												by = j+2;
											nck=1;
											}
										}
									
									}
										
								}
								if(nck==1) {
									nck =-1;
									break;
								}
								for(int i =0;i<omok.length-4;i++) {
									for(int j =omok.length-1;j>=3;j--) {
										if(j-4>=0) {
											if(omok[i][j] == 2 && omok[i+1][j-1] == 2 && omok[i+3][j-3] == 2 && omok[i+4][j-4] == 2 && omok[i+2][j-2] == 1 ) {
												omok[i+2][j-2]  =3;
													omok[bx-1][by-1] =1;
													bx = i+2; 
													by = j-2;
													nck=1;
											}
										}
									
									}
										
								}
								if(nck==1) {
									nck =-1;
									break;
								}
								//2�� 2�� �J���� �߰��� �����ڵ�
								
								 for(int i =0;i<omok.length-5;i++) {
								
										 
										 for(int j =0;j<omok.length;j++) {
												if(omok[i][j] == 2 && omok[i+2][j] == 2 && omok[i+3][j] == 2 && omok[i+4][j] == 2 && omok[i+1][j] == 1 ) {
													omok[i+1][j] = 3;
													omok[bx-1][by-1] =1;
													bx = i+1; 
													by = j;
												nck=1;
												}
											}
									
									 
										
											
									}
								 if(nck==1) {
										nck =-1;
										break;
									}
								 for(int i =0;i<omok.length;i++) {
										for(int j =0;j<omok.length-5;j++) {
											if(j-1>=0) {
												if(omok[i][j] == 2 && omok[i][j+2] == 2 && omok[i][j+3] == 2 && omok[i][j+4] == 2 && omok[i][j+1] == 1 ) {
													omok[i][j+1]  = 3;
													omok[bx-1][by-1] =1;
													bx = i; 
													by = j;
													nck=1;
												}
												
											}
											
										}
											
									}
								 if(nck==1) {
										nck =-1;
										break;
									}
									for(int i =0;i<omok.length-4;i++) {
										
										for(int j =0;j<omok.length-4;j++) {
											if(j-1>=0&&i-1>=0) {
												
												if(omok[i][j] == 2 && omok[i+2][j+2] == 2 && omok[i+3][j+3] == 2 && omok[i+4][j+4] == 2 && omok[i+1][j+1] == 1 ) {
													omok[i+1][j+1] = 3 ;
													omok[bx-1][by-1] =1;
													bx = i+1; 
													by = j+1;
												nck=1;
												}
											}
										
										}
											
									}
									if(nck==1) {
										nck =-1;
										break;
									}
									for(int i =0;i<omok.length-4;i++) {
										for(int j =omok.length-1;j>=3;j--) {
											if(j-4>=0) {
												if(omok[i][j] == 2 && omok[i+2][j-2] == 2 && omok[i+3][j-3] == 2 && omok[i+4][j-4] == 2 && omok[i+1][j-1] == 1 ) {
													omok[i+1][j-1]  =3;
														omok[bx-1][by-1] =1;
														bx = i+1; 
														by = j-1;
												nck=1;
												}
											}
										
										}
											
									}
									if(nck==1) {
										nck =-1;
										break;
									}
									//1�� 3���J���� �ڵ�
									 for(int i =0;i<omok.length-5;i++) {
										 if(i-1>=0) {
											 
											 for(int j =0;j<omok.length;j++) {
													if(omok[i][j] == 2 && omok[i+2][j] == 2 && omok[i+1][j] == 2 && omok[i+4][j] == 2 && omok[i+3][j] == 1 ) {
														omok[i+3][j] = 3;
														omok[bx-1][by-1] =1;
														bx = i+3; 
														by = j;
													nck=1;
													}
												}
										
										 }
											
												
										}
									 if(nck==1) {
											nck =-1;
											break;
										}
									 for(int i =0;i<omok.length;i++) {
											for(int j =0;j<omok.length-5;j++) {
												if(j-1>=0) {
													if(omok[i][j] == 2 && omok[i][j+2] == 2 && omok[i][j+1] == 2 && omok[i][j+4] == 2 && omok[i][j+3] == 1 ) {
														omok[i][j+3]  = 3;
														omok[bx-1][by-1] =1;
														bx = i; 
														by = j+3;
													nck=1;
													}
													
												}
												
											}
												
										}
									 if(nck==1) {
											nck =-1;
											break;
										}
										for(int i =0;i<omok.length-4;i++) {
											
											for(int j =0;j<omok.length-4;j++) {
												if(j-1>=0&&i-1>=0) {
													
													if(omok[i][j] == 2 && omok[i+2][j+2] == 2 && omok[i+1][j+1] == 2 && omok[i+4][j+4] == 2 && omok[i+3][j+3] == 1 ) {
														omok[i+3][j+3] = 3 ;
														omok[bx-1][by-1] =1;
														bx = i+3; 
														by = j+3;
													nck =1;
													}
												}
											
											}
												
										}
										if(nck==1) {
											nck =-1;
											break;
										}
										for(int i =0;i<omok.length-4;i++) {
											for(int j =omok.length-1;j>=3;j--) {
												if(j-4>=0) {
													if(omok[i][j] == 2 && omok[i+1][j-1] == 2 && omok[i+2][j-2] == 2 && omok[i+4][j-4] == 2 && omok[i+3][j-3] == 1 ) {
														omok[i+3][j-3]  =3;
															omok[bx-1][by-1] =1;
															bx = i+3; 
															by = j-3;
															nck=1;
													}
												}
											
											}
												
										}
										if(nck==1) {
											nck =-1;
											break;
										}
										//3�� 1�� �J���� �ڵ�
										 for(int i =0;i<omok.length-5;i++) {
									
												 
												 for(int j =0;j<omok.length;j++) {
														if(omok[i][j] == 2 && omok[i+2][j] == 2 && omok[i+3][j] == 2  && omok[i+1][j] == 1 ) {
															omok[i+1][j] = 3;
															omok[bx-1][by-1] =1;
															bx = i+1; 
															by = j;
															nck=1;
														}
													}
											
											 
												
													
											}
										 if(nck==1) {
												nck =-1;
												break;
											}
										 for(int i =0;i<omok.length;i++) {
												for(int j =0;j<omok.length-5;j++) {
													if(j-1>=0) {
														if(omok[i][j] == 2 && omok[i][j+2] == 2 && omok[i][j+3] == 2 &&  omok[i][j+1] == 1 ) {
															omok[i][j+1]  = 3;
															omok[bx-1][by-1] =1;
															bx = i; 
															by = j+1;
														nck=1;
														}
														
													}
													
												}
													
											}
										 if(nck==1) {
												nck =-1;
												break;
											}
											for(int i =0;i<omok.length-4;i++) {
												
												for(int j =0;j<omok.length-4;j++) {
													if(j-1>=0&&i-1>=0) {
														
														if(omok[i][j] == 2 && omok[i+2][j+2] == 2 && omok[i+3][j+3] == 2  && omok[i+1][j+1] == 1 ) {
															omok[i+1][j+1] = 3 ;
															omok[bx-1][by-1] =1;
															bx = i+1; 
															by = j+1;
															nck=1;
														}
													}
												
												}
													
											}
											if(nck==1) {
												nck =-1;
												break;
											}
											for(int i =0;i<omok.length-4;i++) {
												for(int j =omok.length-1;j>=3;j--) {
													
														if(omok[i][j] == 2 && omok[i+2][j-2] == 2 && omok[i+3][j-3] == 2 && omok[i+1][j-1] == 1 ) {
															omok[i+1][j-1]  =3;
																omok[bx-1][by-1] =1;
																bx = i+1; 
																by = j-1;
																nck=1;
														}
													
												
												}
													
											}
											if(nck==1) {
												nck =-1;
												break;
											}
											//1�� 2���J���� �ڵ�
											 for(int i =0;i<omok.length-5;i++) {
												
													 
													 for(int j =0;j<omok.length;j++) {
															if(omok[i][j] == 2  && omok[i+1][j] == 2 && omok[i+3][j] == 2 && omok[i+2][j] == 1 ) {
																omok[i+2][j] = 3;
																omok[bx-1][by-1] =1;
																bx = i+2; 
																by = j;
															nck=1;
															}
														}
												
												 
													
														
												}
											 if(nck==1) {
													nck =-1;
													break;
												}
											 for(int i =0;i<omok.length;i++) {
													for(int j =0;j<omok.length-5;j++) {
														if(j-1>=0) {
															if(omok[i][j] == 2  && omok[i][j+1] == 2 && omok[i][j+3] == 2 && omok[i][j+2] == 1 ) {
																omok[i][j+2]  = 3;
																omok[bx-1][by-1] =1;
																bx = i; 
																by = j+2;
															nck=1;
															}
															
														}
														
													}
														
												}
											 if(nck==1) {
													nck =-1;
													break;
												}
												for(int i =0;i<omok.length-4;i++) {
													
													for(int j =0;j<omok.length-4;j++) {
														if(j-1>=0&&i-1>=0) {
															
															if(omok[i][j] == 2  && omok[i+1][j+1] == 2 && omok[i+3][j+3] == 2 && omok[i+2][j+2] == 1 ) {
																omok[i+2][j+2] = 3 ;
																omok[bx-1][by-1] =1;
																bx = i+2; 
																by = j+2;
																nck=1;
															}
														}
													
													}
														
												}
												if(nck==1) {
													nck =-1;
													break;
												}
												for(int i =0;i<omok.length-4;i++) {
													for(int j =omok.length-1;j>=3;j--) {
														if(j-4>=0) {
															if(omok[i][j] == 2 && omok[i+1][j-1] == 2 && omok[i+3][j-3] == 2  && omok[i+2][j-2] == 1 ) {
																omok[i+2][j-2]  =3;
																	omok[bx-1][by-1] =1;
																	bx = i+2; 
																	by = j-2;
																	nck=1;
															}
														}
													
													}
														
												}
												if(nck==1) {
													nck =-1;
													break;
												}
												//2�� 1���J���� �ڵ�
												break;
						}
					
						 bx= bx+1;
						 by = by+1;
						
												
					}else {
					
						continue;
					}
					
					
				}else {
					continue;
				}
				System.out.println("======================");
				System.out.println("��ǻ�ʹ��� ��ǥ:" +(bx)+","+(by) );
				System.out.println("======================");
				System.out.println("[ 1][ 2 ][ 3][4 ][5 ][6 ][7 ][8 ][9 ][10][11][12][13]");
				for(int i =0;i<omok.length;i++) {
					for(int j =0;j<omok.length;j++) {
						if(omok[i][j] == 1) {
							System.out.print("[��]");
							
						}else if(omok[i][j] == 2) {
							System.out.print("[��]");
						}else if(omok[i][j] == 3) {
							System.out.print("[��]");
						}
						
						
					}
					
					 if(omok[i][0] == omok[i][0] ) {
						 System.out.println("["+(i+1)+"]");
					}
				}
				
				for(int i =0;i<omok.length-5;i++) {
					for(int j =0;j<omok.length;j++) {
						if(omok[i][j] == 3 && omok[i+1][j] == 3 && omok[i+2][j] == 3 && omok[i+3][j] == 3 && omok[i+4][j] == 3 ) {
							System.out.println("==============");
							System.out.println("BINGO ��ǻ�ʹ� �¸�!");
							System.out.println("===============");
							ck=1;
							break;
						}
					}
						
				}
				
				
				
				
				
				for(int i =0;i<omok.length;i++) {
					for(int j =0;j<omok.length-5;j++) {
						if(omok[i][j] == 3 && omok[i][j+1] == 3 && omok[i][j+2] == 3 && omok[i][j+3] == 3 && omok[i][j+4] == 3) {
							System.out.println("==============");
							System.out.println("BINGO ��ǻ�ʹ� �¸�!");
							System.out.println("===============");
							ck=1;
							break;
						}
					}
						
				}
				
				for(int i =0;i<omok.length-5;i++) {
					for(int j =0;j<omok.length-5;j++) {
						if(omok[i][j] == 3 && omok[i+1][j+1] == 3 && omok[i+2][j+2] == 3 && omok[i+3][j+3] == 3 && omok[i+4][j+4] == 3) {
							System.out.println("==============");
							System.out.println("BINGO ��ǻ�ʹ� �¸�!");
							System.out.println("===============");
							ck=1;
							break;
						}
					}
						
				}
				
				for(int i =0;i<omok.length-4;i++) {
					for(int j =omok.length-1;j>=3;j--) {
						if(omok[i][j] == 3 && omok[i+1][j-1] == 3 && omok[i+2][j-2] == 3 && omok[i+3][j-3] == 3 && omok[i+4][j-4] == 3 ) {
							System.out.println("==============");
							System.out.println("BINGO ��ǻ�ʹ� �¸�!");
							System.out.println("===============");
							ck=1;
							break;
						}
					}
						
				}
				
				
				break;
			}
			if(ck==1) {
				System.out.println("�������!");
				ws = ws+1;
				ck =-1;
				break;
			}
			
	
		}
		
		
	}


	
	
	

}
