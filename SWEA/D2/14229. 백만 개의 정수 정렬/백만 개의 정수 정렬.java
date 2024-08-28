import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr = new int[1000000];
	static int[] tmp = new int[1000000];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 1000000; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		mergeSort(0, 999999);
		System.out.println(arr[500000]);
	}
	
	static void mergeSort(int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(left, mid);
			mergeSort(mid + 1, right);
			merge(left, mid, right);
		}
	}
	
	static void merge(int left, int mid, int right) {
		int L = left;
		int R = mid + 1;
		int idx = left;
		
		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				tmp[idx++] = arr[L++];
			} else {
				tmp[idx++] = arr[R++];
			}
		}
		
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		else if (R <= right) {
			for (int i = R; i <= right; i++) {
				tmp[idx++] = arr[i];
			}
		}
		
		for (int i = left; i <= right; i++) {
			arr[i] = tmp[i];
		}
	}
}