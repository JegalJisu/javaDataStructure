package chap3;

// 단일 연결 리스트 클래스
public class SinglyLinkedListExample {
	private Node head;
	
	SinglyLinkedListExample() {
		this.head = null;
	}
	
	class Node {
		private int value; // 값
		private Node next; // 포인터
		
		Node(int value, Node next) {
			this.value = value;
			this.next = next;
		}
		
		public int getValue() {
			return this.value;
		}
	}
	
	// 모든 노드 출력
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
	
	// 노드 추가
	public void append(int value) {
		if (this.head == null) {
			this.head = new Node(value, null);
			return;
		}
		
		Node pointer = this.head;
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		
		pointer.next = new Node(value, null);
	}
	
	// 노드 삭제
	public void delete(int value) {
		Node pointer = this.head;
		
		// 첫 노드의 값이 인자 값과 같으면
		if (pointer.getValue() == value) {
			this.head = this.head.next;
			return;
		}
		
		// 삭제될 노드의 앞 노드를 저장하기 위해 생성
		Node temp = pointer;
		// 포인터 변수가 null이 아니면서 인자 값과 달라질 때까지 반복
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
