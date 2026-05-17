import java.util.Scanner;

public class 겹치지않게선분고르기2 {
	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new int[1001];
		
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			if(dp[to] == 0) {
				dp[to] = from;
				cnt++;
			} else {
				dp[to] = Math.min(dp[to], from);
			}
		}
		
		System.out.println(cnt);
	}
}
