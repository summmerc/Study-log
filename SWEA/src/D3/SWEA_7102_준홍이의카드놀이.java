package D3;

import java.util.ArrayDeque;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_7102_준홍이의카드놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] sum = new int[N + M + 1];
			
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= M; j++) {
					sum[i + j]++;
				}
			}
			
			int max = 0;
			for(int i = 1; i <= N + M; i++) {
				if(max < sum[i]) max = sum[i];
			}
			
			Queue<Integer> result = new ArrayDeque<>();
			for(int i = 1; i <= N + M; i++) {
				if(max == sum[i])
					result.add(i);
			}
			
			System.out.print("#" + tc + " ");
			while(!result.isEmpty()) {
				System.out.print(result.poll() + " ");
			}
			System.out.println();
		}
	}
}
