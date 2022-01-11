package chap5;

public class LinkedListDequeExample {
	private class Node {
		Object data = null;
		Node next = null;
		
		Node (Object data) {
			this.data = data;
		}
		
		private Object getValue() {
			return data;
		}
	}
	
	private Node front = null;
	private Node rear = null;
	
	public void addFirst(Object data) {
		Node node = new Node(data);
		if (front == null) {
			front = node;
			rear = front;
			return;
		}
		
		Node temp = front;
		front = node;
		front.next = temp;
	}
	
	public void addLast(Object data) {
		Node node = new Node(data);
		
		if (front == null) {
			front = node;
			rear = front;
			return;
		}
		
		rear.next = node;
		rear = rear.next;
	}
	
	public Object removeFirst() {
		Object value = front.getValue();
		front = front.next;
		
		return value;
	}
	
	public Object removeLast() {
		Object value = rear.getValue();
		
		Node temp = front;
		// 이 반복문이 어떻게 끝날 수 있는지 처음엔 이해를 못했는데
		// temp.next가 rear일때 밑에 두줄을 실행하고
		// 한바퀴를 더 돌아 temp = temp.next를 실행
		// 이때 바뀐 temp는  null이니까 while문 조건이 만족되지 않아 반복문이 멈춘다.
		// 개인적으로 가독성을 위해서 break를 추가했으면...
		while (temp != null) {
			if (temp.next != rear) {
				temp = temp.next;
				continue;
			}
			
			rear = temp;
			rear.next = null;
		}
		
		return value;
	}
	
	public String print() {
		StringBuffer sb = new StringBuffer();
		Node temp = front;
		
		while (temp != null) {
			Object value = temp.getValue();
			temp = temp.next;
			
			if (temp == null) {
				sb.append(value);
			}
			else {
				sb.append(String.format("%s->", value));
			}
		}
		
		return sb.toString();
	}
}
