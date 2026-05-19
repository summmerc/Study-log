package Level12;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class nxm표이동4 {
	static int N, M, A, B;
	static int[][] grid;
	static PriorityQueue<Point> item;
	static long MOD = 1000000007;
	static class Point implements Comparable<Point> {
		int r, c;
		
		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
		@Override
		public int compareTo(Point o) {
			if(this.r != o.r) {
				return this.r - o.r;
			}
			return this.c - o.c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		grid = new int[N + 1][M + 1];
		item = new PriorityQueue<>();
		

		for(int i = 0; i < A; i++) {
			item.add(new Point(sc.nextInt(), sc.nextInt()));
		}
		
		for(int i = 0; i < B; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			grid[r][c] = 2;
		}
		
		Point start = new Point(1, 1);
		long result = 1;
		
		while(!item.isEmpty()) {
			Point nextItem = item.poll();
			
			if(nextItem.c < start.c) {
				System.out.println(0);
				return;
			}
			
			long ways = find(start, nextItem);
			result = (result * ways) % MOD;
			
			start = nextItem;
		}
		
		Point end = new Point(N, M);
		if(end.c < start.c) {
			System.out.println(0);
			return;
		}
		
		long ways = find(start, end);
		result = (result * ways) % MOD;
		
		System.out.println(result);
	}
	
	static long find(Point s, Point d) {
		if(grid[s.r][s.c] == 1 || grid[d.r][d.c] == 1) return 0;
		
		long[][] dp = new long[d.r + 1][d.c + 1];
		
		dp[s.r][s.c] = 1;
		for(int i = s.r; i <= d.r; i++) {
			for(int j = s.c; j <= d.c; j++) {
				if(i == s.r && j == s.c || grid[i][j] == 2) continue;
				
				if(i - 1 >= s.r && grid[i - 1][j] != 2) {
					dp[i][j] = (dp[i][j] + dp[i - 1][j]) % MOD;
				}
				
				if(j - 1 >= s.c && grid[i][j - 1] != 2) {
					dp[i][j] = (dp[i][j] + dp[i][j - 1]) % MOD;
				}
			}
		}
		
		return dp[d.r][d.c];
	}
}
