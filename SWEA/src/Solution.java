import java.util.Scanner;

public class Solution {
	static int V;
	static int E;
	static boolean[] visited;
	static int[][] tree;
	static int find1, find2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			V = sc.nextInt();
			E = sc.nextInt();
			find1 = sc.nextInt();
			find2 = sc.nextInt();
			
			tree = new int[V + 1][3];
			
			for(int i = 0; i < E; i++) {
				int parent = sc.nextInt();
				int child = sc.nextInt();
				
				if(tree[parent][0] == 0) {
					tree[parent][0] = child;
				}
				else {
					tree[parent][1] = child;
				}
				
				tree[child][2] = parent;
			}
			
			int root = find(find1, find2);
			
			System.out.println("#" + tc + " " + root + " " + size(root));
		}
	}
	
	static int find(int find1, int find2) {
		visited = new boolean[V + 1];
		while(find1 != 0) {
			visited[find1] = true;
			find1 = tree[find1][2];
		}
		
		while(find2 != 0) {
			if(visited[find2] == true) return find2;
			find2 = tree[find2][2];
		}
		
		return 0;
	}
	
	static int size(int root) {
		if(root == 0) return 0;
		return 1 + size(tree[root][0]) + size(tree[root][1]);
	}
}
