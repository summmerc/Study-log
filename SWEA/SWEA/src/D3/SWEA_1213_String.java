package D3;
import java.util.Scanner;

public class SWEA_1213_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 0; tc < 10; tc++) {
			int T = sc.nextInt();

			String test = sc.next();
			String text = sc.next();
			
			if(test.length() > 10 || text.length() > 1000) {
				continue;
			}

			char[] cTest = new char[test.length()];
			char[] cText = new char[text.length()];
			for (int i = 0; i < test.length(); i++) {
				cTest[i] = test.charAt(i);
			}

			for (int i = 0; i < text.length(); i++) {
				cText[i] = text.charAt(i);
			}

			int cnt = 0;
			int start = 0;
			int check = 0;
			
			while (start <= cText.length - cTest.length) {
				if(cTest[0] == cText[start]) {
					check = 1;
					for(int i = 1; i < cTest.length; i++) {
						if(cTest[i] != cText[start + i]) {
							break;
						}
						check++;
					}
					if(check == cTest.length) {
						cnt++;
					}
				}
				start++;
			}
			System.out.println("#" + T + " " + cnt);
		}

	}
}
