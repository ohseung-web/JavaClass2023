package leejunhun;

import java.util.*;
import java.text.*;
public class Shop {

	Scanner scn = new Scanner(System.in);
	ProductManager pm = new ProductManager();
	UserManager um = new UserManager();
	QnaManager qnam = new QnaManager();
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd _ hh:mm");
	
	User currentUser;
	String martlogo = "*********************MEGA MART     since 2020.05.14 *****************";
	String[] OutterMenu = {"로그인", "회원가입", "종료","관리자로그인"};
	String[] InnerMenu = {"MyPage", "쇼핑하기", "로그아웃", "회원탈퇴"};
	// 로그아웃은 이너메뉴임
	
	public void Run() {
	
		OutterMenu:				// 로그인 안되어있을때.
			while(true)	{
				if(currentUser == null) {
					OutterMenus();
					System.out.print("메뉴를 선택하세요 : ");
					int selector = scn.nextInt();
					
					switch(selector)	{
					case 1:				//로그인
						MemberLogin();			// FI P
						break;
					case 2:				//회원가입
						MemberJoin();
						break;
					case 3:
						break OutterMenu;
					case 4:
						System.out.println("관리자 : [eriot : qwer!]");
						MemberLogin();
						break;
					}
				
				}else if(currentUser != null)	{		// 로그인 되어있다면
					System.out.println("\n\n");
					// MyPage, 쇼핑하기, 로그아웃하기, 회원탈퇴하기, 
					InnerMenu:
						while(true)	{			// 사용자로그인
							if(currentUser.getClass().equals(User.class)) {

								InnerMenus();
								System.out.print("메뉴를 선택하세요 : ");
								int innerselect = scn.nextInt();
								
								switch(innerselect)	{
									case 1:				// mypage
										MemberMypage();
										break;
									case 2:				// shopping
										pm.Shopping(currentUser);
										break;
									case 3:				// logout
										MemberLogout();
									
										break InnerMenu;
									case 4:				// secede
										MemberSecede();
										break InnerMenu;
								}
								
							}else {			// 관리자로그인
								System.out.println("반갑습니다. 관리자님.");
								Administrator();
							break;
							// 관리자메뉴
							}
			
						}
				}
			}
	}
	
	public void OutterMenus()	{
		System.out.println();
		System.out.println(martlogo);
		System.out.println("");
		for(int i=1; i<=OutterMenu.length; i++)	{
			System.out.println("\t\t\t[" + i + "]" + OutterMenu[i-1]);

		}
	}
	public void InnerMenus()	{
		System.out.println("=====================================================================");
		System.out.println("\t\t\t  " + currentUser.getId() + " 님, 반갑습니다");
		System.out.println("=====================================================================");
		for(int i=1; i<=InnerMenu.length; i++)	{
			System.out.println("\t\t\t[" + i + "]" + InnerMenu[i-1]);
		}
	}
	
