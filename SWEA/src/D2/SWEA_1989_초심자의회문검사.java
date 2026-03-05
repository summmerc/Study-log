package D2;

import java.util.Scanner;

public class SWEA_1989_초심자의회문검사 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int have = 1;
			
			String text = sc.next();
			int l = text.length();
			
			char[] cArr = text.toCharArray();
			
			for(int i = 0; i < l / 2; i++) {
				if(cArr[i] != cArr[l - 1 - i]) {
					have = 0;
					break;
				}
			}
			
			System.out.println("#" + tc + " " + have);
		}
	}
}
