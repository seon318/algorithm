import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] board = new int[101];

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            board[x] = y;
        }

        boolean[] visited = new boolean[101];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int position = now[0];
            int moves = now[1];

            if (position == 100) {
                System.out.println(moves);
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int nextPos = position + i;

                if (nextPos > 100) continue;
                if (board[nextPos] != 0) nextPos = board[nextPos];
                if (!visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.add(new int[]{nextPos, moves + 1});
                }
            }
        }
    }
}
