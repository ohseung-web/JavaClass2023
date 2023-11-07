package leejunhun;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
//TODO 스포츠용품 안들어가는 ISSUE
public class ProductManager {
	Scanner scn = new Scanner(System.in);
	String[] shopMenu = {"상품종류별 보기", "전체상품보기", "검색하기", "뒤로가기"};
	
	static HashMap<String, String> productTypeList = new HashMap<>();
	ArrayList<Product> productList = new ArrayList<>();
	
	// 임시 장바구니배열. 종료 직전 구매때문에 만들어둔거
	ArrayList<PurchasedProduct> templist = new ArrayList<>();
	
	int pn = 0;		// 상품 일련번호 용 변수 (생성자)
	

	public ProductManager()	{
		//TODO MOCK 상품 입력해야함.
		// Mockup List
		//==========================신선식품=================//
		productList.add(new Product(pn++,"별빛촌농산", "식품", "신선식품", "사과1kg", 9850));
		productList.add(new Product(pn++,"표고1번지", "식품", "신선식품", "버섯1kg", 7900));
		productList.add(new Product(pn++,"참외농장", "식품", "신선식품", "참외10kg", 16110));
		productList.add(new Product(pn++,"청원농협", "식품", "신선식품", "왕쌀20kg", 47900));
		productList.add(new Product(pn++,"제스프리", "식품", "신선식품", "키워3.5kg", 28800));
		productList.add(new Product(pn++,"후레쉬빌", "식품", "신선식품", "햇감자1kg", 8900));
		productList.add(new Product(pn++,"안심밥상제", "식품", "신선식품", "흑돼지1.2kg", 5900));
		productTypeList.put("신선식품", "식품");
		//======================가공식품=====================//
		productList.add(new Product(pn++,"고기굽자", "식품", "가공식품", "너겟1kg", 12780));
		productList.add(new Product(pn++,"프렌드마켓", "식품", "가공식품", "누네띠네", 3770));
		productList.add(new Product(pn++,"미소푸드", "식품", "가공식품", "크림빵", 17010));
		productList.add(new Product(pn++,"하림온라인", "식품", "가공식품", "용가리치킨", 27810));
		productList.add(new Product(pn++,"하림온라인", "식품", "가공식품", "닭가슴살",1570));
		productTypeList.put("가공식품", "식품");
		//===============건강식품==========//
		productList.add(new Product(pn++,"프로틴스토", "식품", "건강식품", "퓨어프로틴7", 36800));
		productList.add(new Product(pn++,"상상더드림", "식품", "건강식품", "혈행개선제", 99000));
		productList.add(new Product(pn++,"노천영농합", "식품", "건강식품", "12년근인삼", 120000));
		productTypeList.put("건강식품", "식품");
		//============스포츠===============//
		productList.add(new Product(pn++,"라이프마켓", "스포츠", "의료용품", "에어파스EX", 6900));
		productList.add(new Product(pn++,"의료기장터", "스포츠", "의료용품", "점착붕대", 990));
		productTypeList.put("의료용품", "스포츠");
		productList.add(new Product(pn++,"VoiceCaddie", "스포츠", "스포츠잡화", "거리측정기", 399000));
		productList.add(new Product(pn++,"나이키KR", "스포츠", "스포츠잡화", "입체마스크", 12000));
		productList.add(new Product(pn++,"지브이투어", "스포츠", "스포츠잡화", "골프채풀셋", 977000));
		productTypeList.put("스포츠잡화",  "스포츠");
		//===============================================패션====================/
		productList.add(new Product(pn++,"티메이", "의류", "여성의류", "트레이닝복", 10900));
		productList.add(new Product(pn++,"티메이", "의류", "여성의류", "티탁티셔츠", 5900));
		productList.add(new Product(pn++,"티메이", "의류", "여성의류", "빅사이즈티", 10000));
		productTypeList.put("여성의류", "의류");
		productList.add(new Product(pn++,"티메이", "의류", "남성의류", "빅사이즈티", 10900));
		productList.add(new Product(pn++,"젊은디자인", "의류", "남성의류", "조거팬츠", 7900));
		productList.add(new Product(pn++,"디스퀘어드", "의류", "남성의류", "20S반팔티", 39000));
		productTypeList.put("남성의류", "의류");
		
		//===========================================================공구==============//
		productList.add(new Product(pn++,"엑셀부속", "공구", "작업공구", "배관자재", 2000));
		productList.add(new Product(pn++,"일렉트릭", "공구", "작업공구", "빅전동드릴", 99500));
		productList.add(new Product(pn++,"케이에스몰", "공구", "작업공구", "반코팅장갑", 15500));
		productTypeList.put("작업공구", "공구");
		productList.add(new Product(pn++,"글로벌조경", "공구", "안전용품", "보행매트", 2000));
		productList.add(new Product(pn++,"헤일로샵", "공구", "안전용품", "분말소화기", 28900));
		productList.add(new Product(pn++,"파뷸러스", "공구", "안전용품", "차량진입판", 33900));
		productTypeList.put("안전용품", "공구");
	}
	
