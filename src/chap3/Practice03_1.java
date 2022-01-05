package chap3;

public class Practice03_1{
	/*
	 * 단일 연결 리스트 삽입 메서드에서 중복을 허용하지 않는 삽입 메서드로 수정해 보세요.
	 */
}

class SinglyLinkedListPractice {
	private Node head;
	
	SinglyLinkedListPractice() {
		this.head = null;
	}
	
	class Node {
		private int value;
		private Node next;
		
		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		public int getValue() {
			return this.value;
		}
	}
	
	public void printAll() {
		Node pointer = this.head;
		
		StringBuilder builder = new StringBuilder();
		while (pointer.next != null) {
			builder.append(pointer.getValue());
			builder.append(" -> ");
			pointer = pointer.next;
		}
		
		builder.append(pointer.getValue());
		System.out.println(pointer.toString());
	}
	
	/*
	 * 단일 연결 리스트 삽입 메서드에서 중복을 허용하지 않는 삽입 메서드로 수정해 보세요.
	 */
	public void append(int value) {
		if (this.head == null) {
			this.head = new Node(value, null);
			return;
		}
		
		Node pointer = this.head;
		
		while (pointer.next != null) {
			if (pointer.getValue() == value) {
				// 예외처리 하기 싫어서 RuntimeException 사용
				throw new RuntimeException("Same Value");
			}
			pointer = pointer.next;
		}
		
		if (pointer.getValue() == value) {
			throw new RuntimeException("Same Value");
		}
		
		pointer.next = new Node(value, null);
	}
	
	public void delete(int value) {
		Node pointer = this.head;
		
		if (pointer.getValue() == value) {
			this.head = this.head.next;
			return;
		}
		
		Node temp = pointer;
		
		while (pointer != null && pointer.getValue() != value) {
			temp = pointer;
			pointer = pointer.next;
		}
		
		if (pointer.next == null) {
			temp.next = null;
		}
		else {
			temp.next = pointer.next;
		}
		
		pointer = null;
	}
}
