package megaMovie;
import java.text.*;
import java.util.*;

public class MovieMenu extends MovieVO{
	
	ArrayList<UserVO> user = new ArrayList<>();
	ArrayList<TicketingVO> ticketing = new ArrayList<>();
	ArrayList<AlarmVO> alarm = new ArrayList<>();
	ArrayList<PointVO> pointVO = new ArrayList<>();
	
	SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd(E)");
	SimpleDateFormat f2 = new SimpleDateFormat("HH:mm");
	DecimalFormat de = new DecimalFormat("#,##0");
	Calendar cal = Calendar.getInstance();
	
	Scanner scan = new Scanner(System.in);
	
	int[][] seat = new int[13][10]; //서울
	int[][] gseat = new int[9][8]; //경기도
	int[][] iseat = new int[5][10]; //인천
	
	String id; //영화구매한 회원
	String name; //영화이름
	String local; //지역
	String Theater; //영화관
	Date dath; //예매일
	Date time; //영화 볼 날짜,시간
	String ticket = ""; //예매한 열
	int cnt; //구매한 영화 갯수
	int price; //영화금액
	int price2; //영화금액
	int point = 0; //포인트
	int moviePrice;
	
	int size = getMovie().length;
	int count = 0;
	int mo = -1;
	int timeCnt = 0; //날짜 체크키
	int timeChk = 0; //타임 체크키
	int dayth = 0; //예매한 날짜 
	int[][] seat2 = new int[8][2];
	int seatCnt = 0; //seat2좌석세기
	int finalChk = -1; //seat2좌석 초기화
	
	public ArrayList<TicketingVO> getTicketing() {
		return ticketing;
	}

	public void setTicketing(ArrayList<TicketingVO> ticketing) {
		this.ticketing = ticketing;
	}

