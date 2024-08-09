import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n, num, max;
		int t = Integer.parseInt(br.readLine());
		int[] arr;

		// 1. 입력
		for (int tc = 1; tc <= t; tc++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// 2. 단조 증가하는 수 최댓값 갱신
			max = -1;
			for (int i = 0; i < n; i++) {
				out: for (int j = i + 1; j < n; j++) {
					num = arr[i] * arr[j];
					// 만약 뒤 숫자가 감소할 경우 다음 num으로 넘어감
					if (num > max) {
						for (int k = 1; k < (num + "").length(); k++) {
							if ((num + "").charAt(k) < (num + "").charAt(k - 1))
								continue out;
						}
                        max = num; // 최댓값 갱신
					}

				}
			}
			// 3. 출력
			bw.append("#" + tc + " " + max + "\n");
		}

		bw.flush();
	}
}
