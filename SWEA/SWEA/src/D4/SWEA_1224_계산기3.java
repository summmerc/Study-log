package D4;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1224_계산기3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = sc.nextInt();

			String line = sc.next();

			Stack<Character> op = new Stack<>();
			StringBuilder postfix = new StringBuilder();

			Map<Character, Integer> priority = new HashMap<>();
			priority.put('*', 2);
			priority.put('+', 1);
			priority.put('(', 0);

			for (int i = 0; i < N; i++) {
				char c = line.charAt(i);

				if (c >= '0' && c <= '9') {
					postfix.append(c);
				} else if (c == '(') {
					op.push(c);
				} else if (c == ')') {
					while (op.peek() != '(') {
						postfix.append(op.pop());
					}
					op.pop();
				} else {
					if (op.isEmpty())
						op.push(c);
					else {
						while (!op.isEmpty() && priority.get(op.peek()) >= priority.get(c)) {
							postfix.append(op.pop());
						}
						op.push(c);
					}
				}
			} // for
			while(!op.isEmpty())
				postfix.append(op.pop());
			
			Stack<Integer> result = new Stack<>();
			for(int i = 0; i < postfix.length(); i++) {
				char c = postfix.charAt(i);
				
				int num1 = 0;
				int num2 = 0;
				
				if(c >= '0' && c <= '9') {
					result.push(c - '0');
				}
				else if(c == '+') {
					num2 = result.pop();
					num1 = result.pop();
					
					result.push(num1 + num2);
				}
				else {
					num2 = result.pop();
					num1 = result.pop();
					
					result.push(num1 * num2);
				}
			}//for
			
			System.out.println("#" + tc + " " + result.pop());
		} // tc
	} // main
}