	public void MemberLogin()	{
		currentUser = um.Login();
		if(currentUser == null)	{
			System.out.println("해당 계정정보가 시스템에 없습니다.\n");
		}else {
			System.out.println("안녕하세요, " + currentUser.getId() +" 님!");
		}
	}
	public void MemberLogout()	{
		currentUser = um.Logout(currentUser);
		if(currentUser == null)	{
			System.out.println("성공적으로 로그아웃 되었습니다! \n");
		}
	}
	public void MemberJoin() {
		int statuscode = um.Join();
		if(statuscode == 200)	{
			System.out.println("회원가입에 성공하였습니다! 환영합니다!\n");
		}else if(statuscode == 404) {
			System.out.println("에러가 발생하였습니다. 관리자에게 연락 바랍니다.\n");
		}else if(statuscode == 403)	{
			System.out.println("이미 시스템에 존재하는 계정명입니다. 다른계정을 선택해주세요\n");
		}else {
			System.out.println("ERR!");
		}
	}
	public void MemberSecede() {
		int statuscode = um.secede(currentUser);
		if(statuscode == 404)	{
			System.out.println("로그인 후 이용해주세요.\n");
		}else if(statuscode == 403)	{
			System.out.println("관리자 계정은 탈퇴할 수 없습니다.\n");
		}else if(statuscode == 200) {
			System.out.println("정상 탈퇴처리 되었습니다. 안녕히가세요\n");
			currentUser = null;
		}else if(statuscode == 4041)	{
			System.out.println("입력한 계정정보가 시스템에 없습니다. 다시확인해주세요\n");
		}
	}
	public void MemberMypage()	{
		String[] myPageMenu = {"뒤로가기", "개인정보 조회", "장바구니 조회", "문의하기", "지난문의 확인하기"};
		String[] personalMenu = {"뒤로가기", "비밀번호변경", "기초배송지 변경"};
		// 비밀번호 변경 메서드 있음.
	
		MyPage:
			while(true) {
				System.out.println("=====================================================================");
				System.out.println("\t\t\t    " + "MY PAGE");
				System.out.println("=====================================================================");
				for(int i=0; i<myPageMenu.length; i++)	{
					System.out.println("\t\t\t[" + i + "] " + myPageMenu[i]);
				}
				System.out.print("메뉴 선택 : ");
				int sel = scn.nextInt();
				switch(sel)	{
					case 0:
						break MyPage;
					case 1:		// 개인정보 조회
						while(true) {
							System.out.println("=====================================================================");
							System.out.println("\t\t\t  " + "개인정보 조회");
							System.out.println("=====================================================================");
							
							System.out.println("\t계정명 : " + currentUser.getId());
							System.out.println("\t계정종류 : " + currentUser.getAcctype());
							System.out.println("\t사용자 이름 : " + currentUser.getId());
							System.out.println("\t사용자 전화번호 : " + currentUser.getTel());
							System.out.println("\t사용자 E-mail: " + currentUser.getEmail());
							System.out.println("\t사용자 기본 배송지 주소 : \n\t" + currentUser.getPrimaryaddr());
							System.out.println("=====================================================================");
							
							for(int i=0; i<personalMenu.length; i++)	{
								System.out.println("[" + i + "] " + personalMenu[i]);
							}
							System.out.print("메뉴 선택 : ");
							int innersel = scn.nextInt();
							
							if(innersel == 0)	{
								break;
							}else if(innersel == 1) {
								currentUser.changePw();
							}else if(innersel == 2) {
								currentUser.changeAddr();
							}
							
						}
						break;
					case 2:		
						currentUser.showBucket();
						break;
					case 3: 	
						System.out.println("=====================================================================");
						System.out.println("\t\t\t" + "       문의하기");
						System.out.println("=====================================================================");
						System.out.println("\t   **조회시, 개인 비밀번호를 조회하는점 참고바랍니다.**");
						int result=-1;
						result= qnam.addQna(currentUser);
						if(result==1)	{
							System.out.println("\t         **정상적으로 문의가 등록되었습니다!**");
						}
						break;
					case 4:		// 지난 문의사항 확인하기
						System.out.println("=====================================================================");
						System.out.println("\t\t\t" + "지난 문의내역 확인하기");
						System.out.println("=====================================================================");
						
						//lastqnaPrinter();
						
						ArrayList<Qna> qnalist = new ArrayList<>();
						qnalist = qnam.getQna(currentUser);
						if(qnalist.isEmpty())	{
							System.out.println("\t\t   ** 지난 문의내역이 없습니다.**");
						}else {		// 문의내역이 있다면
							qnalookup:
								while(true) {
									System.out.println("#num\t     작성일\t\t제목\t\t\t답변상태");
									
									for(Qna q : qnalist)	{
										System.out.print(q.getSerialId() + "\t" + sdf.format(q.getDate())
											+"\t"+q.getTitle());
										if(q.getReplyId()==null) {
											System.out.println("\t\t\tN");
										}else {
											System.out.println("\t\t\tY");
										}
									}
									System.out.print("[1] 문의 상세히보기 [2] 뒤로가기\n메뉴선택 : ");
									int qnawork = scn.nextInt();
									switch(qnawork) {
										case 1:
											System.out.print("자세히 볼 문의내역의 #number : ");
											int target = scn.nextInt();
											Qna targetqna = null;
											for(Qna q : qnalist)	{
												if(q.getSerialId() == target) {
													targetqna = q;
												}
											}
											if(targetqna==null) {
												System.out.println("유효하지 않은 입력입니다.");
											}else {
												System.out.println("=====================================================================");
												System.out.print("문의내역 번호 : #" + targetqna.getSerialId() +"\t\t\t\t답변자 : ");
												if(targetqna.getReplyId()==null) {
													System.out.println("미답변상태");
												}else {
													System.out.println(targetqna.getReplyId());
												}
												System.out.println("문의 제목 : " + targetqna.getTitle());
												System.out.println("\n\n");
												System.out.println("문의 본문\n"+targetqna.getContents());
												if(!(targetqna.getReplyId()==null)) {
													System.out.println("\n\n문의 답변\n"+targetqna.getAnswer());
												}
												System.out.println("=====================================================================");
											}
											break;
										case 2:
											break qnalookup;
									}
								}
						}
						break;
				}
			}
		// TODO 쇼핑하기 
		
	}
	
