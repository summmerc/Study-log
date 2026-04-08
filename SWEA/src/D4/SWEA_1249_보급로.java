package D4;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SWEA_1249_보급로 {
	static int N;
	static int[][] map;
	static int[][] dist;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static class Edge implements Comparable<Edge>{
		int r;
		int c;
		int time;
		
		public Edge(int r, int c, int time) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
		}

		@Override
		public int compareTo(Edge o) {
			return this.time - o.time;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			dist = new int[N][N];
			for(int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			
			for(int i = 0; i < N; i++) {
				String line = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}
			
			dijkstra(0, 0, 0);
			
			System.out.println("#" + tc  + " " + dist[N - 1][N - 1]);
		}//tc
	}//main
	
	static void dijkstra(int r, int c, int time) {
		dist[r][c] = time;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(r, c, time));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			int cr = curr.r;
			int cc = curr.c;
			int ct = curr.time;
			
			if(ct > dist[cr][cc]) continue;
			
			if(cr == N - 1 && cc == N - 1) break;
			
			for(int d = 0; d < 4; d++) {
				int nr = cr + dr[d];
				int nc = cc + dc[d];
				
				if(nr >= 0 && nr < N && nc >= 0 && nc < N) {
					int nextTime = ct + map[nr][nc];
					
					if(nextTime < dist[nr][nc]) {
						dist[nr][nc] = nextTime;
						pq.add(new Edge(nr, nc, nextTime));
					}
				}
			}
		}
	}
}
