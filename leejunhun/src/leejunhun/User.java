package leejunhun;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class User {
	Scanner scn = new Scanner(System.in);			// scn.close(); 가 문제일 수 있다. 확인할것
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
		
		// bucket.add(new PurchasedProduct(new Product(999,"test","식품","신선식품","test",99999),99));
	}
	
	public boolean changePw()	{
		
		System.out.print(" 현재 비밀번호를 입력해주세요 : ");
		String usrInputPw = scn.next();
		if(this.pw.equals(usrInputPw))	{
			System.out.print(" 변경하고자 하는 비밀번호를 입력하세요 : ");
			String usrCgPw = scn.next();
			System.out.print(" 동일한 비밀번호를 한번더 입력해주세요 : ");
			String usrCgVerify = scn.next();
			if(usrCgPw.equals(usrCgVerify)) {
				this.pw = usrCgPw;
				System.out.println("계정 비밀번호 변경에 성공하였습니다.\n\n");
				return true;
			}else {
				System.out.println("입력한 두 비밀번호가 일치하지 않습니다.\n");
				return false;
			}
		}else {
			return false;
		}
	}
	public void changeAddr() {
		System.out.print("변경하고자 하는 주소를 입력해주세요\n (띄어쓰기 금지, 엔터입력시 입력종료, 구분은 쉼표로해주세요.) : ");
		//TODO 문제있음. nextLine 메서드 정상여부 파악이 불가
		//scn.nextLine();
		String usrAddr = scn.next();
		this.primaryaddr = usrAddr;
		System.out.println("주소 변경이 완료되었습니다!");
	}

	public int Purchase(Product p, int amount)	{
		if(bucket.size() == 0)	{
			bucket.add(new PurchasedProduct(p, amount));
			return 1;
		}else {			// 상품이 있던경우
			for(int i=0; i<bucket.size(); i++) {
				if(bucket.get(i).name.equals(p.name)) {
					bucket.get(i).amount += amount;
					return 1;
				}
			}// for 끝나고도 여기까지왔으면 상품이 리스트에 없는경우
			bucket.add(new PurchasedProduct(p,amount));
			return 1;
		}

	}
	public int Purchase(Product p, int amount, boolean paied)	{
		if(bucket.size() == 0)	{
			bucket.add(new PurchasedProduct(p, amount, paied));
			return 1;
		}else {			// 상품이 있던경우
			for(int i=0; i<bucket.size(); i++) {
				if(bucket.get(i).name.equals(p.name)) {
					bucket.get(i).amount += amount;
					return 1;
				}
			}// for 끝나고도 여기까지왔으면 상품이 리스트에 없는경우
			bucket.add(new PurchasedProduct(p,amount, paied));
			return 1;
		}

	}

	public void showBucket() {
		
		
		HashMap<String, String> list = ProductManager.getProductTypes();
		Iterator<Map.Entry<String, String>> setofcategory = list.entrySet().iterator();
		// hashmap 전체다 들고와서 리스트화
		
		ArrayList<String> primaryset = new ArrayList<>();
		
		while(setofcategory.hasNext()) {
			Map.Entry<String, String> temp = setofcategory.next();
			primaryset.add(temp.getValue());
		}
		primaryset = new ArrayList<String>(new LinkedHashSet<String>(primaryset));

		// 중복제거한 1차품목

		// 2차품목 가공시작
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
		System.out.println("\t\t\t\t" + "장바구니");
		System.out.println("=====================================================================");
		
		
		if(bucket.size() == 0) {
			System.out.println("\t\t      **아직 구매하신 상품이 없어요**");
			return;
		}
		
		
		for(int i=0; i<secondarys.size(); i++)	{
			for(int j=0; j<bucket.size(); j++)	{
				if(bucket.get(j).secondaryType.equals(secondarys.get(i))) {
					System.out.println();
					System.out.println(list.get(secondarys.get(i))+" : "+secondarys.get(i) + " >>");
					System.out.println("판매사\t   1차종류   2차종류       상품명       가격    결제여부 :     소계");
					System.out.println("=====================================================================");
					// 같다면
					System.out.println(prdReturn(bucket.get(j)) + "  :    " + bucket.get(j).price * bucket.get(j).amount);
				}
			}

		
		}
		// 장바구니 출력부
		System.out.println("=====================================================================");
		System.out.print("[1] 뒤로가기");
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
				System.out.println("미결제 내역이 없습니다");
				return;
			}
			for(PurchasedProduct pp : templist) {
				System.out.println(pp.PrintPurchasedInfo() + " : " + (pp.amount * pp.price));
				tot += (pp.amount * pp.price);
			}
			System.out.println("총액 : " + tot);
			System.out.print("결제를 시작할게요. 금액을 넣어주세요 : ");
			while(true) {
				
				int smoney = scn.nextInt();
				money += smoney;
				if(money - tot <0)	{
					System.out.println("금액이 충반하지 않습니다. 추가금액을 입력해주세요 : ");
				}else {
					break;
				}
			}
			System.out.println("결제가 완료되었습니다. 거스름돈 : " + (money-tot));
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
		System.out.println("\t\t\t" + "    영 수 증");
		System.out.println("=====================================================================");
		System.out.println("      MEGA MART(종로점)                                         ");
		System.out.println("      " + arr[0] + "원                                               ");
		System.out.println("\n\n\n                                                       현금 : " + arr[1] +"원");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("승인일시                                            " + sdf.format(date));
		System.out.println("승인번호                                                   "+confirmNum);
		System.out.println("거래유형                                                         현금");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("공급가액                                                     " + df.format((arr[0]*0.9)));
		System.out.println("부가세                                                       " + df.format((arr[0]*0.1)));
		System.out.println("서비스료                                                          0원");
		System.out.println("---------------------------------------------------------------------");
		System.out.println("가맹점명                                             MEGAMART(종로점)");
		System.out.println("사업자번호                                              " + snum);
		System.out.println("가맹점번호                                              " + shopnum);
		System.out.println("----------------------------------------------------------------------");
		System.out.println("상품명            단가            구매개수                         소계");
		System.out.println("----------------------------------------------------------------------");
		for(int i=0; i<templist.size(); i++) {
			System.out.println(templist.get(i).name + "          " + templist.get(i).price + "             " + templist.get(i).amount
					+"                         " + (templist.get(i).price * templist.get(i).amount));
		}
		// 아까 결제하면서 유저 장바구니로 복사했으니
		// 임시 장바구니에서는 삭제 (== 이관처리)
		templist.clear();
		System.out.println("=====================================================================");
		System.out.println("\t\t\t" + "    영 수 증 끝");
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
		

		// test해봐야함, 10이아니라 5일수도있음
		// 판매사
		if(p.seller.length() > 10) {
			str += p.seller.substring(0, 9);
			str += "  ";
		}else {
			str += p.seller;
			for(int j=0; j<seller; j++)	{
				str += " ";
			}
		}
		// 1차카테고리
		str += p.primaryType;
		for(int j=0; j<primary; j++)	{
			str += " ";
		}
		// 2차카테고리
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
