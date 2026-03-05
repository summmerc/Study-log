package D2;

import java.util.Scanner;

public class SWEA_1970_쉬운거스름돈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[] change = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
			int[] cnt = new int[change.length];
			
			for(int i = 0; i < change.length; i++) {
				int use = N / change[i];
				cnt[i] = use;
				N %= change[i];
			}
			
			System.out.println("#" + tc);
			for(int i = 0; i < cnt.length; i++) {
				System.out.print(cnt[i] + " ");
			}
			System.out.println();
			
		}
	}
}
