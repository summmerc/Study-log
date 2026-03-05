package D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_14229_백만개의정수정렬 {
	static int[] arr;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line = br.readLine();
		
		StringTokenizer st = new StringTokenizer(line);
		int N = 1000000;
		arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(0, N - 1);
		System.out.println(arr[500000]);
	}
	
	static void quickSort(int left, int right) {
		if(left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}
	
	static int partition(int left, int right) {
		int pivot = arr[left];
		int l = left + 1;
		int r = right;
		
		while(l <= r) {
			while(l <= r && arr[l] <= pivot) l++;
			while(arr[r] > pivot) r--;
			if(l < r)
				swap(l, r);	
		}
		swap(left, r);
		return r;
	}
	
	static void swap(int num1, int num2) {
		int tmp = arr[num1];
		arr[num1] = arr[num2];
		arr[num2] = tmp;
	}
}
