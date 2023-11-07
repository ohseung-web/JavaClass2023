package leejunhun;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
//TODO ��������ǰ �ȵ��� ISSUE
public class ProductManager {
	Scanner scn = new Scanner(System.in);
	String[] shopMenu = {"��ǰ������ ����", "��ü��ǰ����", "�˻��ϱ�", "�ڷΰ���"};
	
	static HashMap<String, String> productTypeList = new HashMap<>();
	ArrayList<Product> productList = new ArrayList<>();
	
	// �ӽ� ��ٱ��Ϲ迭. ���� ���� ���Ŷ����� �����а�
	ArrayList<PurchasedProduct> templist = new ArrayList<>();
	
	int pn = 0;		// ��ǰ �Ϸù�ȣ �� ���� (������)
	

	public ProductManager()	{
		//TODO MOCK ��ǰ �Է��ؾ���.
		// Mockup List
		//==========================�ż���ǰ=================//
		productList.add(new Product(pn++,"�����̳��", "��ǰ", "�ż���ǰ", "���1kg", 9850));
		productList.add(new Product(pn++,"ǥ��1����", "��ǰ", "�ż���ǰ", "����1kg", 7900));
		productList.add(new Product(pn++,"���ܳ���", "��ǰ", "�ż���ǰ", "����10kg", 16110));
		productList.add(new Product(pn++,"û������", "��ǰ", "�ż���ǰ", "�ս�20kg", 47900));
		productList.add(new Product(pn++,"��������", "��ǰ", "�ż���ǰ", "Ű��3.5kg", 28800));
		productList.add(new Product(pn++,"�ķ�����", "��ǰ", "�ż���ǰ", "�ް���1kg", 8900));
		productList.add(new Product(pn++,"�Ƚɹ����", "��ǰ", "�ż���ǰ", "�����1.2kg", 5900));
		productTypeList.put("�ż���ǰ", "��ǰ");
		//======================������ǰ=====================//
		productList.add(new Product(pn++,"������", "��ǰ", "������ǰ", "�ʰ�1kg", 12780));
		productList.add(new Product(pn++,"�����帶��", "��ǰ", "������ǰ", "���׶��", 3770));
		productList.add(new Product(pn++,"�̼�Ǫ��", "��ǰ", "������ǰ", "ũ����", 17010));
		productList.add(new Product(pn++,"�ϸ��¶���", "��ǰ", "������ǰ", "�밡��ġŲ", 27810));
		productList.add(new Product(pn++,"�ϸ��¶���", "��ǰ", "������ǰ", "�߰�����",1570));
		productTypeList.put("������ǰ", "��ǰ");
		//===============�ǰ���ǰ==========//
		productList.add(new Product(pn++,"����ƾ����", "��ǰ", "�ǰ���ǰ", "ǻ������ƾ7", 36800));
		productList.add(new Product(pn++,"�����帲", "��ǰ", "�ǰ���ǰ", "���ళ����", 99000));
		productList.add(new Product(pn++,"��õ������", "��ǰ", "�ǰ���ǰ", "12����λ�", 120000));
		productTypeList.put("�ǰ���ǰ", "��ǰ");
		//============������===============//
		productList.add(new Product(pn++,"����������", "������", "�Ƿ��ǰ", "�����Ľ�EX", 6900));
		productList.add(new Product(pn++,"�Ƿ������", "������", "�Ƿ��ǰ", "�����ش�", 990));
		productTypeList.put("�Ƿ��ǰ", "������");
		productList.add(new Product(pn++,"VoiceCaddie", "������", "��������ȭ", "�Ÿ�������", 399000));
		productList.add(new Product(pn++,"����ŰKR", "������", "��������ȭ", "��ü����ũ", 12000));
		productList.add(new Product(pn++,"����������", "������", "��������ȭ", "����äǮ��", 977000));
		productTypeList.put("��������ȭ",  "������");
		//===============================================�м�====================/
		productList.add(new Product(pn++,"Ƽ����", "�Ƿ�", "�����Ƿ�", "Ʈ���̴׺�", 10900));
		productList.add(new Product(pn++,"Ƽ����", "�Ƿ�", "�����Ƿ�", "ƼŹƼ����", 5900));
		productList.add(new Product(pn++,"Ƽ����", "�Ƿ�", "�����Ƿ�", "�������Ƽ", 10000));
		productTypeList.put("�����Ƿ�", "�Ƿ�");
		productList.add(new Product(pn++,"Ƽ����", "�Ƿ�", "�����Ƿ�", "�������Ƽ", 10900));
		productList.add(new Product(pn++,"����������", "�Ƿ�", "�����Ƿ�", "��������", 7900));
		productList.add(new Product(pn++,"�������", "�Ƿ�", "�����Ƿ�", "20S����Ƽ", 39000));
		productTypeList.put("�����Ƿ�", "�Ƿ�");
		
		//===========================================================����==============//
		productList.add(new Product(pn++,"�����μ�", "����", "�۾�����", "�������", 2000));
		productList.add(new Product(pn++,"�Ϸ�Ʈ��", "����", "�۾�����", "�������帱", 99500));
		productList.add(new Product(pn++,"���̿�����", "����", "�۾�����", "�������尩", 15500));
		productTypeList.put("�۾�����", "����");
		productList.add(new Product(pn++,"�۷ι�����", "����", "������ǰ", "�����Ʈ", 2000));
		productList.add(new Product(pn++,"���Ϸμ�", "����", "������ǰ", "�и���ȭ��", 28900));
		productList.add(new Product(pn++,"�ĺ淯��", "����", "������ǰ", "����������", 33900));
		productTypeList.put("������ǰ", "����");
	}
	
