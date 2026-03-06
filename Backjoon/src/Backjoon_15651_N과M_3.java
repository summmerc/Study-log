
import java.util.Scanner;

public class Backjoon_15651_N과M_3 {
	static int N;
	static int M;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		
		rePermutaiton(0);
		System.out.println(sb);
	}
	
	static void rePermutaiton(int cnt) {
		if(cnt == M) {
			for(int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			result[cnt] = i;
			rePermutaiton(cnt + 1);
		}
	}
}
