package Level10;
import java.util.Scanner;

public class 안전지대 {
	static int N; // 세로
	static int M; // 가로
	static int K;
	static int max;
	static int[][] grid;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 마을의 집들 중 높이가 K이하인 집들은 전부 무에 잠긴다
		// 안전영역 : 잠기지 않은 집들의 구성 -> 안전 영역의 수가 최대가 될때 K값 출력
		N = sc.nextInt();
		M = sc.nextInt();
		grid = new int[N][M];

		int maxHeight = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				grid[i][j] = sc.nextInt();
				maxHeight = Math.max(maxHeight, grid[i][j]);
			}
		}
		
		K = 1; //최대가 될 때 K값
		max = 0; //안전지대수
		for (int i = 1; i <= maxHeight; i++) {
			visited = new boolean[N][M];
			int cnt = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visited[r][c] && grid[r][c] > i) {
						dfs(r, c, i);
						cnt++;
					}
				}
			}
			if(cnt > max) {
				max = cnt;
				K = i;
			}
		}
		
		System.out.println(K + " " + max);
	}

	static void dfs(int sR, int sC, int K) {
		visited[sR][sC] = true;
		
		for(int d = 0; d < 4; d++) {
			int nr = sR + dr[d];
			int nc = sC + dc[d];
			
			if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
			if(visited[nr][nc] || grid[sR][sC] <= K) continue;
			dfs(nr, nc, K);
		}
	}
}
