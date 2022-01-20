package bjpublic.chap04;

public class Practice04_2 {
	/*
	 * 아래 삼각형 모양을 출력하는 메서드를 재귀적으로 구현해 보세요.
	 *       *
	 *      * *
	 *     * * *
	 *    * * * *
	 */
	public static void main(String[] args) {
		triangle(4);
	}

	private static void triangle(int height) {
		triangle(height, 1);
	}

	private static void triangle(int height, int astrix) {
		if (height == astrix) {
			for(int i = 0; i < astrix; i++) {
				System.out.print("* ");
			}
			return;
		}
		
		for (int i = 0; i < height - astrix; i++) {
			System.out.print(" ");
		}
		
		for (int j = 0; j < astrix; j++) {
			System.out.print("* ");
		}
		
		System.out.println();
		
		triangle(height, astrix + 1);
	}
}
