package D4;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_1868_파핑파핑지뢰찾기 {
	static int N;
	static char[][] map;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static boolean[][] visited;
	static int[][] count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();

			map = new char[N][N];
			visited = new boolean[N][N];
			count = new int[N][N];

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j);
				}
			} // 입력

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.') {
						int cnt = 0;
						for (int d = 0; d < 8; d++) {
							int nr = i + dr[d];
							int nc = j + dc[d];

							if (nr < 0 || nr >= N || nc < 0 || nc >= N)
								continue;
							if (map[nr][nc] == '*')
								cnt++;
						}
						count[i][j] = cnt;
					}
				}
			}

			int ans = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == '.' && !visited[r][c] && count[r][c] == 0) {
						ans++;
						bfs(r, c);
					}
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == '.' && !visited[r][c]) {
						ans++;
						visited[r][c] = true;
					}
				}
			}

			System.out.println("#" + tc + " " + ans);
		} // tc
	} // main

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });
		visited[r][c] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int currR = curr[0];
			int currC = curr[1];

			if (count[currR][currC] == 0) {
				for (int d = 0; d < 8; d++) {
					int nr = currR + dr[d];
					int nc = currC + dc[d];

					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					if (map[nr][nc] == '.' && !visited[nr][nc]) {
						visited[nr][nc] = true;

						if (count[nr][nc] == 0) {
							queue.add(new int[] { nr, nc });
						}
					}

				}
			}

		}
	}
}
