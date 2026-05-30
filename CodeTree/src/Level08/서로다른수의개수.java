package Level08;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 서로다른수의개수 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		Set<Integer> set = new HashSet<>();
		
		for(int i = 0; i < N; i++) {
			set.add(sc.nextInt());
		}
		
		System.out.println(set.size());
	}
}
