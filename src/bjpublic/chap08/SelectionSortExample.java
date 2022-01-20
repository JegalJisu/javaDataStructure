package bjpublic.chap08;

public class SelectionSortExample {
	public int[] sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[minIndex] < arr[j]) {
					continue;
				}
				
				minIndex = j;
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
		
		return arr;
	}
}
