import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N; //격자 크기
	static int K; //시작점의 수
	static int M; //꼭 치워야할 돌의 수
	static List<int[]> starts; // 시작점의 위치
	static List<int[]> stones;
	static int[][] map;
	static int max;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		stones = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					stones.add(new int[] {i, j});
				}
			}
		}
		
		starts = new ArrayList<>();
		for(int i = 0; i < K; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			
			starts.add(new int[] {r, c});
		}
		
		max = Integer.MIN_VALUE;
		
		stoneArrange(0, 0);
		
		System.out.println(max);
	}
	
	static void stoneArrange(int idx, int count) {
		if(count == M) {
			max = Math.max(max, bfs());
			return;
		}
	}
	
	static void bfs(int sR, int sC, int rock) {
		int count = 1;
		boolean[][] visited = new boolean[N][N];
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {sR, sC, rock});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			
			int r = curr[0];
			int c = curr[1];
			int s = curr[2];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visited[nr][nc] || map[nr][nc] == 1) continue;
				
				if(map[nr][nc] == 1) {
					s--;
				}
				visited[nr][nc] = true;
				count++;
				q.add(new int[] {nr, nc, s});
			}
		}
		
		max = Math.max(max, count);
	}
}
