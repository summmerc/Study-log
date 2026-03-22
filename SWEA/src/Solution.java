import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static int[] left;
	static int[] right;
	static String[] val;
	static int N;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			sc.nextLine();
			sb = new StringBuilder();
			left = new int[N + 1];
			right = new int[N + 1];
			val = new String[N + 1];
			
			for(int i = 0; i < N; i++) {
				String[] s = sc.nextLine().split(" ");
				int idx = Integer.parseInt(s[0]);
				
				val[idx] = s[1];
				if(s.length >= 3) left[idx] = Integer.parseInt(s[2]);
				if(s.length >= 4) right[idx] = Integer.parseInt(s[3]);
			}
			
			postOrder(1);
			
			String[] line = sb.toString().trim().split(" ");
			Stack<Integer> stack = new Stack<>();
			
			for(int i = 0; i < line.length; i++) {
				String s = line[i];
				int num1;
				int num2;
				if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
					num2 = stack.pop();
					num1 = stack.pop();
					
					switch(s) {
					case "+" :
						stack.push(num1+ num2);
						break;
					case "-" :
						stack.push(num1 - num2);
						break;
					case "*" :
						stack.push(num1 * num2);
						break;
					case "/" :
						stack.push(num1 / num2);
						break;
					} //switch
				} //if
				else {
					stack.push(Integer.parseInt(s));
				}
			}
			
			System.out.println("#" + tc + " " + stack.pop());
		}//tc
	}//main
	
	static void postOrder(int root) {
		if(root < 1 || root > N) return;
		postOrder(left[root]);
		postOrder(right[root]);
		sb.append(val[root]).append(' ');
	}
}
