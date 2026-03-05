package D5;
import java.util.Scanner;

public class SWEA_1247_최적경로 {
	static int N;
	static int[][] loc;
	static boolean[] visited;
	static int minDistance;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			loc = new int[N + 2][2];
			visited = new boolean[N + 2];
			minDistance = Integer.MAX_VALUE;
			
			for(int i = 0; i < N + 2; i++) {
				loc[i][0] = sc.nextInt();
				loc[i][1] = sc.nextInt();
			}
			
			find(0, loc[0][0], loc[0][1], 0);
			System.out.println("#" + tc + " " + minDistance);
		}
		
	}
	
	static void find(int count, int X, int Y, int dist) {
		if(dist >= minDistance) return;
		
		if(count == N) {
			int finalDist = dist + Math.abs(X - loc[1][0]) + Math.abs(Y - loc[1][1]);
			minDistance = Math.min(minDistance, finalDist);
			return;
		}
		
		for(int i = 2; i < N + 2; i++) {
			if(!visited[i]) {
				visited[i] = true;
				
				int next = Math.abs(X - loc[i][0]) + Math.abs(Y - loc[i][1]);
				find(count + 1, loc[i][0], loc[i][1], dist + next);
				
				visited[i] = false;
			}
		}
	}
}