	// ���� ���� ���� , �Ѱ��Լ�
	public void Shopping(User currentCustomer) {
		System.out.println("=====================================================================");
		System.out.println("\t\t\t" + "       SHOPPING");
		System.out.println("=====================================================================");
		OutterLoop:
			while(true) {
				
				
				for(int i=0; i<shopMenu.length; i++)	{
					System.out.println("\t\t\t[" + (i+1) + "] " + shopMenu[i]);
				}
				System.out.print("�޴� ���� : ");
				int OutterSelector = scn.nextInt();
				
				// ���� ����Ҳ���? �� �Լ��� ������ �ϴ°� ����
				// �׷� �� �Լ��� ������ templist ���� �������Ѵ�?
				switch(OutterSelector) {
					case 1:					// ��ǰ������ ����
						CategorizedPrint(currentCustomer);
						break;
					case 2:					// ��ü��ǰ����
						AllPrint(currentCustomer);
						break;
					case 3:					// �˻��ϱ�
						SearchProduct(currentCustomer, templist);
						break;
					case 4:					// �ڷΰ���
						if(templist.size()!=0)	{
							System.out.println("�̰��� ������ �־, ���� �ٷ� ������ ��û�帱�Կ�\n�����Ұ�� ��ٱ��ϰ� �ʱ�ȭ�˴ϴ�.");
							System.out.print("[1] ���ݰ��� [2] �������");
							int selector = scn.nextInt();
							if(selector == 1)	{
								int[] arr = Pay(currentCustomer);
								getRecipt(currentCustomer, arr);
							}else {
								System.out.println("��ٱ��ϰ� �ʱ�ȭ�˴ϴ�");
						templist.clear();
							}
						}
						break OutterLoop;
				
				}
				
			}
	}
	
