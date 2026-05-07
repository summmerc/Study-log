package Level10;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class 마을구분하기 {
	static int N;
	static int[][] map;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static boolean[][] visited;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		pq = new PriorityQueue<>();
		visited = new boolean[N][N];
		int total = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					pq.add(find(i, j));			
					total++;
				}
			}
		}
		
		System.out.println(total);
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
		
	}
	
	static int find(int r, int c) {
		int count = 1;
		visited[r][c] = true;
		
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			int cR = curr[0];
			int cC = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = cR + dr[d];
				int nc = cC + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc] == 0 || visited[nr][nc]) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
				count++;
			}
		}
		
		return count;
	}
}
