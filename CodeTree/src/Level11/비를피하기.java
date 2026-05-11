package Level11;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 비를피하기 {
	static int N; //격자 크기
	static int H; //사람의 수
	static int M; //비를 피할 공간의 수
	static int[][] map;
	static List<int[]> start;
	static int[][] result;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1 : 벽
		//2 : 사람
		//3 : 비를 피할 수 있음
		
		N = sc.nextInt();
		H = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		start = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 2) {
					start.add(new int[] {i, j});
				}
			}
		}
		
		result = new int[N][N];
		for(int[] p : start) {
			bfs(p);
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void bfs(int[] p) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		int sR = p[0];
		int sC = p[1];
		
		visited[sR][sC] = true;
		
		q.add(new int[] {sR, sC, 0});
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int cnt = curr[2];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc] == 1 || visited[nr][nc]) continue;
				if(map[nr][nc] == 3) {
					result[sR][sC] = cnt + 1;
					return;
				}
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc, cnt + 1});
			}
		}
		result[sR][sC] = -1;
	}
}
