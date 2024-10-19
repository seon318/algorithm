import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, k, l, a, b;
	static int[][] board;
	static Queue<int[]> queue = new LinkedList<>();
	static Deque<int[]> snake = new LinkedList<>();
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	
    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			board[a][b] = 1;
		}
		l = Integer.parseInt(br.readLine());
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			queue.add(new int[] {a, st.nextToken().charAt(0) == 'D' ? 1 : -1});
		}
		
		snake.add(new int[] {0, 0});
		
		int time = 0;
		int dir = 0;
		outer : while (true) {
			time++;
			int r = snake.peek()[0] + dr[dir];
			int c = snake.peek()[1] + dc[dir];
			if (!isValid(r, c)) break;
			for (int[] loc : snake) {
				if (loc[0] == r && loc[1] == c) break outer;
			}
			if (board[r][c] == 0) snake.pollLast();
			else board[r][c] = 0;
			snake.addFirst(new int[] {r, c});
		
			if (!queue.isEmpty() && queue.peek()[0] == time) {
				dir = (dir + queue.poll()[1] + 4) % 4;
			}
		}
		
		System.out.println(time);
    }

	private static boolean isValid(int r, int c) {
		return 0 <= r && 0 <= c && r < n && c < n;
	}
}