	// 실제 쇼핑 시작 , 총괄함수
	public void Shopping(User currentCustomer) {
		System.out.println("=====================================================================");
		System.out.println("\t\t\t" + "       SHOPPING");
		System.out.println("=====================================================================");
		OutterLoop:
			while(true) {
				
				
				for(int i=0; i<shopMenu.length; i++)	{
					System.out.println("\t\t\t[" + (i+1) + "] " + shopMenu[i]);
				}
				System.out.print("메뉴 선택 : ");
				int OutterSelector = scn.nextInt();
				
				// 결제 어디서할꺼야? 각 함수가 끝날때 하는게 낫지
				// 그럼 각 함수가 끝날때 templist 비우고 끝내야한다?
				switch(OutterSelector) {
					case 1:					// 상품종류별 보기
						CategorizedPrint(currentCustomer);
						break;
					case 2:					// 전체상품보기
						AllPrint(currentCustomer);
						break;
					case 3:					// 검색하기
						SearchProduct(currentCustomer, templist);
						break;
					case 4:					// 뒤로가기
						if(templist.size()!=0)	{
							System.out.println("미결제 내역이 있어서, 지금 바로 결제를 요청드릴게요\n거절할경우 장바구니가 초기화됩니다.");
							System.out.print("[1] 지금결제 [2] 결제취소");
							int selector = scn.nextInt();
							if(selector == 1)	{
								int[] arr = Pay(currentCustomer);
								getRecipt(currentCustomer, arr);
							}else {
								System.out.println("장바구니가 초기화됩니다");
						templist.clear();
							}
						}
						break OutterLoop;
				
				}
				
			}
	}
	
