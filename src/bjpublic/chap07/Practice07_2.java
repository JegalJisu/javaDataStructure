package bjpublic.chap07;

import java.util.Arrays;

public class Practice07_2 {
	/*
	 * 100,000 크기를 가진 배열이 오름차순으로 정렬되어 있습니다.
	 * 이미 정렬을 마친 배열에 대해서 거품정렬을 시도하려 합니다.
	 * 정렬된 배열인 경우 거품정렬을 하지 않도록 거품정렬 알고리즘을 구현해 보세요.
	 */
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 2, 6};
		int[] copyArr = arr;
		Arrays.sort(copyArr);
		
		if (Arrays.equals(arr, copyArr)) {
			return;
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j +  1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}
}
