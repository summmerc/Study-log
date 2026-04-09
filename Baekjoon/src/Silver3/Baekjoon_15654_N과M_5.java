package Silver3;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon_15654_N과M_5 {
	static int N;
	static int M;
	static int[] nums;
	static boolean[] visited;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		visited = new boolean[N];
		result = new int[M];
		nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		Permutation(0);
		System.out.println(sb);
	}
	
	static void Permutation(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			result[cnt] = nums[i];
			Permutation(cnt + 1);
			visited[i] = false;
		}
	}
}
