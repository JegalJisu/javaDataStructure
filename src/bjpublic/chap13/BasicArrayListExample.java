package bjpublic.chap13;

public class BasicArrayListExample {
	private Object[] array = new Object[10];
	private int index = 0;
	
	public void add(Object value) {
		this.array[index++] = value;
	}
	
	public Object getValue(int index) {
		return this.array[index];
	}
	
	public int size() {
		return this.array.length;
	}
}