	public void lastqnaPrinter() {
		String tmp = "=====================================================================";
		int length = tmp.length();
		System.out.println(length);
		String temp = "제목			";
		System.out.println(temp.length());
		
	}
	
	public void Administrator() {
		AdminOutter:
			while(true) {
				String[] adminMenu = {"점포관리", "회원관리", "문의관리", "관리자로그아웃"};
				System.out.println("[관리메뉴]");
				for(int i=0; i<adminMenu.length; i++)	{
					System.out.println("["+(i+1)+"] " + adminMenu[i]);
				}
				System.out.print("작업 : ");
				int adminsel = scn.nextInt();
				switch(adminsel) {
					case 1:				//점포관리
						StoreManager();
						break;
					case 2:				//회원관리
						MemberManager();
						break;
					case 3:				//문의관리
						QnaManager();
						break;
					case 4:				// 관리자로그아웃
						System.out.println("Log out Succeed!");
						currentUser = null;
						break AdminOutter;
				}
			}
	}
	public void StoreManager() {
		storemanager:
			while(true)	{
				System.out.println("[0] 뒤로가기 [1] 기존점포관리 [2] 신규입점\n 메뉴 선택 :");
				int storesel = scn.nextInt();
				switch(storesel)	{
					case 0:
						break storemanager;
					case 1:
						System.out.println("==========점포현황보고=========");
						LinkedHashSet <String> sellers = new LinkedHashSet<>();

						for(Product p : pm.productList) {

							sellers.add(p.seller);
						}
						ArrayList<String> storenames = new ArrayList<>(sellers);
						
						for(int i=0; i<storenames.size(); i++)	{
							System.out.println("[" + i + "] " + storenames.get(i));
						}
						System.out.println("[-1] 뒤로가기 [N] 해당점포관리");
						int targetstore = scn.nextInt();
						
						if(targetstore == -1)	{
							continue;
							
						}else {
							String storename = storenames.get(targetstore);
							System.out.println("\t\t["+storename+"]");
							System.out.println("\t"+ storename + " 가게의 상품");
							for(Product p : pm.productList)	{
								if(p.seller.equals(storename))	{
									p.printProductInfo();
								}
							}
							System.out.print("작업할 내역 : [1] 신규상품 [2] 가게퇴점 [0] 뒤로가기" );
							int work = scn.nextInt();
							if(work==0)	{
								continue;
							}else if(work==1)	{
								/*
								 (int productNumber, String seller, String primaryType, String secondaryType,
			String name, int price)
								 */
								System.out.println("-상품정보입력시작-");
								String seller = storename;
								System.out.print("상품 1차 카테고리 : ");
								String type = scn.next();
								System.out.print("상품 2차 카테고리 : ");
								String sectype = scn.next();
								System.out.print("상품 이름 : ");
								String name = scn.next();
								
								System.out.print("상품 가격 : ");
								int price = scn.nextInt();
								
								pm.newProduct(seller, type, sectype, name, price);
							}else if(work==2)	{
								System.out.print("확실합니까? [Y|N]");
								
								String yn = scn.next();
								if(yn.equals("Y")) {
									for(Product p : pm.productList) {
										if(p.seller.equals(storename)) {
											p.vailidity = 0;
										}
									}
									System.out.println("해당 점포 모든 판매정보 삭제 완료!");
								}
							}
					
						}
						break;
					case 2:				// 신규입점
						//(String seller, String primaryType, String secondaryType, String name, int price)
						System.out.println("가게 신규입점을 시작합니다.");
						System.out.print("점포명? :");
						String n = scn.next();
						System.out.println("최초 상품정보 입력을 시작합니다.");
						System.out.print("상품 1차타입 : ");
						String pt = scn.next();
						System.out.print("상품 2차타입 : ");
						String st = scn.next();
						System.out.print("상품 이름 : ");
						String pn = scn.next();
						System.out.print("상품 가격? : ");
						int pr = scn.nextInt();
						
						pm.newStore(n, pt, st, pn, pr);
						break;
				}
			}
	}
	public void MemberManager() {
		System.out.println("[멤버관리]");
		System.out.print("[0] 뒤로가기 [1] 전체회원 출력 [2] 멤버검색");
		int mmsel = scn.nextInt();
		if(mmsel == 0)	{
			return;
		}else if(mmsel == 1)	{
			ArrayList<User> list = um.getUserList();
			System.out.println("==============회원목록=================");
			for(int i=0; i<list.size(); i++)	{
				System.out.println("[" + i + "] " + list.get(i).getId());
			}
			System.out.print("[-1] 뒤로가기 [N] 해당 회원 정보 조회");
			int t = scn.nextInt();
			if(t == -1)	{
				return;
			}else {
				User target = list.get(t);

				System.out.println("       [회원정보조회]       ");
				System.out.println("사용자 계정명 : " + target.getId());
				System.out.println("사용자 pw : " + target.getPw());
				System.out.println("사용자 이름 : " +target.getName());
				System.out.println("사용자 유형" + target.getAcctype());
				System.out.println("사용자 email : " + target.getEmail());
				System.out.println("사용자 연락처: " + target.getTel());
				System.out.print("계정 상태 : ");
				if(target.getValidate() == 0)	{
					System.out.println("삭제");
				}else {
					System.out.println("정상");
				}
				if(target.getClass().equals(Administrator.class)) {
					System.out.println("==관리자계정은 배송지, 장바구니가 없습니다.");
				}else {
				System.out.println("사용자 기본 배송지 \n" +target.getPrimaryaddr());
				
				target.showBucket();
				}
				System.out.println("\n\n작업내역? [0] 뒤로가기 [1] 회원삭제 [2] 회원비밀번호변경");
				int w = scn.nextInt();
				
				switch(w) {
					case 0:
						break;
					case 1:
						System.out.print("삭제합니까? [Y|N]");
						String ch = scn.next();
						if(ch.equals("Y")) {
							target.setValidate(0);
							System.out.println("삭제 완료!");
						}
						break;
					case 2:
						System.out.print("대상의 신규 비밀번호 입력 : ");
						String newpw = scn.next();
						System.out.println("동일 비밀번호 재입력 : ");
						String newpwre = scn.next();
						
						if(newpw.equals(newpwre)) {
							target.setPw(newpw);
							System.out.println("비밀번호 변경 완료!");
						}else {
							System.out.println("비밀번호 불일치! 변경실패.");
						}
				}
			}
		}
	}
	public void QnaManager() {
		QnaManage:
			while(true) {
				System.out.println("[0] 뒤로가기 [1] 미답변문의 답변하기 [2] 전체문의 조회하기");
				int selector = scn.nextInt();
				switch(selector) {
					case 0:
						break QnaManage;
					case 1:
						AnswerQna();
						break;
					case 2:
						AllQna();
						break;
				}
			}
	}
	public void AnswerQna() {
		ArrayList<Qna> list = qnam.getQnaList();
		System.out.println("#number            title           User");
		for(int i=0; i<list.size(); i++)	{
			if(list.get(i).getReplyId()==null) {
				System.out.print("["+i+"] " +list.get(i).getTitle() + " : " +list.get(i).getUsrId());
			}
			
		}
		System.out.print("작업내역 ? [-1] 뒤로가기 [N] 해당 QNA 답변하기");
		int s = scn.nextInt();
		if(s==-1)	{
			return;
		}else if(s<list.size()-1) {
			Qna target = list.get(s);
			System.out.println("#Num : " + target.getSerialId());
			System.out.println("작성자 : " + target.getUsrId());
			System.out.println("작성일 : " + target.getDate());
			System.out.println("문의제목 : " + target.getTitle());
			System.out.println("문의내역 : " + target.getContents());
			
			System.out.println("\n\n답변내용 ? ");
			String answer = scn.next();
			
			target.setAnswer(answer);
			target.setReplyId(currentUser.getId());
			
		}else {
			System.out.println("입력이 유효하지 않습니다.");
		}
		
	}
	public void AllQna() {
		ArrayList<Qna> list = qnam.getQnaList();
		System.out.println("#number            title           User       answer?");
		for(int i=0; i<list.size(); i++)	{
			System.out.print("["+i+"] " +list.get(i).getTitle() + " : " +list.get(i).getUsrId());
			if(list.get(i).getReplyId()==null) {
				System.out.println("     미답변");
			}else {
				System.out.println("답변완료");
			}
		}
		System.out.print("작업내역 ? [-1] 뒤로가기 [N] 해당 QNA 자세히보기");
		int s = scn.nextInt();
		if(s==-1)	{
			return;
		}else if(s>list.size()-1) {
			System.out.println("#Num : " + list.get(s).getSerialId());
			System.out.println("작성자 : " + list.get(s).getUsrId());
			System.out.println("작성일 : " + list.get(s).getDate());
			System.out.println("문의제목 : " + list.get(s).getTitle());
			System.out.println("문의내역 : " + list.get(s).getContents());
			System.out.print("답변내용 : ");
			if(list.get(s).getReplyId()==null) {
				System.out.println("미답변상태");
			}else {
				System.out.println(list.get(s).getReplyId());
				System.out.println(list.get(s).getAnswer());
			}
			
		}
	}
}


