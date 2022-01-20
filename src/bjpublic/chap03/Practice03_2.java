package bjpublic.chap03;

public class Practice03_2{
	/*
	 * 원형 이중 연결 리스트 및 아래 세가지의 동작을 구현해 보세요.
	 *  * 삽입
	 *  * 삭제
	 *  * 검색
	 */
	
	public static void main(String[] args) {
		CircularDoubleLinkedListPractice pra = new CircularDoubleLinkedListPractice();
		pra.append(1);
		pra.delete(1);
		pra.printAll();
		
		pra.append(3);
		pra.append(2);
		pra.append(0);
		pra.append(5);
		pra.printAll();
		
		pra.delete(3);
		pra.printAll();
		
		pra.delete(5);
		pra.printAll();
		
		pra.append(7);
		pra.append(1);
		pra.append(4);
		pra.delete(1);
		pra.printAll();
		
		System.out.println("3이 존재하는가 ? " + pra.select(3));
		System.out.println("4가 존재하는가 ? " + pra.select(4));
	}
}

class CircularDoubleLinkedListPractice {
	private Node head;
	private Node tail;
	
	CircularDoubleLinkedListPractice() {
		this.head = null;
		this.tail = null;
	}
	
	class Node {
		private int value;
		private Node prev;
		private Node next;
		
		Node(int value) {
			this.value = value;
		}
		
		Node(int value, Node prev, Node next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
		
		public int getValue() {
			return this.value;
		}
	}
	
	public void printAll() {
		Node pointer = this.head;
		
		if (pointer == null) {
			System.out.println("리스트에 데이터가 존재하지 않습니다.");
			return;
		}
		
		StringBuilder builder = new StringBuilder();
		while (pointer != this.tail) {
			builder.append(pointer.getValue());
			builder.append(" <-> ");
			pointer = pointer.next;
		}
		
		builder.append(pointer.getValue());
		builder.append("(tail) <-> ");
		
		builder.append(this.head.getValue());
		builder.append("(head) ");
		System.out.println(builder.toString());
	}

	
	/*
	 * 삽입
	 */
	public void append(int value) {
		if (this.head == null) {
			// head가 null이면 head에 새로운 노드를 추가하고 그 노드의 앞과 뒤가 head로 동일하다.
			Node node = new Node(value);
			node.prev = node;
			node.next = node;
			
			this.head = node;
			this.tail = node;
			return;
		}
		
		Node pointer = this.head.next;
		
		while (pointer.next != this.head) {
			pointer = pointer.next;
		}
		
		// 새로운 노드가 추가되면 next는 자동으로 head가 된다.
		Node node = new Node(value, pointer, this.head);
		pointer.next = node;
		this.tail = node;
	}
	
	/*
	 * 삭제
	 */
	public void delete(int value) {
		Node pointer = this.head;
		
		if (pointer.getValue() == value) {
			// 리스트에 데이터가 하나밖에 존재하지 않을때의 처리
			if (this.head.next == this.head) {
				this.tail = null;
				this.head = null;
			}
			else {
				Node nextHead = this.head.next;
				nextHead.prev = this.tail;
				this.head = this.head.next;
				this.tail.next = nextHead;
			}
			return;
		}
		
		Node temp = pointer;
		
		while (pointer != this.tail && pointer.getValue() != value) {
			temp = pointer;
			pointer = pointer.next;
		}
		
		if (pointer.getValue() == value) {
			temp.next = pointer.next;
			pointer.next.prev = temp;
			
			// tail이 삭제되었을때에 처리
			// ps. 노드의 prev, next만 바뀐다고 class안에 head와 tail 데이터가 자동으로 바뀌지 않는다.
			if (pointer == this.tail) {
				this.head.prev = temp;
				this.tail = temp;
			}
		}
	}
	
	/*
	 * 검색
	 */
	public boolean select(int value) {
		Node pointer = this.head;
		
		// pointer가 tail일때 또는 pointer의 값이 파라미터로 입력받은 값과 동일할때까지 반복
		while (pointer != this.tail && pointer.getValue() != value) {
			pointer = pointer.next;
		}
		
		return (pointer.getValue() == value);
	}
}
