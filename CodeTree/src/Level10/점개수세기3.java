package Level10;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class 점개수세기3 {
	static int N, Q;
	static int[] points;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Q = sc.nextInt();
		
		points = new int[N];
		
		for(int i = 0; i < N; i++) {
			points[i] = sc.nextInt();
		}
		
		Arrays.sort(points);
		
		HashMap<Integer, Integer> compressed = new HashMap<>();
		for(int i = 0; i < N; i++) {
			compressed.put(points[i], i);
		}
		
		for(int i = 0; i < Q; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int A = compressed.get(a);
			int B = compressed.get(b);
			
			System.out.println(B - A + 1);
		}
		
	}
}
