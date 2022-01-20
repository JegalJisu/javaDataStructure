package bjpublic.chap05;

public class ArrayQueueExample {
	private Object[] arr;
	private int MAX_QUEUE_SIZE;
	private int front;
	private int rear;
	private int peek;
	
	public ArrayQueueExample(int size) {
		this.arr = new Object[size];
		this.MAX_QUEUE_SIZE = size;
		this.front = 0;
		this.rear = -1;
		this.peek = this.front;
	}
	
	public void enqueue(Object value) {
		if (MAX_QUEUE_SIZE - 1 == rear) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		arr[++rear] = value;
	}
	
	public Object dequeue() {
		if (front >= MAX_QUEUE_SIZE) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Object value = arr[peek];
		arr[peek] = null;
		peek = ++front;
		
		return value;
	}
	
	public Object peek() {
		return arr[peek];
	}
	
	public boolean isFull() {
		return MAX_QUEUE_SIZE - 1 == rear;
	}
}
