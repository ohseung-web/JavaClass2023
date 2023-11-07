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
	String menu = "[1]�α���\n[2]ȸ�� ����\n[3]��ȭ���\n[4]�˻�\n[0]����";
	String inmenu = "[1]�α׾ƿ�\n[2]�˶�\n[3]��ȭ���\n[4]�˻�\n[5]����������\n[6]ȸ��Ż��\n[0]����";
	String inmenu2 = "[1]�α׾ƿ�\n[2]�˶�";
	String inmenu3 = "\n[3]��ȭ���\n[4]�˻�\n[5]����������\n[6]ȸ��Ż��\n[0]����";
	static int log = -1;
	int alarmCnt = 0; //�˶��� ����

	public void menu() {
		while(true) {
			adminMenu.movieMenu.finalChk = -1;
			alarmCnt = 0;
			System.out.println();
			System.out.println("---[�ް��ڽ�]---");
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
			System.out.print("�޴� ����(100�����ڸ��): ");
			int select = scan.nextInt();
				
			if(select==1) {
				if(log<0) {
					login(); //�α���
				} else {
					logout(); //�α׾ƿ�
				}
			} else if(select==2) {
				if(log<0) {
					join(); //ȸ������
				} else {
					alarm(); //�˶�
				}
			} else if(select==3) {
				adminMenu.movieMenu.list();
			} else if(select==4) {
				adminMenu.movieMenu.search();
			} else if(select==5) {
				if(log>-1) {
					myPage(); //����������
				}
			} else if(select==6) {
				if(log>-1) {
					bye(); //ȸ��Ż��
				}
			}else if(select==0) {
				System.out.println("�ȳ����輼��.");
				break;
			} else if(select==100) {
				if(log>-1) {
					System.out.println("�α׾ƿ� �� �̿밡��");
				} else {
					adminMenu.adminLogin();
				}
			} else {
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	
//	ȸ������
	public void join() {
		int chk = -1;
		System.out.print("ID: ");
		String myid = scan.next();
		
		for(int i=0; i<adminMenu.movieMenu.user.size(); i++) {
			if(myid.equals(adminMenu.movieMenu.user.get(i).getId())) {
				chk = 1;
				System.out.println("�̹� �����ϴ� ID�Դϴ�.");
			}
		}
		if(chk<0) {
			System.out.print("PW: ");
			String myPw = scan.next();
			System.out.print("�г���: ");
			String myNickName = scan.next();
			System.out.print("�������(ex.800205): ");
			int myBirth = scan.nextInt();
			System.out.print("��ȭ��ȣ: ");
			String myTel = scan.next();
			System.out.print("�̸���: ");
			String myEmail = scan.next();
			
			adminMenu.movieMenu.user.add(new UserVO(myid, myPw, myNickName, myBirth, myTel, myEmail));
			System.out.println("ȸ������ �����մϴ�!");
			System.out.println("1,000p�� �����Ǿ����ϴ�!");
			Date current = new Date();
			adminMenu.movieMenu.pointVO.add(new PointVO(myid, "ȸ������", 1000, current));
		} else {
			System.out.println("ȸ�������� �ٽ� �������ּ���.");
		}
	}
	
//	ȸ��Ż��
	public void bye() {
		adminMenu.movieMenu.user.remove(log);
		log = -1;
		System.out.println("�׵��� ��ſ����ϴ�.");
	}
	
//	�α���
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
			System.out.println("id�� pw�� �ٽ� Ȯ�����ּ���.");
		} else {
			System.out.println("�α����� �Ϸ�Ǿ����ϴ�.");
		}
	}
	
//	�α׾ƿ�
	public void logout() {
		log = -1;
		System.out.println("�ȳ��� �輼��.");
	}
	
//	����������
	public void myPage() {
		while(true) {
			System.out.println();
			System.out.println("[1]�� ���� ����\n[2]����/���ų���\n[3]����Ʈ �̿볻��\n[4]���� ��������\n[5]����");
			System.out.print("�޴� ����: ");
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
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	
//	�˶� �� ����
	public void alarmCnt() {
		Date current = new Date(); //����
		Date current2 = new Date(); //����
		Date current3 = new Date(); //����
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
	
//	�˶�
	public void alarm() {
		Date current = new Date();
		Date current2 = new Date();
		current.setDate(current.getDate()+1);
		int cnt = 1;
		System.out.println();
		
		for(int i=0; i<adminMenu.movieMenu.alarm.size(); i++) {
			if(log==adminMenu.movieMenu.alarm.get(i).getLog() && f.format(current2).equals(f.format(adminMenu.movieMenu.alarm.get(i).getDay()))) {
				System.out.printf("[%d] ������ �����Ͻ� %s �����Դϴ�.\n", cnt, adminMenu.movieMenu.alarm.get(i).getAlarm());
				cnt++;
			}
			if(log==adminMenu.movieMenu.alarm.get(i).getLog() && f.format(current).equals(f.format(adminMenu.movieMenu.alarm.get(i).getDay()))) {
				System.out.printf("[%d] ������ �����Ͻ� %s �����Դϴ�.\n", cnt, adminMenu.movieMenu.alarm.get(i).getAlarm());
				cnt++;
			}
		}
		
		if(cnt==1) {
			System.out.println("�˸������� �����ϴ�.");
		} else {
			cnt = 0;
			System.out.println();
			System.out.println("[1]�˶� ����\n[2]����");
			System.out.print("�޴� ����: ");
			int select = scan.nextInt();
			if(select==1) {
				System.out.print("������ ��ȣ: ");
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
						System.out.println("�����Ǿ����ϴ�.");
					}
				}
			} else if(select==2) {
			} else {
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	
//	�� ���� ����
	public void myInfo() {
		System.out.println();
		System.out.println("--------------------");
		System.out.printf("ID:\t%s\n�г���:\t%s\n�������:\t%s\n��ȭ��ȣ:\t%s\n�̸���:\t%s\n�� ����Ʈ:\t%sp\n", adminMenu.movieMenu.user.get(log).getId(), adminMenu.movieMenu.user.get(log).getNickName(), String.format("%06d", adminMenu.movieMenu.user.get(log).getBirth()), adminMenu.movieMenu.user.get(log).getTel(), adminMenu.movieMenu.user.get(log).getEmail(), de.format(adminMenu.movieMenu.user.get(log).getPoint()));
		System.out.println("--------------------");
		System.out.println("[1]��������\n[2]����");
		System.out.print("�޴� ����: ");
		int select = scan.nextInt();
		if(select==1) {
			modify();
		} else if(select==2) {
		} else {
			System.out.println("���� �޴��Դϴ�.");
		}
	}
	
//	��������
	public void modify() {
		System.out.println();
		System.out.println("���������� ���� ��й�ȣ�� �Է����ּ���.");
		System.out.print("PW: ");
		String myPw = scan.next();
		
		if(adminMenu.movieMenu.user.get(log).getPw().equals(myPw)) {
			while(true) {
				int cnt = -1;
				System.out.println();
				System.out.println("--------------------");
				System.out.printf("ID:\t%s\n�г���:\t%s\n�������:\t%s\n��ȭ��ȣ:\t%s\n�̸���:\t%s\n�� ����Ʈ:\t%sp\n", adminMenu.movieMenu.user.get(log).getId(), adminMenu.movieMenu.user.get(log).getNickName(), String.format("%06d",adminMenu.movieMenu.user.get(log).getBirth()), adminMenu.movieMenu.user.get(log).getTel(), adminMenu.movieMenu.user.get(log).getEmail(), de.format(adminMenu.movieMenu.user.get(log).getPoint()));
				System.out.println("--------------------");
				System.out.println("[1]PW\n[2]�г���\n[3]��ȭ��ȣ\n[4]�̸���\n[5]����");
				System.out.print("������ ����: ");
				int select = scan.nextInt();
				if(select==1) {
					System.out.print("�� ��й�ȣ: ");
					String changePw = scan.next();
					if(changePw.equals(adminMenu.movieMenu.user.get(log).getPw())) {
						System.out.println("���� ��й�ȣ�� �����ϴ�.");
						System.out.println("�ٽ� �Է����ּ���.");
						cnt=1;
					}
					if(cnt==1) {
						continue;
					}
					System.out.print("�� ��й�ȣ Ȯ��: ");
					String chkPw = scan.next();
					if(chkPw.equals(changePw)) {
						System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
						adminMenu.movieMenu.user.get(log).setPw(changePw);
					} else {
						System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.\n�ٽ� �Է����ּ���.\n");
						System.out.print("�� ��й�ȣ Ȯ��: ");
						String chkPw2 = scan.next();
						if(chkPw2.equals(changePw)) {
							adminMenu.movieMenu.user.get(log).setPw(changePw);
							System.out.println("��й�ȣ�� ����Ǿ����ϴ�.");
						} else {
							System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.\nó�� ȭ������ ���ư��ϴ�.");
						}
					}
				} else if(select==2) {
					System.out.print("�� �г���: ");
					String changeNickName = scan.next();
					if(changeNickName.equals(adminMenu.movieMenu.user.get(log).getNickName())) {
						System.out.println("���� �г��Ӱ� �����ϴ�.");
						System.out.println("�ٽ� �Է����ּ���.");
						cnt=1;
					}
					if(cnt==1) {
						continue;
					}
					adminMenu.movieMenu.user.get(log).setNickName(changeNickName);
					System.out.println("�г����� ����Ǿ����ϴ�.");
				} else if(select==3) {
					System.out.print("�� ��ȭ��ȣ: ");
					String changeTel = scan.next();
					if(changeTel.equals(adminMenu.movieMenu.user.get(log).getTel())) {
						System.out.println("���� ��ȭ��ȣ�� �����ϴ�.");
						System.out.println("�ٽ� �Է����ּ���.");
						cnt=1;
					}
					if(cnt==1) {
						continue;
					}
					adminMenu.movieMenu.user.get(log).setTel(changeTel);
					System.out.println("��ȭ��ȣ�� ����Ǿ����ϴ�.");
				} else if(select==4) {
					System.out.print("�� �̸���: ");
					String changeEmail = scan.next();
					if(changeEmail.equals(adminMenu.movieMenu.user.get(log).getEmail())) {
						System.out.println("���� �̸��ϰ� �����ϴ�.");
						System.out.println("�ٽ� �Է����ּ���.");
						cnt=1;
					}
					if(cnt==1) {
						continue;
					}
					adminMenu.movieMenu.user.get(log).setEmail(changeEmail);
					System.out.println("�̸����� ����Ǿ����ϴ�.");
				} else if(select==5) {
					break;
				} else {
					System.out.println("���� �޴��Դϴ�.");
				}
			}
		} else {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		
	}
	
//	����/���ų���
	public void buy() {
		while(true) {
			System.out.println();
			int chk = -1; //1�̸� ���ų��� ����
		
			for(int i=0; i<adminMenu.movieMenu.ticketing.size(); i++) {
				if(adminMenu.movieMenu.ticketing.get(i).getId().equals(adminMenu.movieMenu.user.get(log).getId())) {
					chk = 1;
				}
			}	
		
			int cnt = 1; //������ ��ȭ ����
			if(adminMenu.movieMenu.ticketing.size()==0 || chk==-1) {
				System.out.println("���ų����� �������� �ʽ��ϴ�.");
				break;
			} else {
				System.out.println("��ȣ ��ȭ�̸�\t��ȭ��(����)\t������\t\t\t��ȭ ����\t�󿵽ð�\t\t���� �ż�\t�� �ݾ�");
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
						System.out.printf("[%d] %s\t%s(%s)\t%s\t%s\t%s~%s\t%d\t%s��\n", cnt, adminMenu.movieMenu.ticketing.get(i).getName(), adminMenu.movieMenu.ticketing.get(i).getTheater(), adminMenu.movieMenu.ticketing.get(i).getLocal(), f3.format(adminMenu.movieMenu.ticketing.get(i).getDath()), f.format(adminMenu.movieMenu.ticketing.get(i).getTime()), f2.format(adminMenu.movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), adminMenu.movieMenu.ticketing.get(i).getCnt(), de.format(adminMenu.movieMenu.ticketing.get(i).getPrice()));
						cnt++;
					} 
				}
				cnt = 0;
				System.out.println();
				System.out.println("[1]������ ���\n[2]���� ���\n[3]����");
				System.out.print("�޴� ����: ");
				int select = scan.nextInt();
				if(select==1) {
					System.out.println();
					System.out.print("����� ��ȣ: ");
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
							System.out.println("        --[��ȭ ������]--         ");
							System.out.println("-------------------------------");
							System.out.printf("%s\n%s(%s)\n%s | %s~%s\n���� %d��(%s)\n�� �ݾ�: %s��\n", adminMenu.movieMenu.ticketing.get(i).getName(), adminMenu.movieMenu.ticketing.get(i).getTheater(), adminMenu.movieMenu.ticketing.get(i).getLocal(), f.format(adminMenu.movieMenu.ticketing.get(i).getTime()), f2.format(adminMenu.movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), adminMenu.movieMenu.ticketing.get(i).getCnt(), adminMenu.movieMenu.ticketing.get(i).getTicket(), de.format(adminMenu.movieMenu.ticketing.get(i).getPrice()));
							System.out.println("-------------------------------");
							System.out.printf("%sȸ����\n", adminMenu.movieMenu.user.get(log).getNickName());
							System.out.printf("��� ����Ʈ: %sp\n", de.format(adminMenu.movieMenu.ticketing.get(i).getPoint()));
							System.out.printf("��½ð�: %s\n", f3.format(current));
						}
					}
					cnt=0;
				} else if(select==2) {
					System.out.print("����� ��ȣ: ");
					int select2 = scan.nextInt();
						for(int i=0; i<adminMenu.movieMenu.ticketing.size(); i++) {
							if(adminMenu.movieMenu.ticketing.get(i).getId().equals(adminMenu.movieMenu.user.get(log).getId())) {
								cnt++;
							} 
							if(cnt==select2) {
								Date current = new Date();
								double inPoint = adminMenu.movieMenu.ticketing.get(i).getPrice()*0.05;
								adminMenu.movieMenu.user.get(log).setPoint(-(int)inPoint);
								adminMenu.movieMenu.pointVO.add(new PointVO(adminMenu.movieMenu.user.get(log).getId(), "�������", -(int)inPoint, current));
								
//								�ش��ϴ� �˶� �����
								for(int j=0; j<adminMenu.movieMenu.alarm.size(); j++) {
									if(adminMenu.movieMenu.alarm.get(j).getDay().equals(adminMenu.movieMenu.ticketing.get(j).getTime()) && adminMenu.movieMenu.alarm.get(j).getAlarm().equals(adminMenu.movieMenu.ticketing.get(j).getName())) {
										adminMenu.movieMenu.alarm.remove(j);
									}
								}
								
//								�ش��ϴ� ������ �����
								if(adminMenu.movieMenu.ticketing.get(i).getName().equals(null) || adminMenu.movieMenu.ticketing.get(i).getName().equals(" ")) {
									
								} else {
									for(int a=0; a<adminMenu.movieMenu.getMovie().length; a++) {
										if(adminMenu.movieMenu.getMovie()[a].equals(adminMenu.movieMenu.ticketing.get(i).getName())) {
											adminMenu.movieMenu.getPeople()[a] = adminMenu.movieMenu.getPeople()[a] - adminMenu.movieMenu.ticketing.get(i).getCnt();
										}
									}
								}
								
//								�ش��ϴ� �¼� �����
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
										a = adminMenu.movieMenu.replaceLast(a, "��", "");
										String c = a.substring(a.length()-1, a.length());
										a = adminMenu.movieMenu.replaceLast(a, c, "");
										a = adminMenu.movieMenu.replaceLast(a, " ", "");
//										byte �� ����
										adminMenu.movieMenu.ticketing.get(i).setTicket(adminMenu.movieMenu.replaceLast(adminMenu.movieMenu.ticketing.get(i).getTicket(), c+"��"+b, ""));
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
										a = adminMenu.movieMenu.replaceLast(a, "��", "");
										String c = a.substring(a.length()-1, a.length());
										a = adminMenu.movieMenu.replaceLast(a, c, "");
										a = adminMenu.movieMenu.replaceLast(a, " ", "");
//										byte �� ����
										adminMenu.movieMenu.ticketing.get(i).setTicket(adminMenu.movieMenu.replaceLast(adminMenu.movieMenu.ticketing.get(i).getTicket(), c+"��"+b, ""));
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
								if(adminMenu.movieMenu.ticketing.get(i).getLocal().equals("����")) {
									adminMenu.movieMenu.seat[seat2[a][0]][seat2[a][1]] = 0;
								} else if(adminMenu.movieMenu.ticketing.get(i).getLocal().equals("��⵵")) {
									adminMenu.movieMenu.gseat[seat2[a][0]][seat2[a][1]] = 0;
								} else if(adminMenu.movieMenu.ticketing.get(i).getLocal().equals("��õ")) {
									adminMenu.movieMenu.iseat[seat2[a][0]][seat2[a][1]] = 0;
								} 
							}
							adminMenu.movieMenu.ticketing.remove(i);
							System.out.println("��ҵǾ����ϴ�.");
							}
						}
					cnt=0;
				} else if(select==3) {
					break;
				}  else {
					System.out.println("���� �޴��Դϴ�.");
				}
			}
		}
	}
	
//	����Ʈ �̿볻��
	public void point() {
		System.out.println();
		System.out.printf("��� ���� ����Ʈ: %sp\n", de.format(adminMenu.movieMenu.user.get(log).getPoint()));
		int cnt = 1;
		System.out.println();
		System.out.println("             --[����Ʈ �̿� ����]--");
		System.out.println("----------------------------------------------");
		System.out.println("��ȣ\t\t����\t\t����\t����Ʈ");
		for(int i=0; i<adminMenu.movieMenu.pointVO.size(); i++) {
			if(adminMenu.movieMenu.user.get(log).getId().equals(adminMenu.movieMenu.pointVO.get(i).getId())) {
				System.out.printf("[%d] %s\t%s\t%sp\n", cnt, f3.format(adminMenu.movieMenu.pointVO.get(i).getDay()), adminMenu.movieMenu.pointVO.get(i).getUse(), de.format(adminMenu.movieMenu.pointVO.get(i).getPoint()));
				cnt++;
			}
		}
	}
	
}