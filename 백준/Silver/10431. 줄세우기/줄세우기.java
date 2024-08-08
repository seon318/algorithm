import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int p = Integer.parseInt(br.readLine());
		int t, tmp, num;
		int[] arr = new int[20];
		for (int tc = 0; tc < p; tc++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			for (int i = 0; i < 20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			num = 0;
			for (int i = 0; i < 20; i++) {
				for (int j = i+1; j < 20; j++) {
					if (arr[i] > arr[j]) {
						tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
						num++;
					}
				}
			}
			
			System.out.println(t + " " + num);
		}
	}
}