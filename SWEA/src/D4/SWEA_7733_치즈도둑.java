package D4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7733_치즈도둑 {
	static int N;
	static int[][] cheese;
	static boolean[][] ate;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			cheese = new int[N][N];
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					cheese[i][j] = sc.nextInt();
					max = Math.max(max, cheese[i][j]);
				}
			}

			int MAX = 1;

			for (int d = 1; d <= max; d++) {
				ate = new boolean[N][N];
				int Chunks = 0;
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (cheese[r][c] <= d) {
							ate[r][c] = true;
						}
					}
				}
				for (int r = 0; r < N; r++) {
					for (int c = 0; c < N; c++) {
						if (!ate[r][c]) {
							Chunks++;
							bfs(r, c);
						}
					}
				}

				MAX = Math.max(Chunks, MAX);

			} // 날짜별 for문

			System.out.println("#" + tc + " " + MAX);
		} // tc
	}// main

	static void bfs(int R, int C) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { R, C });
		ate[R][C] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currR = curr[0];
			int currC = curr[1];

			for (int d = 0; d < 4; d++) {
				int nr = currR + dr[d];
				int nc = currC + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (!ate[nr][nc]) {
					ate[nr][nc] = true;

					queue.add(new int[] { nr, nc });
				}
			}
		}
	}
}
