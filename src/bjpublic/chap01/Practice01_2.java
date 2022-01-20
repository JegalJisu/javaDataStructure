package bjpublic.chap01;

public class Practice01_2 {
	public static void main(String[] args) {
		int max = maxValue(20, 31, 15, 31, 7);
		System.out.println("최댓값 : " + max);
	}

	/* 중복을 포함한 다섯 개의 값 중에서 최댓값을 구하는 메서드를 작성해 보세요. */
	private static int maxValue(int data1, int data2, int data3, int data4, int data5) {
		int[]	arr	= {data1, data2, data3, data4, data5};
		int		max	= arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		
		return max;
	}
}