	// 카테고리 종류별 보기 함수
	public void CategorizedPrint(User currentCustomer)	{
		categorizedPrint:
			while(true) {
				System.out.println("=====================================================================");
				System.out.println("\t\t\t" + "     1차상품종류");
				System.out.println("=====================================================================");
				Iterator<String> productsIterator = productTypeList.values().iterator();
				// HashMap 순회해서 정보 처리하려고 선언
				
				// 1차 카테고리 중복제거 및 나열 시작
				ArrayList<String> primaryCategory = new ArrayList<String>();
				
				//TODO 이거 옮겨라 알맞은 위치로
				ArrayList<Product> targetProductList = new ArrayList<>();
				
				while(productsIterator.hasNext()) {
					String temp = productsIterator.next(); 
					if(!primaryCategory.contains(temp)) {
						primaryCategory.add(temp);
					}
				}
				
				// 중복제거 종료
				
				// 화면 메뉴출력
				for(int i=0; i<primaryCategory.size(); i++)	{
					System.out.println("\t\t\t[" + (i+1) +"] " + primaryCategory.get(i));
				}
				System.out.println("\t\t\t[0] 종료");
				// 메뉴출력 종료
				
				
				System.out.print("1차 상품종류를 선택하세요 : ");
				int selector = scn.nextInt();
				if(selector <0 || selector>primaryCategory.size()) {		// 사용자 메뉴선택 (1차카테고리)
					System.out.println("입력이 유효하지 않습니다.");
					return;
				}else if(selector == 0){		// 0 == 종료
					return;
				}else {							// 0 아니면 arrList에 인덱스로 접근하므로 -1처리
					selector -= 1;
				}
				// 선택한 1차카테고리가 카테고리 HashMap에 존재한다면
				if(productTypeList.containsValue(primaryCategory.get(selector))) { 
					// 2차상품종류 획득 시작
					
					// 전체 Hashmap 획득, 이터레이팅
					Iterator<Map.Entry<String, String>> allset = productTypeList.entrySet().iterator();
					
					int iter = 0;
					ArrayList<String> secondaryCategory = new ArrayList<>();
					
					// primary에 "식품, 의료용품" 가 들어가있다면 "신선식품, 가공식품,...,의료소모품,의료기기... 로 들어가게함
					while(allset.hasNext()) {
						Map.Entry<String, String> temp = allset.next();
						if(temp.getValue().equals(primaryCategory.get(selector))) {
							secondaryCategory.add(temp.getKey());
						}
					}
					
					System.out.println("=====================================================================");
					System.out.println("\t\t\t" + "     2차상품종류");
					System.out.println("=====================================================================");
					for(int i=0; i<secondaryCategory.size(); i++)	{
						System.out.println("\t\t\t[" + (i+1) + "] " + secondaryCategory.get(i));
					}
					
					
					System.out.print("2차 상품종류를 선택하세요 :  ");
					int secondaryselector = scn.nextInt()-1;
					
					System.out.println(secondaryCategory.get(secondaryselector) + "로 검색한 결과입니다.");
					System.out.println("=====================================================================");
					System.out.println("Num   판매사\t  1차카테고리   2차카테고리  상품명       가격");
					System.out.println("=====================================================================");
					
					//실제 1, 2차 카테고리 선택 완료. 지금부턴 상품출력, 구매 phase 
					
					//상품 리스트 출력
					// prodReturner 엮이는곳
					int idx = 1;		// 상품 선택에 쓰일 idx
					for(Product p : productList)	{
						if(p.secondaryType.equals(secondaryCategory.get(secondaryselector)) && p.vailidity==1) {
							System.out.println(prdReturn(idx++,p));
							//System.out.print((idx++) + "     ");
							//System.out.println(p.printProductInfo());
							targetProductList.add(p);
						}
					}
					
					//실제 구매 페이즈
					Shop:
						while(true)	{
							System.out.print("[1] 상품구매하기 [2] 뒤로가기 \n메뉴선택 : ");
							int sel = scn.nextInt();
							
							switch(sel)	{
								case 1:
									
									System.out.print("구매할 상품번호를 입력하세요 : ");
									// 구매할 상품 idx
									int pProduct = scn.nextInt()-1;
									Product p = null;
									// 입력값이 2차카테고리 타겟 품목리스트에 없을경우 거절
									if(pProduct > targetProductList.size() || pProduct<0) {
										System.out.println("입력이 유효하지 않습니다.");
										return;
									}
									// 입력값 정상, 해당 상품객체 search
									for(Product search : targetProductList)	{
										if(search.productNumber == targetProductList.get(pProduct).productNumber && search.vailidity==1) {
											// search 성공일경우
											p = search;
										}
									}
												
									// while 돌때마다 초기화하고, p가 null이 아니라면 객체 search 성공
									
									if(p != null) {
										System.out.print("몇개 구매하시겠어요? : ");
										int amount = scn.nextInt();
										
										if(amount>0) {
											
											templist.add(new PurchasedProduct(p,amount));
											
										}else {
											// 입력한 개수가 비정상일때
											System.out.println("입력이 유효하지 않습니다.");
										}
										
									}else {
										// 입력한 상품번호가 비정상일때 거절
										System.out.println("해당 번호의 상품이 존재하지 않습니다.");
									}
									break;
								case 2:
									System.out.println("=====================================================================");
									System.out.println("\t\t\t" + "     Shopping 종료");
									System.out.println("=====================================================================");
									// 각 카테고리화, 전체리스트, 검색화 에서 구매를 진행하고 끝내기로했으니 여기서 구매
									CheckPay(currentCustomer);
									break Shop;
							}
						}
				}else {
					System.out.println("선택이 잘못되었습니다.");
					break categorizedPrint;
				}
			}
	}
	
