package bookshelf;

import java.util.ArrayList;

public class Shelf {
	
	protected ArrayList<String> shelf = new ArrayList<String>();
	//»ý¼ºÀÚ
	/*
	public Shelf() {
		shelf = new ArrayList<String>();
	}
	*/
	public ArrayList<String> getShelf() {
		return shelf;
	}
	public int getCount() {
		return  shelf.size();
	}
	
}
