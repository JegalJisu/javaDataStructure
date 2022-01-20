package bjpublic.chap06;

public class MinHeapTreeExample {
	private int[] heap;
	private int size;
	private int pointer;
	
	public MinHeapTreeExample(int size) {
		this.size = size;
		this.heap = new int[size + 1];
		this.heap[0] = -1;
		this.pointer = 0;
	}
	
	/**
	 * 부모의 인덱스 가져오기
	 * @param index
	 * @return
	 */
	public int getParentIndex(int index) {
		if (index < 1) {
			return -1;
		}
		
		return index / 2;
	}
	
	/**
	 * 왼쪽 자식의 인덱스 가져오기
	 * @param index
	 * @return
	 */
	public int getLeftChildIndex(int index) {
		if (index < 1) {
			return -1;
		}
		
		return 2 * index;
	}
	
	/**
	 * 오른쪽 자식의 인덱스 가져오기
	 * @param index
	 * @return
	 */
	public int getRightChildIndex(int index) {
		if (index < 1) {
			return -1;
		}
		
		return (2 * index) + 1;
	}
	
	/**
	 * 리프 노드(자식이 없는 노드) 판별하기
	 * @param index
	 * @return
	 */
	public boolean isLeafNode(int index) {
		return getLeftChildIndex(index) > size && getRightChildIndex(index) > size;
	}
	
	/**
	 * 최솟값 가져오기
	 * @return
	 */
	public int getRoot() {
		return heap[1];
	}
	
	/**
	 * 스왑 메서드
	 * @param currentIndex
	 * @param parentIndex
	 */
	public void swap(int currentIndex,  int parentIndex) {
		int temp;
		temp = heap[currentIndex];
		heap[currentIndex] = heap[parentIndex];
		heap[parentIndex] = temp;
	}
	
	/**
	 * 최소 힙 트리의 삽입
	 * @param value
	 */
	public void insert(int value) {
		heap[++pointer] = value;
		int currentIndex = pointer;
		
		while (getParentIndex(currentIndex) != -1 && heap[currentIndex] < heap[getParentIndex(currentIndex)]) {
			swap(currentIndex, getParentIndex(currentIndex));
			currentIndex = getParentIndex(currentIndex);
		}
	}
	
	/**
	 * 모든 노드 출력하기
	 */
	public void print() {
		for (int i = 1; i <= size; i++) {
			int parent = heap[i];
			int leftChild = 2 * i <= size ? heap[2 * i] : -1;
			int rightChild = (2 * i) + 1 <= size ? heap[(2 * i) + 1] : -1;
			
			if (leftChild > -1 && rightChild > -1) {
				System.out.println(String.format("부모: %s, 왼쪽 자식: %s, 오른쪽 자식: %s:", parent, leftChild, rightChild));
			}
			else if (leftChild > -1 && rightChild == -1) {
				System.out.println(String.format("부모: %s, 왼쪽 자식: %s, 오른쪽 자식은 없습니다.", parent, leftChild));
			}
			else if (leftChild == -1 && rightChild > -1) {
				System.out.println(String.format("부모: %s, 왼쪽 자식은 없습니다., 오른쪽 자식: %s:", parent, rightChild));
			}
			else {
				System.out.println(String.format("리프 노드: %s", parent));
			}
		}
	}
	
	/**
	 * 최솟값을 반환하면서 삭제
	 * @return
	 */
	public int delete() {
		int result = getRoot();
		
		// 마지막 노드를 루트로 이동
		heap[1] = heap[size];
		heap[size] = -1;
		size--;
		
		if (size > 1) {
			rebuild(1);
		}
		
		return result;
	}
	
	private void rebuild(int current) {
		int leftChildIndex = getLeftChildIndex(current);
		int rightChildIndex = getRightChildIndex(current);
		
		if (isLeafNode(current)) {
			return;
		}
		
		int swapIndex = current;
		if (rightChildIndex > size) {
			if (heap[leftChildIndex] < heap[current]) {
				swapIndex = leftChildIndex;
			}
		}
		else {
			if (heap[leftChildIndex] <= heap[rightChildIndex]) {
				swapIndex = leftChildIndex;
			}
			else {
				swapIndex = rightChildIndex;
			}
		}
		
		if (heap[current] > heap[swapIndex]) {
			swap(current, swapIndex);
			rebuild(swapIndex);
		}
	}
}