	// TODO 상품명 리턴 함수 여깄다! 그리고 베이스 분류도!
	/*
	System.out.println("=====================================================================");
	System.out.println("Num   판매사\t  1차카테고리   2차카테고리  상품명       가격");
	System.out.println("=====================================================================");
	 
	 */
	public String prdReturn(int i, Product p) {
		DecimalFormat df = new DecimalFormat("#,##0");
		String str = "";
		int stdNum = 6;
		int stdSeller = 8;
		int stdPrimary = 12;
		int stdSec = 8;
		int prdName = 10;
		
		int num = stdNum - Integer.toString(i).length();
		int seller = stdSeller-p.seller.length();
		int primary = stdPrimary - p.primaryType.length();
		int sec = stdSec - p.secondaryType.length();
		int name = prdName - p.name.length();
		
		str += i;
		for(int j=0; j<num; j++) {
			str += " ";
		}
		
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
		
		return str;
		
		
	}
	
	
	// 전체보기로 구매하기 함수
	public void AllPrint(User currentCustomer) {
		// 안타깝게도.. 작성 순서와 관계없이 ...1차 2차 카테고리...순서 지켜서 나오려면..
		// ....여기도 카테고리 추출코드가..필요하다..
		
		Iterator<String> productsIterator = productTypeList.values().iterator();
		// HashMap 순회해서 정보 처리하려고 선언
		
		// 1차 카테고리 중복제거 및 나열 시작
		ArrayList<String> primaryCategory = new ArrayList<String>();
		
		while(productsIterator.hasNext()) {
			String temp = productsIterator.next(); 
			if(!primaryCategory.contains(temp)) {
				primaryCategory.add(temp);
			}
		}

		// 중복제거 종료
		// 2차 상품코드 획득시작
		Iterator<Map.Entry<String, String>> allset ;
		
		ArrayList<String> secondaryCategory = new ArrayList<>();
		
		// 1차 상품코드를 돌면서, hashmap에 value가 지금 1차상품코드와 같다면, 넣는거
		for(int i=0; i<primaryCategory.size(); i++) {
			// 비교하는동안 allset은 항상 순회되어야 함
			allset = productTypeList.entrySet().iterator();
			while(allset.hasNext()) {
				Map.Entry<String, String> temp = allset.next();
				if(temp.getValue().equals(primaryCategory.get(i))){
					secondaryCategory.add(temp.getKey());
				}
			}
		}
		
		System.out.println("전체 상품을 출력합니다.\n");
		System.out.println("=========================================================");
		System.out.println("판매사\t  1차카테고리   2차카테고리     상품명       가격");
		System.out.println("=========================================================");
		
		//화면출력부, 2차카테고리 순서에 맞춰서 출력이 되어야 한다.
		for(int i=0; i<secondaryCategory.size(); i++) {
			for(int j=0; j<productList.size(); j++) {
				if(secondaryCategory.get(i).equals(productList.get(j).secondaryType) && productList.get(j).vailidity==1) {
					System.out.println("[" + (j+1) + "]" + productList.get(j).printProductInfo());
				}
			}
		}
		
		// 실제 구매부
		shop:
			while(true)	{
				System.out.print("[1] 구매하기 [2] 뒤로가기\n메뉴선택 : ");
				int sel = scn.nextInt();
				switch(sel)	{	
					case 1:				// 구매하기
						// 루틴 아예틀렸다!
						System.out.print("구매할 상품의 번호를 입력하세요 : ");
						int pPnum = scn.nextInt()-1;
						
						System.out.print("몇개나 구매하시겠어요?");
						int amount = scn.nextInt();
						// 0~size() 까지 했다면, 
						
						if(pPnum >0 && pPnum <productList.size()) {
							// 정상
							if(amount>0) {
								templist.add(new PurchasedProduct(productList.get(pPnum),amount));
							}else {
								// 구매하려는 량이 양수가 아니면
								System.out.println("입력이 유효하지 않습니다.");
							}
							
						}else {
							System.out.println("입력하신 상품번호가 유효하지 않습니다.");
						}
						break;
					case 2:				// 뒤로가기
						// 각각 끝날때마다 구매처리하기로 했으니 여기서도 호출해야 한다.
						CheckPay(currentCustomer);

						break shop;
				}
			}
	}
	
