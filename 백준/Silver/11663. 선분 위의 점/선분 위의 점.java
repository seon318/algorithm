import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] dots;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		dots = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			dots[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(dots);
		
		int start, end;
		for (int t = 0; t < m; t++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			if (dots[0] > end || dots[n - 1] < start) System.out.println(0);
			else System.out.println(getEndIdx(end) - getStartIdx(start) + 1);
		}
		
 	}
	
	static int getStartIdx(int x) {
		
		int left = 0;
		int right = n - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (dots[mid] < x) left = mid + 1;
			else right = mid;
		}
		return left;
	}
	
	static int getEndIdx(int x) {
		
		int left = 0;
		int right = n - 1;
		while (left < right) {
			int mid = (left + right + 1) / 2;
			if (dots[mid] > x) right = mid - 1;
			else left = mid;
		}
		return right;
	}

}