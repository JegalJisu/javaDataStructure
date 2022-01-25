package bjpublic.chap13;

public class IntArrayListExample {
	private int[] array = new int[10];
	private int index = 0;
	
	public void add(int value) {
		this.array[index++] = value;
	}
	
	public int getValue(int index) {
		return this.array[index];
	}
	
	public int size() {
		return this.array.length;
	}
}
