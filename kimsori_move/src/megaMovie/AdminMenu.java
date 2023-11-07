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
	String menu = "[1]������Ȳ\n[2]ȸ�����\n[3]����Ʈ�̿���Ȳ\n[4]��ȭ���\n[5]����";
	
//	������ ȭ��
	public void adminMenu() {
		while(true) {
			System.out.println();
			System.out.println("---[������ �޴�]---");
			System.out.println(menu);
			System.out.print("�޴� ����: ");
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
				System.out.println("������ �޴��� �����մϴ�.");
				break;
			} else {
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	
//	������ �α���
	public void adminLogin() {
		System.out.print("Admin ID: ");
		String adminId = scan.next();
		System.out.print("Admin PW: ");
		String adminPw = scan.next();
		
		if(adminId.equals(admin.getAdminId()) && adminPw.equals(admin.getAdminPw())) {
			System.out.println("������ �α��� ����");
			adminMenu();
		} else {
			System.out.println("�����ڰ� �ƴմϴ�.");
		}
	}
	
//	������Ȳ
	public void ticket() {
		if(movieMenu.ticketing.size()==0) {
			System.out.println("������Ȳ�� �������� �ʽ��ϴ�...");
		}else {
			while(true) {
				System.out.println();
				System.out.println("[1]��ȭ�� ������Ȳ\n[2]ȸ���� ������Ȳ\n[3]����� ���� �¼�\n[4]����");
				System.out.print("�޴� ����: ");
				int select = scan.nextInt();
				if(select==1) {
					while(true) {
						System.out.println();
						int cnt = 1;
						for(int i=0; i<movieMenu.getMovie().length; i++) {
							System.out.printf("[%d]%s\n", cnt, movieMenu.getMovie()[i]);
							cnt++;
						}
						System.out.printf("[%d]����\n", cnt);
						System.out.print("��ȭ ����: ");
						int select3 = scan.nextInt();
						if(select3==cnt) {
							break;
						} else if(select3<cnt && select3>0) {
							cnt=1;
							System.out.println();
							System.out.printf("                                            --[%s]--\n", movieMenu.getMovie()[select3-1]);
							System.out.println("-------------------------------------------------------------------------------------------------------------");
							System.out.println("��ȣ ȸ��ID\t��ȭ��(����)\t������\t\t\t��ȭ ����\t�󿵽ð�\t\t���� �ż�\t�� �ݾ�\t����Ʈ");
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
									System.out.printf("[%d] %s\t%s(%s)\t%s\t%s\t%s~%s\t%d\t%s�� %sp\n", cnt,  movieMenu.ticketing.get(i).getId(), movieMenu.ticketing.get(i).getTheater(), movieMenu.ticketing.get(i).getLocal(), f3.format(movieMenu.ticketing.get(i).getDath()), f.format(movieMenu.ticketing.get(i).getTime()), f2.format(movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), movieMenu.ticketing.get(i).getCnt(), de.format(movieMenu.ticketing.get(i).getPrice()), de.format(movieMenu.ticketing.get(i).getPoint()));
									cnt++;
								} 
							}
							System.out.println("-------------------------------------------------------------------------------------------------------------");
						} else {
							System.out.println("���� �޴��Դϴ�.");
						}
					}
				} else if(select==2) {
					while(true) {
						System.out.println();
						System.out.println("[1]��ü ȸ�� ����\n[2]�� ȸ���� ������Ȳ\n[3]����");
						System.out.print("�޴� ����: ");
						int select2 = scan.nextInt();
						if(select2==1) {
							int cnt = 1; //������ ��ȭ ����
							System.out.println();
							System.out.println("                                            --[��ü ȸ�� ����]--");
							System.out.println("-------------------------------------------------------------------------------------------------------------");
							System.out.println("��ȣ ȸ��ID\t��ȭ�̸�\t��ȭ��(����)\t������\t\t\t��ȭ ����\t�󿵽ð�\t\t���� �ż�\t�� �ݾ�\t����Ʈ");
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
								System.out.printf("[%d] %s\t%s\t%s(%s)\t%s\t%s\t%s~%s\t%d\t%s�� %sp\n", cnt, movieMenu.ticketing.get(i).getId(), movieMenu.ticketing.get(i).getName(), movieMenu.ticketing.get(i).getTheater(), movieMenu.ticketing.get(i).getLocal(), f3.format(movieMenu.ticketing.get(i).getDath()), f.format(movieMenu.ticketing.get(i).getTime()), f2.format(movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), movieMenu.ticketing.get(i).getCnt(), de.format(movieMenu.ticketing.get(i).getPrice()), de.format(movieMenu.ticketing.get(i).getPoint()));
								cnt++;
							}
							System.out.println("-------------------------------------------------------------------------------------------------------------");
							cnt=1;
						} else if(select2==2) {
							while(true) {
								int cnt = 1; //������ ��ȭ ����
								System.out.println();
								for(int i=0; i<movieMenu.user.size(); i++) {
									System.out.printf("[%d]%s\n", cnt, movieMenu.user.get(i).getId());
									cnt++;
								}
								System.out.printf("[%d]����\n", cnt);
								System.out.print("ȸ�� ����: ");
								int select3 = scan.nextInt();
								if(select3==cnt || cnt==1) {
									break;
								} else if(select3<1) {
									System.out.println("���� �޴��Դϴ�.");
								} else {
									cnt = 1; 
									System.out.println();
									System.out.printf("                       --[%s ȸ�� ����]--\n", movieMenu.user.get(select3-1).getId());
									System.out.println("-------------------------------------------------------------------------------------------------------------");
									System.out.println("��ȣ ��ȭ�̸�\t��ȭ��(����)\t������\t\t\t��ȭ ����\t�󿵽ð�\t\t���� �ż�\t�� �ݾ�\t����Ʈ");
									
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
											System.out.printf("[%d] %s\t%s(%s)\t%s\t%s\t%s~%s\t%d\t%s�� %sp\n", cnt,  movieMenu.ticketing.get(i).getName(), movieMenu.ticketing.get(i).getTheater(), movieMenu.ticketing.get(i).getLocal(), f3.format(movieMenu.ticketing.get(i).getDath()), f.format(movieMenu.ticketing.get(i).getTime()), f2.format(movieMenu.ticketing.get(i).getTime()), f2.format(cal.getTime()), movieMenu.ticketing.get(i).getCnt(), de.format(movieMenu.ticketing.get(i).getPrice()), de.format(movieMenu.ticketing.get(i).getPoint()));
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
							System.out.println("���� �޴��Դϴ�.");
						}
					}
					
				} else if(select==3) {
					while(true) {
						System.out.println();
						System.out.println("[1]����\n[2]��⵵\n[3]��õ\n[4]����");
						System.out.printf("�޴� ����: ");
						int select2 = scan.nextInt();
						
						if(select2==1) {
							System.out.println("  ------------SCREEN------------");
							for(int i=0; i<movieMenu.seat.length; i++) { 
								System.out.print(movieMenu.getAlphabet()[i] + " ");
								for(int j=0; j<movieMenu.seat[i].length; j++) { 
									if(movieMenu.seat[i][j]==0) {
										System.out.print("[ ]"); //���¼�
									} else if(movieMenu.seat[i][j]==1) {
										System.out.print("[O]"); //������
									} else if(movieMenu.seat[i][j]==2) {
										System.out.print("[!]"); //¦���¼� ���źҰ�
									} else if(movieMenu.seat[i][j]==3){
										System.out.print("[X]"); //�̹� ���ſϷ�
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
										System.out.print("[ ]"); //���¼�
									} else if(movieMenu.gseat[i][j]==1) {
										System.out.print("[O]"); //������
									} else if(movieMenu.gseat[i][j]==2) {
										System.out.print("[!]"); //¦���¼� ���źҰ�
									} else if(movieMenu.gseat[i][j]==3){
										System.out.print("[X]"); //�̹� ���ſϷ�
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
										System.out.print("[ ]"); //���¼�
									} else if(movieMenu.iseat[i][j]==1) {
										System.out.print("[O]"); //������
									} else if(movieMenu.iseat[i][j]==2) {
										System.out.print("[!]"); //¦���¼� ���źҰ�
									} else if(movieMenu.iseat[i][j]==3){
										System.out.print("[X]"); //�̹� ���ſϷ�
									}
								}
								System.out.println();
							}
							System.out.println("  ------------------------------");
						} else if(select2==4) {
							break;
						} else {
							System.out.println("���� �޴��Դϴ�.");
						}
					}	
				} else if(select==4) {
					break;
				}  else {
					System.out.println("���� �޴��Դϴ�.");
				}
			}
		}
	}
	
//	ȸ�����
	public void userList() {
		if(movieMenu.user.size()==0) {
			System.out.println("ȸ���� �������� �ʽ��ϴ�...");
		}else {
			System.out.println();
			System.out.println("                 --[��ü ȸ�� ����]--");
			System.out.println("------------------------------------------------------");
			System.out.println("ID\tPW\t�г���\t�������\t��ȭ��ȣ\t�̸���\t����Ʈ");
			for(int i=0; i<movieMenu.user.size(); i++) {
				System.out.printf("%s\t%s\t%s\t%d\t%s\t%s\t%s\n", movieMenu.user.get(i).getId(), movieMenu.user.get(i).getPw(), movieMenu.user.get(i).getNickName(), movieMenu.user.get(i).getBirth(), movieMenu.user.get(i).getTel(), movieMenu.user.get(i).getEmail(), de.format(movieMenu.user.get(i).getPoint()));
			}
			System.out.println("------------------------------------------------------");
		}
	}
	
//	ȸ���� ����Ʈ ��Ȳ
	public void point() {
		int cnt = 1;
		if(movieMenu.pointVO.size()==0) {
			System.out.println();
			System.out.println("����Ʈ �̿볻���� �������� �ʽ��ϴ�...");
		} else {
			while(true) {
				System.out.println();
				System.out.println("[1]��ü ����Ʈ ���� ��ȸ\n[2]ȸ���� ����Ʈ ���� ��ȸ\n[3]����");
				System.out.print("�޴� ����: ");
				int select = scan.nextInt();
				if(select==1) {
					System.out.println();
					System.out.println("                --[��ü ����Ʈ �̿� ����]--");
					System.out.println("------------------------------------------------------");
					System.out.println("��ȣ\tȸ��ID\t����\t\t\t����\t����Ʈ");
					for(int i=0; i<movieMenu.pointVO.size(); i++) {
						System.out.printf("[%d]\t%s\t%s\t%s\t%sp\n", cnt, movieMenu.pointVO.get(i).getId(), f3.format(movieMenu.pointVO.get(i).getDay()), movieMenu.pointVO.get(i).getUse(), de.format(movieMenu.pointVO.get(i).getPoint()));
						cnt++;
					}
					System.out.println("------------------------------------------------------");
					cnt = 1;
				} else if(select==2) {
					System.out.println();
					System.out.println("--[ȸ������]--");
					for(int i=0; i<movieMenu.user.size(); i++) {
						System.out.printf("[%d]%s\n", cnt, movieMenu.user.get(i).getId());
						cnt++;
					}
					cnt = 1;
					System.out.print("ȸ�� ����: ");
					int select2 = scan.nextInt();
					if(select2<movieMenu.pointVO.size() && select2!=0) {
						System.out.printf("               --[%s�� ����Ʈ �̿� ����]--\n", movieMenu.user.get(select2-1).getId());
						System.out.println("------------------------------------------------------");
						System.out.println("��ȣ\t����\t\t\t����\t����Ʈ");
						for(int j=0; j<movieMenu.pointVO.size(); j++) {
							if(movieMenu.user.get(select2-1).getId().equals(movieMenu.pointVO.get(j).getId())) {
								System.out.printf("[%d]\t%s\t%s\t%sp\n", cnt, f3.format(movieMenu.pointVO.get(j).getDay()), movieMenu.pointVO.get(j).getUse(), de.format(movieMenu.pointVO.get(j).getPoint()));
								cnt++;
							}
						}
						cnt = 1;
						System.out.println("------------------------------------------------------");
					} else {
						System.out.println("���� ȸ���Դϴ�.");
					}
				} else if(select==3) {
					break;
				} else {
					System.out.println("���� �޴��Դϴ�.");
				}
			}
		}
	}
	
//	��ȭ���
	public void movieList() {
		System.out.println();
		System.out.println("            --[��ȭ ���]--");
		System.out.println("--------------------------------------");
		System.out.println("      ��ȭ�̸�\t������\t����");
		
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
