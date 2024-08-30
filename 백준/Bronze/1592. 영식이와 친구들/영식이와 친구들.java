import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		int now = 0;
		int cnt = 0;
		arr[now] = 1;
		
		while (arr[now] != m) {
			cnt++;
			if (arr[now] % 2 == 1) {
				now = (now + l) % n;
			} else now = (now - l + n) % n; 
			arr[now]++;
		}
		
		System.out.println(cnt);
	}
}