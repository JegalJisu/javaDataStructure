package bjpublic.chap10;

import java.util.Arrays;

public class Practice10_1 {
	/*
	 * {학생이름/학생 번호}로 정리된 학생부가 있습니다.
	 * 이 학생부를 두 가지 방법으로 셸 정렬을 이용하여 오름차순으로 정렬해 보세요.
	 */
	public static void main(String[] args) {
		String[] filnames = {
                "D/22" ,"A/14", "T/03", "F/09", "S/15",
                "B/10", "R/01", "J/05", "H/23", "Y/08"
        };
		
		sort(filnames, 0);
		System.out.println("학생이름 순 : " + Arrays.toString(filnames));
		
		sort(filnames, 1);
		System.out.println("학생번호 순 : " + Arrays.toString(filnames));
	}
	
	public static void sort(String[] arr, int type) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int startIndex = 0; startIndex < gap; startIndex++) {
				insertionSortByGap(arr, gap, startIndex, type);
			}
		}
	}

	private static void insertionSortByGap(String[] arr, int gap, int startIndex, int type) {
		for (int i = startIndex + gap; i < arr.length; i += gap) {
			int j = 0;
			String temp = arr[i];
			String keyword = temp.split("/")[type];
			
			if (type == 0) {
				for (j = i - gap; j >= 0 && arr[j].split("/")[type].charAt(0) > keyword.charAt(0); j -= gap) {
					arr[j + gap] = arr[j];
				}
				arr[j + gap] = temp;
			}
			else if (type == 1) {
				for (j = i - gap; j >= 0 && Integer.parseInt(arr[j].split("/")[type]) > Integer.parseInt(keyword); j -= gap) {
					arr[j + gap] = arr[j];
				}
			}
			
			arr[j + gap] = temp;
		}
	}
}
