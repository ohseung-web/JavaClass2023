package mega_Movie;

import java.text.SimpleDateFormat;
import java.util.*;

public class MovieDAO {
	Scanner scan = new Scanner(System.in);
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
	SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");

	HashMap<String, String> movieLocalType = new HashMap<>();
	ArrayList<MovieDTO> movieDto = new ArrayList<>();
	MovieDTO mdto = new MovieDTO();
	int num=0;

	public MovieDAO() {
		info();
	}

	public void info() {
		addMovie(new MovieDTO(num++, "����", "����","s"));
		addMovie(new MovieDTO(num++, "����", "����","s"));
		addMovie(new MovieDTO(num++, "����", "���빮","s"));
		movieLocalType.put("����", "s");
		addMovie(new MovieDTO(num++, "���", "��õ","k"));
		addMovie(new MovieDTO(num++, "���", "������","k"));
		addMovie(new MovieDTO(num++, "���", "����õ","k"));
		movieLocalType.put("���", "k");
		addMovie(new MovieDTO(num++, "��õ", "����","i"));
		addMovie(new MovieDTO(num++, "��õ", "�˴�","i"));
		addMovie(new MovieDTO(num++, "��õ", "û��","i"));
		movieLocalType.put("��õ", "i");
	}

	// ��ȭ�߰� �޼���
	public void addMovie(MovieDTO m) {
		movieDto.add(m);
	}

	// ��ȭ��� �޼���
	public void movieList() {

		System.out.println("\t\t-- [��ȭ ���] --");
		System.out.println("--------------------------------------------");
		System.out.println("��ȭ�̸�\t\t\t\t����");
		for(int i=0; i<mdto.getMovie().length; i++) {
			System.out.println("["+(i+1)+"]"+mdto.getMovie()[i]+"\t\t\t"
					+sdf.format(mdto.getDay()[i]));
		}
		System.out.println("--------------------------------------------");
		while(true) {
			System.out.println("[1]����");
			System.out.println("[2]����");
			System.out.print("�޴� ����:");
			int select = scan.nextInt();
			if(select == 1) {
				localChoice();
				break;
			}else {
				break;
			}
		}

	}

	// ��ȭ�˻� �޼���
	public void movieSearch() {
		System.out.print("��ȭ�� �˻�");
		String movieName = scan.next();
		int check=0;

		System.out.println("\t\t-- [��ȭ ���] --");
		System.out.println("--------------------------------------------");
		System.out.println("��ȭ�̸�\t\t\t\t����");
		for(int i=0; i<mdto.getMovie().length; i++) {
			if(mdto.getMovie()[i].equals(movieName)) {
				check = i;
			}
		}
		System.out.println("["+(1)+"]"+mdto.getMovie()[check]+"\t\t\t"
				+sdf.format(mdto.getDay()[check]));
		System.out.println("--------------------------------------------");
		while(true) {
			System.out.println("[1]����");
			System.out.println("[2]����");
			System.out.print("�޴� ����:");
			int select = scan.nextInt();
			if(select == 1) {
				localChoice();
				//break;
			}else {
				break;
			}
		}
	}