	// ī�װ� ������ ���� �Լ�
	public void CategorizedPrint(User currentCustomer)	{
		categorizedPrint:
			while(true) {
				System.out.println("=====================================================================");
				System.out.println("\t\t\t" + "     1����ǰ����");
				System.out.println("=====================================================================");
				Iterator<String> productsIterator = productTypeList.values().iterator();
				// HashMap ��ȸ�ؼ� ���� ó���Ϸ��� ����
				
				// 1�� ī�װ� �ߺ����� �� ���� ����
				ArrayList<String> primaryCategory = new ArrayList<String>();
				
				//TODO �̰� �Űܶ� �˸��� ��ġ��
				ArrayList<Product> targetProductList = new ArrayList<>();
				
				while(productsIterator.hasNext()) {
					String temp = productsIterator.next(); 
					if(!primaryCategory.contains(temp)) {
						primaryCategory.add(temp);
					}
				}
				
				// �ߺ����� ����
				
				// ȭ�� �޴����
				for(int i=0; i<primaryCategory.size(); i++)	{
					System.out.println("\t\t\t[" + (i+1) +"] " + primaryCategory.get(i));
				}
				System.out.println("\t\t\t[0] ����");
				// �޴���� ����
				
				
				System.out.print("1�� ��ǰ������ �����ϼ��� : ");
				int selector = scn.nextInt();
				if(selector <0 || selector>primaryCategory.size()) {		// ����� �޴����� (1��ī�װ�)
					System.out.println("�Է��� ��ȿ���� �ʽ��ϴ�.");
					return;
				}else if(selector == 0){		// 0 == ����
					return;
				}else {							// 0 �ƴϸ� arrList�� �ε����� �����ϹǷ� -1ó��
					selector -= 1;
				}
				// ������ 1��ī�װ��� ī�װ� HashMap�� �����Ѵٸ�
				if(productTypeList.containsValue(primaryCategory.get(selector))) { 
					// 2����ǰ���� ȹ�� ����
					
					// ��ü Hashmap ȹ��, ���ͷ�����
					Iterator<Map.Entry<String, String>> allset = productTypeList.entrySet().iterator();
					
					int iter = 0;
					ArrayList<String> secondaryCategory = new ArrayList<>();
					
					// primary�� "��ǰ, �Ƿ��ǰ" �� ���ִٸ� "�ż���ǰ, ������ǰ,...,�Ƿ�Ҹ�ǰ,�Ƿ���... �� ������
					while(allset.hasNext()) {
						Map.Entry<String, String> temp = allset.next();
						if(temp.getValue().equals(primaryCategory.get(selector))) {
							secondaryCategory.add(temp.getKey());
						}
					}
					
					System.out.println("=====================================================================");
					System.out.println("\t\t\t" + "     2����ǰ����");
					System.out.println("=====================================================================");
					for(int i=0; i<secondaryCategory.size(); i++)	{
						System.out.println("\t\t\t[" + (i+1) + "] " + secondaryCategory.get(i));
					}
					
					
					System.out.print("2�� ��ǰ������ �����ϼ��� :  ");
					int secondaryselector = scn.nextInt()-1;
					
					System.out.println(secondaryCategory.get(secondaryselector) + "�� �˻��� ����Դϴ�.");
					System.out.println("=====================================================================");
					System.out.println("Num   �ǸŻ�\t  1��ī�װ�   2��ī�װ�  ��ǰ��       ����");
					System.out.println("=====================================================================");
					
					//���� 1, 2�� ī�װ� ���� �Ϸ�. ���ݺ��� ��ǰ���, ���� phase 
					
					//��ǰ ����Ʈ ���
					// prodReturner ���̴°�
					int idx = 1;		// ��ǰ ���ÿ� ���� idx
					for(Product p : productList)	{
						if(p.secondaryType.equals(secondaryCategory.get(secondaryselector)) && p.vailidity==1) {
							System.out.println(prdReturn(idx++,p));
							//System.out.print((idx++) + "     ");
							//System.out.println(p.printProductInfo());
							targetProductList.add(p);
						}
					}
					
					//���� ���� ������
					Shop:
						while(true)	{
							System.out.print("[1] ��ǰ�����ϱ� [2] �ڷΰ��� \n�޴����� : ");
							int sel = scn.nextInt();
							
							switch(sel)	{
								case 1:
									
									System.out.print("������ ��ǰ��ȣ�� �Է��ϼ��� : ");
									// ������ ��ǰ idx
									int pProduct = scn.nextInt()-1;
									Product p = null;
									// �Է°��� 2��ī�װ� Ÿ�� ǰ�񸮽�Ʈ�� ������� ����
									if(pProduct > targetProductList.size() || pProduct<0) {
										System.out.println("�Է��� ��ȿ���� �ʽ��ϴ�.");
										return;
									}
									// �Է°� ����, �ش� ��ǰ��ü search
									for(Product search : targetProductList)	{
										if(search.productNumber == targetProductList.get(pProduct).productNumber && search.vailidity==1) {
											// search �����ϰ��
											p = search;
										}
									}
												
									// while �������� �ʱ�ȭ�ϰ�, p�� null�� �ƴ϶�� ��ü search ����
									
									if(p != null) {
										System.out.print("� �����Ͻðھ��? : ");
										int amount = scn.nextInt();
										
										if(amount>0) {
											
											templist.add(new PurchasedProduct(p,amount));
											
										}else {
											// �Է��� ������ �������϶�
											System.out.println("�Է��� ��ȿ���� �ʽ��ϴ�.");
										}
										
									}else {
										// �Է��� ��ǰ��ȣ�� �������϶� ����
										System.out.println("�ش� ��ȣ�� ��ǰ�� �������� �ʽ��ϴ�.");
									}
									break;
								case 2:
									System.out.println("=====================================================================");
									System.out.println("\t\t\t" + "     Shopping ����");
									System.out.println("=====================================================================");
									// �� ī�װ�ȭ, ��ü����Ʈ, �˻�ȭ ���� ���Ÿ� �����ϰ� ������������� ���⼭ ����
									CheckPay(currentCustomer);
									break Shop;
							}
						}
				}else {
					System.out.println("������ �߸��Ǿ����ϴ�.");
					break categorizedPrint;
				}
			}
	}
	
