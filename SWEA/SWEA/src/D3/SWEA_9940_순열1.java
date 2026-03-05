package D3;

import java.util.Scanner;

public class SWEA_9940_순열1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			boolean[] check = new boolean[N + 1];
			for(int i = 0; i < N; i++) {
				check[arr[i]] = true;
			}
			
			String answer = "Yes";
			for(int i = 1; i <= N; i++) {
				if(!check[i]) answer = "No";
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
}
