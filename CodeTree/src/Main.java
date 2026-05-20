import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N;
	static int INF = 9999999;
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
		
		int minD = INF;
		
		
		for(int l = 1; l <= 100; l++) {
			int[][] dp = new int[N][N];
			
			if(grid[0][0] < l) continue;
			
			for(int i = 0; i < N; i++) {
				Arrays.fill(dp[i], INF);
			}
			
			dp[0][0] = grid[0][0];
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(i == 0 && j == 0 || grid[i][j] < l) continue;
					
					int up = INF;
					int left = INF;
					
					if(i - 1 >= 0 && dp[i - 1][j] != INF) {
						up = Math.max(grid[i][j], dp[i - 1][j]);
					}
					
					if(j - 1 >= 0 && dp[i][j - 1] != INF) {
						left = Math.max(grid[i][j], dp[i][j - 1]);
					}
					
					dp[i][j] = Math.min(up, left);
					
					if(dp[N - 1][N - 1] != INF) {
						int diff = dp[N - 1][N - 1] - l;
						
						minD = Math.min(minD, diff);
					}
				}
			}
		}
		
		System.out.println(minD);
	}
}
