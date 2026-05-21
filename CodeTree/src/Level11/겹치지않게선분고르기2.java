package Level11;
import java.util.Arrays;
import java.util.Scanner;

public class 겹치지않게선분고르기2 {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int[][] node = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			node[i][0] = sc.nextInt();
			node[i][1] = sc.nextInt();
		}
		
		
		Arrays.sort(node, (o1, o2) -> {
			if(o1[1] != o2[1]) {
				return o1[1] - o2[1];
			}
			return o1[0] - o2[0];
		});
		
		int[] dp = new int[N];
		
		Arrays.fill(dp, 1);
		
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(node[i][0] > node[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			
			max = Math.max(dp[i], max);
		}
		
		System.out.println(max);
	}
}
