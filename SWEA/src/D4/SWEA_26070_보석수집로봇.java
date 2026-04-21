package D4;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_26070_보석수집로봇 {
	static int N, M;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int min;
	static int lastDir;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			map = new int[N][N];
			M = 0;
			
			Map<Integer, int[]> pos = new HashMap<>();
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
					
					if(map[i][j] != 0) {
						M++;
						pos.put(map[i][j], new int[] {i, j});
					}
				}
			}
		
			min = 0;
			int sR = 0;
			int sC = 0;
			lastDir = 0;
			
			for(int i = 1; i <= M; i++) {
				bfs(sR, sC, i);
				
				int[] next = pos.get(i);
				sR = next[0];
				sC = next[1];
				
			}
			
			System.out.println("#" + tc + " " + min);
		}
		
	}
	
	static void bfs(int sR, int sC, int target) {
		int[][][] v = new int[N][N][4];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				Arrays.fill(v[i][j], Integer.MAX_VALUE);
			}
		}
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[3] - b[3]);
		q.add(new int[] {sR, sC, lastDir, 0});
		
		v[sR][sC][lastDir] = 0;
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			int dir = curr[2];
			int dist = curr[3];
			
			if(dist > v[r][c][dir]) continue;
			
			if(map[r][c] == target) {
				min += dist;
				lastDir = dir;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				if(map[r][c] == 0 && d > 1) break;
				
				int nd = (dir + d) % 4;
				int nr = r + dr[nd];
				int nc = c + dc[nd];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(v[nr][nc][nd] > dist + d) {
					v[nr][nc][nd] = dist+d;
					q.add(new int[] {nr, nc, nd, dist + d});
				}
			}
		}
	}
}
