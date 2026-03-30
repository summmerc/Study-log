import java.util.Scanner;
import java.util.Stack;

public class Baekjoon_1874_스택수열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		boolean yes = true;
		Stack<Integer> stack = new Stack<>();
		int current = 1;
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			while(current <= num) {
				stack.push(current++);
				sb.append("+\n");
			}
			
			if(stack.peek() == num) {
				stack.pop();
				sb.append("-\n");
			} else {
				yes = false;
				break;
			}
			
		}
		
		if(yes) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}
