package bjpublic.chap02;

import java.util.Arrays;

public class Practice02_4 {
	public static void main(String[] args) {
		int[]	arr		= {5, 10, 9, 27, 2, 8, 10, 4, 27, 1};
		int[]	result	= new int[10];
		
		/*
		 * 중복되니 요소를 제거한 새 배열을 반환하는 메서드를 작성해보세요.
		 * 중복 제거된 빈요소는 기본값 0으로 삽입됩니다.
		 */
		// 중복되는 숫자가 존재하는지 찾는다.
		// 자기 자신은 검증할 필요가 없으므로 제외한다.
		// 앞에서 검증이 완료된 수는 다시 검증 할 필요가 없으므로 제외한다.
		// ex) 만약에 arr[1]인 10을 검증 할 시 앞에있는 값인 arr[0]인 5를 검증할 필요가 없다.
		for (int i = 0; i < arr.length - 1; i++) {
			result[i] = arr[i];
			
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					arr[j] = 0;
				}
			}
		}
		
		// arr의 마지막 값은 앞에 존재하는 모든 수들이 검증이 완료되었기 때문에 검증할 필요 없이 추가한다.
		result[arr.length - 1] = arr[arr.length - 1];
		System.out.println(Arrays.toString(result));
	}
}
