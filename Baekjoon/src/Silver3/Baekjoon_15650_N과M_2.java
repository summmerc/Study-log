package Silver3;

import java.util.Scanner;

public class Baekjoon_15650_N과M_2 {
	static int N;
	static int M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		
		combination(0, 1);
		System.out.println(sb);
	}
	
	static void combination(int cnt, int start) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i <= N; i++) {
			result[cnt] = i;
			combination(cnt + 1, i + 1);
		}
	}
}