	// TODO ��ǰ�� ���� �Լ� ������! �׸��� ���̽� �з���!
	/*
	System.out.println("=====================================================================");
	System.out.println("Num   �ǸŻ�\t  1��ī�װ�   2��ī�װ�  ��ǰ��       ����");
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
		
		return str;
		
		
	}
	
	
	// ��ü����� �����ϱ� �Լ�
	public void AllPrint(User currentCustomer) {
		// ��Ÿ���Ե�.. �ۼ� ������ ������� ...1�� 2�� ī�װ�...���� ���Ѽ� ��������..
		// ....���⵵ ī�װ� �����ڵ尡..�ʿ��ϴ�..
		
		Iterator<String> productsIterator = productTypeList.values().iterator();
		// HashMap ��ȸ�ؼ� ���� ó���Ϸ��� ����
		
		// 1�� ī�װ� �ߺ����� �� ���� ����
		ArrayList<String> primaryCategory = new ArrayList<String>();
		
		while(productsIterator.hasNext()) {
			String temp = productsIterator.next(); 
			if(!primaryCategory.contains(temp)) {
				primaryCategory.add(temp);
			}
		}

		// �ߺ����� ����
		// 2�� ��ǰ�ڵ� ȹ�����
		Iterator<Map.Entry<String, String>> allset ;
		
		ArrayList<String> secondaryCategory = new ArrayList<>();
		
		// 1�� ��ǰ�ڵ带 ���鼭, hashmap�� value�� ���� 1����ǰ�ڵ�� ���ٸ�, �ִ°�
		for(int i=0; i<primaryCategory.size(); i++) {
			// ���ϴµ��� allset�� �׻� ��ȸ�Ǿ�� ��
			allset = productTypeList.entrySet().iterator();
			while(allset.hasNext()) {
				Map.Entry<String, String> temp = allset.next();
				if(temp.getValue().equals(primaryCategory.get(i))){
					secondaryCategory.add(temp.getKey());
				}
			}
		}
		
		System.out.println("��ü ��ǰ�� ����մϴ�.\n");
		System.out.println("=========================================================");
		System.out.println("�ǸŻ�\t  1��ī�װ�   2��ī�װ�     ��ǰ��       ����");
		System.out.println("=========================================================");
		
		//ȭ����º�, 2��ī�װ� ������ ���缭 ����� �Ǿ�� �Ѵ�.
		for(int i=0; i<secondaryCategory.size(); i++) {
			for(int j=0; j<productList.size(); j++) {
				if(secondaryCategory.get(i).equals(productList.get(j).secondaryType) && productList.get(j).vailidity==1) {
					System.out.println("[" + (j+1) + "]" + productList.get(j).printProductInfo());
				}
			}
		}
		
		// ���� ���ź�
		shop:
			while(true)	{
				System.out.print("[1] �����ϱ� [2] �ڷΰ���\n�޴����� : ");
				int sel = scn.nextInt();
				switch(sel)	{	
					case 1:				// �����ϱ�
						// ��ƾ �ƿ�Ʋ�ȴ�!
						System.out.print("������ ��ǰ�� ��ȣ�� �Է��ϼ��� : ");
						int pPnum = scn.nextInt()-1;
						
						System.out.print("��� �����Ͻðھ��?");
						int amount = scn.nextInt();
						// 0~size() ���� �ߴٸ�, 
						
						if(pPnum >0 && pPnum <productList.size()) {
							// ����
							if(amount>0) {
								templist.add(new PurchasedProduct(productList.get(pPnum),amount));
							}else {
								// �����Ϸ��� ���� ����� �ƴϸ�
								System.out.println("�Է��� ��ȿ���� �ʽ��ϴ�.");
							}
							
						}else {
							System.out.println("�Է��Ͻ� ��ǰ��ȣ�� ��ȿ���� �ʽ��ϴ�.");
						}
						break;
					case 2:				// �ڷΰ���
						// ���� ���������� ����ó���ϱ�� ������ ���⼭�� ȣ���ؾ� �Ѵ�.
						CheckPay(currentCustomer);

						break shop;
				}
			}
	}
	
	// Ű����� �˻��ؼ� �����ϱ� �Լ�
	public void SearchProduct(User currentCustomer, ArrayList<PurchasedProduct> ptemp) {
		SearchInter:	
			while(true) {

				System.out.print("[1] ��ǰ������ �˻��ϱ� [2] �ǸŻ�� �˻��ϱ� [3] �ڷΰ���\n�޴����� :");
				int selector = scn.nextInt();

				switch(selector)	{
				// ��ǰ �̸����� �˻��ϱ�
				case 1:			
					System.out.print("�˻��Ͻ� ��ǰ���� �Է��ϼ��� (���� ����): ");
					// TODO Skip �ȵǴ� ISSUE
					//scn.skip("[\\r\\n]");

					String keywordPn = scn.next();



					ArrayList<Product> psearchedProduct = new ArrayList<>();

					// �˻��Ϸ�
					for(Product p : productList)	{
						if(p.name.matches(".*"+keywordPn+".*")) {
							psearchedProduct.add(p);
						}
					}
					// ��º�
					System.out.println("�˻������ ������ �����ϴ�");
					int pidx = 1;
					for(Product p : psearchedProduct)	{
						System.out.println("[" + (pidx++) + "] " + p.printProductInfo());
					}
					shop:
						while(true) {


							System.out.print("1. �����ϱ� 2.�ڷΰ���\n�޴����� : ");
							int menu = scn.nextInt();

							switch(menu)	{
							case 1:		//
								System.out.print("�����Ͻ� ��ǰ�� ��ǰ��ȣ�� �Է��ϼ��� : ");
								int pPnum = scn.nextInt();

								System.out.print("��� �����Ͻðھ��? : ");
								int amount = scn.nextInt();

								Product temp = psearchedProduct.get(pPnum-1);


								if(temp !=null && amount >0)	{
									templist.add(new PurchasedProduct(temp,amount));
									System.out.println("�ӽ� ��ٱ��Ͽ� �Է� ����!");
								}else {
									System.out.println("�Է��� ��ȿ���� �ʽ��ϴ�.");
								}
								break;
							case 2:		// �ڷΰ���
								CheckPay(currentCustomer);
				
								break shop;
							}
						}
					break;
					// �ǸŻ�� �˻��ϱ�
				case 2:			
					System.out.print("�˻��Ͻ� �ǸŻ縦 �Է��ϼ��� : ");
					scn.skip("[\\r\\n]");
					String keywordSn = scn.nextLine();

					ArrayList<Product> ssearchedProduct = new ArrayList<>();

					System.out.println("�˻������ ������ �����ϴ� : ");



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

							System.out.print("[1] �����ϱ� [2] �ڷΰ���\n�޴����� : ");
							int menu = scn.nextInt();

							switch(menu)	{
							case 1:		
								System.out.print("�����Ͻ� ��ǰ�� ��ǰ��ȣ�� �Է��ϼ��� : ");
								int  pPnum = scn.nextInt();

								System.out.print("��� �����Ͻðھ��? : ");
								int amount = scn.nextInt();

								Product temp = ssearchedProduct.get(pPnum-1);
								if(temp !=null && amount >0)	{
									templist.add(new PurchasedProduct(temp,amount));

								}else {
									System.out.println("�Է��� ��ȿ���� �ʽ��ϴ�.");
								}

								break;

							case 2:		// �ڷΰ���
								CheckPay(currentCustomer);

								break shop;
							}
						}
					break;
				case 3:
					System.out.println("�˻��� �����մϴ�.");
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

	public void CheckPay(User currentCustomer) {
		if(templist.size() == 0)	{
			// ���ſ��� ��ǰ�� �ϳ��� ���ٸ� ����
			System.out.println(" �ӽ� ��ٱ��Ͽ� ��ǰ�� �� �ϳ��� �������� �ʽ��ϴ�");
			return;
		}else {
			// ���� ���� ��ǰ�� �����Ѵٸ� ��ƾ ����
			System.out.print("\t\t���� �������� ���� ��ǰ�� �ֽ��ϴ�.\n\t\t���� �ٷ� �����Ͻðھ��? [1] �� [2] �ƴϿ� : ");
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
							System.out.println("���� ���� ǰ���� ���� ��ϰ� ��ġ�� ǰ���� �־, �ٷ� �����ϼž߸� �ؿ�");
							chk = true;
						}
					}
				}
				*/
				
