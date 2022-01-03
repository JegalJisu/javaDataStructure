package chap2;

public class Practice02_2 {
	public static void main(String[] args) {
		int[]	arr = {10, 11, 2, 5, 3, 3, 24, 15, 6, 9};
		
		/* 배열의 최댓값과 최솟값을 구하는 메서드를 작성해 보세요. */
		int		min = 999;
		int		max = 0;
		
		for (int number : arr) {
			if (number > max) {
				max = number;
			}
			
			if (number < min) {
				min = number;
			}
		}
		
		System.out.println("최댓값 : " + max + ",\t최솟값 : " + min);
	}
}
