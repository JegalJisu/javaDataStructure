package bjpublic.chap02;

import java.util.Scanner;

public class Practice02_5 {
	public static void main(String[] args) {
		/*
		 * 사용자로부터 소문자 알파벳 1개를 입력받아 대문자로 변경하여 출력하는 코드를 작성해 보세요.
		 * 예)'a'를 입력받아 'A'로 출력합니다.
		 */
		Scanner	scanner = new Scanner(System.in);
		
		while (true) {
			String	text = scanner.nextLine();
			char smallLetter = text.charAt(0);
			
			// 입력한 문자가 한개 이면서 알파벳 소문자인 경우에만 만족시킨다.
			if (text.length() == 1 && 'a' <= smallLetter && smallLetter <= 'z') {
				// 'A' - 'a'를 하면 소문자를 대문자로 변경해 줄 만큼의 수가 나온다.
				System.out.println((char) (smallLetter + ('A' - 'a')));
				break;
			}
			else {
				System.out.println("알파벳 소문자 한 개를 입력해주세요.");
			}
		}
	}
}
