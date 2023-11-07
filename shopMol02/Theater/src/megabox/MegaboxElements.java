package megabox;

public class MegaboxElements{
	public static final int row = 9; // �¼��� ��
	public static final int column = 8; // �¼��� ��
	protected int[][] screen = new int[row][column]; // �¼�
	protected String[] rowAlphabet = {"A","B","C","D","E","F","G","H","I"};
	protected int revenue = 0; // �����
	protected int personnel = 0; // ������ �ο���
	protected String reserveRow = null;
	protected int reserveSeat1 = 0; // �����¼�1
	protected int reserveSeat2 = 0; // �����¼�2
	protected boolean run = true;

	public MegaboxElements() {}

	public int[][] getScreen() {
		return screen;
	}

	public void setScreen(int[][] screen) {
		this.screen = screen;
	}

	public String[] getRowAlphabet() {
		return rowAlphabet;
	}

	public void setRowAlphabet(String[] rowAlphabet) {
		this.rowAlphabet = rowAlphabet;
	}
	
	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getPersonnel() {
		return personnel;
	}

	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}

	public String getReserveRow() {
		return reserveRow;
	}

	public void setReserveRow(String reserveRow) {
		this.reserveRow = reserveRow;
	}

	public int getReserveSeat1() {
		return reserveSeat1;
	}

	public void setReserveSeat1(int reserveSeat1) {
		this.reserveSeat1 = reserveSeat1;
	}

	public int getReserveSeat2() {
		return reserveSeat2;
	}

	public void setReserveSeat2(int reserveSeat2) {
		this.reserveSeat2 = reserveSeat2;
	}
	
	public boolean isRun() {
		return run;
	}

	public void setRun(boolean run) {
		this.run = run;
	}
	
	public void printScreen() {
		System.out.println("---------SCREEN---------");
		for(int i=0;i<row;i++) {
			System.out.print(rowAlphabet[i]);
			for(int j=0;j<column;j++) {
				if(screen[i][j]==0) {
					System.out.print("[ ]"); // �������� ���� �ڸ�
				}
				else if(screen[i][j]==1) {
					System.out.print("[O]"); // ������ �ڸ�
				}
				else if(screen[i][j]==2) {
					System.out.print("[X]"); // ���� �Ұ����� �ڸ� (�� �� ���� or Ȧ�� �� �� ������ ��� ������ ���)
				}
				else {
					System.out.print("[-]"); // �ٸ� ������� ������ �ڸ�
				}
			}
			System.out.println();
		}
		System.out.println("------------------------");
	}
	
	public void disableEvenColumns() { // ¦�� ��° �ڸ��� ���� �Ұ����� �ڸ��� ����
		for(int i=0;i<row;i++) {
			for(int j=0;j<column/2-1;j++) { // ���� ������ ¦���� ��� ��� ����
				// ¦�� ��° �� �߿��� ���� ������ �ڸ��� �ְ�, �� �ڸ� �翷�� ������ �ڸ��� �ϳ��� ���� �� (������ �� ����)
				if(screen[i][2*j+1]==0 && screen[i][2*j]!=1 && screen[i][2*j+2]!=1) {
					screen[i][2*j+1]=2; // �� �ڸ��� ���� �Ұ����� �ڸ��� ǥ��
				}
			}
			if(screen[i][column-1]==0 && screen[i][column-2]!=1) { // ������ ���� ��쵵 �����ϵ��� ���ش�.
				screen[i][column-1]=2;
			}
		}
	}
	
	public void initializeDisabledColumns() { // ���� �Ұ������� ǥ��ƴ� �ڸ� �ʱ�ȭ
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(screen[i][j]==2) {
					screen[i][j]=0;
				}
			}
		}
	}
	
	public void convertReservedSeats() { // ������ �ڸ��� ���ŵ� �ڸ��� ����
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(screen[i][j]==1) {
					screen[i][j]=3;
				}
			}
		}
	}
	
	public void cancelReservedSeats() { // ������ �ڸ��� ���
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				if(screen[i][j]==1) {
					screen[i][j]=0;
					revenue -= 12000;
				}
			}
		}
	}
}
