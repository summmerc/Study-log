package D4;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1218_괄호짝짓기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();

			Stack<Character> stack = new Stack<>();
			int check = 1;
			
			String line = sc.next();

			for (int i = 0; i < T; i++) {
				char c = line.charAt(i);
				if (c == '(' || c == '[' || c == '{' || c == '<') {
					stack.push(c);
				} else if (c == ')' || c == ']' || c == '}'  || c == '>') {
					if (stack.isEmpty()) {
						check = 0;
						break;
					}

					if ((c == ')' && stack.pop() != '(') ||
						(c == '}' && stack.pop() != '{') || 
						(c == ']' && stack.pop() != '[') ||
						(c == '>' && stack.pop() != '<')) {
						check = 0;
						break;
					}
				} // else if
			} // for
			if (check == 1 && !stack.isEmpty()) {
				check = 0;
			}
			System.out.println("#" + tc + " " + check);
		} // tc
	} // main
}
