package bjpublic.chap09;

import java.util.Arrays;

public class Practice09_1 {
	/*
	 * "oool l000 ooll oolo" 2진수르르 나타내는 문자열이 존재합니다.
	 * 이 문자열을 10진수로 변환하여 배열에 차례대로 넣은 뒤, 삽입 정렬을 이용하여 오름차순으로 정렬해 보세요.
	 */
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
