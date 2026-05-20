package Level11;
import java.util.Scanner;

public class 연속한K개의숫자 {
	static int N, K, B;
	static int[] none;
	static int[] cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		B = sc.nextInt();
		
		none = new int[N + 1];
		cnt = new int[N + 1];
		
		for(int i = 0; i < B; i++) {
			none[sc.nextInt()] = 1;
		}
		
		int missing = 0;
		for(int i = 1; i <= K; i++) {
			if(none[i] == 1) missing++;
		}
		
		int min = missing;
		
		for(int i = K + 1; i <= N; i++) {
			if(none[i] == 1) {
				missing++;
			}
			if(none[i - K] == 1) {
				missing--;
			}
			
			min = Math.min(min, missing);
		}
		
		System.out.println(min);
	}
}
