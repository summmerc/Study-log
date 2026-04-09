package 모의SW테스트;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1949_등산로조성 {
	static int N;
	static int K;
	static int[][] mountain;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Peak>[] high;
	static boolean[][] visited;
	static int max;

	static class Peak {
		int r, c;

		public Peak(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();

			mountain = new int[N][N];
			high = new ArrayList[N + 1];
			visited = new boolean[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				high[i] = new ArrayList<>();
			}

			int highest = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					mountain[i][j] = sc.nextInt();
					highest = Math.max(highest, mountain[i][j]);
				}
			}
			max = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mountain[i][j] == highest) {
						visited[i][j] = true;
						dfs(i, j, mountain[i][j], 1, false);
						visited[i][j] = false;
					}
				}
			}
			
			System.out.println("#" + tc + " " + max);
		}
	}

	static void dfs(int r, int c, int h, int dist, boolean kUsed) {
		max = Math.max(max,  dist);
		
		for(int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
				if(visited[nr][nc]) continue;
				if(mountain[nr][nc] < h) {
					visited[nr][nc] = true;
					dfs(nr, nc, mountain[nr][nc], dist + 1, kUsed);
					visited[nr][nc] = false;
				}
				else if(!kUsed && mountain[nr][nc] - K < h) {
					visited[nr][nc] = true;
					dfs(nr, nc, mountain[nr][nc] - (mountain[nr][nc] - mountain[r][c] + 1), dist + 1, true);
					visited[nr][nc] = false;
				}
			}
			
		}
	}

}
