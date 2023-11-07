package fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
	
	ArrayList<T> list = new ArrayList<>();
	
	public ArrayList<T> getList() {
		return list;
	}

	public void setList(ArrayList<T> list) {
		this.list = list;

	}

	public void add(T item) {
		list.add(item);
	}
	
	public String toString() {
		return list.toString();
	}
}
