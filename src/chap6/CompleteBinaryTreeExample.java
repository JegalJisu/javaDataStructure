package chap6;

public class CompleteBinaryTreeExample {
	public void printAll(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int leftNode = this.getLeftNode(arr, i);
			int rightNode = this.getRightNode(arr, i);
			
			if (leftNode > -1) {
				System.out.println(String.format("%d의 왼쪽 자식의 노드는 %d", arr[i], leftNode));
			}
			
			if (rightNode > -1) {
				System.out.println(String.format("%d의 오른쪽 자식의 노드는 %d", arr[i], rightNode));
			}
		}
	}

	private int getLeftNode(int[] arr, int index) {
		int findIndex = 2 * index;
		if (arr.length <= findIndex) {
			return -1;
		}
		return arr[findIndex];
	}
	
	private int getRightNode(int[] arr, int index) {
		int findIndex = (2 * index) + 1;
		if (arr.length <= findIndex) {
			return -1;
		}
		return arr[findIndex];
	}
}
