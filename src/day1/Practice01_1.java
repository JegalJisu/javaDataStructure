package day1;

import java.util.Arrays;

public class Practice01_1 {
	public static void main(String[] args) {
		int min = minValue(5, 9, 2, 13);
		
		System.out.println("최솟값 : " + min);
	}

	// 네 개의 값 중에서 최솟값을 구하는 메서드를 작성해 보세요.
	private static int minValue(int data1, int data2, int data3, int data4) {
		int[]	arr = {data1, data2, data3, data4};
		int		min = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
		}
		
		return min;
//		Arrays.sort(arr);
//		return arr[0];
	}
}
