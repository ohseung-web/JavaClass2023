package bookshelf;

public class BookShelf extends Shelf implements Queue {

	@Override
	public void inQueue(String title) {
		shelf.add(title);
	}
	//shelf.add(title); //ArrayList���� add�� �� �ڿ��� ���� �߰� �ȴ�.

	public void inQueueshwoInfo() {
		for(int i=0;i<shelf.size();i++) { 
			System.out.println(i+"��° :"+shelf.get(i));
		}

	}

	@Override
	public String deQueue() {
		return shelf.remove(0); // ���� ù��° �ڷḦ ����
	}



	public void deQueueshwoInfo() { 
		int sizeval = shelf.size(); 
		for(int i=0;i<sizeval;i++) { 
		System.out.println(i+"��° :"+shelf.remove(0)); 
		} 
	}


	@Override
	public int getSize() {
		return getCount();
	}

}