	//	영화목록
	public void list() {
		while(true) {
			if(finalChk==0) {
				break;
			}
			finalChk = -1;
			for(int i=0; i<8; i++) {
				for(int j=0; j<2; j++) {
					seat2[i][j] = -1;
				}
			}
			int log = Menu.log;
			System.out.println();
			System.out.println("            --[영화 목록]--");
			System.out.println("--------------------------------------");
			System.out.println("      영화이름\t예매율\t상영일");
			
			if(count==0) {
				for(int i=0; i<size; i++) {
					getDay()[i].setYear(getDay()[i].getYear()-1900);
					getDay()[i].setMonth(getDay()[i].getMonth()-1);
					count=1;
				}
			}
			
			for(int i=0; i<size; i++) {
				int a = getPeople()[i];
				double b = (a*100)/252.0;
				advance[i] = b;
				System.out.printf("[%d]%s\t%.1f\t%s\n", (i+1), getMovie()[i], advance[i], f.format(getDay()[i]));
			}
			
			System.out.println("--------------------------------------");
			System.out.println("[1]예매\n[2]이전");
			System.out.print("메뉴선택: ");
			int select = scan.nextInt();
			
			if(select==1) {
				if(log<0) {
					System.out.println("로그인 후 이용가능");
				} else {
					id = user.get(log).getId();
					System.out.print("예매할 영화: ");
					int select2 = scan.nextInt();
					for(int i=0; i<size; i++) {
						if(select2-1==i) {
							name = getMovie()[select2-1];
							mo = select2-1;
							ticketing();
							if(finalChk==0) {
								break;
							}
						}
					}
				}
			} else if(select==2) {
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	

	// 지역 선택
	public void ticketing() {
		while(true) {
			if(timeChk==0) {
				for(int i=0; i<size; i++) {
					getTime()[i].setYear(getTime()[i].getYear()-1900);
					getTime()[i].setMonth(getTime()[i].getMonth()-1);
					getTime2()[i].setYear(getTime2()[i].getYear()-1900);
					getTime2()[i].setMonth(getTime2()[i].getMonth()-1);
					getTime3()[i].setYear(getTime3()[i].getYear()-1900);
					getTime3()[i].setMonth(getTime3()[i].getMonth()-1);
					timeChk=1;
				}
			}
			System.out.println();
			System.out.println("--[지역 선택]--");
			
			for(int i=0; i<size; i++) {
				System.out.printf("[%d]%s\n", (i+1), getLocal()[i]);
			}
			System.out.println("------------");
			System.out.println("[1]지역선택\n[2]이전");
			System.out.print("메뉴 선택: ");
			int select3 = scan.nextInt();
			if(select3==1) {
				System.out.print("지역선택: ");
				int select = scan.nextInt();
				local = getLocal()[select-1];
				theater();
				if(finalChk==0) {
					break;
				}
			} else if(select3==2) {
				name = "";
				mo = 0;
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
//	극장 선택
	public void theater() {
		while(true) {
			System.out.println();
			System.out.println("--[극장 선택]--");
			if(local.equals(getLocal()[0])) {
				for(int i=0; i<size; i++) {
					System.out.printf("[%d]%s\n", (i+1), getsTheater()[i]);
				}
				System.out.println("------------");
			} else if(local.equals(getLocal()[1])) {
				for(int i=0; i<size; i++) {
					System.out.printf("[%d]%s\n", (i+1), getgTheater()[i]);
				}
				System.out.println("------------");
			} else if(local.equals(getLocal()[2])) {
				for(int i=0; i<size; i++) {
					System.out.printf("[%d]%s\n", (i+1), getiTheater()[i]);
				}
				System.out.println("------------");
			}
			System.out.println("[1]극장선택\n[2]이전");
			System.out.print("메뉴 선택: ");
			int select3 = scan.nextInt();
			if(select3==1) {
				System.out.print("극장선택: ");
				int select2 = scan.nextInt();
				if(local.equals(getLocal()[0])) {
					Theater = getsTheater()[select2-1];
				} else if(local.equals(getLocal()[1])) {
					Theater = getgTheater()[select2-1];
				} else if(local.equals(getLocal()[2])) {
					Theater = getiTheater()[select2-1];
				}
				time();
				if(finalChk==0) {
					break;
				}
			} else if(select3==2) {
				local = "";
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
//	날짜 선택
	public void time() {
		while(true) {
			System.out.println();
			System.out.println("--[날짜 선택]--");
			for(int i=0; i<size; i++) {
				System.out.printf("[%d]%d일\n", (i+1), getDath()[i]);
			}
			System.out.println("------------");
			System.out.println("[1]날짜선택\n[2]이전");
			System.out.print("메뉴 선택: ");
			int select3 = scan.nextInt();
			if(select3==1) {
				System.out.print("날짜 선택: ");
				int select = scan.nextInt();
				dayth = select;
				time2();
				if(finalChk==0) {
					break;
				}
			} else if(select3==2) {
				Theater = "";
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
//	시간 선택
	public void time2() {
		while(true) {
			System.out.println();
			System.out.println("--[시간 선택]--");
			if(dayth==1) {
				for(int i=0; i<size; i++) {
					cal.setTime(getTime()[i]);
					cal.add(Calendar.HOUR, preview[mo][0]);
					cal.add(Calendar.MINUTE, preview[mo][1]);
					System.out.printf("[%d]%s~%s\n", (i+1), f2.format(getTime()[i]), f2.format(cal.getTime()));
				}
			} else if(dayth==2) {
				for(int i=0; i<size; i++) {
					cal.setTime(getTime2()[i]);
					cal.add(Calendar.HOUR, preview[mo][0]);
					cal.add(Calendar.MINUTE, preview[mo][1]);
					System.out.printf("[%d]%s~%s\n", (i+1), f2.format(getTime2()[i]), f2.format(cal.getTime()));
				}
			} else if(dayth==3) {
				for(int i=0; i<size; i++) {
					cal.setTime(getTime3()[i]);
					cal.add(Calendar.HOUR, preview[mo][0]);
					cal.add(Calendar.MINUTE, preview[mo][1]);
					System.out.printf("[%d]%s~%s\n", (i+1), f2.format(getTime3()[i]), f2.format(cal.getTime()));
				}
			}
			System.out.println("------------");
			System.out.println("[1]시간선택\n[2]이전");
			System.out.print("메뉴 선택: ");
			int select3 = scan.nextInt();
			if(select3==1) {
				System.out.print("시간 선택: ");
				int select2 = scan.nextInt();
				if(dayth==1) {
					time = getTime()[select2-1];
				} else if(dayth==2) {
					time = getTime2()[select2-1];
				} else if(dayth==3) {
					time = getTime3()[select2-1];
				}
				seeMenu();
				if(finalChk==0) {
					break;
				}
			} else if(select3==2) {
				dayth = 0;
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
//	좌석출력
	public void seat() {
		System.out.println();
		if(local.equals("서울")) {
			System.out.println("  ------------SCREEN------------");
			for(int i=0; i<seat.length; i++) { 
				System.out.print(getAlphabet()[i] + " ");
				for(int j=0; j<seat[i].length; j++) { 
					if(seat[i][j]==0) {
						System.out.print("[ ]"); //빈좌석
					} else if(seat[i][j]==1) {
						System.out.print("[O]"); //예매함
					} else if(seat[i][j]==2) {
						System.out.print("[!]"); //짝수좌석 예매불가
					} else if(seat[i][j]==3){
						System.out.print("[X]"); //이미 예매완료
					}
				}
				System.out.println();
			}
			System.out.println("  ------------------------------");
		} else if(local.equals("경기도")) {
			System.out.println("  ---------SCREEN---------");
			for(int i=0; i<gseat.length; i++) { 
				System.out.print(getAlphabet()[i] + " ");
				for(int j=0; j<gseat[i].length; j++) { 
					if(gseat[i][j]==0) {
						System.out.print("[ ]"); //빈좌석
					} else if(gseat[i][j]==1) {
						System.out.print("[O]"); //예매함
					} else if(gseat[i][j]==2) {
						System.out.print("[!]"); //짝수좌석 예매불가
					} else if(gseat[i][j]==3){
						System.out.print("[X]"); //이미 예매완료
					}
				}
				System.out.println();
			}
			System.out.println("  ------------------------");
		} else if(local.equals("인천")) {
			System.out.println("  ------------SCREEN------------");
			for(int i=0; i<iseat.length; i++) { 
				System.out.print(getAlphabet()[i] + " ");
				for(int j=0; j<iseat[i].length; j++) { 
					if(iseat[i][j]==0) {
						System.out.print("[ ]"); //빈좌석
					} else if(iseat[i][j]==1) {
						System.out.print("[O]"); //예매함
					} else if(iseat[i][j]==2) {
						System.out.print("[!]"); //짝수좌석 예매불가
					} else if(iseat[i][j]==3){
						System.out.print("[X]"); //이미 예매완료
					}
				}
				System.out.println();
			}
			System.out.println("  ------------------------------");
		}
	}
	
//	관람인원 선택
	public void seeMenu() {
		while(true) {
			seat();
			System.out.print("인원 선택(1~8)(0.이전): ");
			int person = scan.nextInt();
			if(person>8 || person<0) {
				System.out.println("인원을 다시 확인하세요.");
				seeMenu();
				break;
			} else {
				if(person==1) {
					one();
					break;
				} else if(person==2) {
					two();
					break;
				} else if(person==3) {
					three();
					break;
				} else if(person==4) {
					four();
					break;
				} else if(person==5) {
					five();
					break;
				} else if(person==6) {
					six();
					break;
				} else if(person==7) {
					seven();
					break;
				} else if(person==8) {
					eight();
					break;
				} else if(person==0) {
					time = new Date(0,0,0,0,0,0);
					break;
				}
			}
		}
	}
	
//	replaceLast
	public String replaceLast(String string, String toReplace, String replacement) {    
			int pos = string.lastIndexOf(toReplace);     
		    if (pos > -1) {     
		    	return string.substring(0, pos)+ replacement + string.substring(pos + toReplace.length(), string.length());     
		    } else { 
		    	return string;     
		    } 
		} 
	
//	1명 선택
	public void one() {
		while(true) {
			if(local.equals("서울")) {
				int c = 2; //-1이면 continue, 1이면 예매완료
				

				int[][] viewSeat = new int[8][2];
				
				for(int a=0; a<viewSeat.length; a++) { 
					for(int b=0; b<viewSeat[a].length; b++) { 
						viewSeat[a][b] = -1;
					}
				}
				
//				짝수좌석 선택 못하게 출력
				for(int i=0; i<seat.length; i++) { 
					for(int j=0; j<seat[i].length; j++) { 
						if((j+1)%2==0 && seat[i][j]!=3 && seat[i][j]!=1) {
//							선택한 좌석이 : 짝수좌석 / 예매 완료 / 예매함 일때
							seat[i][j]=2; // 짝수좌석 예매불과로 출력! 
//							앞에 예매한 좌석과 짝수좌석이 연달아 있을때 그 짝수좌석은 예매 가능하게 하는 코드
							if(j!=seat[0].length-1) {
								if(seat[i][j-1]==1 || seat[i][j+1]==1) {
									seat[i][j]=0;
								}
							} else {
								if(seat[i][j-1]==1) {
									seat[i][j]=0;
								}
							}
						}
					}
				}
				
				seat();
				int chk = -1; //행 index번호 찾기
				
				System.out.print("예매좌석1(A~M): ");
				String choice = scan.next();
				System.out.print("예매좌석2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("없는 좌석입니다.");
					continue;
				}
				
				if(choice2<1 || choice2>10) {
					c=-1;
				} 
				
				for(int i=0; i<getAlphabet().length; i++) { 
					if(getAlphabet()[i].equals(choice)) {
						chk = i;
					}
				}
				
//				예외처리
				if(chk<0) { //A~M열이 아니면
					c = -1;
				} else {
					for(int i=0; i<seat.length; i++) { 
						for(int j=0; j<seat[i].length; j++) { 
							if(choice2>seat[i].length+1 || choice2<1 || seat[chk][choice2-1]==3 || seat[chk][choice2-1]==1 || seat[chk][choice2-1]==2) { 
//								예매좌석번호가 0 이하, 10이상이거나 / 예매불가능한 좌석이거나 / 예매한 좌석이거나 / 홀수행을 선택하면
								c = -1;
							} else {
								c = 1;
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("예매불가능한 좌석입니다.");
					System.out.println("다시 선택해주세요.");
					continue;
				} else {
					seat[chk][choice2-1] = 1;
					seat();
					ticket = ticket + choice + "열" + (choice2);
					System.out.println("좌석선택이 완료되었습니다.");
					cnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					reset();
					System.out.println("[1]예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						seat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				}
			} else if(local.equals("경기도")) {
				int c = 2; //-1이면 continue, 1이면 예매완료
//				짝수좌석 선택 못하게 출력
				for(int i=0; i<gseat.length; i++) { 
					for(int j=0; j<gseat[i].length; j++) { 
						if((j+1)%2==0 && gseat[i][j]!=3 && gseat[i][j]!=1) {
//							선택한 좌석이 : 짝수좌석 / 예매 완료 / 예매함 일때
							gseat[i][j]=2; // 짝수좌석 예매불과로 출력!
//							앞에 예매한 좌석과 짝수좌석이 연달아 있을때 그 짝수좌석은 예매 가능하게 하는 코드
							if(j!=gseat[0].length-1) {
								if(gseat[i][j-1]==1 || gseat[i][j+1]==1) {
									gseat[i][j]=0;
								}
							} else {
								if(gseat[i][j-1]==1) {
									gseat[i][j]=0;
								}
							}
						}
					}
				}
				seat();
				int chk = -1; //행 index번호 찾기
				
				System.out.print("예매좌석1(A~I): ");
				String choice = scan.next();
				System.out.print("예매좌석2(1~8): ");
				int choice2 = scan.nextInt();
				
				if(choice2>8) {
					System.out.println("없는 좌석입니다.");
					continue;
				}
				
				if(choice2<1 || choice2>8) {
					c=-1;
				} 
				
				for(int i=0; i<getAlphabet().length; i++) { 
					if(getAlphabet()[i].equals(choice)) {
						chk = i;
					}
				}
				
				if(chk>8) {
					chk=-1;
				}
				
//				예외처리
				if(chk<0) { //A~M열이 아니면
					c = -1;
				} else {
					for(int i=0; i<gseat.length; i++) { 
						for(int j=0; j<gseat[i].length; j++) { 
							if(choice2>gseat[i].length+1 || choice2<1 || gseat[chk][choice2-1]==3 || gseat[chk][choice2-1]==1 || gseat[chk][choice2-1]==3) { 
//								예매좌석번호가 0 이하, 10이상이거나 / 예매불가능한 좌석이거나 / 예매한 좌석이거나 / 홀수행을 선택하면
								c = -1;
							} else {
								c = 1;
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("예매불가능한 좌석입니다.");
					System.out.println("다시 선택해주세요.");
					continue;
				} else {
					gseat[chk][choice2-1] = 1;
					seat();
					ticket = ticket + choice + "열" + (choice2);
					System.out.println("좌석선택이 완료되었습니다.");
					cnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					reset();
					System.out.println("[1]예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						gseat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				}
			} else if(local.equals("인천")) {
				int c = 2; //-1이면 continue, 1이면 예매완료
//				짝수좌석 선택 못하게 출력
				for(int i=0; i<iseat.length; i++) { 
					for(int j=0; j<iseat[i].length; j++) { 
						if((j+1)%2==0 && iseat[i][j]!=3 && iseat[i][j]!=1) {
//							선택한 좌석이 : 짝수좌석 / 예매 완료 / 예매함 일때
							iseat[i][j]=2; // 짝수좌석 예매불과로 출력!
//							앞에 예매한 좌석과 짝수좌석이 연달아 있을때 그 짝수좌석은 예매 가능하게 하는 코드
							if(j!=iseat[0].length-1) {
								if(iseat[i][j-1]==1 || iseat[i][j+1]==1) {
									iseat[i][j]=0;
								}
							} else {
								if(iseat[i][j-1]==1) {
									iseat[i][j]=0;
								}
							}
						}
					}
				}
				seat();
				int chk = -1; //행 index번호 찾기
				
				System.out.print("예매좌석1(A~E): ");
				String choice = scan.next();
				System.out.print("예매좌석2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("없는 좌석입니다.");
					continue;
				}
				
				if(choice2<1 || choice2>10) {
					c=-1;
				} 
				
				for(int i=0; i<getAlphabet().length; i++) { 
					if(getAlphabet()[i].equals(choice)) {
						chk = i;
					}
				}
				
				if(chk>4) {
					chk=-1;
				}
				
//				예외처리
				if(chk<0) { //A~M열이 아니면
					c = -1;
				} else {
					for(int i=0; i<iseat.length; i++) { 
						for(int j=0; j<iseat[i].length; j++) { 
							if(choice2>iseat[i].length+1 || choice2<1 || iseat[chk][choice2-1]==3 || iseat[chk][choice2-1]==1 || iseat[chk][choice2-1]==3) { 
//								예매좌석번호가 0 이하, 10이상이거나 / 예매불가능한 좌석이거나 / 예매한 좌석이거나 / 홀수행을 선택하면
								c = -1;
							} else {
								c = 1;
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("예매불가능한 좌석입니다.");
					System.out.println("다시 선택해주세요.");
					continue;
				} else {
					iseat[chk][choice2-1] = 1;
					seat();
					ticket = ticket + choice + "열" + (choice2);
					System.out.println("좌석선택이 완료되었습니다.");
					cnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					reset();
					System.out.println("[1]예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						iseat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				}
			} 
			
		}
	}
	
//	2명 선택
	public void two() {
		while(true) {
			if(local.equals("서울")) {
				seat();
				int chk = -1; //행 index번호 찾기
				int c = 2; //-1이면 continue, 1이면 예매완료, 2면 뒤에 좌석!
				
				System.out.print("예매좌석1(A~M): ");
				String choice = scan.next();
				System.out.print("예매좌석2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("없는 좌석입니다.");
					continue;
				}
				
				if(choice2<1 || choice2>10) {
					c=-1;
				} 
				
				for(int i=0; i<getAlphabet().length; i++) { 
					if(getAlphabet()[i].equals(choice)) {
						chk = i;
					}
				}
				
//				예외처리
				if(c!=-1) {
					if(chk<0) { //A~M열이 아니면
						c = -1;
					} else {
						for(int i=0; i<seat.length; i++) { 
							for(int j=0; j<seat[i].length; j++) { 
								if(choice2!=seat[i].length) {
									if((seat[chk][choice2-1]!=1 && seat[chk][choice2-1]!=3) && (seat[chk][choice2]==1 || seat[chk][choice2]==3) && (seat[chk][choice2-2]!=3 && seat[chk][choice2-2]!=1)) {
//										선택한 좌석이 예매가능 좌석이고, 선택한 다음 좌석이 예매완료고, 선택하기 전 좌석이 예매완료가 아니면
										c = 1;
									} else if(choice2>seat[i].length+1 || choice2<1 || seat[chk][choice2-1]==3 || seat[chk][choice2-1]==1 || seat[chk][choice2]==3 || seat[chk][choice2]==1) { 
//										예매좌석번호가 0 이하, 10이상이거나 / 예매불가능한 좌석이거나 / 예매완료거나 / 다음좌석이 예매불가능한 좌석이거나 / 다음 좌석이 예매완료
										c = -1;
									} 
								} else {
									if(seat[chk][choice2-2]==3 || seat[chk][choice2-2]==1) {
//										10번 좌석을 선택했을 때 9번 좌석이 예매완료나 예매중상태면
										c = -1;
									} else {
										c = 1;
									}
								}
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("예매불가능한 좌석입니다.");
					System.out.println("다시 선택해주세요.");
					continue;
				} else if(c==1) {
					seat[chk][choice2-1] = 1; //선택한 좌석
					seat[chk][choice2-2] = 1; //선택한 좌석의 이전 예매!
					seat();
					System.out.println("좌석선택이 완료되었습니다.");
					ticket = ticket + choice + "열" + (choice2-1) + " ";
					ticket = ticket + choice + "열" + (choice2);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				} else if(c==2) {
					seat[chk][choice2-1] = 1; //선택한 좌석
					seat[chk][choice2] = 1; //선택한 좌석 다음좌석 예매
					seat();
					System.out.println("좌석선택이 완료되었습니다.");
					ticket = ticket + choice + "열" + (choice2) + " ";
					ticket = ticket + choice + "열" + (choice2+1);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				}
			} else if(local.equals("경기도")) {
				seat();
				int chk = -1; //행 index번호 찾기
				int c = 2; //-1이면 continue, 1이면 예매완료, 2면 뒤에 좌석!
				
				System.out.print("예매좌석1(A~I): ");
				String choice = scan.next();
				System.out.print("예매좌석2(1~8): ");
				int choice2 = scan.nextInt();
				
				if(choice2>8) {
					System.out.println("없는 좌석입니다.");
					continue;
				}
				
				if(choice2<1 || choice2>8) {
					c=-1;
				} 
				
				for(int i=0; i<getAlphabet().length; i++) { 
					if(getAlphabet()[i].equals(choice)) {
						chk = i;
					}
				}
				
				if(chk>8) {
					chk=-1;
				}
				
//				예외처리
				if(c!=-1) {
					if(chk<0) { //A~M열이 아니면
						c = -1;
					} else {
						for(int i=0; i<gseat.length; i++) { 
							for(int j=0; j<gseat[i].length; j++) { 
								if(choice2!=gseat[i].length) {
									if((gseat[chk][choice2-1]!=1 && gseat[chk][choice2-1]!=3) && (gseat[chk][choice2]==1 || gseat[chk][choice2]==3) && (gseat[chk][choice2-2]!=3 && gseat[chk][choice2-2]!=1)) {
//										선택한 좌석이 예매가능 좌석이고, 선택한 다음 좌석이 예매완료고, 선택하기 전 좌석이 예매완료가 아니면
										c = 1;
									} else if(choice2>gseat[i].length+1 || choice2<1 || gseat[chk][choice2-1]==3 || gseat[chk][choice2-1]==1 || gseat[chk][choice2]==3 || gseat[chk][choice2]==1) { 
//										예매좌석번호가 0 이하, 10이상이거나 / 예매불가능한 좌석이거나 / 예매완료거나 / 다음좌석이 예매불가능한 좌석이거나 / 다음 좌석이 예매완료
										c = -1;
									} 
								} else {
									if(gseat[chk][choice2-2]==3 || gseat[chk][choice2-2]==1) {
//										10번 좌석을 선택했을 때 9번 좌석이 예매완료나 예매중상태면
										c = -1;
									} else {
										c = 1;
									}
								}
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("예매불가능한 좌석입니다.");
					System.out.println("다시 선택해주세요.");
					continue;
				} else if(c==1) {
					gseat[chk][choice2-1] = 1; //선택한 좌석
					gseat[chk][choice2-2] = 1; //선택한 좌석의 이전 예매!
					seat();
					System.out.println("좌석선택이 완료되었습니다.");
					ticket = ticket + choice + "열" + (choice2-1) + " ";
					ticket = ticket + choice + "열" + (choice2);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				} else if(c==2) {
					gseat[chk][choice2-1] = 1; //선택한 좌석
					gseat[chk][choice2] = 1; //선택한 좌석 다음좌석 예매
					seat();
					System.out.println("좌석선택이 완료되었습니다.");
					ticket = ticket + choice + "열" + (choice2) + " ";
					ticket = ticket + choice + "열" + (choice2+1);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				}
			} else if(local.equals("인천")) {
				seat();
				int chk = -1; //행 index번호 찾기
				int c = 2; //-1이면 continue, 1이면 예매완료, 2면 뒤에 좌석!
				
				System.out.print("예매좌석1(A~E): ");
				String choice = scan.next();
				System.out.print("예매좌석2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2<1 || choice2>10) {
					c=-1;
				} 
				
				if(choice2>10) {
					System.out.println("없는 좌석입니다.");
					continue;
				}
				
				for(int i=0; i<getAlphabet().length; i++) { 
					if(getAlphabet()[i].equals(choice)) {
						chk = i;
					}
				}
				
				if(chk>4) {
					chk=-1;
				}
				
//				예외처리
				if(c!=-1) {
					if(chk<0) { //A~M열이 아니면
						c = -1;
					} else {
						for(int i=0; i<iseat.length; i++) { 
							for(int j=0; j<iseat[i].length; j++) { 
								if(choice2!=iseat[i].length) {
									if((iseat[chk][choice2-1]!=1 && iseat[chk][choice2-1]!=3) && (iseat[chk][choice2]==1 || iseat[chk][choice2]==3) && (iseat[chk][choice2-2]!=3 && iseat[chk][choice2-2]!=1)) {
//										선택한 좌석이 예매가능 좌석이고, 선택한 다음 좌석이 예매완료고, 선택하기 전 좌석이 예매완료가 아니면
										c = 1;
									} else if(choice2>iseat[i].length+1 || choice2<1 || iseat[chk][choice2-1]==3 || iseat[chk][choice2-1]==1 || iseat[chk][choice2]==3 || iseat[chk][choice2]==1) { 
//										예매좌석번호가 0 이하, 10이상이거나 / 예매불가능한 좌석이거나 / 예매완료거나 / 다음좌석이 예매불가능한 좌석이거나 / 다음 좌석이 예매완료
										c = -1;
									} 
								} else {
									if(iseat[chk][choice2-2]==3 || iseat[chk][choice2-2]==1) {
//										10번 좌석을 선택했을 때 9번 좌석이 예매완료나 예매중상태면
										c = -1;
									} else {
										c = 1;
									}
								}
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("예매불가능한 좌석입니다.");
					System.out.println("다시 선택해주세요.");
					continue;
				} else if(c==1) {
					iseat[chk][choice2-1] = 1; //선택한 좌석
					iseat[chk][choice2-2] = 1; //선택한 좌석의 이전 예매!
					seat();
					System.out.println("좌석선택이 완료되었습니다.");
					ticket = ticket + choice + "열" + (choice2-1) + " ";
					ticket = ticket + choice + "열" + (choice2);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				} else if(c==2) {
					iseat[chk][choice2-1] = 1; //선택한 좌석
					iseat[chk][choice2] = 1; //선택한 좌석 다음좌석 예매
					seat();
					System.out.println("좌석선택이 완료되었습니다.");
					ticket = ticket + choice + "열" + (choice2) + " ";
					ticket = ticket + choice + "열" + (choice2+1);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				}
			} 
			
		}
	}
	
//	2명 선택(3명 이상 선택했을시)
	public void twoOne() {
		while(true) {
			if(local.equals("서울")) {
				seat();
				int chk = -1; //행 index번호 찾기
				int c = 2; //-1이면 continue, 1이면 예매완료, 2면 뒤에 좌석!
				
				System.out.print("예매좌석1(A~M): ");
				String choice = scan.next();
				System.out.print("예매좌석2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("없는 좌석입니다.");
					continue;
				}
				
				if(choice2<1 || choice2>10) {
					c=-1;
				}  
				
				for(int i=0; i<getAlphabet().length; i++) { 
					if(getAlphabet()[i].equals(choice)) {
						chk = i;
					}
				}
				
//				예외처리
				if(c!=-1) {
					if(chk<0) { //A~M열이 아니면
						c = -1;
					} else {
						for(int i=0; i<seat.length; i++) { 
							for(int j=0; j<seat[i].length; j++) { 
								if(choice2!=seat[i].length) {
									if((seat[chk][choice2-1]!=1 && seat[chk][choice2-1]!=3) && (seat[chk][choice2]==1 || seat[chk][choice2]==3) && (seat[chk][choice2-2]!=3 && seat[chk][choice2-2]!=1)) {
//										선택한 좌석이 예매가능 좌석이고, 선택한 다음 좌석이 예매완료고, 선택하기 전 좌석이 예매완료가 아니면
										c = 1;
									} else if(choice2>seat[i].length+1 || choice2<1 || seat[chk][choice2-1]==3 || seat[chk][choice2-1]==1 || seat[chk][choice2]==3 || seat[chk][choice2]==1) { 
//										예매좌석번호가 0 이하, 10이상이거나 / 예매불가능한 좌석이거나 / 예매완료거나 / 다음좌석이 예매불가능한 좌석이거나 / 다음 좌석이 예매완료
										c = -1;
									} 
								} else {
									if(seat[chk][choice2-2]==3 || seat[chk][choice2-2]==1) {
//										10번 좌석을 선택했을 때 9번 좌석이 예매완료나 예매중상태면
										c = -1;
									} else {
										c = 1;
									}
								}
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("예매불가능한 좌석입니다.");
					System.out.println("다시 선택해주세요.");
					continue;
				} else if(c==1) {
					seat[chk][choice2-1] = 1; //선택한 좌석
					seat[chk][choice2-2] = 1; //선택한 좌석의 이전 예매!
					ticket = ticket + choice + "열" + (choice2-1) + " ";
					ticket = ticket + choice + "열" + (choice2) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]계속 예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0;
						seat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						seat[chk][choice2-1] = 0;
						seat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				} else if(c==2) {
					seat[chk][choice2-1] = 1; //선택한 좌석
					seat[chk][choice2] = 1; //선택한 좌석 다음좌석 예매
					ticket = ticket + choice + "열" + (choice2) + " ";
					ticket = ticket + choice + "열" + (choice2+1) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]계속 예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0;
						seat[chk][choice2] = 0; 
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1) + " ", "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1) + " ", "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				}
			} else if(local.equals("경기도")) {
				seat();
				int chk = -1; //행 index번호 찾기
				int c = 2; //-1이면 continue, 1이면 예매완료, 2면 뒤에 좌석!
				
				System.out.print("예매좌석1(A~I): ");
				String choice = scan.next();
				System.out.print("예매좌석2(1~8): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("없는 좌석입니다.");
					continue;
				}
				
				if(choice2<1 || choice2>8) {
					c=-1;
				}  
				
				for(int i=0; i<getAlphabet().length; i++) { 
					if(getAlphabet()[i].equals(choice)) {
						chk = i;
					}
				}
				
				if(chk>8) {
					chk=-1;
				}
				
//				예외처리
				if(c!=-1) {
					if(chk<0) { //A~M열이 아니면
						c = -1;
					} else {
						for(int i=0; i<gseat.length; i++) { 
							for(int j=0; j<gseat[i].length; j++) { 
								if(choice2!=gseat[i].length) {
									if((gseat[chk][choice2-1]!=1 && gseat[chk][choice2-1]!=3) && (gseat[chk][choice2]==1 || gseat[chk][choice2]==3) && (gseat[chk][choice2-2]!=3 && gseat[chk][choice2-2]!=1)) {
//										선택한 좌석이 예매가능 좌석이고, 선택한 다음 좌석이 예매완료고, 선택하기 전 좌석이 예매완료가 아니면
										c = 1;
									} else if(choice2>gseat[i].length+1 || choice2<1 || gseat[chk][choice2-1]==3 || gseat[chk][choice2-1]==1 || gseat[chk][choice2]==3 || gseat[chk][choice2]==1) { 
//										예매좌석번호가 0 이하, 10이상이거나 / 예매불가능한 좌석이거나 / 예매완료거나 / 다음좌석이 예매불가능한 좌석이거나 / 다음 좌석이 예매완료
										c = -1;
									} 
								} else {
									if(gseat[chk][choice2-2]==3 || gseat[chk][choice2-2]==1) {
//										10번 좌석을 선택했을 때 9번 좌석이 예매완료나 예매중상태면
										c = -1;
									} else {
										c = 1;
									}
								}
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("예매불가능한 좌석입니다.");
					System.out.println("다시 선택해주세요.");
					continue;
				} else if(c==1) {
					gseat[chk][choice2-1] = 1; //선택한 좌석
					gseat[chk][choice2-2] = 1; //선택한 좌석의 이전 예매!
					ticket = ticket + choice + "열" + (choice2-1) + " ";
					ticket = ticket + choice + "열" + (choice2) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]계속 예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0;
						gseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						gseat[chk][choice2-1] = 0;
						gseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				} else if(c==2) {
					gseat[chk][choice2-1] = 1; //선택한 좌석
					gseat[chk][choice2] = 1; //선택한 좌석 다음좌석 예매
					ticket = ticket + choice + "열" + (choice2) + " ";
					ticket = ticket + choice + "열" + (choice2+1) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]계속 예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0;
						gseat[chk][choice2] = 0; 
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1) + " ", "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1) + " ", "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				}
			} else if(local.equals("인천")) {
				seat();
				int chk = -1; //행 index번호 찾기
				int c = 2; //-1이면 continue, 1이면 예매완료, 2면 뒤에 좌석!
				
				System.out.print("예매좌석1(A~E): ");
				String choice = scan.next();
				System.out.print("예매좌석2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("없는 좌석입니다.");
					continue;
				}
				
				if(choice2<1 || choice2>10) {
					c=-1;
				}  
				
				for(int i=0; i<getAlphabet().length; i++) { 
					if(getAlphabet()[i].equals(choice)) {
						chk = i;
					}
				}
				
				if(chk>4) {
					chk=-1;
				}
				
//				예외처리
				if(c!=-1) {
					if(chk<0) { //A~M열이 아니면
						c = -1;
					} else {
						for(int i=0; i<iseat.length; i++) { 
							for(int j=0; j<iseat[i].length; j++) { 
								if(choice2!=iseat[i].length) {
									if((iseat[chk][choice2-1]!=1 && iseat[chk][choice2-1]!=3) && (iseat[chk][choice2]==1 || iseat[chk][choice2]==3) && (iseat[chk][choice2-2]!=3 && iseat[chk][choice2-2]!=1)) {
//										선택한 좌석이 예매가능 좌석이고, 선택한 다음 좌석이 예매완료고, 선택하기 전 좌석이 예매완료가 아니면
										c = 1;
									} else if(choice2>iseat[i].length+1 || choice2<1 || iseat[chk][choice2-1]==3 || iseat[chk][choice2-1]==1 || iseat[chk][choice2]==3 || iseat[chk][choice2]==1) { 
//										예매좌석번호가 0 이하, 10이상이거나 / 예매불가능한 좌석이거나 / 예매완료거나 / 다음좌석이 예매불가능한 좌석이거나 / 다음 좌석이 예매완료
										c = -1;
									} 
								} else {
									if(iseat[chk][choice2-2]==3 || iseat[chk][choice2-2]==1) {
//										10번 좌석을 선택했을 때 9번 좌석이 예매완료나 예매중상태면
										c = -1;
									} else {
										c = 1;
									}
								}
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("예매불가능한 좌석입니다.");
					System.out.println("다시 선택해주세요.");
					continue;
				} else if(c==1) {
					iseat[chk][choice2-1] = 1; //선택한 좌석
					iseat[chk][choice2-2] = 1; //선택한 좌석의 이전 예매!
					ticket = ticket + choice + "열" + (choice2-1) + " ";
					ticket = ticket + choice + "열" + (choice2) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]계속 예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0;
						iseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						iseat[chk][choice2-1] = 0;
						iseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "열" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				} else if(c==2) {
					iseat[chk][choice2-1] = 1; //선택한 좌석
					iseat[chk][choice2] = 1; //선택한 좌석 다음좌석 예매
					ticket = ticket + choice + "열" + (choice2) + " ";
					ticket = ticket + choice + "열" + (choice2+1) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]계속 예매하기\n[2]좌석 다시 선택");
					System.out.print("메뉴선택: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0;
						iseat[chk][choice2] = 0; 
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1) + " ", "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("없는 메뉴입니다.");
						System.out.println("다시 선택해주세요.");
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "열" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "열" + (choice2+1) + " ", "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					}
					if(c==1) {
						continue;
					} else if(c==-1) {
						break;
					}
				}
			} 
		}
	}
	
//	3명 선택
	public void three() {
		twoOne();
		one();
	}
	
//	4명 선택
	public void four() {
		twoOne();
		two();
	}
	
//	5명 선택
	public void five() {
		twoOne();
		twoOne();
		one();
	}
	
//	6명 선택
	public void six() {
		twoOne();
		twoOne();
		two();
	}
	
//	7명 선택
	public void seven() {
		twoOne();
		twoOne();
		twoOne();
		one();
	}
	
//	8명 선택
	public void eight() {
		twoOne();
		twoOne();
		twoOne();
		two();
	}
	
//	좌석 초기화 
	public void reset() {
		if(local.equals("서울")) {
			for(int i=0; i<seat.length; i++) { 
				for(int j=0; j<seat[i].length; j++) { 
					if(seat[i][j]==2) {
						seat[i][j]=0;
					} else if(seat[i][j]==1) {
						seat[i][j]=3;
					}
				}
			}
		} else if(local.equals("경기도")) {
			for(int i=0; i<gseat.length; i++) { 
				for(int j=0; j<gseat[i].length; j++) { 
					if(gseat[i][j]==2) {
						gseat[i][j]=0;
					} else if(gseat[i][j]==1) {
						gseat[i][j]=3;
					}
				}
			}
		} else if(local.equals("인천")) {
			for(int i=0; i<iseat.length; i++) { 
				for(int j=0; j<iseat[i].length; j++) { 
					if(iseat[i][j]==2) {
						iseat[i][j]=0;
					} else if(iseat[i][j]==1) {
						iseat[i][j]=3;
					}
				}
			}
		} 
	}
	
//	결제하기
	public void payment() {
		int log = Menu.log;
		for(int i=0; i<size; i++) {
			if(name.equals(getMovie()[i])) {
				moviePrice = getPrice()[i];
			}
		}
		price = cnt*moviePrice;
		price2 = cnt*moviePrice; //포인트로 차감
		cal.setTime(time);
		cal.add(Calendar.HOUR, preview[mo][0]);
		cal.add(Calendar.MINUTE, preview[mo][1]);
		while(true) {
			System.out.println();
			System.out.println("---------------------------------");
			System.out.printf("%s\n%s(%s)\n%s | %s~%s\n성인 %d명(%s)\n", name, Theater, local, f.format(time), f2.format(time), f2.format(cal.getTime()), cnt, ticket);
			System.out.println("---------------------------------");
			System.out.printf("금액:\t\t%s원\n포인트:\t\t-%sp\n총결제금액:\t%s원\n", de.format(price), de.format(point), de.format(price2));
			System.out.println("---------------------------------");
			System.out.println("[1]결제\n[2]포인트 사용\n[3]좌석 다시 선택");
			System.out.print("메뉴선택: ");
			int select = scan.nextInt();
			if(select==1) {
				Date current = new Date();
				dath = current;
				ticketing.add(new TicketingVO(id, name, local, Theater, dath, time, ticket, cnt, price2, point));
				
				for(int i=0; i<size; i++) {
					if(name.equals(getMovie()[i])) {
						getPeople()[i] = getPeople()[i] + cnt;
						int a = getPeople()[i];
						double b = (a*100)/252.0;
						advance[i] = b;
					}
				}
				alarm.add(new AlarmVO(log, time, name));
				System.out.println("결제가 완료되었습니다.");
				double inPoint = price2*0.05;
				System.out.printf("영화예매로 %sp가 적립되었습니다!\n", de.format((int)inPoint));
				pointVO.add(new PointVO(id, "영화예매", (int)inPoint, current));
				user.get(log).setPoint((int)inPoint);
				basketReset();
				finalChk = 0;
				break;
			} else if(select==2) {
				System.out.printf("현재 보유 포인트: %sp\n", de.format(user.get(log).getPoint()));
				System.out.print("사용할 포인트: ");
				point = scan.nextInt();
				if(point>user.get(log).getPoint()) {
					System.out.println("포인트가 부족합니다.");
					point = 0;
				} else if(point<1) {
					System.out.println("0p이하는 쓸 수 없습니다.");
					point = 0;
				} else {
					Date current = new Date();
					price2 = price2 - point;
					user.get(log).setPoint(-point);
					System.out.printf("%sp만큼 금액이 차갑됩니다.\n", de.format(point));
					pointVO.add(new PointVO(id, "영화예매", -point, current));
				}
			} else if(select==3) {
				user.get(log).setPoint(point);
				cnt = 0;
				price = 0;
				price2 = 0;
				point = 0;
				ticket = "";
				for(int i=0; i<8; i++) {
					for(int j=0; j<2; j++) {
						if(seat2[i][j]>-1) {
							if(local.equals("서울")) {
								seat[seat2[i][0]][seat2[i][1]] = 0;
							} else if(local.equals("경기도")) {
								gseat[seat2[i][0]][seat2[i][1]] = 0;
							} else if(local.equals("인천")) {
								iseat[seat2[i][0]][seat2[i][1]] = 0;
							} 
						}
					}
				}
				seatCnt = 0;
				seeMenu();
				break;
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}	
	}
	
//	장바구니 리셋
	public void basketReset() {
		id = ""; //영화구매한 회원
		name = ""; //영화이름
		local = ""; //지역
		Theater = ""; //영화관
		dath = new Date(0,0,0,0,0,0); //예매일
		ticket = ""; //예매한 열
		cnt = 0; //구매한 영화 갯수
		price = 0; //영화금액
		price2 = 0; //영화금액
		point = 0; //영화금액
		moviePrice = 0;
		seatCnt = 0;
	}
	
//	검색
	public void search() {
		int log = Menu.log;
		int cnt = 0;
		System.out.print("영화명 검색: ");
		String movie = scan.next();
		for(int i=0; i<size; i++) {
			if(getMovie()[i].contains(movie)) {
				cnt = 1;
			}
		}
		if(cnt==0) {
			System.out.println("존재하지 않는 영화입니다.");
		} else {
			cnt=1;
			System.out.println();
			System.out.println("            --[영화 목록]--");
			System.out.println("--------------------------------------");
			System.out.println("      영화이름\t예매율\t상영일");
			for(int i=0; i<size; i++) {
				if(getMovie()[i].contains(movie)) {
					if(count==0) {
						for(int j=0; j<size; j++) {
							getDay()[j].setYear(getDay()[j].getYear()-1900);
							getDay()[j].setMonth(getDay()[j].getMonth()-1);
							count=1;
						}
					}
					System.out.printf("[%d]%s\t%.1f\t%s\n", cnt, getMovie()[i], advance[i], f.format(getDay()[i]));
					cnt++;
				} 
			}
			cnt=0;
			System.out.println("--------------------------------------");
			System.out.println("[1]예매\n[2]이전");
			System.out.print("메뉴선택: ");
			int select = scan.nextInt();
				
			if(select==1) {
				if(log<0) {
					System.out.println("로그인 후 이용가능");
				} else {
					id = user.get(log).getId();
					System.out.print("예매할 영화: ");
					int select2 = scan.nextInt();
					for(int i=0; i<size; i++) {
						if(getMovie()[i].contains(movie)) {
							cnt++;
						} 
						if(cnt==select2) { 
							name = getMovie()[i];
							mo = i;
							ticketing();
						}
					}
				}
			} else if(select==2) {
			} else {
				System.out.println("없는 메뉴입니다.");
			}
		}
	}
	
}
