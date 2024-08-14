import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[2 * n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 2 * n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = n - 1;
		int nextPos;
		int stage = 0;
		int zero = 0;
		LinkedList<Integer> robots = new LinkedList<>();
		
		 while (zero < k) {
	            stage++;

	            // 1. 벨트 회전
	            start = (start + 2 * n - 1) % (2 * n);
	            end = (end + 2 * n - 1) % (2 * n);

	            // 2. 기존 위치 로봇 내리기
	            if (!robots.isEmpty() && robots.peek() == end) {
	                robots.poll();
	            }

	            // 3. 로봇 이동
	            for (int i = 0; i < robots.size(); i++) {
	                nextPos = (robots.get(i) + 1) % (2 * n);

	                if (arr[nextPos] > 0 && !robots.contains(nextPos)) {
	                    robots.set(i, nextPos);
	                    if (arr[nextPos]-- == 1)
	                        zero++;
	                }
	            }

	            // 4. 이동한 위치 로봇 내리기
	            if (!robots.isEmpty() && robots.peek() == end) {
	                robots.poll();
	            }

	            // 5. 로봇 올리기
	            if (arr[start] > 0) {
	                robots.add(start);
	                if (arr[start]-- == 1)
	                    zero++;
	            }
	        }
		System.out.println(sb.append(stage));
	}
}
