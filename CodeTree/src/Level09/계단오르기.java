package Level09;
import java.util.Scanner;

public class 계단오르기 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		if(N < 2) {
			System.out.println(0);
			return;
		}
		
		int[] dp = new int[N + 1];
		
		dp[0] = 1;
		if(N >= 2) dp[2] = 1;
		if(N >= 3) dp[3] = 1;
		
		for(int i = 4; i <= N; i++) {
			dp[i] = (dp[i - 2] + dp[i - 3]) % 10007;
		}
		
		System.out.println(dp[N]);
	}
}
