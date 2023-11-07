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
	String[] OutterMenu = {"�α���", "ȸ������", "����","�����ڷα���"};
	String[] InnerMenu = {"MyPage", "�����ϱ�", "�α׾ƿ�", "ȸ��Ż��"};
	// �α׾ƿ��� �̳ʸ޴���
	
	public void Run() {
	
		OutterMenu:				// �α��� �ȵǾ�������.
			while(true)	{
				if(currentUser == null) {
					OutterMenus();
					System.out.print("�޴��� �����ϼ��� : ");
					int selector = scn.nextInt();
					
					switch(selector)	{
					case 1:				//�α���
						MemberLogin();			// FI P
						break;
					case 2:				//ȸ������
						MemberJoin();
						break;
					case 3:
						break OutterMenu;
					case 4:
						System.out.println("������ : [eriot : qwer!]");
						MemberLogin();
						break;
					}
				
				}else if(currentUser != null)	{		// �α��� �Ǿ��ִٸ�
					System.out.println("\n\n");
					// MyPage, �����ϱ�, �α׾ƿ��ϱ�, ȸ��Ż���ϱ�, 
					InnerMenu:
						while(true)	{			// ����ڷα���
							if(currentUser.getClass().equals(User.class)) {

								InnerMenus();
								System.out.print("�޴��� �����ϼ��� : ");
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
								
							}else {			// �����ڷα���
								System.out.println("�ݰ����ϴ�. �����ڴ�.");
								Administrator();
							break;
							// �����ڸ޴�
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
		System.out.println("\t\t\t  " + currentUser.getId() + " ��, �ݰ����ϴ�");
		System.out.println("=====================================================================");
		for(int i=1; i<=InnerMenu.length; i++)	{
			System.out.println("\t\t\t[" + i + "]" + InnerMenu[i-1]);
		}
	}
	
	public void MemberLogin()	{
		currentUser = um.Login();
		if(currentUser == null)	{
			System.out.println("�ش� ���������� �ý��ۿ� �����ϴ�.\n");
		}else {
			System.out.println("�ȳ��ϼ���, " + currentUser.getId() +" ��!");
		}
	}
	public void MemberLogout()	{
		currentUser = um.Logout(currentUser);
		if(currentUser == null)	{
			System.out.println("���������� �α׾ƿ� �Ǿ����ϴ�! \n");
		}
	}
	public void MemberJoin() {
		int statuscode = um.Join();
		if(statuscode == 200)	{
			System.out.println("ȸ�����Կ� �����Ͽ����ϴ�! ȯ���մϴ�!\n");
		}else if(statuscode == 404) {
			System.out.println("������ �߻��Ͽ����ϴ�. �����ڿ��� ���� �ٶ��ϴ�.\n");
		}else if(statuscode == 403)	{
			System.out.println("�̹� �ý��ۿ� �����ϴ� �������Դϴ�. �ٸ������� �������ּ���\n");
		}else {
			System.out.println("ERR!");
		}
	}
	public void MemberSecede() {
		int statuscode = um.secede(currentUser);
		if(statuscode == 404)	{
			System.out.println("�α��� �� �̿����ּ���.\n");
		}else if(statuscode == 403)	{
			System.out.println("������ ������ Ż���� �� �����ϴ�.\n");
		}else if(statuscode == 200) {
			System.out.println("���� Ż��ó�� �Ǿ����ϴ�. �ȳ���������\n");
			currentUser = null;
		}else if(statuscode == 4041)	{
			System.out.println("�Է��� ���������� �ý��ۿ� �����ϴ�. �ٽ�Ȯ�����ּ���\n");
		}
	}
	public void MemberMypage()	{
		String[] myPageMenu = {"�ڷΰ���", "�������� ��ȸ", "��ٱ��� ��ȸ", "�����ϱ�", "�������� Ȯ���ϱ�"};
		String[] personalMenu = {"�ڷΰ���", "��й�ȣ����", "���ʹ���� ����"};
		// ��й�ȣ ���� �޼��� ����.
	
		MyPage:
			while(true) {
				System.out.println("=====================================================================");
				System.out.println("\t\t\t    " + "MY PAGE");
				System.out.println("=====================================================================");
				for(int i=0; i<myPageMenu.length; i++)	{
					System.out.println("\t\t\t[" + i + "] " + myPageMenu[i]);
				}
				System.out.print("�޴� ���� : ");
				int sel = scn.nextInt();
				switch(sel)	{
					case 0:
						break MyPage;
					case 1:		// �������� ��ȸ
						while(true) {
							System.out.println("=====================================================================");
							System.out.println("\t\t\t  " + "�������� ��ȸ");
							System.out.println("=====================================================================");
							
							System.out.println("\t������ : " + currentUser.getId());
							System.out.println("\t�������� : " + currentUser.getAcctype());
							System.out.println("\t����� �̸� : " + currentUser.getId());
							System.out.println("\t����� ��ȭ��ȣ : " + currentUser.getTel());
							System.out.println("\t����� E-mail: " + currentUser.getEmail());
							System.out.println("\t����� �⺻ ����� �ּ� : \n\t" + currentUser.getPrimaryaddr());
							System.out.println("=====================================================================");
							
							for(int i=0; i<personalMenu.length; i++)	{
								System.out.println("[" + i + "] " + personalMenu[i]);
							}
							System.out.print("�޴� ���� : ");
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
						System.out.println("\t\t\t" + "       �����ϱ�");
						System.out.println("=====================================================================");
						System.out.println("\t   **��ȸ��, ���� ��й�ȣ�� ��ȸ�ϴ��� ����ٶ��ϴ�.**");
						int result=-1;
						result= qnam.addQna(currentUser);
						if(result==1)	{
							System.out.println("\t         **���������� ���ǰ� ��ϵǾ����ϴ�!**");
						}
						break;
					case 4:		// ���� ���ǻ��� Ȯ���ϱ�
						System.out.println("=====================================================================");
						System.out.println("\t\t\t" + "���� ���ǳ��� Ȯ���ϱ�");
						System.out.println("=====================================================================");
						
						//lastqnaPrinter();
						
						ArrayList<Qna> qnalist = new ArrayList<>();
						qnalist = qnam.getQna(currentUser);
						if(qnalist.isEmpty())	{
							System.out.println("\t\t   ** ���� ���ǳ����� �����ϴ�.**");
						}else {		// ���ǳ����� �ִٸ�
							qnalookup:
								while(true) {
									System.out.println("#num\t     �ۼ���\t\t����\t\t\t�亯����");
									
									for(Qna q : qnalist)	{
										System.out.print(q.getSerialId() + "\t" + sdf.format(q.getDate())
											+"\t"+q.getTitle());
										if(q.getReplyId()==null) {
											System.out.println("\t\t\tN");
										}else {
											System.out.println("\t\t\tY");
										}
									}
									System.out.print("[1] ���� �������� [2] �ڷΰ���\n�޴����� : ");
									int qnawork = scn.nextInt();
									switch(qnawork) {
										case 1:
											System.out.print("�ڼ��� �� ���ǳ����� #number : ");
											int target = scn.nextInt();
											Qna targetqna = null;
											for(Qna q : qnalist)	{
												if(q.getSerialId() == target) {
													targetqna = q;
												}
											}
											if(targetqna==null) {
												System.out.println("��ȿ���� ���� �Է��Դϴ�.");
											}else {
												System.out.println("=====================================================================");
												System.out.print("���ǳ��� ��ȣ : #" + targetqna.getSerialId() +"\t\t\t\t�亯�� : ");
												if(targetqna.getReplyId()==null) {
													System.out.println("�̴亯����");
												}else {
													System.out.println(targetqna.getReplyId());
												}
												System.out.println("���� ���� : " + targetqna.getTitle());
												System.out.println("\n\n");
												System.out.println("���� ����\n"+targetqna.getContents());
												if(!(targetqna.getReplyId()==null)) {
													System.out.println("\n\n���� �亯\n"+targetqna.getAnswer());
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
		// TODO �����ϱ� 
		
	}
	
	public void lastqnaPrinter() {
		String tmp = "=====================================================================";
		int length = tmp.length();
		System.out.println(length);
		String temp = "����			";
		System.out.println(temp.length());
		
	}
	
	public void Administrator() {
		AdminOutter:
			while(true) {
				String[] adminMenu = {"��������", "ȸ������", "���ǰ���", "�����ڷα׾ƿ�"};
				System.out.println("[�����޴�]");
				for(int i=0; i<adminMenu.length; i++)	{
					System.out.println("["+(i+1)+"] " + adminMenu[i]);
				}
				System.out.print("�۾� : ");
				int adminsel = scn.nextInt();
				switch(adminsel) {
					case 1:				//��������
						StoreManager();
						break;
					case 2:				//ȸ������
						MemberManager();
						break;
					case 3:				//���ǰ���
						QnaManager();
						break;
					case 4:				// �����ڷα׾ƿ�
						System.out.println("Log out Succeed!");
						currentUser = null;
						break AdminOutter;
				}
			}
	}
	public void StoreManager() {
		storemanager:
			while(true)	{
				System.out.println("[0] �ڷΰ��� [1] ������������ [2] �ű�����\n �޴� ���� :");
				int storesel = scn.nextInt();
				switch(storesel)	{
					case 0:
						break storemanager;
					case 1:
						System.out.println("==========������Ȳ����=========");
						LinkedHashSet <String> sellers = new LinkedHashSet<>();

						for(Product p : pm.productList) {

							sellers.add(p.seller);
						}
						ArrayList<String> storenames = new ArrayList<>(sellers);
						
						for(int i=0; i<storenames.size(); i++)	{
							System.out.println("[" + i + "] " + storenames.get(i));
						}
						System.out.println("[-1] �ڷΰ��� [N] �ش���������");
						int targetstore = scn.nextInt();
						
						if(targetstore == -1)	{
							continue;
							
						}else {
							String storename = storenames.get(targetstore);
							System.out.println("\t\t["+storename+"]");
							System.out.println("\t"+ storename + " ������ ��ǰ");
							for(Product p : pm.productList)	{
								if(p.seller.equals(storename))	{
									p.printProductInfo();
								}
							}
							System.out.print("�۾��� ���� : [1] �űԻ�ǰ [2] �������� [0] �ڷΰ���" );
							int work = scn.nextInt();
							if(work==0)	{
								continue;
							}else if(work==1)	{
								/*
								 (int productNumber, String seller, String primaryType, String secondaryType,
			String name, int price)
								 */
								System.out.println("-��ǰ�����Է½���-");
								String seller = storename;
								System.out.print("��ǰ 1�� ī�װ� : ");
								String type = scn.next();
								System.out.print("��ǰ 2�� ī�װ� : ");
								String sectype = scn.next();
								System.out.print("��ǰ �̸� : ");
								String name = scn.next();
								
								System.out.print("��ǰ ���� : ");
								int price = scn.nextInt();
								
								pm.newProduct(seller, type, sectype, name, price);
							}else if(work==2)	{
								System.out.print("Ȯ���մϱ�? [Y|N]");
								
								String yn = scn.next();
								if(yn.equals("Y")) {
									for(Product p : pm.productList) {
										if(p.seller.equals(storename)) {
											p.vailidity = 0;
										}
									}
									System.out.println("�ش� ���� ��� �Ǹ����� ���� �Ϸ�!");
								}
							}
					
						}
						break;
					case 2:				// �ű�����
						//(String seller, String primaryType, String secondaryType, String name, int price)
						System.out.println("���� �ű������� �����մϴ�.");
						System.out.print("������? :");
						String n = scn.next();
						System.out.println("���� ��ǰ���� �Է��� �����մϴ�.");
						System.out.print("��ǰ 1��Ÿ�� : ");
						String pt = scn.next();
						System.out.print("��ǰ 2��Ÿ�� : ");
						String st = scn.next();
						System.out.print("��ǰ �̸� : ");
						String pn = scn.next();
						System.out.print("��ǰ ����? : ");
						int pr = scn.nextInt();
						
						pm.newStore(n, pt, st, pn, pr);
						break;
				}
			}
	}
	public void MemberManager() {
		System.out.println("[�������]");
		System.out.print("[0] �ڷΰ��� [1] ��üȸ�� ��� [2] ����˻�");
		int mmsel = scn.nextInt();
		if(mmsel == 0)	{
			return;
		}else if(mmsel == 1)	{
			ArrayList<User> list = um.getUserList();
			System.out.println("==============ȸ�����=================");
			for(int i=0; i<list.size(); i++)	{
				System.out.println("[" + i + "] " + list.get(i).getId());
			}
			System.out.print("[-1] �ڷΰ��� [N] �ش� ȸ�� ���� ��ȸ");
			int t = scn.nextInt();
			if(t == -1)	{
				return;
			}else {
				User target = list.get(t);

				System.out.println("       [ȸ��������ȸ]       ");
				System.out.println("����� ������ : " + target.getId());
				System.out.println("����� pw : " + target.getPw());
				System.out.println("����� �̸� : " +target.getName());
				System.out.println("����� ����" + target.getAcctype());
				System.out.println("����� email : " + target.getEmail());
				System.out.println("����� ����ó: " + target.getTel());
				System.out.print("���� ���� : ");
				if(target.getValidate() == 0)	{
					System.out.println("����");
				}else {
					System.out.println("����");
				}
				if(target.getClass().equals(Administrator.class)) {
					System.out.println("==�����ڰ����� �����, ��ٱ��ϰ� �����ϴ�.");
				}else {
				System.out.println("����� �⺻ ����� \n" +target.getPrimaryaddr());
				
				target.showBucket();
				}
				System.out.println("\n\n�۾�����? [0] �ڷΰ��� [1] ȸ������ [2] ȸ����й�ȣ����");
				int w = scn.nextInt();
				
				switch(w) {
					case 0:
						break;
					case 1:
						System.out.print("�����մϱ�? [Y|N]");
						String ch = scn.next();
						if(ch.equals("Y")) {
							target.setValidate(0);
							System.out.println("���� �Ϸ�!");
						}
						break;
					case 2:
						System.out.print("����� �ű� ��й�ȣ �Է� : ");
						String newpw = scn.next();
						System.out.println("���� ��й�ȣ ���Է� : ");
						String newpwre = scn.next();
						
						if(newpw.equals(newpwre)) {
							target.setPw(newpw);
							System.out.println("��й�ȣ ���� �Ϸ�!");
						}else {
							System.out.println("��й�ȣ ����ġ! �������.");
						}
				}
			}
		}
	}
	public void QnaManager() {
		QnaManage:
			while(true) {
				System.out.println("[0] �ڷΰ��� [1] �̴亯���� �亯�ϱ� [2] ��ü���� ��ȸ�ϱ�");
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
		System.out.print("�۾����� ? [-1] �ڷΰ��� [N] �ش� QNA �亯�ϱ�");
		int s = scn.nextInt();
		if(s==-1)	{
			return;
		}else if(s<list.size()-1) {
			Qna target = list.get(s);
			System.out.println("#Num : " + target.getSerialId());
			System.out.println("�ۼ��� : " + target.getUsrId());
			System.out.println("�ۼ��� : " + target.getDate());
			System.out.println("�������� : " + target.getTitle());
			System.out.println("���ǳ��� : " + target.getContents());
			
			System.out.println("\n\n�亯���� ? ");
			String answer = scn.next();
			
			target.setAnswer(answer);
			target.setReplyId(currentUser.getId());
			
		}else {
			System.out.println("�Է��� ��ȿ���� �ʽ��ϴ�.");
		}
		
	}
	public void AllQna() {
		ArrayList<Qna> list = qnam.getQnaList();
		System.out.println("#number            title           User       answer?");
		for(int i=0; i<list.size(); i++)	{
			System.out.print("["+i+"] " +list.get(i).getTitle() + " : " +list.get(i).getUsrId());
			if(list.get(i).getReplyId()==null) {
				System.out.println("     �̴亯");
			}else {
				System.out.println("�亯�Ϸ�");
			}
		}
		System.out.print("�۾����� ? [-1] �ڷΰ��� [N] �ش� QNA �ڼ�������");
		int s = scn.nextInt();
		if(s==-1)	{
			return;
		}else if(s>list.size()-1) {
			System.out.println("#Num : " + list.get(s).getSerialId());
			System.out.println("�ۼ��� : " + list.get(s).getUsrId());
			System.out.println("�ۼ��� : " + list.get(s).getDate());
			System.out.println("�������� : " + list.get(s).getTitle());
			System.out.println("���ǳ��� : " + list.get(s).getContents());
			System.out.print("�亯���� : ");
			if(list.get(s).getReplyId()==null) {
				System.out.println("�̴亯����");
			}else {
				System.out.println(list.get(s).getReplyId());
				System.out.println(list.get(s).getAnswer());
			}
			
		}
	}
}


