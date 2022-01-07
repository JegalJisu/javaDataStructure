package chap5;

public class LinkedListStackExample {
	private Node head;
	private Node top;
	
	private class Node {
		private Object data;
		private Node next;
		
		Node(Object data) {
			this.data = data;
		}
	}
	
	private void push(Object data) {
		if (head == null) {
			head = new Node(data);
			top = head;
			return;
		}
		
		Node node = new Node(data);
		top.next = node;
		top = node;
	}
	
	public Object pop() {
		if (top == null) {
			throw new ArrayIndexOutOfBoundsException();
		}
		
		Node temp = head;
		Object data = this.peek();
		if (temp.next == null) {
			head = null;
			top = null;
			return data;
		}
		
		while (temp.next != null) {
			top = temp;
			temp = temp.next;
		}
		
		top.next = null;
		return data;
	}
	
	public Object peek() {
		return top.data;
	}
	
	public boolean empty() {
		return top == null;
	}
}
