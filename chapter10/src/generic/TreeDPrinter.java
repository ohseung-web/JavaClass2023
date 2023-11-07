package generic;

import java.util.ArrayList;

public class TreeDPrinter<T extends Material> { // material���� ��ӹ��� type�� ����� �� �ֵ��� ������ ���ش�

	ArrayList<T> list = new ArrayList<>();
	private T material;

	public T getMaterial() {
		return material;
	}

	public void setMaterial(T material) {
		this.material = material;
		}

   @Override
   public String toString() {
	 //  return material.toString();
	   return list.toString();
   }
   
   public void printing() {
	   material.doprinting();
   }
   
   public void add(T printer) {
	   list.add(printer);
   }
}
