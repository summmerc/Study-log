package D4;
import java.util.Scanner;

public class SWEA_1231_중위순회 {
	static int[] left;
	static int[] right;
	static char[] val;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			sc.nextLine();
			val = new char[N + 1];
			left = new int[N + 1];
			right = new int[N + 1];
			
			for(int i = 0; i < N; i++) {
				String[] parts = sc.nextLine().split(" ");
				
				int idx = Integer.parseInt(parts[0]);
				val[idx] = parts[1].charAt(0);
				
				if(parts.length >= 3) left[idx] = Integer.parseInt(parts[2]);
				if(parts.length >= 4) right[idx] = Integer.parseInt(parts[3]);
			}
			
			System.out.print("#" + tc + " ");
			inOrder(1);
			System.out.println();

		}
	}
	public static void inOrder(int v) {
		if(v == 0 || v > N) return;
		inOrder(left[v]);
		System.out.print(val[v]);
		inOrder(right[v]);
	}
	
}
