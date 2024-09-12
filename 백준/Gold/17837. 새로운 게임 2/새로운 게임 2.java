import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Piece {
		int id, r, c, d;

		public Piece(int id, int r, int c, int d) {
			this.id = id;
			this.r = r;
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Piece [id=" + id + ", r=" + r + ", c=" + c + ", d=" + d + "]";
		}
	}

	static int n, k, r, c, d, nr, nc, turn, ans;
	static Piece tmp;
	static List<Piece> pieces;
	static Queue<Piece> newQueue = new LinkedList<>();
	static Deque<Piece>[][] board;
	static Deque<Piece> curr, next, move = new ArrayDeque<>();
	static int[][] color;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		color = new int[n][n];
		board = new ArrayDeque[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
				board[i][j] = new ArrayDeque<>();
			}
		}

		pieces = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken()) - 1;
			d = Integer.parseInt(st.nextToken());
			board[r][c].addLast(new Piece(i + 1, r, c, d));
			pieces.add(board[r][c].peekLast());
		}

		ans = -1;
		turn = 0;
		outer: while (++turn <= 1000) {

			for (Piece piece : pieces) {
				d = piece.d;
				nr = piece.r + dr[d];
				nc = piece.c + dc[d];
				if (isBlue(nr, nc)) {
					d = piece.d = (d % 2 == 0) ? d - 1 : d + 1;
					nr = piece.r + dr[d];
					nc = piece.c + dc[d];
					if (isBlue(nr, nc)) {
						continue;
					}
				}
				
				curr = board[piece.r][piece.c];
				next = board[nr][nc];

				while (!curr.isEmpty()) {
					tmp = curr.pollLast();
					move.addFirst(tmp);
					if (tmp.id == piece.id) break; 
				}
				
				if (isRed(nr, nc)) {
					while (!move.isEmpty()) {
						tmp = move.pollLast();
						next.addLast(tmp);
						tmp.r = nr;
						tmp.c = nc;
					}
				} else {
					while (!move.isEmpty()) {
						tmp = move.pollFirst();
						next.addLast(tmp);
						tmp.r = nr;
						tmp.c = nc;
					}
				}
				
				if (board[nr][nc].size() >= 4) {
					ans = turn;
					break outer;
				}

			}
		}

		System.out.println(ans);
	}

	static boolean isBlue(int x, int y) {
		return x < 0 || y < 0 || x >= n || y >= n || color[x][y] == 2;
	}

	static boolean isRed(int x, int y) {
		return color[x][y] == 1;
	}
}