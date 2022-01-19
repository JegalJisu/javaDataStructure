package chap9;

import java.util.Arrays;

public class Practice09_1 {
	public static void main(String[] args) {
		String text = "oool l000 ooll oolo";
		String binary = text.replaceAll("o", "0").replaceAll("l", "1");
		String[] binaryArr = binary.split(" ");
		int[] arr = new int[binaryArr.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(binaryArr[i], 2);
		}
		
		System.out.println("2진수" + Arrays.toString(arr));
		
		for (int i = 1; i < arr.length; i++) {
			int target = arr[i];
			int j;
			
			for (j = i - 1; j >= 0 && arr[j] > target; j--) {
				arr[j + 1] = arr[j];
			}
			
			arr[j + 1] = target;
		}
		
		System.out.println("삽입정렬 후 : " + Arrays.toString(arr));
	}
}
