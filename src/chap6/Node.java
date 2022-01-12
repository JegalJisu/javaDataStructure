package chap6;

public class Node {
	private int value;
	private Node left;
	private Node right;
	
	Node(int value) {
		this.value = value;
	}
	
	public Node(int value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}

	public void setLeftChild(Node node) {
		this.left = node;
	}
	
	public void setRightChild(Node node) {
		this.right = node;
	}
	
	public Node getLeftChild() {
		return this.left;
	}
	
	public Node getRightChild() {
		return this.right;
	}
}
