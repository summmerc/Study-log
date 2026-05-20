package Level11;
import java.util.Scanner;

public class nxn표규칙대로이동하기 {
	static int N;
	static int[][] grid;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		grid = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		int[][] dp = new int[N][N];
		
		if(grid[0][0] == 0) {
			dp[0][0] = 1;
		} else {
			dp[0][0] = 0;
		}
		
		for(int i = 1; i < N; i++) {
			if(dp[0][i - 1] % 3 == grid[0][i]) {
				dp[0][i] = dp[0][i - 1] + 1;
			} else {
				dp[0][i] = dp[0][i - 1];
			}
		}
		
		for(int i = 1; i < N; i++) {
			if(dp[i - 1][0] % 3 == grid[i][0]) {
				dp[i][0] = dp[i - 1][0] + 1;
			} else {
				dp[i][0] = dp[i - 1][0];
			}
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = 1; j < N; j++) {
				if(dp[i][j - 1] % 3 == grid[i][j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
				} // 왼쪽에서 오는거
				
				if(dp[i - 1][j] % 3 == grid[i][j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
				} //위쪽에서 오는거
				
				int max = Math.max(dp[i - 1][j], dp[i][j - 1]);
				dp[i][j] = Math.max(max, dp[i][j]);
			}
		}
		
		System.out.println(dp[N - 1][N - 1]);
	}
}
