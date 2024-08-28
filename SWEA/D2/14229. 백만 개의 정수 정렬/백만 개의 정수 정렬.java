import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr = new int[1000000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		quickSort(0, 999999);
		System.out.println(arr[500000]);
	}
	
	static void quickSort(int left, int right) {
		if (left < right) {
			int pivot = partition(left, right);
			quickSort(left, pivot - 1);
			quickSort(pivot + 1, right);
		}
	}
	
	static int partition(int left, int right) {
		int pivot = arr[left];
		int L = left + 1;
		int R = right;
		
		while (L <= R) {
			while (L <= R && arr[L] <= pivot) L++;
			while (arr[R] > pivot) R--;
			
			if (L < R) {
				int tmp = arr[L];
				arr[L] = arr[R];
				arr[R] = tmp;
			}
		}
		int tmp = arr[left];
		arr[left] = arr[R];
		arr[R] = tmp;
		 
		return R;
	}
}