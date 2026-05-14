import java.util.Scanner;

public class Main {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		N = sc.nextInt();
		
		int[] dp = new int[N + 1];
		
		dp[0] = 1;
		if(N >= 1) dp[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		
		System.out.println(dp[N]);
	}
	
}