			/*	if(chk == true) {
					int[] arr = Pay(currentCustomer);
					getRecipt(currentCustomer, templist, arr);
				}else {*/
				System.out.println("\t\t**��ٱ��Ͽ��� �־�ΰ�, ���߿� ������ ���͵帱�Կ�\t\t");
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
		System.out.println("\t\t\t" + "    ��������ǰ��");
		int tot = 0;
		System.out.println("=====================================================================");
		System.out.println("�ǸŻ�\t   1������   2������       ��ǰ��       ����    �������� :     �Ұ�");
		System.out.println("=====================================================================");
		for(PurchasedProduct pp : templist) {

			System.out.println(pp.PrintPurchasedInfo() + "   :    " + (pp.amount * pp.price));
			tot += pp.amount * pp.price;
		}
		System.out.println("�� �� : " + tot);
		System.out.print("���� �ݾ��� �Է����ּ��� : ");
		int money = 0;
		while(true) {
			int smoney = scn.nextInt();
			money += smoney;
			if(money - tot <0)	{
				System.out.println("�����ݾ���" + (money-tot) + " �� �����մϴ�. �� �־��ּ���");
			}else {
				break;
			}
		}
		System.out.println("�����մϴ�. �Ž����� : " + (money - tot));
		for(PurchasedProduct pp : templist) {
			// ���� ��ٱ��Ϸ� ����
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

		System.out.println("=====================================================================");
		System.out.println("\t\t\t" + "    �� �� �� ��");
		System.out.println("=====================================================================");
		System.out.println("\n\n\n");
		templist.clear();
	}
	
	
	public void newProduct(String seller, String type, String sectype, String name, int price) {
		productList.add(new Product(pn++, seller, type, sectype, name, price));
		System.out.println("�߰� ����!\n");
	}
	
	public void newStore(String seller, String primaryType, String secondaryType, String name, int price) {
		productList.add(new Product(pn++, seller, primaryType, secondaryType, name, price));
		System.out.println("�ű����� ���� �Ϸ�!");
	}
	
	public static HashMap<String, String> getProductTypes(){
		return productTypeList;
		
	}
	public ArrayList<PurchasedProduct> getTemplist() {
		return templist;
	}

}