	// 키워드로 검색해서 구매하기 함수
	public void SearchProduct(User currentCustomer, ArrayList<PurchasedProduct> ptemp) {
		SearchInter:	
			while(true) {

				System.out.print("[1] 상품명으로 검색하기 [2] 판매사로 검색하기 [3] 뒤로가기\n메뉴선택 :");
				int selector = scn.nextInt();

				switch(selector)	{
				// 상품 이름으로 검색하기
				case 1:			
					System.out.print("검색하실 상품명을 입력하세요 (띄어쓰기 금지): ");
					// TODO Skip 안되는 ISSUE
					//scn.skip("[\\r\\n]");

					String keywordPn = scn.next();



					ArrayList<Product> psearchedProduct = new ArrayList<>();

					// 검색완료
					for(Product p : productList)	{
						if(p.name.matches(".*"+keywordPn+".*")) {
							psearchedProduct.add(p);
						}
					}
					// 출력부
					System.out.println("검색결과는 다음과 같습니다");
					int pidx = 1;
					for(Product p : psearchedProduct)	{
						System.out.println("[" + (pidx++) + "] " + p.printProductInfo());
					}
					shop:
						while(true) {


							System.out.print("1. 구매하기 2.뒤로가기\n메뉴선택 : ");
							int menu = scn.nextInt();

							switch(menu)	{
							case 1:		//
								System.out.print("구매하실 상품의 상품번호를 입력하세요 : ");
								int pPnum = scn.nextInt();

								System.out.print("몇개나 구매하시겠어요? : ");
								int amount = scn.nextInt();

								Product temp = psearchedProduct.get(pPnum-1);


								if(temp !=null && amount >0)	{
									templist.add(new PurchasedProduct(temp,amount));
									System.out.println("임시 장바구니에 입력 성공!");
								}else {
									System.out.println("입력이 유효하지 않습니다.");
								}
								break;
							case 2:		// 뒤로가기
								CheckPay(currentCustomer);
				
								break shop;
							}
						}
					break;
					// 판매사로 검색하기
				case 2:			
					System.out.print("검색하실 판매사를 입력하세요 : ");
					scn.skip("[\\r\\n]");
					String keywordSn = scn.nextLine();

					ArrayList<Product> ssearchedProduct = new ArrayList<>();

					System.out.println("검색결과는 다음과 같습니다 : ");



					for(Product p : productList)	{
						if(p.seller.matches(".*"+keywordSn+".*")) {
							ssearchedProduct.add(p);
						}
					}

					int sidx = 1;
					for(Product p : ssearchedProduct)	{
						System.out.println("[" + (sidx++) + "]" + p.printProductInfo());
					}


					shop:
						while(true) {

							System.out.print("[1] 구매하기 [2] 뒤로가기\n메뉴선택 : ");
							int menu = scn.nextInt();

							switch(menu)	{
							case 1:		
								System.out.print("구매하실 상품의 상품번호를 입력하세요 : ");
								int  pPnum = scn.nextInt();

								System.out.print("몇개나 구매하시겠어요? : ");
								int amount = scn.nextInt();

								Product temp = ssearchedProduct.get(pPnum-1);
								if(temp !=null && amount >0)	{
									templist.add(new PurchasedProduct(temp,amount));

								}else {
									System.out.println("입력이 유효하지 않습니다.");
								}

								break;

							case 2:		// 뒤로가기
								CheckPay(currentCustomer);

								break shop;
							}
						}
					break;
				case 3:
					System.out.println("검색을 종료합니다.");
					break SearchInter;	
				}
			}
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

	public void CheckPay(User currentCustomer) {
		if(templist.size() == 0)	{
			// 구매예정 상품이 하나도 없다면 거절
			System.out.println(" 임시 장바구니에 상품이 단 하나도 존재하지 않습니다");
			return;
		}else {
			// 구매 예정 상품이 존재한다면 루틴 시작
			System.out.print("\t\t아직 결제하지 않은 상품이 있습니다.\n\t\t지금 바로 결제하시겠어요? [1] 예 [2] 아니오 : ");
			int selector = scn.nextInt();
			if(selector == 1)	{
				int[] arr = Pay(currentCustomer);
				getRecipt(currentCustomer, arr);
			}else {
				
				/*
				boolean chk = false;
				ArrayList<PurchasedProduct> tempbucket = currentCustomer.getBucket();
				
				for(int i=0; i<templist.size(); i++) {
					System.out.println("templist : " + templist.get(i).name);
				}
				for(int j=0; j<tempbucket.size(); j++) {
					System.out.println("tempbucket: " + tempbucket.get(j).name);
				}
	
				for(int i=0; i<templist.size(); i++)	{
					for(int j=0; j<tempbucket.size(); j++)	{
						if(templist.get(i).name.equals(tempbucket.get(j).name)) {
							System.out.println("구매 결정 품목중 이전 기록과 겹치는 품목이 있어서, 바로 결제하셔야만 해요");
							chk = true;
						}
					}
				}
				*/
				
			/*	if(chk == true) {
					int[] arr = Pay(currentCustomer);
					getRecipt(currentCustomer, templist, arr);
				}else {*/
				System.out.println("\t\t**장바구니에만 넣어두고, 나중에 결제를 도와드릴게요\t\t");
					for(PurchasedProduct pp : templist) {
						currentCustomer.Purchase(new Product(pp.productNumber, pp.seller, pp.primaryType
								,pp.secondaryType, pp.name, pp.price), pp.amount);
					}
					ArrayList<PurchasedProduct> tpp = currentCustomer.getBucket();
					for(int i=0; i<tpp.size(); i++) {
						System.out.println(tpp.get(i).name);
					}
					
				//}
			}
		}
	}
	public int[] Pay(User currentCustomer) {
		System.out.println("=====================================================================");
		System.out.println("\t\t\t" + "    결제예정품목");
		int tot = 0;
		System.out.println("=====================================================================");
		System.out.println("판매사\t   1차종류   2차종류       상품명       가격    결제여부 :     소계");
		System.out.println("=====================================================================");
		for(PurchasedProduct pp : templist) {

			System.out.println(pp.PrintPurchasedInfo() + "   :    " + (pp.amount * pp.price));
			tot += pp.amount * pp.price;
		}
		System.out.println("총 계 : " + tot);
		System.out.print("결제 금액을 입력해주세요 : ");
		int money = 0;
		while(true) {
			int smoney = scn.nextInt();
			money += smoney;
			if(money - tot <0)	{
				System.out.println("결제금액이" + (money-tot) + " 원 부족합니다. 더 넣어주세요");
			}else {
				break;
			}
		}
		System.out.println("감사합니다. 거스름돈 : " + (money - tot));
		for(PurchasedProduct pp : templist) {
			// 유저 장바구니로 복사
			currentCustomer.Purchase(new Product(pp.productNumber, pp.seller, pp.primaryType ,pp.secondaryType, pp.name, pp.price), pp.amount, true);

		}
		int[] arr = {tot, money};

		return arr;
	}
	
	public void getRecipt(User currentCustomer, int[] arr) {
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

		System.out.println("=====================================================================");
		System.out.println("\t\t\t" + "    영 수 증 끝");
		System.out.println("=====================================================================");
		System.out.println("\n\n\n");
		templist.clear();
	}
	
	
	public void newProduct(String seller, String type, String sectype, String name, int price) {
		productList.add(new Product(pn++, seller, type, sectype, name, price));
		System.out.println("추가 성공!\n");
	}
	
	public void newStore(String seller, String primaryType, String secondaryType, String name, int price) {
		productList.add(new Product(pn++, seller, primaryType, secondaryType, name, price));
		System.out.println("신규점포 입점 완료!");
	}
	
	public static HashMap<String, String> getProductTypes(){
		return productTypeList;
		
	}
	public ArrayList<PurchasedProduct> getTemplist() {
		return templist;
	}

}
