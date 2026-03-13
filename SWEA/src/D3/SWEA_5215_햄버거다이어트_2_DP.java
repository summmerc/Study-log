package D3;
import java.util.Scanner;

public class SWEA_5215_햄버거다이어트_2_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			
			int[] S = new int[N + 1];
			int[] C = new int[N + 1];
			
			for(int i = 1; i <= N; i++) {
				S[i] = sc.nextInt();
				C[i] = sc.nextInt();
			}
			
			int[][] dp = new int[N + 1][L + 1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= L; j++) {
					if(C[i] > j) {
						dp[i][j] = dp[i - 1][j];
					}
					else {
						dp[i][j] = Math.max(dp[i - 1][j], S[i] + dp[i - 1][j - C[i]]);
					}
				}
			}
			
			System.out.println("#" + tc + " " + dp[N][L]);
		}
	}
}
