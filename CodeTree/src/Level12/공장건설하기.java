package Level12;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 공장건설하기 {
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
				dist[i][j] = -1;
				if(grid[i][j] == 2) {
					houses.add(new int[] {i, j});
				}
			}
		}
		
		Queue<int[]> q = new ArrayDeque<>();
		for(int[] house : houses) {
			q.add(new int[] {house[0], house[1]});
			dist[house[0]][house[1]] = 0;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int di = dist[r][c];
			
			max = Math.max(max, di);
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(dist[nr][nc] != -1 || grid[nr][nc] == 1) continue;
				
				dist[nr][nc] = di + 1;
				q.add(new int[] {nr, nc});
			}
		}
		
		System.out.println(max);
		
	}
}
