package megaMovie;
import java.text.*;
import java.util.*;

public class AdminMenu {
	
	AdminVO admin = new AdminVO();
	MovieMenu movieMenu = new MovieMenu();
	Scanner scan = new Scanner(System.in);
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd(E)");
	SimpleDateFormat f2 = new SimpleDateFormat("HH:mm");
	SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss");
	DecimalFormat de = new DecimalFormat("#,##0");
	Calendar cal = Calendar.getInstance();
	String menu = "[1]예매현황\n[2]회원목록\n[3]포인트이용현황\n[4]영화목록\n[5]이전";
	
//	관리자 화면
	public void adminMenu() {
		while(true) {
			System.out.println();
			System.out.println("---[관리자 메뉴]---");
			System.out.println(menu);
			System.out.print("메뉴 선택: ");
			int select = scan.nextInt();
			if(select==1) {
				ticket();
			} else if(select==2) {
				userList();
			} else if(select==3) {
				point();
			} else if(select==4) {
				movieList();
			} else if(select==5) {
				System.out.println("관리자 메뉴를 종료합니다.");
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
//	관리자 로그인
	public void adminLogin() {
		System.out.print("Admin ID: ");
		String adminId = scan.next();
		System.out.print("Admin PW: ");
		String adminPw = scan.next();
		
		if(adminId.equals(admin.getAdminId()) && adminPw.equals(admin.getAdminPw())) {
			System.out.println("관리자 로그인 성공");
			adminMenu();
		} else {
			System.out.println("관리자가 아닙니다.");
		}
	}
	
//	예매현황
	public void ticket() {
		if(movieMenu.ticketing.size()==0) {
			System.out.println("예매현황이 존재하지 않습니다...");
		}else {
			while(true) {
				System.out.println();
				System.out.println("[1]영화별 예매현황\n[2]회원별 예매현황\n[3]극장당 남은 좌석\n[4]이전");
				System.out.print("메뉴 선택: ");
				int select = scan.nextInt();
				if(select==1) {
					while(true) {
						System.out.println();
						int cnt = 1;
						for(int i=0; i<movieMenu.getMovie().length; i++) {
							System.out.printf("[%d]%s\n", cnt, movieMenu.getMovie()[i]);
							cnt++;
						}
						System.out.printf("[%d]이전\n", cnt);
						System.out.print("영화 선택: ");
						int select3 = scan.nextInt();
						if(select3==cnt) {
							break;
						} else if(select3<cnt && select3>0) {
							cnt=1;
							System.out.println();
							System.out.printf("                                            --[%s]--\n", movieMenu.getMovie()[select3-1]);
							System.out.println("-------------------------------------------------------------------------------------------------------------");
							System.out.println("번호 회원ID\t영화관(지역)\t예매일\t\t\t영화 상영일\t상영시간\t\t예매 매수\t총 금액\t포인트");
							for(int i=0; i<movieMenu.ticketing.size(); i++) {
								if(movieMenu.ticketing.get(i).getName().equals(movieMenu.getMovie()[select3-1])) {
									int mo = -1;
									for(int j=0; j<movieMenu.getMovie().length; j++) {
										if(movieMenu.getMovie()[j].equals(movieMenu.ticketing.get(i).getName())) {
											mo=j;
										}
									}
									cal.setTime(movieMenu.ticketing.get(i).getTime());
									cal.add(Calendar.HOUR, movieMenu.preview[mo][0]);
									cal.add(Calendar.MINUTE, movieMenu.preview[mo][1]);
									System.out.printf("[%d] %s\t%s(%s)\t%s\t%s\t%s~%s\t%d\t%s원 %sp\n", cnt,  movieMenu.ticketing.get(i).getId(), movieMenu.ticketing.get(i).getTheater(), movieMenu.ticketing.get(i).getLocal(), f3.format(movieMenu.ticketing.get(i).getDath()), f.format(movieMenu.ticketing.get(i).getTime()), f2.format(movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), movieMenu.ticketing.get(i).getCnt(), de.format(movieMenu.ticketing.get(i).getPrice()), de.format(movieMenu.ticketing.get(i).getPoint()));
									cnt++;
								} 
							}
							System.out.println("-------------------------------------------------------------------------------------------------------------");
						} else {
							System.out.println("없는 메뉴입니다.");
						}
					}
				} else if(select==2) {
					while(true) {
						System.out.println();
						System.out.println("[1]전체 회원 보기\n[2]각 회원별 예매현황\n[3]이전");
						System.out.print("메뉴 선택: ");
						int select2 = scan.nextInt();
						if(select2==1) {
							int cnt = 1; //예매한 영화 갯수
							System.out.println();
							System.out.println("                                            --[전체 회원 보기]--");
							System.out.println("-------------------------------------------------------------------------------------------------------------");
							System.out.println("번호 회원ID\t영화이름\t영화관(지역)\t예매일\t\t\t영화 상영일\t상영시간\t\t예매 매수\t총 금액\t포인트");
							for(int i=0; i<movieMenu.ticketing.size(); i++) {
								int mo = -1;
								for(int j=0; j<movieMenu.getMovie().length; j++) {
									if(movieMenu.getMovie()[j].equals(movieMenu.ticketing.get(i).getName())) {
										mo=j;
									}
								}
								cal.setTime(movieMenu.ticketing.get(i).getTime());
								cal.add(Calendar.HOUR, movieMenu.preview[mo][0]);
								cal.add(Calendar.MINUTE, movieMenu.preview[mo][1]);
								System.out.printf("[%d] %s\t%s\t%s(%s)\t%s\t%s\t%s~%s\t%d\t%s원 %sp\n", cnt, movieMenu.ticketing.get(i).getId(), movieMenu.ticketing.get(i).getName(), movieMenu.ticketing.get(i).getTheater(), movieMenu.ticketing.get(i).getLocal(), f3.format(movieMenu.ticketing.get(i).getDath()), f.format(movieMenu.ticketing.get(i).getTime()), f2.format(movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), movieMenu.ticketing.get(i).getCnt(), de.format(movieMenu.ticketing.get(i).getPrice()), de.format(movieMenu.ticketing.get(i).getPoint()));
								cnt++;
							}
							System.out.println("-------------------------------------------------------------------------------------------------------------");
							cnt=1;
						} else if(select2==2) {
							while(true) {
								int cnt = 1; //예매한 영화 갯수
								System.out.println();
								for(int i=0; i<movieMenu.user.size(); i++) {
									System.out.printf("[%d]%s\n", cnt, movieMenu.user.get(i).getId());
									cnt++;
								}
								System.out.printf("[%d]이전\n", cnt);
								System.out.print("회원 선택: ");
								int select3 = scan.nextInt();
								if(select3==cnt || cnt==1) {
									break;
								} else if(select3<1) {
									System.out.println("없는 메뉴입니다.");
								} else {
									cnt = 1; 
									System.out.println();
									System.out.printf("                       --[%s 회원 보기]--\n", movieMenu.user.get(select3-1).getId());
									System.out.println("-------------------------------------------------------------------------------------------------------------");
									System.out.println("번호 영화이름\t영화관(지역)\t예매일\t\t\t영화 상영일\t상영시간\t\t예매 매수\t총 금액\t포인트");
									
									for(int i=0; i<movieMenu.ticketing.size(); i++) {
										if(movieMenu.ticketing.get(i).getId().equals(movieMenu.user.get(select3-1).getId())) {
											int mo = -1;
											for(int j=0; j<movieMenu.getMovie().length; j++) {
												if(movieMenu.getMovie()[j].equals(movieMenu.ticketing.get(i).getName())) {
													mo=j;
												}
											}
											cal.setTime(movieMenu.ticketing.get(i).getTime());
											cal.add(Calendar.HOUR, movieMenu.preview[mo][0]);
											cal.add(Calendar.MINUTE, movieMenu.preview[mo][1]);
											System.out.printf("[%d] %s\t%s(%s)\t%s\t%s\t%s~%s\t%d\t%s원 %sp\n", cnt,  movieMenu.ticketing.get(i).getName(), movieMenu.ticketing.get(i).getTheater(), movieMenu.ticketing.get(i).getLocal(), f3.format(movieMenu.ticketing.get(i).getDath()), f.format(movieMenu.ticketing.get(i).getTime()), f2.format(movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), movieMenu.ticketing.get(i).getCnt(), de.format(movieMenu.ticketing.get(i).getPrice()), de.format(movieMenu.ticketing.get(i).getPoint()));
											cnt++;
										} 
									}
									System.out.println("-------------------------------------------------------------------------------------------------------------");
									cnt=1;
								}
							}
						} else if(select2==3) {
							break;
						} else {
							System.out.println("없는 메뉴입니다.");
						}
					}
					
				} else if(select==3) {
					while(true) {
						System.out.println();
						System.out.println("[1]서울\n[2]경기도\n[3]인천\n[4]이전");
						System.out.printf("메뉴 선택: ");
						int select2 = scan.nextInt();
						
						if(select2==1) {
							System.out.println("  ------------SCREEN------------");
							for(int i=0; i<movieMenu.seat.length; i++) { 
								System.out.print(movieMenu.getAlphabet()[i] + " ");
								for(int j=0; j<movieMenu.seat[i].length; j++) { 
									if(movieMenu.seat[i][j]==0) {
										System.out.print("[ ]"); //빈좌석
									} else if(movieMenu.seat[i][j]==1) {
										System.out.print("[O]"); //예매함
									} else if(movieMenu.seat[i][j]==2) {
										System.out.print("[!]"); //짝수좌석 예매불가
									} else if(movieMenu.seat[i][j]==3){
										System.out.print("[X]"); //이미 예매완료
									}
								}
								System.out.println();
							}
							System.out.println("  ------------------------------");
						} else if(select2==2) {
							System.out.println("  ---------SCREEN---------");
							for(int i=0; i<movieMenu.gseat.length; i++) { 
								System.out.print(movieMenu.getAlphabet()[i] + " ");
								for(int j=0; j<movieMenu.gseat[i].length; j++) { 
									if(movieMenu.gseat[i][j]==0) {
										System.out.print("[ ]"); //빈좌석
									} else if(movieMenu.gseat[i][j]==1) {
										System.out.print("[O]"); //예매함
									} else if(movieMenu.gseat[i][j]==2) {
										System.out.print("[!]"); //짝수좌석 예매불가
									} else if(movieMenu.gseat[i][j]==3){
										System.out.print("[X]"); //이미 예매완료
									}
								}
								System.out.println();
							}
							System.out.println("  ------------------------");
						} else if(select2==3) {
							System.out.println("  ------------SCREEN------------");
							for(int i=0; i<movieMenu.iseat.length; i++) { 
								System.out.print(movieMenu.getAlphabet()[i] + " ");
								for(int j=0; j<movieMenu.iseat[i].length; j++) { 
									if(movieMenu.iseat[i][j]==0) {
										System.out.print("[ ]"); //빈좌석
									} else if(movieMenu.iseat[i][j]==1) {
										System.out.print("[O]"); //예매함
									} else if(movieMenu.iseat[i][j]==2) {
										System.out.print("[!]"); //짝수좌석 예매불가
									} else if(movieMenu.iseat[i][j]==3){
										System.out.print("[X]"); //이미 예매완료
									}
								}
								System.out.println();
							}
							System.out.println("  ------------------------------");
						} else if(select2==4) {
							break;
						} else {
							System.out.println("없는 메뉴입니다.");
						}
					}	
				} else if(select==4) {
					break;
				}  else {
					System.out.println("없는 메뉴입니다.");
				}
			}
		}
	}
	
//	회원목록
	public void userList() {
		if(movieMenu.user.size()==0) {
			System.out.println("회원이 존재하지 않습니다...");
		}else {
			System.out.println();
			System.out.println("                 --[전체 회원 내역]--");
			System.out.println("------------------------------------------------------");
			System.out.println("ID\tPW\t닉네임\t생년원일\t전화번호\t이메일\t포인트");
			for(int i=0; i<movieMenu.user.size(); i++) {
				System.out.printf("%s\t%s\t%s\t%d\t%s\t%s\t%s\n", movieMenu.user.get(i).getId(), movieMenu.user.get(i).getPw(), movieMenu.user.get(i).getNickName(), movieMenu.user.get(i).getBirth(), movieMenu.user.get(i).getTel(), movieMenu.user.get(i).getEmail(), de.format(movieMenu.user.get(i).getPoint()));
			}
			System.out.println("------------------------------------------------------");
		}
	}
	
//	회원별 포인트 현황
	public void point() {
		int cnt = 1;
		if(movieMenu.pointVO.size()==0) {
			System.out.println();
			System.out.println("포인트 이용내역이 존해하지 않습니다...");
		} else {
			while(true) {
				System.out.println();
				System.out.println("[1]전체 포인트 내역 조회\n[2]회원별 포인트 내역 조회\n[3]이전");
				System.out.print("메뉴 선택: ");
				int select = scan.nextInt();
				if(select==1) {
					System.out.println();
					System.out.println("                --[전체 포인트 이용 내역]--");
					System.out.println("------------------------------------------------------");
					System.out.println("번호\t회원ID\t일자\t\t\t내용\t포인트");
					for(int i=0; i<movieMenu.pointVO.size(); i++) {
						System.out.printf("[%d]\t%s\t%s\t%s\t%sp\n", cnt, movieMenu.pointVO.get(i).getId(), f3.format(movieMenu.pointVO.get(i).getDay()), movieMenu.pointVO.get(i).getUse(), de.format(movieMenu.pointVO.get(i).getPoint()));
						cnt++;
					}
					System.out.println("------------------------------------------------------");
					cnt = 1;
				} else if(select==2) {
					System.out.println();
					System.out.println("--[회원선택]--");
					for(int i=0; i<movieMenu.user.size(); i++) {
						System.out.printf("[%d]%s\n", cnt, movieMenu.user.get(i).getId());
						cnt++;
					}
					cnt = 1;
					System.out.print("회원 선택: ");
					int select2 = scan.nextInt();
					if(select2<movieMenu.pointVO.size() && select2!=0) {
						System.out.printf("               --[%s님 포인트 이용 내역]--\n", movieMenu.user.get(select2-1).getId());
						System.out.println("------------------------------------------------------");
						System.out.println("번호\t일자\t\t\t내용\t포인트");
						for(int j=0; j<movieMenu.pointVO.size(); j++) {
							if(movieMenu.user.get(select2-1).getId().equals(movieMenu.pointVO.get(j).getId())) {
								System.out.printf("[%d]\t%s\t%s\t%sp\n", cnt, f3.format(movieMenu.pointVO.get(j).getDay()), movieMenu.pointVO.get(j).getUse(), de.format(movieMenu.pointVO.get(j).getPoint()));
								cnt++;
							}
						}
						cnt = 1;
						System.out.println("------------------------------------------------------");
					} else {
						System.out.println("없는 회원입니다.");
					}
				} else if(select==3) {
					break;
				} else {
					System.out.println("없는 메뉴입니다.");
				}
			}
		}
	}
	
//	영화목록
	public void movieList() {
		System.out.println();
		System.out.println("            --[영화 목록]--");
		System.out.println("--------------------------------------");
		System.out.println("      영화이름\t예매율\t상영일");
		
		if(movieMenu.count==0) {
			for(int i=0; i<movieMenu.getMovie().length; i++) {
				movieMenu.getDay()[i].setYear(movieMenu.getDay()[i].getYear()-1900);
				movieMenu.getDay()[i].setMonth(movieMenu.getDay()[i].getMonth()-1);
				movieMenu.count=1;
			}
		}
		
		for(int i=0; i<movieMenu.getMovie().length; i++) {
			int a = movieMenu.getPeople()[i];
			double b = (a*100)/252.0;
			movieMenu.advance[i] = b;
			System.out.printf("[%d]%s\t%.1f\t%s\n", (i+1), movieMenu.getMovie()[i], movieMenu.advance[i], f.format(movieMenu.getDay()[i]));
		}
	}
	
}
