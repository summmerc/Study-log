import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		int[] e = new int[N];
		int[] t = new int[N];
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			e[i] = sc.nextInt();
			t[i] = sc.nextInt();
			max += t[i];
		}
		
		int[] dp = new int[max + 1];
		
		for(int i = 0; i < N; i++) {
			int currE = e[i];
			int currT = t[i];
			
			for(int time = max; time >= currT; time--) {
				dp[time] = Math.max(dp[time], dp[time - currT] + currE);
			}
		}
		
		int ans = -1;
		for(int time = 0; time <= max; time++) {
			if(dp[time] >= M) {
				ans = time;
				break;
			}
		}
		
		System.out.println(ans);
		
	}
}
