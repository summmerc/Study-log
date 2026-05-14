package Level11;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 빙하 {
	static int N, M;
	static int[][] grid;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//1 : 빙하, 0 : 물
		// 물에 닿아있는 부분들이 동시에 녹음(1초)
		// 빙하로 둘러싸여있는 물의 경우x
		// 빙하가 전부 녹는데 걸리는 시간, 마지막 녹은 빙하의 크기
		// 테투리는 무조건 전부 물
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int time = 0;
		int lastSize = 0;
		grid = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		while(true) {
			int currSize = countIce();
			if(currSize == 0) break;
			
			lastSize = currSize;
			
			melt();
			time++;
		}
		
		System.out.println(time + " " + lastSize);
	}
	
	static int countIce() {
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(grid[i][j] == 1) cnt++;
			}
		}
		
		return cnt;
	}
	
	static void melt() {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {0, 0});
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			int curr[] = q.poll();
			int r = curr[0];
			int c = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
				if(visited[nr][nc]) continue;
				if(grid[nr][nc] == 1) {
					grid[nr][nc] = 0;
					visited[nr][nc] = true;
					continue;
				}
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
	}
}
