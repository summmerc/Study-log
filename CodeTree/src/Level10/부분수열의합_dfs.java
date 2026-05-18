package Level10;
import java.util.Scanner;

public class 부분수열의합_dfs {
	static int N;
	static int M;
	static int[] A;
	static boolean found;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		A = new int[N];
		
		for(int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		
		dfs(0, 0);
		
		if(found) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}
	
	static void dfs(int idx, int sum) {
		if(found) return;
		if(sum > M) return;
		
		if(sum == M) {
			found = true;
			return;
		}
		
		if(idx == N) return;
		
		dfs(idx + 1, sum + A[idx]);
		dfs(idx + 1, sum);
	}
}
