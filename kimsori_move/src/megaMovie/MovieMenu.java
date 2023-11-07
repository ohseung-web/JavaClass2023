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
	
	int[][] seat = new int[13][10]; //����
	int[][] gseat = new int[9][8]; //��⵵
	int[][] iseat = new int[5][10]; //��õ
	
	String id; //��ȭ������ ȸ��
	String name; //��ȭ�̸�
	String local; //����
	String Theater; //��ȭ��
	Date dath; //������
	Date time; //��ȭ �� ��¥,�ð�
	String ticket = ""; //������ ��
	int cnt; //������ ��ȭ ����
	int price; //��ȭ�ݾ�
	int price2; //��ȭ�ݾ�
	int point = 0; //����Ʈ
	int moviePrice;
	
	int size = getMovie().length;
	int count = 0;
	int mo = -1;
	int timeCnt = 0; //��¥ üũŰ
	int timeChk = 0; //Ÿ�� üũŰ
	int dayth = 0; //������ ��¥ 
	int[][] seat2 = new int[8][2];
	int seatCnt = 0; //seat2�¼�����
	int finalChk = -1; //seat2�¼� �ʱ�ȭ
	
	public ArrayList<TicketingVO> getTicketing() {
		return ticketing;
	}

	public void setTicketing(ArrayList<TicketingVO> ticketing) {
		this.ticketing = ticketing;
	}

	//	��ȭ���
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
			System.out.println("            --[��ȭ ���]--");
			System.out.println("--------------------------------------");
			System.out.println("      ��ȭ�̸�\t������\t����");
			
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
			System.out.println("[1]����\n[2]����");
			System.out.print("�޴�����: ");
			int select = scan.nextInt();
			
			if(select==1) {
				if(log<0) {
					System.out.println("�α��� �� �̿밡��");
				} else {
					id = user.get(log).getId();
					System.out.print("������ ��ȭ: ");
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
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	

	// ���� ����
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
			System.out.println("--[���� ����]--");
			
			for(int i=0; i<size; i++) {
				System.out.printf("[%d]%s\n", (i+1), getLocal()[i]);
			}
			System.out.println("------------");
			System.out.println("[1]��������\n[2]����");
			System.out.print("�޴� ����: ");
			int select3 = scan.nextInt();
			if(select3==1) {
				System.out.print("��������: ");
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
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	
//	���� ����
	public void theater() {
		while(true) {
			System.out.println();
			System.out.println("--[���� ����]--");
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
			System.out.println("[1]���弱��\n[2]����");
			System.out.print("�޴� ����: ");
			int select3 = scan.nextInt();
			if(select3==1) {
				System.out.print("���弱��: ");
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
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	
//	��¥ ����
	public void time() {
		while(true) {
			System.out.println();
			System.out.println("--[��¥ ����]--");
			for(int i=0; i<size; i++) {
				System.out.printf("[%d]%d��\n", (i+1), getDath()[i]);
			}
			System.out.println("------------");
			System.out.println("[1]��¥����\n[2]����");
			System.out.print("�޴� ����: ");
			int select3 = scan.nextInt();
			if(select3==1) {
				System.out.print("��¥ ����: ");
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
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	
//	�ð� ����
	public void time2() {
		while(true) {
			System.out.println();
			System.out.println("--[�ð� ����]--");
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
			System.out.println("[1]�ð�����\n[2]����");
			System.out.print("�޴� ����: ");
			int select3 = scan.nextInt();
			if(select3==1) {
				System.out.print("�ð� ����: ");
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
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	
//	�¼����
	public void seat() {
		System.out.println();
		if(local.equals("����")) {
			System.out.println("  ------------SCREEN------------");
			for(int i=0; i<seat.length; i++) { 
				System.out.print(getAlphabet()[i] + " ");
				for(int j=0; j<seat[i].length; j++) { 
					if(seat[i][j]==0) {
						System.out.print("[ ]"); //���¼�
					} else if(seat[i][j]==1) {
						System.out.print("[O]"); //������
					} else if(seat[i][j]==2) {
						System.out.print("[!]"); //¦���¼� ���źҰ�
					} else if(seat[i][j]==3){
						System.out.print("[X]"); //�̹� ���ſϷ�
					}
				}
				System.out.println();
			}
			System.out.println("  ------------------------------");
		} else if(local.equals("��⵵")) {
			System.out.println("  ---------SCREEN---------");
			for(int i=0; i<gseat.length; i++) { 
				System.out.print(getAlphabet()[i] + " ");
				for(int j=0; j<gseat[i].length; j++) { 
					if(gseat[i][j]==0) {
						System.out.print("[ ]"); //���¼�
					} else if(gseat[i][j]==1) {
						System.out.print("[O]"); //������
					} else if(gseat[i][j]==2) {
						System.out.print("[!]"); //¦���¼� ���źҰ�
					} else if(gseat[i][j]==3){
						System.out.print("[X]"); //�̹� ���ſϷ�
					}
				}
				System.out.println();
			}
			System.out.println("  ------------------------");
		} else if(local.equals("��õ")) {
			System.out.println("  ------------SCREEN------------");
			for(int i=0; i<iseat.length; i++) { 
				System.out.print(getAlphabet()[i] + " ");
				for(int j=0; j<iseat[i].length; j++) { 
					if(iseat[i][j]==0) {
						System.out.print("[ ]"); //���¼�
					} else if(iseat[i][j]==1) {
						System.out.print("[O]"); //������
					} else if(iseat[i][j]==2) {
						System.out.print("[!]"); //¦���¼� ���źҰ�
					} else if(iseat[i][j]==3){
						System.out.print("[X]"); //�̹� ���ſϷ�
					}
				}
				System.out.println();
			}
			System.out.println("  ------------------------------");
		}
	}
	
//	�����ο� ����
	public void seeMenu() {
		while(true) {
			seat();
			System.out.print("�ο� ����(1~8)(0.����): ");
			int person = scan.nextInt();
			if(person>8 || person<0) {
				System.out.println("�ο��� �ٽ� Ȯ���ϼ���.");
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
	
//	1�� ����
	public void one() {
		while(true) {
			if(local.equals("����")) {
				int c = 2; //-1�̸� continue, 1�̸� ���ſϷ�
				

				int[][] viewSeat = new int[8][2];
				
				for(int a=0; a<viewSeat.length; a++) { 
					for(int b=0; b<viewSeat[a].length; b++) { 
						viewSeat[a][b] = -1;
					}
				}
				
//				¦���¼� ���� ���ϰ� ���
				for(int i=0; i<seat.length; i++) { 
					for(int j=0; j<seat[i].length; j++) { 
						if((j+1)%2==0 && seat[i][j]!=3 && seat[i][j]!=1) {
//							������ �¼��� : ¦���¼� / ���� �Ϸ� / ������ �϶�
							seat[i][j]=2; // ¦���¼� ���źҰ��� ���! 
//							�տ� ������ �¼��� ¦���¼��� ���޾� ������ �� ¦���¼��� ���� �����ϰ� �ϴ� �ڵ�
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
				int chk = -1; //�� index��ȣ ã��
				
				System.out.print("�����¼�1(A~M): ");
				String choice = scan.next();
				System.out.print("�����¼�2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("���� �¼��Դϴ�.");
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
				
//				����ó��
				if(chk<0) { //A~M���� �ƴϸ�
					c = -1;
				} else {
					for(int i=0; i<seat.length; i++) { 
						for(int j=0; j<seat[i].length; j++) { 
							if(choice2>seat[i].length+1 || choice2<1 || seat[chk][choice2-1]==3 || seat[chk][choice2-1]==1 || seat[chk][choice2-1]==2) { 
//								�����¼���ȣ�� 0 ����, 10�̻��̰ų� / ���źҰ����� �¼��̰ų� / ������ �¼��̰ų� / Ȧ������ �����ϸ�
								c = -1;
							} else {
								c = 1;
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("���źҰ����� �¼��Դϴ�.");
					System.out.println("�ٽ� �������ּ���.");
					continue;
				} else {
					seat[chk][choice2-1] = 1;
					seat();
					ticket = ticket + choice + "��" + (choice2);
					System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
					cnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					reset();
					System.out.println("[1]�����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						seat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
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
			} else if(local.equals("��⵵")) {
				int c = 2; //-1�̸� continue, 1�̸� ���ſϷ�
//				¦���¼� ���� ���ϰ� ���
				for(int i=0; i<gseat.length; i++) { 
					for(int j=0; j<gseat[i].length; j++) { 
						if((j+1)%2==0 && gseat[i][j]!=3 && gseat[i][j]!=1) {
//							������ �¼��� : ¦���¼� / ���� �Ϸ� / ������ �϶�
							gseat[i][j]=2; // ¦���¼� ���źҰ��� ���!
//							�տ� ������ �¼��� ¦���¼��� ���޾� ������ �� ¦���¼��� ���� �����ϰ� �ϴ� �ڵ�
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
				int chk = -1; //�� index��ȣ ã��
				
				System.out.print("�����¼�1(A~I): ");
				String choice = scan.next();
				System.out.print("�����¼�2(1~8): ");
				int choice2 = scan.nextInt();
				
				if(choice2>8) {
					System.out.println("���� �¼��Դϴ�.");
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
				
//				����ó��
				if(chk<0) { //A~M���� �ƴϸ�
					c = -1;
				} else {
					for(int i=0; i<gseat.length; i++) { 
						for(int j=0; j<gseat[i].length; j++) { 
							if(choice2>gseat[i].length+1 || choice2<1 || gseat[chk][choice2-1]==3 || gseat[chk][choice2-1]==1 || gseat[chk][choice2-1]==3) { 
//								�����¼���ȣ�� 0 ����, 10�̻��̰ų� / ���źҰ����� �¼��̰ų� / ������ �¼��̰ų� / Ȧ������ �����ϸ�
								c = -1;
							} else {
								c = 1;
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("���źҰ����� �¼��Դϴ�.");
					System.out.println("�ٽ� �������ּ���.");
					continue;
				} else {
					gseat[chk][choice2-1] = 1;
					seat();
					ticket = ticket + choice + "��" + (choice2);
					System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
					cnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					reset();
					System.out.println("[1]�����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						gseat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
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
			} else if(local.equals("��õ")) {
				int c = 2; //-1�̸� continue, 1�̸� ���ſϷ�
//				¦���¼� ���� ���ϰ� ���
				for(int i=0; i<iseat.length; i++) { 
					for(int j=0; j<iseat[i].length; j++) { 
						if((j+1)%2==0 && iseat[i][j]!=3 && iseat[i][j]!=1) {
//							������ �¼��� : ¦���¼� / ���� �Ϸ� / ������ �϶�
							iseat[i][j]=2; // ¦���¼� ���źҰ��� ���!
//							�տ� ������ �¼��� ¦���¼��� ���޾� ������ �� ¦���¼��� ���� �����ϰ� �ϴ� �ڵ�
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
				int chk = -1; //�� index��ȣ ã��
				
				System.out.print("�����¼�1(A~E): ");
				String choice = scan.next();
				System.out.print("�����¼�2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("���� �¼��Դϴ�.");
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
				
//				����ó��
				if(chk<0) { //A~M���� �ƴϸ�
					c = -1;
				} else {
					for(int i=0; i<iseat.length; i++) { 
						for(int j=0; j<iseat[i].length; j++) { 
							if(choice2>iseat[i].length+1 || choice2<1 || iseat[chk][choice2-1]==3 || iseat[chk][choice2-1]==1 || iseat[chk][choice2-1]==3) { 
//								�����¼���ȣ�� 0 ����, 10�̻��̰ų� / ���źҰ����� �¼��̰ų� / ������ �¼��̰ų� / Ȧ������ �����ϸ�
								c = -1;
							} else {
								c = 1;
							}
						}
					}
				}
				
				if(c==-1) {
					System.out.println("���źҰ����� �¼��Դϴ�.");
					System.out.println("�ٽ� �������ּ���.");
					continue;
				} else {
					iseat[chk][choice2-1] = 1;
					seat();
					ticket = ticket + choice + "��" + (choice2);
					System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
					cnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					reset();
					System.out.println("[1]�����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						iseat[chk][choice2-1] = 0;
						cnt--;
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
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
	
//	2�� ����
	public void two() {
		while(true) {
			if(local.equals("����")) {
				seat();
				int chk = -1; //�� index��ȣ ã��
				int c = 2; //-1�̸� continue, 1�̸� ���ſϷ�, 2�� �ڿ� �¼�!
				
				System.out.print("�����¼�1(A~M): ");
				String choice = scan.next();
				System.out.print("�����¼�2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("���� �¼��Դϴ�.");
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
				
//				����ó��
				if(c!=-1) {
					if(chk<0) { //A~M���� �ƴϸ�
						c = -1;
					} else {
						for(int i=0; i<seat.length; i++) { 
							for(int j=0; j<seat[i].length; j++) { 
								if(choice2!=seat[i].length) {
									if((seat[chk][choice2-1]!=1 && seat[chk][choice2-1]!=3) && (seat[chk][choice2]==1 || seat[chk][choice2]==3) && (seat[chk][choice2-2]!=3 && seat[chk][choice2-2]!=1)) {
//										������ �¼��� ���Ű��� �¼��̰�, ������ ���� �¼��� ���ſϷ��, �����ϱ� �� �¼��� ���ſϷᰡ �ƴϸ�
										c = 1;
									} else if(choice2>seat[i].length+1 || choice2<1 || seat[chk][choice2-1]==3 || seat[chk][choice2-1]==1 || seat[chk][choice2]==3 || seat[chk][choice2]==1) { 
//										�����¼���ȣ�� 0 ����, 10�̻��̰ų� / ���źҰ����� �¼��̰ų� / ���ſϷ�ų� / �����¼��� ���źҰ����� �¼��̰ų� / ���� �¼��� ���ſϷ�
										c = -1;
									} 
								} else {
									if(seat[chk][choice2-2]==3 || seat[chk][choice2-2]==1) {
//										10�� �¼��� �������� �� 9�� �¼��� ���ſϷᳪ �����߻��¸�
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
					System.out.println("���źҰ����� �¼��Դϴ�.");
					System.out.println("�ٽ� �������ּ���.");
					continue;
				} else if(c==1) {
					seat[chk][choice2-1] = 1; //������ �¼�
					seat[chk][choice2-2] = 1; //������ �¼��� ���� ����!
					seat();
					System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
					ticket = ticket + choice + "��" + (choice2-1) + " ";
					ticket = ticket + choice + "��" + (choice2);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]�����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
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
					seat[chk][choice2-1] = 1; //������ �¼�
					seat[chk][choice2] = 1; //������ �¼� �����¼� ����
					seat();
					System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
					ticket = ticket + choice + "��" + (choice2) + " ";
					ticket = ticket + choice + "��" + (choice2+1);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]�����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1), "");
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
			} else if(local.equals("��⵵")) {
				seat();
				int chk = -1; //�� index��ȣ ã��
				int c = 2; //-1�̸� continue, 1�̸� ���ſϷ�, 2�� �ڿ� �¼�!
				
				System.out.print("�����¼�1(A~I): ");
				String choice = scan.next();
				System.out.print("�����¼�2(1~8): ");
				int choice2 = scan.nextInt();
				
				if(choice2>8) {
					System.out.println("���� �¼��Դϴ�.");
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
				
//				����ó��
				if(c!=-1) {
					if(chk<0) { //A~M���� �ƴϸ�
						c = -1;
					} else {
						for(int i=0; i<gseat.length; i++) { 
							for(int j=0; j<gseat[i].length; j++) { 
								if(choice2!=gseat[i].length) {
									if((gseat[chk][choice2-1]!=1 && gseat[chk][choice2-1]!=3) && (gseat[chk][choice2]==1 || gseat[chk][choice2]==3) && (gseat[chk][choice2-2]!=3 && gseat[chk][choice2-2]!=1)) {
//										������ �¼��� ���Ű��� �¼��̰�, ������ ���� �¼��� ���ſϷ��, �����ϱ� �� �¼��� ���ſϷᰡ �ƴϸ�
										c = 1;
									} else if(choice2>gseat[i].length+1 || choice2<1 || gseat[chk][choice2-1]==3 || gseat[chk][choice2-1]==1 || gseat[chk][choice2]==3 || gseat[chk][choice2]==1) { 
//										�����¼���ȣ�� 0 ����, 10�̻��̰ų� / ���źҰ����� �¼��̰ų� / ���ſϷ�ų� / �����¼��� ���źҰ����� �¼��̰ų� / ���� �¼��� ���ſϷ�
										c = -1;
									} 
								} else {
									if(gseat[chk][choice2-2]==3 || gseat[chk][choice2-2]==1) {
//										10�� �¼��� �������� �� 9�� �¼��� ���ſϷᳪ �����߻��¸�
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
					System.out.println("���źҰ����� �¼��Դϴ�.");
					System.out.println("�ٽ� �������ּ���.");
					continue;
				} else if(c==1) {
					gseat[chk][choice2-1] = 1; //������ �¼�
					gseat[chk][choice2-2] = 1; //������ �¼��� ���� ����!
					seat();
					System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
					ticket = ticket + choice + "��" + (choice2-1) + " ";
					ticket = ticket + choice + "��" + (choice2);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]�����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
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
					gseat[chk][choice2-1] = 1; //������ �¼�
					gseat[chk][choice2] = 1; //������ �¼� �����¼� ����
					seat();
					System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
					ticket = ticket + choice + "��" + (choice2) + " ";
					ticket = ticket + choice + "��" + (choice2+1);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]�����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1), "");
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
			} else if(local.equals("��õ")) {
				seat();
				int chk = -1; //�� index��ȣ ã��
				int c = 2; //-1�̸� continue, 1�̸� ���ſϷ�, 2�� �ڿ� �¼�!
				
				System.out.print("�����¼�1(A~E): ");
				String choice = scan.next();
				System.out.print("�����¼�2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2<1 || choice2>10) {
					c=-1;
				} 
				
				if(choice2>10) {
					System.out.println("���� �¼��Դϴ�.");
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
				
//				����ó��
				if(c!=-1) {
					if(chk<0) { //A~M���� �ƴϸ�
						c = -1;
					} else {
						for(int i=0; i<iseat.length; i++) { 
							for(int j=0; j<iseat[i].length; j++) { 
								if(choice2!=iseat[i].length) {
									if((iseat[chk][choice2-1]!=1 && iseat[chk][choice2-1]!=3) && (iseat[chk][choice2]==1 || iseat[chk][choice2]==3) && (iseat[chk][choice2-2]!=3 && iseat[chk][choice2-2]!=1)) {
//										������ �¼��� ���Ű��� �¼��̰�, ������ ���� �¼��� ���ſϷ��, �����ϱ� �� �¼��� ���ſϷᰡ �ƴϸ�
										c = 1;
									} else if(choice2>iseat[i].length+1 || choice2<1 || iseat[chk][choice2-1]==3 || iseat[chk][choice2-1]==1 || iseat[chk][choice2]==3 || iseat[chk][choice2]==1) { 
//										�����¼���ȣ�� 0 ����, 10�̻��̰ų� / ���źҰ����� �¼��̰ų� / ���ſϷ�ų� / �����¼��� ���źҰ����� �¼��̰ų� / ���� �¼��� ���ſϷ�
										c = -1;
									} 
								} else {
									if(iseat[chk][choice2-2]==3 || iseat[chk][choice2-2]==1) {
//										10�� �¼��� �������� �� 9�� �¼��� ���ſϷᳪ �����߻��¸�
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
					System.out.println("���źҰ����� �¼��Դϴ�.");
					System.out.println("�ٽ� �������ּ���.");
					continue;
				} else if(c==1) {
					iseat[chk][choice2-1] = 1; //������ �¼�
					iseat[chk][choice2-2] = 1; //������ �¼��� ���� ����!
					seat();
					System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
					ticket = ticket + choice + "��" + (choice2-1) + " ";
					ticket = ticket + choice + "��" + (choice2);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]�����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
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
					iseat[chk][choice2-1] = 1; //������ �¼�
					iseat[chk][choice2] = 1; //������ �¼� �����¼� ����
					seat();
					System.out.println("�¼������� �Ϸ�Ǿ����ϴ�.");
					ticket = ticket + choice + "��" + (choice2) + " ";
					ticket = ticket + choice + "��" + (choice2+1);
					cnt+=2;
					reset();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]�����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						payment();
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1), "");
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
	
//	2�� ����(3�� �̻� ����������)
	public void twoOne() {
		while(true) {
			if(local.equals("����")) {
				seat();
				int chk = -1; //�� index��ȣ ã��
				int c = 2; //-1�̸� continue, 1�̸� ���ſϷ�, 2�� �ڿ� �¼�!
				
				System.out.print("�����¼�1(A~M): ");
				String choice = scan.next();
				System.out.print("�����¼�2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("���� �¼��Դϴ�.");
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
				
//				����ó��
				if(c!=-1) {
					if(chk<0) { //A~M���� �ƴϸ�
						c = -1;
					} else {
						for(int i=0; i<seat.length; i++) { 
							for(int j=0; j<seat[i].length; j++) { 
								if(choice2!=seat[i].length) {
									if((seat[chk][choice2-1]!=1 && seat[chk][choice2-1]!=3) && (seat[chk][choice2]==1 || seat[chk][choice2]==3) && (seat[chk][choice2-2]!=3 && seat[chk][choice2-2]!=1)) {
//										������ �¼��� ���Ű��� �¼��̰�, ������ ���� �¼��� ���ſϷ��, �����ϱ� �� �¼��� ���ſϷᰡ �ƴϸ�
										c = 1;
									} else if(choice2>seat[i].length+1 || choice2<1 || seat[chk][choice2-1]==3 || seat[chk][choice2-1]==1 || seat[chk][choice2]==3 || seat[chk][choice2]==1) { 
//										�����¼���ȣ�� 0 ����, 10�̻��̰ų� / ���źҰ����� �¼��̰ų� / ���ſϷ�ų� / �����¼��� ���źҰ����� �¼��̰ų� / ���� �¼��� ���ſϷ�
										c = -1;
									} 
								} else {
									if(seat[chk][choice2-2]==3 || seat[chk][choice2-2]==1) {
//										10�� �¼��� �������� �� 9�� �¼��� ���ſϷᳪ �����߻��¸�
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
					System.out.println("���źҰ����� �¼��Դϴ�.");
					System.out.println("�ٽ� �������ּ���.");
					continue;
				} else if(c==1) {
					seat[chk][choice2-1] = 1; //������ �¼�
					seat[chk][choice2-2] = 1; //������ �¼��� ���� ����!
					ticket = ticket + choice + "��" + (choice2-1) + " ";
					ticket = ticket + choice + "��" + (choice2) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]��� �����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0;
						seat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						seat[chk][choice2-1] = 0;
						seat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
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
					seat[chk][choice2-1] = 1; //������ �¼�
					seat[chk][choice2] = 1; //������ �¼� �����¼� ����
					ticket = ticket + choice + "��" + (choice2) + " ";
					ticket = ticket + choice + "��" + (choice2+1) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]��� �����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						seat[chk][choice2-1] = 0;
						seat[chk][choice2] = 0; 
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1) + " ", "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						seat[chk][choice2-1] = 0; 
						seat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1) + " ", "");
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
			} else if(local.equals("��⵵")) {
				seat();
				int chk = -1; //�� index��ȣ ã��
				int c = 2; //-1�̸� continue, 1�̸� ���ſϷ�, 2�� �ڿ� �¼�!
				
				System.out.print("�����¼�1(A~I): ");
				String choice = scan.next();
				System.out.print("�����¼�2(1~8): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("���� �¼��Դϴ�.");
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
				
//				����ó��
				if(c!=-1) {
					if(chk<0) { //A~M���� �ƴϸ�
						c = -1;
					} else {
						for(int i=0; i<gseat.length; i++) { 
							for(int j=0; j<gseat[i].length; j++) { 
								if(choice2!=gseat[i].length) {
									if((gseat[chk][choice2-1]!=1 && gseat[chk][choice2-1]!=3) && (gseat[chk][choice2]==1 || gseat[chk][choice2]==3) && (gseat[chk][choice2-2]!=3 && gseat[chk][choice2-2]!=1)) {
//										������ �¼��� ���Ű��� �¼��̰�, ������ ���� �¼��� ���ſϷ��, �����ϱ� �� �¼��� ���ſϷᰡ �ƴϸ�
										c = 1;
									} else if(choice2>gseat[i].length+1 || choice2<1 || gseat[chk][choice2-1]==3 || gseat[chk][choice2-1]==1 || gseat[chk][choice2]==3 || gseat[chk][choice2]==1) { 
//										�����¼���ȣ�� 0 ����, 10�̻��̰ų� / ���źҰ����� �¼��̰ų� / ���ſϷ�ų� / �����¼��� ���źҰ����� �¼��̰ų� / ���� �¼��� ���ſϷ�
										c = -1;
									} 
								} else {
									if(gseat[chk][choice2-2]==3 || gseat[chk][choice2-2]==1) {
//										10�� �¼��� �������� �� 9�� �¼��� ���ſϷᳪ �����߻��¸�
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
					System.out.println("���źҰ����� �¼��Դϴ�.");
					System.out.println("�ٽ� �������ּ���.");
					continue;
				} else if(c==1) {
					gseat[chk][choice2-1] = 1; //������ �¼�
					gseat[chk][choice2-2] = 1; //������ �¼��� ���� ����!
					ticket = ticket + choice + "��" + (choice2-1) + " ";
					ticket = ticket + choice + "��" + (choice2) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]��� �����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0;
						gseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						gseat[chk][choice2-1] = 0;
						gseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
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
					gseat[chk][choice2-1] = 1; //������ �¼�
					gseat[chk][choice2] = 1; //������ �¼� �����¼� ����
					ticket = ticket + choice + "��" + (choice2) + " ";
					ticket = ticket + choice + "��" + (choice2+1) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]��� �����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						gseat[chk][choice2-1] = 0;
						gseat[chk][choice2] = 0; 
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1) + " ", "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						gseat[chk][choice2-1] = 0; 
						gseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1) + " ", "");
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
			} else if(local.equals("��õ")) {
				seat();
				int chk = -1; //�� index��ȣ ã��
				int c = 2; //-1�̸� continue, 1�̸� ���ſϷ�, 2�� �ڿ� �¼�!
				
				System.out.print("�����¼�1(A~E): ");
				String choice = scan.next();
				System.out.print("�����¼�2(1~10): ");
				int choice2 = scan.nextInt();
				
				if(choice2>10) {
					System.out.println("���� �¼��Դϴ�.");
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
				
//				����ó��
				if(c!=-1) {
					if(chk<0) { //A~M���� �ƴϸ�
						c = -1;
					} else {
						for(int i=0; i<iseat.length; i++) { 
							for(int j=0; j<iseat[i].length; j++) { 
								if(choice2!=iseat[i].length) {
									if((iseat[chk][choice2-1]!=1 && iseat[chk][choice2-1]!=3) && (iseat[chk][choice2]==1 || iseat[chk][choice2]==3) && (iseat[chk][choice2-2]!=3 && iseat[chk][choice2-2]!=1)) {
//										������ �¼��� ���Ű��� �¼��̰�, ������ ���� �¼��� ���ſϷ��, �����ϱ� �� �¼��� ���ſϷᰡ �ƴϸ�
										c = 1;
									} else if(choice2>iseat[i].length+1 || choice2<1 || iseat[chk][choice2-1]==3 || iseat[chk][choice2-1]==1 || iseat[chk][choice2]==3 || iseat[chk][choice2]==1) { 
//										�����¼���ȣ�� 0 ����, 10�̻��̰ų� / ���źҰ����� �¼��̰ų� / ���ſϷ�ų� / �����¼��� ���źҰ����� �¼��̰ų� / ���� �¼��� ���ſϷ�
										c = -1;
									} 
								} else {
									if(iseat[chk][choice2-2]==3 || iseat[chk][choice2-2]==1) {
//										10�� �¼��� �������� �� 9�� �¼��� ���ſϷᳪ �����߻��¸�
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
					System.out.println("���źҰ����� �¼��Դϴ�.");
					System.out.println("�ٽ� �������ּ���.");
					continue;
				} else if(c==1) {
					iseat[chk][choice2-1] = 1; //������ �¼�
					iseat[chk][choice2-2] = 1; //������ �¼��� ���� ����!
					ticket = ticket + choice + "��" + (choice2-1) + " ";
					ticket = ticket + choice + "��" + (choice2) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-2;
					seatCnt++;
					System.out.println("[1]��� �����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0;
						iseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						iseat[chk][choice2-1] = 0;
						iseat[chk][choice2-2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, ticket + choice + "��" + (choice2-1) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2), "");
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
					iseat[chk][choice2-1] = 1; //������ �¼�
					iseat[chk][choice2] = 1; //������ �¼� �����¼� ����
					ticket = ticket + choice + "��" + (choice2) + " ";
					ticket = ticket + choice + "��" + (choice2+1) + " ";
					cnt+=2;
					seat();
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2-1;
					seatCnt++;
					seat2[seatCnt][0] = chk;
					seat2[seatCnt][1] = choice2;
					seatCnt++;
					System.out.println("[1]��� �����ϱ�\n[2]�¼� �ٽ� ����");
					System.out.print("�޴�����: ");
					int select = scan.nextInt();
					if(select==1) {
						break;
					} else if(select==2) {
						c = 1;
						iseat[chk][choice2-1] = 0;
						iseat[chk][choice2] = 0; 
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1) + " ", "");
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
						seat2[seatCnt][0] = -1;
						seat2[seatCnt][1] = -1;
						seatCnt--;
					} else {
						System.out.println("���� �޴��Դϴ�.");
						System.out.println("�ٽ� �������ּ���.");
						c = 1;
						iseat[chk][choice2-1] = 0; 
						iseat[chk][choice2] = 0;
						cnt-=2;
						ticket = replaceLast(ticket, choice + "��" + (choice2) + " ", "");
						ticket = replaceLast(ticket, choice + "��" + (choice2+1) + " ", "");
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
	
//	3�� ����
	public void three() {
		twoOne();
		one();
	}
	
//	4�� ����
	public void four() {
		twoOne();
		two();
	}
	
//	5�� ����
	public void five() {
		twoOne();
		twoOne();
		one();
	}
	
//	6�� ����
	public void six() {
		twoOne();
		twoOne();
		two();
	}
	
//	7�� ����
	public void seven() {
		twoOne();
		twoOne();
		twoOne();
		one();
	}
	
//	8�� ����
	public void eight() {
		twoOne();
		twoOne();
		twoOne();
		two();
	}
	
//	�¼� �ʱ�ȭ 
	public void reset() {
		if(local.equals("����")) {
			for(int i=0; i<seat.length; i++) { 
				for(int j=0; j<seat[i].length; j++) { 
					if(seat[i][j]==2) {
						seat[i][j]=0;
					} else if(seat[i][j]==1) {
						seat[i][j]=3;
					}
				}
			}
		} else if(local.equals("��⵵")) {
			for(int i=0; i<gseat.length; i++) { 
				for(int j=0; j<gseat[i].length; j++) { 
					if(gseat[i][j]==2) {
						gseat[i][j]=0;
					} else if(gseat[i][j]==1) {
						gseat[i][j]=3;
					}
				}
			}
		} else if(local.equals("��õ")) {
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
	
//	�����ϱ�
	public void payment() {
		int log = Menu.log;
		for(int i=0; i<size; i++) {
			if(name.equals(getMovie()[i])) {
				moviePrice = getPrice()[i];
			}
		}
		price = cnt*moviePrice;
		price2 = cnt*moviePrice; //����Ʈ�� ����
		cal.setTime(time);
		cal.add(Calendar.HOUR, preview[mo][0]);
		cal.add(Calendar.MINUTE, preview[mo][1]);
		while(true) {
			System.out.println();
			System.out.println("---------------------------------");
			System.out.printf("%s\n%s(%s)\n%s | %s~%s\n���� %d��(%s)\n", name, Theater, local, f.format(time), f2.format(time), f2.format(cal.getTime()), cnt, ticket);
			System.out.println("---------------------------------");
			System.out.printf("�ݾ�:\t\t%s��\n����Ʈ:\t\t-%sp\n�Ѱ����ݾ�:\t%s��\n", de.format(price), de.format(point), de.format(price2));
			System.out.println("---------------------------------");
			System.out.println("[1]����\n[2]����Ʈ ���\n[3]�¼� �ٽ� ����");
			System.out.print("�޴�����: ");
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
				System.out.println("������ �Ϸ�Ǿ����ϴ�.");
				double inPoint = price2*0.05;
				System.out.printf("��ȭ���ŷ� %sp�� �����Ǿ����ϴ�!\n", de.format((int)inPoint));
				pointVO.add(new PointVO(id, "��ȭ����", (int)inPoint, current));
				user.get(log).setPoint((int)inPoint);
				basketReset();
				finalChk = 0;
				break;
			} else if(select==2) {
				System.out.printf("���� ���� ����Ʈ: %sp\n", de.format(user.get(log).getPoint()));
				System.out.print("����� ����Ʈ: ");
				point = scan.nextInt();
				if(point>user.get(log).getPoint()) {
					System.out.println("����Ʈ�� �����մϴ�.");
					point = 0;
				} else if(point<1) {
					System.out.println("0p���ϴ� �� �� �����ϴ�.");
					point = 0;
				} else {
					Date current = new Date();
					price2 = price2 - point;
					user.get(log).setPoint(-point);
					System.out.printf("%sp��ŭ �ݾ��� �����˴ϴ�.\n", de.format(point));
					pointVO.add(new PointVO(id, "��ȭ����", -point, current));
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
							if(local.equals("����")) {
								seat[seat2[i][0]][seat2[i][1]] = 0;
							} else if(local.equals("��⵵")) {
								gseat[seat2[i][0]][seat2[i][1]] = 0;
							} else if(local.equals("��õ")) {
								iseat[seat2[i][0]][seat2[i][1]] = 0;
							} 
						}
					}
				}
				seatCnt = 0;
				seeMenu();
				break;
			} else {
				System.out.println("���� �޴��Դϴ�.");
			}
		}	
	}
	
//	��ٱ��� ����
	public void basketReset() {
		id = ""; //��ȭ������ ȸ��
		name = ""; //��ȭ�̸�
		local = ""; //����
		Theater = ""; //��ȭ��
		dath = new Date(0,0,0,0,0,0); //������
		ticket = ""; //������ ��
		cnt = 0; //������ ��ȭ ����
		price = 0; //��ȭ�ݾ�
		price2 = 0; //��ȭ�ݾ�
		point = 0; //��ȭ�ݾ�
		moviePrice = 0;
		seatCnt = 0;
	}
	
//	�˻�
	public void search() {
		int log = Menu.log;
		int cnt = 0;
		System.out.print("��ȭ�� �˻�: ");
		String movie = scan.next();
		for(int i=0; i<size; i++) {
			if(getMovie()[i].contains(movie)) {
				cnt = 1;
			}
		}
		if(cnt==0) {
			System.out.println("�������� �ʴ� ��ȭ�Դϴ�.");
		} else {
			cnt=1;
			System.out.println();
			System.out.println("            --[��ȭ ���]--");
			System.out.println("--------------------------------------");
			System.out.println("      ��ȭ�̸�\t������\t����");
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
			System.out.println("[1]����\n[2]����");
			System.out.print("�޴�����: ");
			int select = scan.nextInt();
				
			if(select==1) {
				if(log<0) {
					System.out.println("�α��� �� �̿밡��");
				} else {
					id = user.get(log).getId();
					System.out.print("������ ��ȭ: ");
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
				System.out.println("���� �޴��Դϴ�.");
			}
		}
	}
	
}
