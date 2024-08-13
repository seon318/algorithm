import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String command;
		int n, c, x, y;
		LinkedList<String> password = new LinkedList<>();

		for (int tc = 1; tc <= 10; tc++) {
			// 암호문 입력
			password.clear();
			n = Integer.parseInt(br.readLine());
			password.addAll(Arrays.asList(br.readLine().split(" ")));

			// 명령어 입력
			c = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < c; i++) {
				command = st.nextToken();

				// 명령어 수행
				switch (command) {
				case "I": {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						password.add(x + j, st.nextToken());
					}
					break;
				}

				case "D": {
					x = Integer.parseInt(st.nextToken());
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						password.remove(x + 1);
					}
					break;
				}

				case "A": {
					y = Integer.parseInt(st.nextToken());
					for (int j = 0; j < y; j++) {
						password.add(st.nextToken());
					}
					break;
				}
				}

			}

			// 결과 출력
			sb = new StringBuilder();
			sb.append("#" + tc + " ");
			for (int i = 0; i < 10; i++) {
                sb.append(password.get(i) + " ");
            }
			bw.append(sb).append("\n");
		}

		bw.flush();
	}
}