	//�������� �޼���
	public void localChoice() {
		int num = 1;
		int num1 = 1;
		
		while(true) {
			System.out.println();
			System.out.println("-- [���� ����] --");
			for(String local : movieLocalType.keySet()) {
				System.out.println("["+(num++)+"]"+local);
			}
			System.out.println("--------------");
			System.out.println("[1]��������");
			System.out.println("[2]����");
			System.out.print("�޴� ����:");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.print("���� ����:");
				int localsel = scan.nextInt();
				System.out.println();
				System.out.println("-- [���� ����] --");
				if(localsel == 1) {
					for(MovieDTO mo : movieDto) {
						if(mo.getFirstTheater().equals("s")) {
							System.out.println("["+(num1++)+"]" + mo.getTheater());  
						}
					}
					
				}else if(localsel == 2) {
					for(MovieDTO mo : movieDto) {
						if(mo.getFirstTheater().equals("k")) {
							System.out.println("["+(num1++)+"]" + mo.getTheater());  
						}
					}
				}else {
					for(MovieDTO mo : movieDto) {
						if(mo.getFirstTheater().equals("i")) {
							System.out.println("["+(num1++)+"]" + mo.getTheater());  
						}
					}
				}
			}else {
				break;
			}
			theaterChoice();
		}
		
	}

	// ���弱�� �޼���
	public void theaterChoice() {
		while(true) {
				System.out.println("--------------");
				System.out.println("[1]���弱��");
				System.out.println("[2]����");
				System.out.print("�޴� ����:");
				int sel1 = scan.nextInt();
				if(sel1==1) {
					System.out.print("���� ����");
					int theatersel = scan.nextInt();
					if(theatersel == 1 ) {
						dayChoice();
					}else if(theatersel == 2 ) {
						dayChoice();
					}else {
						dayChoice();
					}
				}else {
					break;
				}
			}
		}

	// ���ڼ��� �޼���
	public void dayChoice() {
		int num3 = 1;
		while(true) {
			System.out.println();
			System.out.println("-- [��¥ ����] --");
			System.out.println("["+num3+"]"+mdto.day1+"��");
			System.out.println("["+(num3+1)+"]"+mdto.day2+"��");
			System.out.println("["+(num3+2)+"]"+mdto.day3+"��");
			System.out.println("--------------");
			System.out.println("[1]��¥����");
			System.out.println("[2]����");
			System.out.print("�޴� ����:");
			int select = scan.nextInt();
			if(select == 1) {
				System.out.print("��¥ ����");
				int daysel = scan.nextInt();
				System.out.println();
				if(daysel == 1 ) {
					timeChoice1();
				}else if(daysel == 2) {
					timeChoice2();
				}else {
					timeChoice3();
				}
			}else {
				break;
			}
		}
	}

	// �ð����� �޼���----------------------------------------------------------------
	public void timeChoice1() {
		int num4 = 1;
		while(true) {
			System.out.println("-- [�ð� ����] --");
			for(int i=0; i<mdto.getTime().length; i++) {
				System.out.println("["+(num4++)+"]" + sdf2.format(mdto.getTime()[i])
				+"~"+(mdto.getTime()[i].getHours()+2)+":"+(mdto.getTime()[i].getMinutes()+20)); 
			}
			System.out.println("--------------");
			System.out.println("[1]�ð�����");
			System.out.println("[2]����");
			System.out.print("�޴� ����:");
			int select = scan.nextInt();

			if(select == 1) {
				System.out.print("SCREEN");
				int daysel = scan.nextInt();
				System.out.println();
				if(daysel == 1) {

				}
			}else {
				break;
			}
		}
	}

	public void timeChoice2() {
		int num4 = 1;
		while(true) {
			System.out.println();
			System.out.println("-- [�ð� ����] --");

			for(int i=0; i<mdto.getTime2().length; i++) {
				System.out.println("["+(num4++)+"]" + sdf2.format(mdto.getTime2()[i])
				+"~"+(mdto.getTime2()[i].getHours()+1)+":"+(mdto.getTime2()[i].getMinutes()+50));
			}
			System.out.println("--------------");
			System.out.println("[1]�ð�����");
			System.out.println("[2]����");
			System.out.print("�޴� ����:");
			int select = scan.nextInt();

			if(select == 1) {
				System.out.print("SCREEN");
				int daysel = scan.nextInt();
				System.out.println();
				if(daysel == 1) {

				}
			}else {
				break;
			}
		}
	}

	public void timeChoice3() {
		int num4 = 1;
		while(true) {
			System.out.println();
			System.out.println("-- [�ð� ����] --");
			for(int i=0; i<mdto.getTime3().length; i++) {
				System.out.println("["+(num4++)+"]" + sdf2.format(mdto.getTime3()[i])
				+"~"+(mdto.getTime3()[i].getHours()+2)+":"+(mdto.getTime3()[i].getMinutes()+10)); 
			}
			System.out.println("--------------");
			System.out.println("[1]�ð�����");
			System.out.println("[2]����");
			System.out.print("�޴� ����:");
			int select = scan.nextInt();

			if(select == 1) {
				System.out.print("SCREEN");
				int daysel = scan.nextInt();
				System.out.println();
				if(daysel == 1) {

				}
			}else {
				break;
			}
		}
	}
	//-----------------------------------------------------------------

}
