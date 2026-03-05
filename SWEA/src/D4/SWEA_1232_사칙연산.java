package D4;
import java.util.Scanner;
import java.util.Stack;

public class SWEA_1232_사칙연산 {
	static String[] val;
	static int[] left;
	static int[] right;
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			sc.nextLine();

			val = new String[N + 1];
			left = new int[N + 1];
			right = new int[N + 1];

			for (int i = 0; i < N; i++) {
				String[] line = sc.nextLine().split(" ");

				int idx = Integer.parseInt(line[0]);
				val[idx] = line[1];
				if (line.length >= 3)
					left[idx] = Integer.parseInt(line[2]);
				if (line.length >= 4)
					right[idx] = Integer.parseInt(line[3]);
			}
			sb = new StringBuilder();
			postOrder(1);
			String[] result = sb.toString().trim().split(" ");
			Stack<Integer> stack = new Stack<>();

			for (int i = 0; i < result.length; i++) {
				String c = result[i];
				int num1;
				int num2;
				if (c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")) {
					num2 = stack.pop();
					num1 = stack.pop();
					switch (c) {
					case "+":
						stack.push(num1 + num2);
						break;
					case "-":
						stack.push(num1 - num2);
						break;
					case "/":
						stack.push(num1 / num2);
						break;
					case "*":
						stack.push(num1 * num2);
						break;
					}
				}
				else {
					stack.push(Integer.parseInt(c));
				}

			}
			System.out.println("#" + tc + " " + stack.pop());

		}

	}

	public static void postOrder(int v) {
		if (v == 0 || v > N)
			return;
		postOrder(left[v]);
		postOrder(right[v]);
		sb.append(val[v]).append(' ');
	}
}
