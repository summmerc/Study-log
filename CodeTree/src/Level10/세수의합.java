package Level10;
import java.util.HashMap;
import java.util.Scanner;

public class 세수의합 {
	static int N;
	static long K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextLong();
		
		long[] arr = new long[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}
		
		HashMap<Long, Integer> map = new HashMap<>();
		
		int count = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				long t = K - arr[i] - arr[j];
				
				count += map.getOrDefault(t, 0);
			}
			
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		System.out.println(count);
	}

}
