package D4;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1222_계산기1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			int len = sc.nextInt();
			
			String line = sc.next();
			
			Stack<Character> op = new Stack<>();
			StringBuilder postfix = new StringBuilder();
			for(int i = 0; i < len; i++) {
				char c = line.charAt(i);
				
				if(c == '+') op.push(c);
				else if(c >= '0' && c <= '9') {
					postfix.append(c);
				}
			}
			while(!op.isEmpty()) {
				postfix.append(op.pop());
			}
			
			Stack<Integer> result = new Stack<>();
			for(int i = 0; i < postfix.length(); i++) {
				int num1;
				int num2;
				
				char c = postfix.charAt(i);
				
				if(c >= '0' && c <= '9') {
					result.push(c - '0');
				} else {
					num2 = result.pop();
					num1 = result.pop();
					
					result.push(num1 + num2);
				}
			}
			int sum = result.pop();
			System.out.println("#" + tc + " " + sum);
		}
	}
}
