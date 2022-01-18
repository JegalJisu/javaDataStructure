package chap8;

import java.util.Arrays;

public class Practice08_1 {
	/*
	 * "HelloWorld" 문자열을 선택 정렬을 사용하여 오름차순으로 정렬해 보세요.
	 */
	public static void main(String[] args) {
		String text = "HelloWorld";
		char[] arr = text.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			int minIndex = i;
			
			for (int j = i; j < arr.length; j++) {
				if (arr[minIndex] < arr[j]) {
					continue;
				}
				
				minIndex = j;
			}
			
			if (minIndex != i) {
				char temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
}
