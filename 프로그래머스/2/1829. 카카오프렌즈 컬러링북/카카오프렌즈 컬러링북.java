import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int num = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] == 0 || visited[i][j]) continue;
                numberOfArea++;
                num = 1;
                visited[i][j] = true;
                queue.add(new int[] {i, j, picture[i][j]});
                while (!queue.isEmpty()) {
                    int[] tmp = queue.poll();
                    int x = tmp[0];
                    int y = tmp[1];
                    int z = tmp[2];
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (0 > nx || nx >= m || 0 > ny || ny >= n || visited[nx][ny] ||
                           picture[nx][ny] != z) continue;
                        visited[nx][ny] = true;
                        num++;
                        queue.add(new int[] {nx, ny, z});
                    }
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, num);
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}