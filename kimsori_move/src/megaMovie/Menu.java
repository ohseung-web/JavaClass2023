package megaMovie;

import java.text.*;
import java.util.*;

public class Menu {
	
	AdminMenu adminMenu = new AdminMenu();
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd(E)");
	SimpleDateFormat f2 = new SimpleDateFormat("HH:mm");
	SimpleDateFormat f3 = new SimpleDateFormat("yyyy-MM-dd(E) HH:mm:ss");
	DecimalFormat de = new DecimalFormat("#,##0");
	Calendar cal = Calendar.getInstance();
	
	Scanner scan = new Scanner(System.in);
	String menu = "[1]로그인\n[2]회원 가입\n[3]영화목록\n[4]검색\n[0]종료";
	String inmenu = "[1]로그아웃\n[2]알람\n[3]영화목록\n[4]검색\n[5]마이페이지\n[6]회원탈퇴\n[0]종료";
	String inmenu2 = "[1]로그아웃\n[2]알람";
	String inmenu3 = "\n[3]영화목록\n[4]검색\n[5]마이페이지\n[6]회원탈퇴\n[0]종료";
	static int log = -1;
	int alarmCnt = 0; //알람수 세기

	public void menu() {
		while(true) {
			adminMenu.movieMenu.finalChk = -1;
			alarmCnt = 0;
			System.out.println();
			System.out.println("---[메가박스]---");
			if(log<0) {
				System.out.println(menu);
			} else {
				alarmCnt();
				if(alarmCnt==0 || alarmCnt<0) {
					System.out.println(inmenu);
				} else if(alarmCnt>0) {
					System.out.println(inmenu2 + "(" + alarmCnt + ")" + inmenu3);
				} 
			}
			System.out.print("메뉴 선택(100관리자모드): ");
			int select = scan.nextInt();
				
			if(select==1) {
				if(log<0) {
					login(); //로그인
				} else {
					logout(); //로그아웃
				}
			} else if(select==2) {
				if(log<0) {
					join(); //회원가입
				} else {
					alarm(); //알람
				}
			} else if(select==3) {
				adminMenu.movieMenu.list();
			} else if(select==4) {
				adminMenu.movieMenu.search();
			} else if(select==5) {
				if(log>-1) {
					myPage(); //마이페이지
				}
			} else if(select==6) {
				if(log>-1) {
					bye(); //회원탈퇴
				}
			}else if(select==0) {
				System.out.println("안녕히계세요.");
				break;
			} else if(select==100) {
				if(log>-1) {
					System.out.println("로그아웃 후 이용가능");
				} else {
					adminMenu.adminLogin();
				}
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
//	회원가입
	public void join() {
		int chk = -1;
		System.out.print("ID: ");
		String myid = scan.next();
		
		for(int i=0; i<adminMenu.movieMenu.user.size(); i++) {
			if(myid.equals(adminMenu.movieMenu.user.get(i).getId())) {
				chk = 1;
				System.out.println("이미 존재하는 ID입니다.");
			}
		}
		if(chk<0) {
			System.out.print("PW: ");
			String myPw = scan.next();
			System.out.print("닉네임: ");
			String myNickName = scan.next();
			System.out.print("생년월일(ex.800205): ");
			int myBirth = scan.nextInt();
			System.out.print("전화번호: ");
			String myTel = scan.next();
			System.out.print("이메일: ");
			String myEmail = scan.next();
			
			adminMenu.movieMenu.user.add(new UserVO(myid, myPw, myNickName, myBirth, myTel, myEmail));
			System.out.println("회원가입 축하합니다!");
			System.out.println("1,000p가 적립되었습니다!");
			Date current = new Date();
			adminMenu.movieMenu.pointVO.add(new PointVO(myid, "회원가입", 1000, current));
		} else {
			System.out.println("회원가입을 다시 진행해주세요.");
		}
	}
	
//	회원탈퇴
	public void bye() {
		adminMenu.movieMenu.user.remove(log);
		log = -1;
		System.out.println("그동안 즐거웠습니다.");
	}
	
//	로그인
	public void login() {
		System.out.print("id: ");
		String myid = scan.next();
		System.out.print("pw: ");
		String mypw = scan.next();
			
		for(int i=0; i<adminMenu.movieMenu.user.size(); i++) {
			if(adminMenu.movieMenu.user.get(i).getId().equals(myid) && adminMenu.movieMenu.user.get(i).getPw().equals(mypw)) {
				log=i;
			}
		}
			
		if(log<0) {
			System.out.println("id와 pw를 다시 확인해주세요.");
		} else {
			System.out.println("로그인이 완료되었습니다.");
		}
	}
	
//	로그아웃
	public void logout() {
		log = -1;
		System.out.println("안녕히 계세요.");
	}
	
//	마이페이지
	public void myPage() {
		while(true) {
			System.out.println();
			System.out.println("[1]내 정보 보기\n[2]예매/구매내역\n[3]포인트 이용내역\n[4]개인 정보수정\n[5]이전");
			System.out.print("메뉴 선택: ");
			int select = scan.nextInt();
			if(select==1) {
				myInfo();
			} else if(select==2) {
				buy();
			} else if(select==3) {
				point();
			} else if(select==4) {
				modify();
			} else if(select==5) {
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
//	알람 수 세기
	public void alarmCnt() {
		Date current = new Date(); //내일
		Date current2 = new Date(); //오늘
		Date current3 = new Date(); //전날
		current.setDate(current.getDate()+1);
		current3.setDate(current3.getDate()-1);
		for(int i=0; i<adminMenu.movieMenu.alarm.size(); i++) {
			if(log==adminMenu.movieMenu.alarm.get(i).getLog() && f.format(current2).equals(f.format(adminMenu.movieMenu.alarm.get(i).getDay()))) {
				alarmCnt++;
			}
			if(log==adminMenu.movieMenu.alarm.get(i).getLog() && f.format(current).equals(f.format(adminMenu.movieMenu.alarm.get(i).getDay()))) {
				alarmCnt++;
			}
			if(log==adminMenu.movieMenu.alarm.get(i).getLog() && f.format(current3).equals(f.format(adminMenu.movieMenu.alarm.get(i).getDay()))) {
				alarmCnt--;
				adminMenu.movieMenu.alarm.remove(i);
			}
		}
	}
	
//	알람
	public void alarm() {
		Date current = new Date();
		Date current2 = new Date();
		current.setDate(current.getDate()+1);
		int cnt = 1;
		System.out.println();
		
		for(int i=0; i<adminMenu.movieMenu.alarm.size(); i++) {
			if(log==adminMenu.movieMenu.alarm.get(i).getLog() && f.format(current2).equals(f.format(adminMenu.movieMenu.alarm.get(i).getDay()))) {
				System.out.printf("[%d] 오늘은 예매하신 %s 상영일입니다.\n", cnt, adminMenu.movieMenu.alarm.get(i).getAlarm());
				cnt++;
			}
			if(log==adminMenu.movieMenu.alarm.get(i).getLog() && f.format(current).equals(f.format(adminMenu.movieMenu.alarm.get(i).getDay()))) {
				System.out.printf("[%d] 내일은 예매하신 %s 상영일입니다.\n", cnt, adminMenu.movieMenu.alarm.get(i).getAlarm());
				cnt++;
			}
		}
		
		if(cnt==1) {
			System.out.println("알림내역이 없습니다.");
		} else {
			cnt = 0;
			System.out.println();
			System.out.println("[1]알람 삭제\n[2]이전");
			System.out.print("메뉴 선택: ");
			int select = scan.nextInt();
			if(select==1) {
				System.out.print("삭제할 번호: ");
				int select2 = scan.nextInt();
				for(int i=0; i<adminMenu.movieMenu.alarm.size(); i++) {
					if(log==adminMenu.movieMenu.alarm.get(i).getLog() && f.format(current2).equals(f.format(adminMenu.movieMenu.alarm.get(i).getDay()))) {
						cnt++;
					}
					if(log==adminMenu.movieMenu.alarm.get(i).getLog() && f.format(current).equals(f.format(adminMenu.movieMenu.alarm.get(i).getDay()))) {
						cnt++;
					}
					if(cnt==select2) {
						adminMenu.movieMenu.alarm.remove(i);
						System.out.println("삭제되었습니다.");
					}
				}
			} else if(select==2) {
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
//	내 정보 보기
	public void myInfo() {
		System.out.println();
		System.out.println("--------------------");
		System.out.printf("ID:\t%s\n닉네임:\t%s\n생년월일:\t%s\n전화번호:\t%s\n이메일:\t%s\n내 포인트:\t%sp\n", adminMenu.movieMenu.user.get(log).getId(), adminMenu.movieMenu.user.get(log).getNickName(), String.format("%06d", adminMenu.movieMenu.user.get(log).getBirth()), adminMenu.movieMenu.user.get(log).getTel(), adminMenu.movieMenu.user.get(log).getEmail(), de.format(adminMenu.movieMenu.user.get(log).getPoint()));
		System.out.println("--------------------");
		System.out.println("[1]정보수정\n[2]이전");
		System.out.print("메뉴 선택: ");
		int select = scan.nextInt();
		if(select==1) {
			modify();
		} else if(select==2) {
		} else {
			System.out.println("없는 메뉴입니다.");
		}
	}
	
//	정보수정
	public void modify() {
		System.out.println();
		System.out.println("정보수정을 위해 비밀번호를 입력해주세요.");
		System.out.print("PW: ");
		String myPw = scan.next();
		
		if(adminMenu.movieMenu.user.get(log).getPw().equals(myPw)) {
			while(true) {
				int cnt = -1;
				System.out.println();
				System.out.println("--------------------");
				System.out.printf("ID:\t%s\n닉네임:\t%s\n생년월일:\t%s\n전화번호:\t%s\n이메일:\t%s\n내 포인트:\t%sp\n", adminMenu.movieMenu.user.get(log).getId(), adminMenu.movieMenu.user.get(log).getNickName(), String.format("%06d",adminMenu.movieMenu.user.get(log).getBirth()), adminMenu.movieMenu.user.get(log).getTel(), adminMenu.movieMenu.user.get(log).getEmail(), de.format(adminMenu.movieMenu.user.get(log).getPoint()));
				System.out.println("--------------------");
				System.out.println("[1]PW\n[2]닉네임\n[3]전화번호\n[4]이메일\n[5]이전");
				System.out.print("변경할 정보: ");
				int select = scan.nextInt();
				if(select==1) {
					System.out.print("새 비밀번호: ");
					String changePw = scan.next();
					if(changePw.equals(adminMenu.movieMenu.user.get(log).getPw())) {
						System.out.println("이전 비밀번호와 같습니다.");
						System.out.println("다시 입력해주세요.");
						cnt=1;
					}
					if(cnt==1) {
						continue;
					}
					System.out.print("새 비밀번호 확인: ");
					String chkPw = scan.next();
					if(chkPw.equals(changePw)) {
						System.out.println("비밀번호가 변경되었습니다.");
						adminMenu.movieMenu.user.get(log).setPw(changePw);
					} else {
						System.out.println("비밀번호가 일치하지 않습니다.\n다시 입력해주세요.\n");
						System.out.print("새 비밀번호 확인: ");
						String chkPw2 = scan.next();
						if(chkPw2.equals(changePw)) {
							adminMenu.movieMenu.user.get(log).setPw(changePw);
							System.out.println("비밀번호가 변경되었습니다.");
						} else {
							System.out.println("비밀번호가 일치하지 않습니다.\n처음 화면으로 돌아갑니다.");
						}
					}
				} else if(select==2) {
					System.out.print("새 닉네임: ");
					String changeNickName = scan.next();
					if(changeNickName.equals(adminMenu.movieMenu.user.get(log).getNickName())) {
						System.out.println("이전 닉네임과 같습니다.");
						System.out.println("다시 입력해주세요.");
						cnt=1;
					}
					if(cnt==1) {
						continue;
					}
					adminMenu.movieMenu.user.get(log).setNickName(changeNickName);
					System.out.println("닉네임이 변경되었습니다.");
				} else if(select==3) {
					System.out.print("새 전화번호: ");
					String changeTel = scan.next();
					if(changeTel.equals(adminMenu.movieMenu.user.get(log).getTel())) {
						System.out.println("이전 전화번호와 같습니다.");
						System.out.println("다시 입력해주세요.");
						cnt=1;
					}
					if(cnt==1) {
						continue;
					}
					adminMenu.movieMenu.user.get(log).setTel(changeTel);
					System.out.println("전화번호가 변경되었습니다.");
				} else if(select==4) {
					System.out.print("새 이메일: ");
					String changeEmail = scan.next();
					if(changeEmail.equals(adminMenu.movieMenu.user.get(log).getEmail())) {
						System.out.println("이전 이메일과 같습니다.");
						System.out.println("다시 입력해주세요.");
						cnt=1;
					}
					if(cnt==1) {
						continue;
					}
					adminMenu.movieMenu.user.get(log).setEmail(changeEmail);
					System.out.println("이메일이 변경되었습니다.");
				} else if(select==5) {
					break;
				} else {
					System.out.println("없는 메뉴입니다.");
				}
			}
		} else {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
	}
	
//	예매/구매내역
	public void buy() {
		while(true) {
			System.out.println();
			int chk = -1; //1이면 예매내역 없음
		
			for(int i=0; i<adminMenu.movieMenu.ticketing.size(); i++) {
				if(adminMenu.movieMenu.ticketing.get(i).getId().equals(adminMenu.movieMenu.user.get(log).getId())) {
					chk = 1;
				}
			}	
		
			int cnt = 1; //예매한 영화 갯수
			if(adminMenu.movieMenu.ticketing.size()==0 || chk==-1) {
				System.out.println("예매내역이 존재하지 않습니다.");
				break;
			} else {
				System.out.println("번호 영화이름\t영화관(지역)\t예매일\t\t\t영화 상영일\t상영시간\t\t예매 매수\t총 금액");
				for(int i=0; i<adminMenu.movieMenu.ticketing.size(); i++) {
					if(adminMenu.movieMenu.ticketing.get(i).getId().equals(adminMenu.movieMenu.user.get(log).getId())) {
						int mo = -1;
						for(int j=0; j<adminMenu.movieMenu.getMovie().length; j++) {
							if(adminMenu.movieMenu.getMovie()[j].equals(adminMenu.movieMenu.ticketing.get(i).getName())) {
								mo=j;
							}
						}
						cal.setTime(adminMenu.movieMenu.ticketing.get(i).getTime());
						cal.add(Calendar.HOUR, adminMenu.movieMenu.preview[mo][0]);
						cal.add(Calendar.MINUTE, adminMenu.movieMenu.preview[mo][1]);
						System.out.printf("[%d] %s\t%s(%s)\t%s\t%s\t%s~%s\t%d\t%s원\n", cnt, adminMenu.movieMenu.ticketing.get(i).getName(), adminMenu.movieMenu.ticketing.get(i).getTheater(), adminMenu.movieMenu.ticketing.get(i).getLocal(), f3.format(adminMenu.movieMenu.ticketing.get(i).getDath()), f.format(adminMenu.movieMenu.ticketing.get(i).getTime()), f2.format(adminMenu.movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), adminMenu.movieMenu.ticketing.get(i).getCnt(), de.format(adminMenu.movieMenu.ticketing.get(i).getPrice()));
						cnt++;
					} 
				}
				cnt = 0;
				System.out.println();
				System.out.println("[1]영수증 출력\n[2]예매 취소\n[3]이전");
				System.out.print("메뉴 선택: ");
				int select = scan.nextInt();
				if(select==1) {
					System.out.println();
					System.out.print("출력할 번호: ");
					int select2 = scan.nextInt();
					
					for(int i=0; i<adminMenu.movieMenu.ticketing.size(); i++) {
						if(adminMenu.movieMenu.ticketing.get(i).getId().equals(adminMenu.movieMenu.user.get(log).getId())) {
							cnt++;
						} 
						if(cnt==select2) {
							int mo = -1;
							for(int j=0; j<adminMenu.movieMenu.getMovie().length; j++) {
								if(adminMenu.movieMenu.getMovie()[j].equals(adminMenu.movieMenu.ticketing.get(i).getName())) {
									mo=j;
								}
							}
							Date current = new Date();
							cal.setTime(adminMenu.movieMenu.ticketing.get(i).getTime());
							cal.add(Calendar.HOUR, adminMenu.movieMenu.preview[mo][0]);
							cal.add(Calendar.MINUTE, adminMenu.movieMenu.preview[mo][1]);
							System.out.println();
							System.out.println("        --[영화 영수증]--         ");
							System.out.println("-------------------------------");
							System.out.printf("%s\n%s(%s)\n%s | %s~%s\n성인 %d명(%s)\n총 금액: %s원\n", adminMenu.movieMenu.ticketing.get(i).getName(), adminMenu.movieMenu.ticketing.get(i).getTheater(), adminMenu.movieMenu.ticketing.get(i).getLocal(), f.format(adminMenu.movieMenu.ticketing.get(i).getTime()), f2.format(adminMenu.movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), adminMenu.movieMenu.ticketing.get(i).getCnt(), adminMenu.movieMenu.ticketing.get(i).getTicket(), de.format(adminMenu.movieMenu.ticketing.get(i).getPrice()));
							System.out.println("-------------------------------");
							System.out.printf("%s회원님\n", adminMenu.movieMenu.user.get(log).getNickName());
							System.out.printf("사용 포인트: %sp\n", de.format(adminMenu.movieMenu.ticketing.get(i).getPoint()));
							System.out.printf("출력시간: %s\n", f3.format(current));
						}
					}
					cnt=0;
				} else if(select==2) {
					System.out.print("취소할 번호: ");
					int select2 = scan.nextInt();
						for(int i=0; i<adminMenu.movieMenu.ticketing.size(); i++) {
							if(adminMenu.movieMenu.ticketing.get(i).getId().equals(adminMenu.movieMenu.user.get(log).getId())) {
								cnt++;
							} 
							if(cnt==select2) {
								Date current = new Date();
								double inPoint = adminMenu.movieMenu.ticketing.get(i).getPrice()*0.05;
								adminMenu.movieMenu.user.get(log).setPoint(-(int)inPoint);
								adminMenu.movieMenu.pointVO.add(new PointVO(adminMenu.movieMenu.user.get(log).getId(), "예매취소", -(int)inPoint, current));
								
//								해당하는 알람 지우기
								for(int j=0; j<adminMenu.movieMenu.alarm.size(); j++) {
									if(adminMenu.movieMenu.alarm.get(j).getDay().equals(adminMenu.movieMenu.ticketing.get(j).getTime()) && adminMenu.movieMenu.alarm.get(j).getAlarm().equals(adminMenu.movieMenu.ticketing.get(j).getName())) {
										adminMenu.movieMenu.alarm.remove(j);
									}
								}
								
//								해당하는 예매율 지우기
								if(adminMenu.movieMenu.ticketing.get(i).getName().equals(null) || adminMenu.movieMenu.ticketing.get(i).getName().equals(" ")) {
									
								} else {
									for(int a=0; a<adminMenu.movieMenu.getMovie().length; a++) {
										if(adminMenu.movieMenu.getMovie()[a].equals(adminMenu.movieMenu.ticketing.get(i).getName())) {
											adminMenu.movieMenu.getPeople()[a] = adminMenu.movieMenu.getPeople()[a] - adminMenu.movieMenu.ticketing.get(i).getCnt();
										}
									}
								}
								
//								해당하는 좌석 지우기
								int[][] seat2 = new int[8][2];
								for(int j=0; j<8; j++) {
									if(adminMenu.movieMenu.ticketing.get(i).getTicket().equals("") || adminMenu.movieMenu.ticketing.get(i).getTicket().equals(null)) {
										break;
								} else {
									String a = adminMenu.movieMenu.ticketing.get(i).getTicket();
									String b = a.substring(a.length()-1, a.length());
									int b12 = Integer.parseInt(b);
									if(b.equals("0")) {
										b = a.substring(a.length()-2, a.length()); //2
										System.out.println(b);
										a = adminMenu.movieMenu.replaceLast(a, b, "");
										a = adminMenu.movieMenu.replaceLast(a, "열", "");
										String c = a.substring(a.length()-1, a.length());
										a = adminMenu.movieMenu.replaceLast(a, c, "");
										a = adminMenu.movieMenu.replaceLast(a, " ", "");
//										byte 수 세기
										adminMenu.movieMenu.ticketing.get(i).setTicket(adminMenu.movieMenu.replaceLast(adminMenu.movieMenu.ticketing.get(i).getTicket(), c+"열"+b, ""));
										if(adminMenu.movieMenu.ticketing.get(i).getTicket().length()>0) {
											char last0 = adminMenu.movieMenu.ticketing.get(i).getTicket().charAt(adminMenu.movieMenu.ticketing.get(i).getTicket().length() - 1);
											String last00 = Character.toString(last0);
											if(last00.equals(" ")) {
												adminMenu.movieMenu.ticketing.get(i).setTicket(adminMenu.movieMenu.replaceLast(adminMenu.movieMenu.ticketing.get(i).getTicket(), " ", ""));
											}
										}
										int d = Integer.parseInt(b);
										int e = -1;
										if(c.equals("A")) {
											e = 0;
											seat2[j][0] = e;
										} else if(c.equals("B")) {
											e = 1;
											seat2[j][0] = e;
										} else if(c.equals("C")) {
											e = 2;
											seat2[j][0] = e;
										} else if(c.equals("D")) {
											e = 3;
											seat2[j][0] = e;
										} else if(c.equals("E")) {
											e = 4;
											seat2[j][0] = e;
										} else if(c.equals("F")) {
											e = 5;
											seat2[j][0] = e;
										} else if(c.equals("G")) {
											e = 6;
											seat2[j][0] = e;
										} else if(c.equals("H")) {
											e = 7;
											seat2[j][0] = e;
										} else if(c.equals("I")) {
											e = 8;
											seat2[j][0] = e;
										} else if(c.equals("J")) {
											e = 9;
											seat2[j][0] = e;
										} else if(c.equals("K")) {
											e = 10;
											seat2[j][0] = e;
										} else if(c.equals("L")) {
											e = 11;
											seat2[j][0] = e;
										} else if(c.equals("M")) {
											e = 12;
											seat2[j][0] = e;
										}
										seat2[j][1] = d-1;
										
									} else {
										a = adminMenu.movieMenu.replaceLast(a, b, "");
										a = adminMenu.movieMenu.replaceLast(a, "열", "");
										String c = a.substring(a.length()-1, a.length());
										a = adminMenu.movieMenu.replaceLast(a, c, "");
										a = adminMenu.movieMenu.replaceLast(a, " ", "");
//										byte 수 세기
										adminMenu.movieMenu.ticketing.get(i).setTicket(adminMenu.movieMenu.replaceLast(adminMenu.movieMenu.ticketing.get(i).getTicket(), c+"열"+b, ""));
										if(adminMenu.movieMenu.ticketing.get(i).getTicket().length()>0) {
											char last0 = adminMenu.movieMenu.ticketing.get(i).getTicket().charAt(adminMenu.movieMenu.ticketing.get(i).getTicket().length() - 1);
											String last00 = Character.toString(last0);
											if(last00.equals(" ")) {
												adminMenu.movieMenu.ticketing.get(i).setTicket(adminMenu.movieMenu.replaceLast(adminMenu.movieMenu.ticketing.get(i).getTicket(), " ", ""));
											}
										}
										int d = Integer.parseInt(b);
										int e = -1;
										if(c.equals("A")) {
											e = 0;
											seat2[j][0] = e;
										} else if(c.equals("B")) {
											e = 1;
											seat2[j][0] = e;
										} else if(c.equals("C")) {
											e = 2;
											seat2[j][0] = e;
										} else if(c.equals("D")) {
											e = 3;
											seat2[j][0] = e;
										} else if(c.equals("E")) {
											e = 4;
											seat2[j][0] = e;
										} else if(c.equals("F")) {
											e = 5;
											seat2[j][0] = e;
										} else if(c.equals("G")) {
											e = 6;
											seat2[j][0] = e;
										} else if(c.equals("H")) {
											e = 7;
											seat2[j][0] = e;
										} else if(c.equals("I")) {
											e = 8;
											seat2[j][0] = e;
										} else if(c.equals("G")) {
											e = 9;
											seat2[j][0] = e;
										} else if(c.equals("K")) {
											e = 10;
											seat2[j][0] = e;
										} else if(c.equals("L")) {
											e = 11;
											seat2[j][0] = e;
										} else if(c.equals("M")) {
											e = 12;
											seat2[j][0] = e;
										}
										seat2[j][1] = d-1;
									}
									
									
								}
							}
							for(int a=0; a<8; a++) {
								if(adminMenu.movieMenu.ticketing.get(i).getLocal().equals("서울")) {
									adminMenu.movieMenu.seat[seat2[a][0]][seat2[a][1]] = 0;
								} else if(adminMenu.movieMenu.ticketing.get(i).getLocal().equals("경기도")) {
									adminMenu.movieMenu.gseat[seat2[a][0]][seat2[a][1]] = 0;
								} else if(adminMenu.movieMenu.ticketing.get(i).getLocal().equals("인천")) {
									adminMenu.movieMenu.iseat[seat2[a][0]][seat2[a][1]] = 0;
								} 
							}
							adminMenu.movieMenu.ticketing.remove(i);
							System.out.println("취소되었습니다.");
							}
						}
					cnt=0;
				} else if(select==3) {
					break;
				}  else {
					System.out.println("없는 메뉴입니다.");
				}
			}
		}
	}
	
//	포인트 이용내역
	public void point() {
		System.out.println();
		System.out.printf("사용 가능 포인트: %sp\n", de.format(adminMenu.movieMenu.user.get(log).getPoint()));
		int cnt = 1;
		System.out.println();
		System.out.println("             --[포인트 이용 내역]--");
		System.out.println("----------------------------------------------");
		System.out.println("번호\t\t일자\t\t내용\t포인트");
		for(int i=0; i<adminMenu.movieMenu.pointVO.size(); i++) {
			if(adminMenu.movieMenu.user.get(log).getId().equals(adminMenu.movieMenu.pointVO.get(i).getId())) {
				System.out.printf("[%d] %s\t%s\t%sp\n", cnt, f3.format(adminMenu.movieMenu.pointVO.get(i).getDay()), adminMenu.movieMenu.pointVO.get(i).getUse(), de.format(adminMenu.movieMenu.pointVO.get(i).getPoint()));
				cnt++;
			}
		}
	}
	
}