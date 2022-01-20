package bjpublic.chap11;

import java.util.Arrays;

// 분할정복 전략의 한 종류
public class MergeSortExample {
	private void mergeSort(int arr[], int start, int div, int end) {
		int[] temp = new int[arr.length];
		
		int s = start;
		int r = div + 1;
		int k = start; // 배열에 복사할 위치 인덱스
		
		while (s <= div && r <= end) {
			if (arr[s] <= arr[r]) {
				temp[k++] = arr[s++];
			}
			else {
				temp[k++] = arr[r++];
			}
		}
		
		// 앞쪽
		while (s <= div) {
			temp[k++] = arr[s++];
		}
		
		// 뒤쪽
		while (r <= end) {
			temp[k++] = arr[r++];
		}
		
		for (int h = 0; h <= end - start; h++) {
			arr[start + h] = temp[start + h];
		}
	}
	
	public void merge(int arr[], int left, int right) {
		// 하나가 남을 때까지
		if (left < right) {
			int div = (left + right) / 2;
			
			merge(arr, left, div);
			merge(arr, div +1, right);
			mergeSort(arr, left, div, right);
		}
	}
	
	public static void main(String[] args) {
		MergeSortExample mse = new MergeSortExample();
		int[] arr = {5, 2, 30, 11, 9, 17, 12, 24};
		
		System.out.println(String.format("초기 배열: %s", Arrays.toString(arr)));
		mse.merge(arr, 0, arr.length - 1);
		System.out.println("병합 정렬 완료 후: " + Arrays.toString(arr));
	}
}
