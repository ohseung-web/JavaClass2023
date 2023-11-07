package bookshelf;

public class BookShelf extends Shelf implements Queue {

	@Override
	public void inQueue(String title) {
		shelf.add(title);
	}
	//shelf.add(title); //ArrayList에서 add는 맨 뒤에서 부터 추가 된다.

	public void inQueueshwoInfo() {
		for(int i=0;i<shelf.size();i++) { 
			System.out.println(i+"번째 :"+shelf.get(i));
		}

	}

	@Override
	public String deQueue() {
		return shelf.remove(0); // 제일 첫번째 자료를 삭제
	}



	public void deQueueshwoInfo() { 
		int sizeval = shelf.size(); 
		for(int i=0;i<sizeval;i++) { 
		System.out.println(i+"번째 :"+shelf.remove(0)); 
		} 
	}


	@Override
	public int getSize() {
		return getCount();
	}

}
