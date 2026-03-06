
import java.util.Arrays;
import java.util.Scanner;

public class Backjoon_15655_N과M_6 {
	static int N;
	static int M;
	static int[] nums;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		result = new int[M];
		nums = new int[N];
		
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		Arrays.sort(nums);
		
		combination(0, 0);
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
		
		for(int i = start; i < N; i++) {
			result[cnt] = nums[i];
			combination(cnt + 1, i + 1);
		}
	}
}
