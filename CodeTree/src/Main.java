import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int N;

	static class Person implements Comparable<Person> {
		int id;
		int s;
		int e;

		public Person(int id, int s, int e) {
			this.id = id;
			this.s = s;
			this.e = e;
		}

		@Override
		public int compareTo(Person o) {
			return this.s - o.s;
		}
	}

	static class Seat implements Comparable<Seat> {
		int num;
		int e;

		public Seat(int num, int e) {
			this.num = num;
			this.e = e;
		}

		public int compareTo(Seat o) {
			return this.e - o.e;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		Person[] people = new Person[N];

		for (int i = 0; i < N; i++) {
			people[i] = new Person(i, sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(people);

		PriorityQueue<Integer> seatQ = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			seatQ.add(i);
		}
		
		PriorityQueue<Seat> q = new PriorityQueue<>();
		
		int[] ans = new int[N];
		
		for(int i = 0; i < N; i++) {
			Person p = people[i];
			
			while(!q.isEmpty() && q.peek().e <= p.s) {
				Seat empty = q.poll();
				seatQ.add(empty.num);
			}
			
			int com = seatQ.poll();
			
			ans[p.id] = com;
			
			q.add(new Seat(com, p.e));
		}
		
		for(int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
