package bjpublic.chap11;

import java.util.Arrays;

public class Practice11_1 {
	/*
	 * [1, 12,15, 7, 3, 9, 10, 8, 2, 5, 4]의 데이터를 담고 있는 배열이 있습니다.
	 * 이 배열을 내림차순으로 병합 정렬하고 분할-병합 과정을 출력해 보세요.
	 */
	public static void main(String[] args) {
		int[] arr = {1, 12,15, 7, 3, 9, 10, 8, 2, 5, 4};
		
		merge(arr, 0, arr.length - 1);
		System.out.println("병합정렬 후 : " + Arrays.toString(arr));
	}

	private static void merge(int[] arr, int left, int right) {
		if (left < right) {
			int div = (left + right) / 2;
			
			merge(arr, left, div);
			merge(arr, div +1, right);
			mergeSort(arr, left, div, right);
		}
	}

	private static void mergeSort(int[] arr, int start, int div, int end) {
		int[] temp = new int[arr.length];
		
		int s = start;
		int r = div + 1;
		int k = start;
		
		while (s <= div && r <= end) {
			if (arr[s] <= arr[r]) {
				temp[k++] = arr[s++];
			}
			else {
				temp[k++] = arr[r++];
			}
		}
		
		while (s <= div) {
			temp[k++] = arr[s++];
		}
		
		while (r <= end) {
			temp[k++] = arr[r++];
		}
		
		for (int h = 0; h <= end - start; h++) {
			arr[start + h] = temp[start + h];
		}
		
		System.out.println("중간 : " + Arrays.toString(Arrays.copyOfRange(temp, start, end + 1)));
	}
}
