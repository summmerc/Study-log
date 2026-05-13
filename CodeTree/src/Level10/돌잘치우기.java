package Level10;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 돌잘치우기 {
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
		
		//0 : 이동가능 1 : 돌의 위치
		
		N = sc.nextInt();
		K = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][N];
		stones = new ArrayList<>(); //돌 위치
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] == 1) {
					stones.add(new int[] {i, j});
				}
			}
		}
		
		starts = new ArrayList<>(); //시작점
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
		
		if(idx == stones.size()) return;
		
		int[] stone = stones.get(idx);
		map[stone[0]][stone[1]] = 0;
		stoneArrange(idx + 1, count + 1);
		map[stone[0]][stone[1]] = 1;
		
		stoneArrange(idx + 1, count);
	}
	
	static int bfs() {
		int count = 0;
		boolean[][] visited = new boolean[N][N];
		
		Queue<int[]> q = new ArrayDeque<>();

		for(int[] st : starts) {
			q.add(st);
			visited[st[0]][st[1]] = true;
		}
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			count++;
			
			int r = curr[0];
			int c = curr[1];
			
			for(int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(visited[nr][nc] || map[nr][nc] == 1) continue;
				
				visited[nr][nc] = true;
				q.add(new int[] {nr, nc});
			}
		}
		
		return count;
	}
}
