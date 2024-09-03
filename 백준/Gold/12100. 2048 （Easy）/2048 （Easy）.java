import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static int n, max, ans;
	static int[][] board;
	static Deque<Integer> deque;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		for (int i= 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		deque = new ArrayDeque<>();
		//상하좌우 
		for (int dir = 0; dir < 4; dir++) {
			move(dir, 0, board);
		}
		
		System.out.println(ans);
	}
	
	static void move(int d, int cnt, int[][] new_matrix) {
		if (cnt == 5) {
			max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					max = Math.max(new_matrix[i][j], max);
				}
			}
			ans = Math.max(max, ans);
			return;
		}
		
		
		int[][] matrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = new_matrix[i][j];
			}
		}
		
		switch (d) {
		case 0:
			for (int j = 0; j < n; j++) {
				for (int i = 0; i < n; i++) {
					if (!deque.isEmpty() && deque.peekLast() == matrix[i][j]) {
						deque.pollLast();
						deque.addLast(matrix[i][j] * 2);
						matrix[i][j] = 0;
						for (int k= 0; k < n; k++) {
							if (deque.isEmpty()) break;
							if (matrix[k][j] == 0) matrix[k][j] = deque.pollFirst();
						}
					} else if (matrix[i][j] != 0){
						deque.addLast(matrix[i][j]);
						matrix[i][j] = 0;
					}
				}
				for (int k= 0; k < n; k++) {
					if (deque.isEmpty()) break;
					if (matrix[k][j] == 0) matrix[k][j] = deque.pollFirst();
				}
			}
			for (int dir = 0; dir < 4; dir++) {
				move(dir, cnt + 1, matrix);
			}
			break;
			
		case 1:
			for (int j = 0; j < n; j++) {
				for (int i = n - 1; i >= 0; i--) {
					if (!deque.isEmpty() && deque.peekLast() == matrix[i][j]) {
						deque.pollLast();
						deque.addLast(matrix[i][j] * 2);
						matrix[i][j] = 0;
						for (int k= n - 1; k >= 0; k--) {
							if (deque.isEmpty()) break;
							if (matrix[k][j] == 0) matrix[k][j] = deque.pollFirst();
						}
					} else if (matrix[i][j] != 0){
						deque.addLast(matrix[i][j]);
						matrix[i][j] = 0;
					}
				}
				for (int k= n - 1; k >= 0; k--) {
					if (deque.isEmpty()) break;
					if (matrix[k][j] == 0) matrix[k][j] = deque.pollFirst();
				}
			}
			for (int dir = 0; dir < 4; dir++) {
				move(dir, cnt + 1, matrix);
			}
			break;
			
		case 2:
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!deque.isEmpty() && deque.peekLast() == matrix[i][j]) {
						deque.pollLast();
						deque.addLast(matrix[i][j] * 2);
						matrix[i][j] = 0;
						for (int k= 0; k < n; k++) {
							if (deque.isEmpty()) break;
							if (matrix[i][k] == 0) matrix[i][k] = deque.pollFirst();
						}
						
					} else if (matrix[i][j] != 0){
						deque.addLast(matrix[i][j]);
						matrix[i][j] = 0;
					}
				}
				for (int k= 0; k < n; k++) {
					if (deque.isEmpty()) break;
					if (matrix[i][k] == 0) matrix[i][k] = deque.pollFirst();
				}
			}
			for (int dir = 0; dir < 4; dir++) {
				move(dir, cnt + 1, matrix);
			}
			break;
			
		case 3:
			for (int i = 0; i < n; i++) {
				for (int j = n - 1; j >= 0; j--) {
					if (!deque.isEmpty() && deque.peekLast() == matrix[i][j]) {
						deque.pollLast();
						deque.addLast(matrix[i][j] * 2);
						matrix[i][j] = 0;
						for (int k= n - 1; k >= 0; k--) {
							if (deque.isEmpty()) break;
							if (matrix[i][k] == 0) matrix[i][k] = deque.pollFirst();
						}
					} else if (matrix[i][j] != 0){
						deque.addLast(matrix[i][j]);
						matrix[i][j] = 0;
					} 
				}
				for (int k= n - 1; k >= 0; k--) {
					if (deque.isEmpty()) break;
					if (matrix[i][k] == 0) matrix[i][k] = deque.pollFirst();
				}
			}
			for (int dir = 0; dir < 4; dir++) {
				move(dir, cnt + 1, matrix);
			}
			break;
		}
	}
}