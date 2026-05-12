import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] grid;
	static int[][] dist;
	static List<int[]> houses;
	static int max;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//0: 빈공간 1: 벽 2: 집
		
		N = sc.nextInt();
		grid = new int[N][N];
		dist = new int[N][N];
		houses = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				grid[i][j] = sc.nextInt();
				if(grid[i][j] == 2) {
					houses.add(new int[] {i, j});
				}
			}
		}
		
		for(int[] house : houses) {
			max = Math.max(bfs(house[0], house[1]), max);
		}
		
		System.out.println(max);
		
	}
	static int bfs(int sR, int sC) {
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sR, sC, 0});
		
		boolean[][] visited = new boolean[N][N];
		visited[sR][sC] = true;

		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int dist = curr[2];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(grid[nr][nc] == 1 || visited[nr][nc]) continue;
				
				if(grid[nr][nc] == 2) {
					return dist + 1;
				}
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, dist + 1});
			}
		}
		return -1;
	}
}
