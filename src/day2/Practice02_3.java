package day2;

import java.util.Arrays;

public class Practice02_3 {
	public static void main(String[] args) {
		int[]	arr1	= {1, 3, 2};
		int[]	arr2	= {2, 3, 1};
		
		/* 순서가 없는 두 배열에서 서로 같은 요소를 포함하는지 판별하는 메서드를 작성해보세요. */
		for (int num1 : arr1) {
			boolean	isSame	= false;
			
			for (int num2 : arr2) {
				if (num1 == num2) {
					isSame = true;
				}
			}
			
			if (!isSame) {
				System.out.println("A배열" + Arrays.toString(arr1) + ",B배열" + Arrays.toString(arr2) + "은 다른 배열입니다.");
				return;
			}
		}
		
		System.out.println("A배열" + Arrays.toString(arr1) + ",B배열" + Arrays.toString(arr2) + "은 같은 배열입니다.");
	}
}
