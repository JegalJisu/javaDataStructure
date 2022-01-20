package bjpublic.chap10;

import java.util.Arrays;

// 삽입정렬이 어느정도 정렬된 배열일 경우 삽입정렬이 빠르지만
// 정렬이 되지 않은 배열에서는 쉘정렬이 더 빠르다.
// 아마 삽입정렬은 계속 배열의 순서를 바꾸다보니 작업이 많은듯 하다.
public class ShellSortExample {
	public void sort(int[] arr) {
		int length = arr.length;
		
		System.out.println(String.format("초기 배열: %s \n", Arrays.toString(arr)));
		System.out.println("---");
		for (int gap = length / 2; gap > 0; gap /= 2) {
			System.out.println(String.format("간격 %s(으)로 배열을 나눕니다.", gap));
			
			for (int startIndex = 0; startIndex < gap; startIndex++) {
				this.insertionSortByGap(arr, gap, startIndex);
			}
		}
		
		System.out.println("---");
	}
	
	private void insertionSortByGap(int[] arr, int gap, int startIndex) {
		for (int i = startIndex + gap; i < arr.length; i += gap) {
			int j;
			int temp = arr[i];
			
			for (j = i - gap; j >= 0 && arr[j] > temp; j -= gap) {
				arr[j + gap] = arr[j];
			}
			arr[j + gap] = temp;
		}
		
		System.out.println(String.format("정렬 진행 후 배열: %s \n", Arrays.toString(arr)));
	}
	
	public static void main(String[] args) {
		ShellSortExample sse = new ShellSortExample();
		int[] arr = new int[] {32, 29, 15, 20, 41, 10, 30, 22, 1};
		
		sse.sort(arr);
		System.out.println("셀 정렬 완료 후 : " + Arrays.toString(arr));
	}
}
