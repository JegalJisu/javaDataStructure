package bjpublic.chap06;

import bjpublic.chap05.LinkedListQueueExample;

public class BinarySearchTreeExample{
	private Node root;
	
	public void setRoot(Node node) {
		this.root = node;
	}
	
	public Node getRoot() {
		return this.root;
	}
	
	/**
	 * 너비 우선 탐색 (Breadth First Search)
	 */
	public void bfs(Node root) {
		LinkedListQueueExample queue = new LinkedListQueueExample();
		queue.enqueue(root);
		
		while (!queue.empty()) {
			Node node = (Node) queue.dequeue();
			System.out.print(node.getValue() + " ");
			
			if (node.getLeftChild() != null) {
				queue.enqueue(node.getLeftChild());
			}
			
			if (node.getRightChild() != null) {
				queue.enqueue(node.getRightChild());
			}
		}
	}
	
	public void insert(int value) {
		if (this.root == null) {
			this.root = new Node(value);
			return;
		}
		
		Node target = this.root;
		Node parent = null;
		
		while (target != null) {
			parent = target;
			if (target.getValue() == value) {
				System.out.println(String.format("%s는(은) 중복된 값입니다.\n삽입을 중단합니다.", value));
				break;
			}
			
			if (target.getValue() > value) {
				target = target.getLeftChild();
				
				if (target == null) {
					parent.setLeftChild(new Node(value));
				}
			}
			else {
				target = target.getRightChild();
				
				if (target == null) {
					parent.setRightChild(new Node(value));
				}
			}
		}
	}
	
	/**
	 * 재귀 함수를 사용하는 방법
	 */
	public Node search(Node node, int value) {
		if (node == null) {
			return null;
		}
		else if (node.getValue() == value) {
			return node;
		}
		else if (node.getValue() > value) {
			return search(node.getLeftChild(), value);
		}
		else {
			return search(node.getRightChild(), value);
		}
	}
	
	/**
	 * 반복문을 사용하는 방법
	 */
	public Node search(int value) {
		if (this.root == null) {
			return null;
		}
		
		Node target= this.root;
		while (target != null & target.getValue() != value) {
			if (target.getValue() > value) {
				target = target.getLeftChild();
			}
			else {
				target = target.getRightChild();
			}
		}
		
		return target;
	}
	
	/**
	 * 파라미터로 받은 노드의 자식들을 포함한 가장 작은 값
	 */
	public Node getMinimumNode(Node node) {
		if (node == null) {
			return null;
		}
		
		if (node.getLeftChild() != null) {
			return getMinimumNode(node.getLeftChild());
		}
		
		return node;
	}
	
	public Node delete(Node root, int value) {
		if (root == null) {
			return null;
		}
		
		if (root.getValue() == value) {
			if (root.getLeftChild() == null && root.getRightChild() == null) {
				root = null;
				return null;
			}
			else if (root.getLeftChild() != null && root.getRightChild() == null) {
				Node left = root.getLeftChild();
				root = null;
				return left;
			}
			else if (root.getLeftChild() == null && root.getRightChild() != null) {
				Node right = root.getRightChild();
				root = null;
				return right;
			}
			else {
				Node children = getMinimumNode(root.getRightChild());
				root.setValue(children.getValue());
				root.setRightChild(delete(root.getRightChild(), children.getValue()));
			}
		}
		
		if (root.getValue() > value) {
			root.setLeftChild(delete(root.getLeftChild(), value));
		}
		else {
			root.setRightChild(delete(root.getRightChild(), value));
		}
		
		return root;
	}
}
