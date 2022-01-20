package bjpublic.chap07;

import java.util.Arrays;
import java.util.Random;

public class Practice07_1 {
	/*
	 * 입력 받은 값의 크기만큼 배열을 생성하고, 각 요소는 중복되지 않으며, 무작위 값으로 초기화하여 내림차순으로 정렬해 보세요.
	 * (1 < n <= 입력받은값)(n은 자연수)
	 */
	public static void main(String[] args) {
		int size = 5;
		int[] arr = new int[size];
		
		// 배열에 숫자를 순서대로 삽입
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		
		// 랜덤으로 배열을 섞음
		for (int i = 0; i < size * 2; i++) {
			Random random = new Random();
			int num1 = random.nextInt(size);
			int num2 = random.nextInt(size);
			
			int temp = arr[num1];
			arr[num1] = arr[num2];
			arr[num2] = temp;
		}
		
		System.out.println("생성된 배열: " + Arrays.toString(arr));
		
		// 내림차순으로 버블정렬
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] < arr[j +  1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		System.out.println("결괏값: " + Arrays.toString(arr));
	}
}
