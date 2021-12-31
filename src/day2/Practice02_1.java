package day2;

import java.util.Scanner;

public class Practice02_1 {
	public static void main(String[] args) {
		int[]	arr		= new int[5];
		int		sum		= 0;
		Scanner scanner = new Scanner(System.in);
		
		/* 5개의 양수를 입력받은 배열의 모든 요소의 합을 구하는 메서드를 작성해 보세요. */
		for (int i = 0; i < arr.length; i++) {
			int inputNum = 0;
			while (true) {
				inputNum = scanner.nextInt();
				
				if (inputNum > 0) {
					break;
				}
				else {
					System.out.println("양수만 입력해주세요.");
				}
			}
			
			arr[i] = inputNum;
			sum += arr[i];
		}
		
		System.out.println("5개의 숫자의 합 : " + sum);
	}
}
