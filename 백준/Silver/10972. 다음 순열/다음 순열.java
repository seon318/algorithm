import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int i = n - 1;
		while (i > 0 && arr[i - 1] >= arr[i]) --i;
		if (i == 0) {
			System.out.println(-1);
			return;
		}
		int j = n - 1;
		while (j > 0 && arr[i - 1] >= arr[j]) --j;
		swap(i - 1, j);
		int k = n - 1;
		while (i < k) swap(i++, k--);
		StringBuilder sb = new StringBuilder();
		for (int a = 0; a < n; a++) {
			sb.append(arr[a] + " ");
		}
		System.out.println(sb);
	}

	static void swap(int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
}

