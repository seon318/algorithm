import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[w];
		int max = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < w; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (arr[max] < arr[i]) max = i;
		}
		
		int cnt = 0;
		int tmp = 0;
		for (int i = 0; i < max; i++) {
			if (tmp < arr[i]) tmp = arr[i];
			cnt += tmp - arr[i];
		}
		
		tmp = 0;
		for (int i = w - 1; i > max; i--) {
			if (tmp < arr[i]) tmp = arr[i];
			cnt += tmp - arr[i];
		}
		
		System.out.println(cnt);
	}
}
