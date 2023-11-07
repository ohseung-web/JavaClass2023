package leejunhun;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class User {
	Scanner scn = new Scanner(System.in);			// scn.close(); �� ������ �� �ִ�. Ȯ���Ұ�
	private String id;
	private String pw;
	
	private String acctype;
	private String name;
	private String tel;
	private String email;
	private String primaryaddr;
	private int validate;
	private ArrayList<PurchasedProduct> bucket;
	
	

	public ArrayList<PurchasedProduct> getBucket() {
		return bucket;
	}
	public User() {}
	public User(String id, String pw, String acctype, String name, String tel, String email, String primaryaddr) {
		this.id = id;
		this.pw = pw;
		this.acctype = acctype;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.primaryaddr = primaryaddr;
		validate = 1;
		bucket = new ArrayList<>();
		
		// bucket.add(new PurchasedProduct(new Product(999,"test","��ǰ","�ż���ǰ","test",99999),99));
	}
	
	public boolean changePw()	{
		
		System.out.print(" ���� ��й�ȣ�� �Է����ּ��� : ");
		String usrInputPw = scn.next();
		if(this.pw.equals(usrInputPw))	{
			System.out.print(" �����ϰ��� �ϴ� ��й�ȣ�� �Է��ϼ��� : ");
			String usrCgPw = scn.next();
			System.out.print(" ������ ��й�ȣ�� �ѹ��� �Է����ּ��� : ");
			String usrCgVerify = scn.next();
			if(usrCgPw.equals(usrCgVerify)) {
				this.pw = usrCgPw;
				System.out.println("���� ��й�ȣ ���濡 �����Ͽ����ϴ�.\n\n");
				return true;
			}else {
				System.out.println("�Է��� �� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.\n");
				return false;
			}
		}else {
			return false;
		}
	}
	public void changeAddr() {
		System.out.print("�����ϰ��� �ϴ� �ּҸ� �Է����ּ���\n (���� ����, �����Է½� �Է�����, ������ ��ǥ�����ּ���.) : ");
		//TODO ��������. nextLine �޼��� ���󿩺� �ľ��� �Ұ�
		//scn.nextLine();
		String usrAddr = scn.next();
		this.primaryaddr = usrAddr;
		System.out.println("�ּ� ������ �Ϸ�Ǿ����ϴ�!");
	}

	public int Purchase(Product p, int amount)	{
		if(bucket.size() == 0)	{
			bucket.add(new PurchasedProduct(p, amount));
			return 1;
		}else {			// ��ǰ�� �ִ����
			for(int i=0; i<bucket.size(); i++) {
				if(bucket.get(i).name.equals(p.name)) {
					bucket.get(i).amount += amount;
					return 1;
				}
			}// for ������ ������������� ��ǰ�� ����Ʈ�� ���°��
			bucket.add(new PurchasedProduct(p,amount));
			return 1;
		}

	}
	public int Purchase(Product p, int amount, boolean paied)	{
		if(bucket.size() == 0)	{
			bucket.add(new PurchasedProduct(p, amount, paied));
			return 1;
		}else {			// ��ǰ�� �ִ����
			for(int i=0; i<bucket.size(); i++) {
				if(bucket.get(i).name.equals(p.name)) {
					bucket.get(i).amount += amount;
					return 1;
				}
			}// for ������ ������������� ��ǰ�� ����Ʈ�� ���°��
			bucket.add(new PurchasedProduct(p,amount, paied));
			return 1;
		}

	}

	public void showBucket() {
		
		
		HashMap<String, String> list = ProductManager.getProductTypes();
		Iterator<Map.Entry<String, String>> setofcategory = list.entrySet().iterator();
		// hashmap ��ü�� ���ͼ� ����Ʈȭ
		
		ArrayList<String> primaryset = new ArrayList<>();
		
		while(setofcategory.hasNext()) {
			Map.Entry<String, String> temp = setofcategory.next();
			primaryset.add(temp.getValue());
		}
		primaryset = new ArrayList<String>(new LinkedHashSet<String>(primaryset));

		// �ߺ������� 1��ǰ��

		// 2��ǰ�� ��������
		ArrayList<Map.Entry<String, String>> sectemp = new ArrayList<>(list.entrySet());

		
		ArrayList<String> secondarys = new ArrayList<>();
		
		

		for(int i=0; i<primaryset.size(); i++)	{
			for(int j=0; j<sectemp.size(); j++) {
				if(primaryset.get(i).equals(sectemp.get(j).getValue())){
					secondarys.add(sectemp.get(j).getKey());
				}
			}
		}
		
		System.out.println("=====================================================================");
		System.out.println("\t\t\t\t" + "��ٱ���");
		System.out.println("=====================================================================");
		
		
		if(bucket.size() == 0) {
			System.out.println("\t\t      **���� �����Ͻ� ��ǰ�� �����**");
			return;
		}
		
		
		for(int i=0; i<secondarys.size(); i++)	{
			for(int j=0; j<bucket.size(); j++)	{
				if(bucket.get(j).secondaryType.equals(secondarys.get(i))) {
					System.out.println();
					System.out.println(list.get(secondarys.get(i))+" : "+secondarys.get(i) + " >>");
					System.out.println("�ǸŻ�\t   1������   2������       ��ǰ��       ����    �������� :     �Ұ�");
					System.out.println("=====================================================================");
					// ���ٸ�
					System.out.println(prdReturn(bucket.get(j)) + "  :    " + bucket.get(j).price * bucket.get(j).amount);
				}
			}

		
		}
		// ��ٱ��� ��º�
		System.out.println("=====================================================================");
		System.out.print("[1] �ڷΰ���");
		int sel = scn.nextInt();
		if(sel == 1)	{
			return;
		}else if(sel==2) {
			ArrayList<PurchasedProduct> templist = new ArrayList<>();
			for(PurchasedProduct pp : bucket) {
				if(pp.paied == false) {
					templist.add(pp);
				}
			}
			int tot = 0;
			int money = 0;
			if(templist.size() == 0)	{
				System.out.println("�̰��� ������ �����ϴ�");
				return;
			}
			for(PurchasedProduct pp : templist) {
				System.out.println(pp.PrintPurchasedInfo() + " : " + (pp.amount * pp.price));
				tot += (pp.amount * pp.price);
			}
			System.out.println("�Ѿ� : " + tot);
			System.out.print("������ �����ҰԿ�. �ݾ��� �־��ּ��� : ");
			while(true) {
				
				int smoney = scn.nextInt();
				money += smoney;
				if(money - tot <0)	{
					System.out.println("�ݾ��� ������� �ʽ��ϴ�. �߰��ݾ��� �Է����ּ��� : ");
				}else {
					break;
				}
			}
			System.out.println("������ �Ϸ�Ǿ����ϴ�. �Ž����� : " + (money-tot));
			for(PurchasedProduct pp : templist) {
				pp.setPaied(true);
			}
			int[] arr = {tot, money};
			getRecipt(templist, arr);

		}
		
	}
	public int getValidate() {
		return validate;
	}
	public void setValidate(int validate) {
		this.validate = validate;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getId() {
		return id;
	}
	public String getPw() {
		return pw;
	}
	public String getAcctype() {
		return acctype;
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public String getEmail() {
		return email;
	}
	public String getPrimaryaddr() {
		return primaryaddr;
	}

	public void getRecipt(ArrayList<PurchasedProduct> templist, int[] arr) {
		String snum = "440-137-142522";
		String shopnum = "1551-142-10551";
		Date date = new Date();
		Random rdn = new Random();
		String confirmNum = "";
		DecimalFormat df = new DecimalFormat("#,##0");
		for(int i=0; i<8; i++)	{
			confirmNum += Integer.toString(rdn.nextInt(10));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd::hh:mm:ss");
		System.out.println("=====================================================================");
		System.out.println("\t\t\t" + "    �� �� ��");
		System.out.println("=====================================================================");
		System.out.println("      MEGA MART(������)                                         ");
		System.out.println("      " + arr[0] + "��                                               ");
		System.out.println("\n\n\n                                                       ���� : " + arr[1] +"��");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("�����Ͻ�                                            " + sdf.format(date));
		System.out.println("���ι�ȣ                                                   "+confirmNum);
		System.out.println("�ŷ�����                                                         ����");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("���ް���                                                     " + df.format((arr[0]*0.9)));
		System.out.println("�ΰ���                                                       " + df.format((arr[0]*0.1)));
		System.out.println("���񽺷�                                                          0��");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("��������                                             MEGAMART(������)");
		System.out.println("����ڹ�ȣ                                              " + snum);
		System.out.println("��������ȣ                                              " + shopnum);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("��ǰ��            �ܰ�            ���Ű���                         �Ұ�");
		System.out.println("----------------------------------------------------------------------");
		for(int i=0; i<templist.size(); i++) {
			System.out.println(templist.get(i).name + "          " + templist.get(i).price + "             " + templist.get(i).amount
					+"                         " + (templist.get(i).price * templist.get(i).amount));
		}
		// �Ʊ� �����ϸ鼭 ���� ��ٱ��Ϸ� ����������
		// �ӽ� ��ٱ��Ͽ����� ���� (== �̰�ó��)
		templist.clear();
		System.out.println("=====================================================================");
		System.out.println("\t\t\t" + "    �� �� �� ��");
		System.out.println("=====================================================================");
		System.out.println("\n\n\n");
	}
	public String prdReturn(PurchasedProduct p) {
		DecimalFormat df = new DecimalFormat("#,##0");
		String str = "";
		int stdSeller = 4;
		int stdPrimary = 12;
		int stdSec = 8;
		int prdName = 6;
		
		int seller = stdSeller-p.seller.length();
		int primary = stdPrimary - p.primaryType.length();
		int sec = stdSec - p.secondaryType.length();
		int name = prdName - p.name.length();
		

		// test�غ�����, 10�̾ƴ϶� 5�ϼ�������
		// �ǸŻ�
		if(p.seller.length() > 10) {
			str += p.seller.substring(0, 9);
			str += "  ";
		}else {
			str += p.seller;
			for(int j=0; j<seller; j++)	{
				str += " ";
			}
		}
		// 1��ī�װ�
		str += p.primaryType;
		for(int j=0; j<primary; j++)	{
			str += " ";
		}
		// 2��ī�װ�
		str += p.secondaryType;
		for(int j=0; j<sec; j++)	{
			str += " ";
		}
		if(p.name.length() >= 12) {
			str += p.name.substring(0,11);
			str += "  ";
		}else {
			str += p.name;
			for(int j=0; j<name; j++)	{
				str += " ";
			}
		}
		
		
		str += df.format(p.price);
		str += "   " + df.format(p.price * p.amount);
		str += "   " + p.isPaied();
		
		return str;
		
		
	}
}
