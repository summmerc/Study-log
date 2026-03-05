package D3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[] card = new String[N];

			for (int i = 0; i < N; i++) {
				card[i] = sc.next();
			}

			Queue<String> q1 = new ArrayDeque<>();
			Queue<String> q2 = new ArrayDeque<>();

			int half = 0;
			if(N % 2 == 0)
				half = N / 2;
			else
				half = N / 2 + 1;
			
			for(int i = 0; i < half; i++) {
				q1.add(card[i]);
			}
			for(int i = half; i < N; i++) {
				q2.add(card[i]);
			}
			
			System.out.print("#" + tc + " ");
			while (!q1.isEmpty() || !q2.isEmpty()) {
				if (!q1.isEmpty())
					System.out.print(q1.poll() + " ");
				if (!q2.isEmpty())
					System.out.print(q2.poll() + " ");
			}
			System.out.println();
		}
	}
}
