package Silver3;

import java.util.Scanner;

public class Baekjoon_15649_N과M_1 {
	static int N;
	static int M;
	static int[] result;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		result = new int[M];
		visited = new boolean[N + 1];
		
		permutation(0);
		System.out.println(sb);
	}
	
	static void permutation(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			result[cnt] = i;
			permutation(cnt + 1);
			visited[i] = false;
		}
	}
}
