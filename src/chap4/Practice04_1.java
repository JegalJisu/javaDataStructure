package chap4;

import java.util.Scanner;

public class Practice04_1 {
	/*
	 * 입력받은 두 양수를 x, n 변수에 할당하고 x의 n제곱을 재귀적으로 구현해보세요.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력해주세요 : ");
		int x = scanner.nextInt();
		System.out.print("두번째 숫자를 입력해주세요 : ");
		int n = scanner.nextInt();
		
		System.out.println(square(x, n));
	}

	static int square(int x, int n) {
		if (n == 1) {
			return x;
		}
		
		return x * square(x, n - 1);
	}
}
