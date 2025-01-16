import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        Stack<Character>[] stacks = new Stack[n];
        for (int i = 0; i < n; i++) stacks[i] = new Stack<>();
        char[][] blocks = new char[m][];
        for (int i = 0; i < m; i++) blocks[i] = board[i].toCharArray();
        boolean[][] erase;
        int[] dx = {1, 1, 0};
        int[] dy = {0, 1, 1};
        int cnt, idx, answer = 0;
        boolean isErased;
        
        while (true) {
            erase = new boolean[m][n];
            isErased = false;            
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (blocks[i][j] == ' ') continue;
                    cnt = 0;
                    for (int d = 0; d < 3; d++) {
                        if (blocks[i][j] == blocks[i + dx[d]][j + dy[d]]) cnt++;
                    }
                    if (cnt < 3) continue;
                    erase[i][j] = true;
                    isErased = true;
                    for (int d = 0; d < 3; d++) {
                        erase[i + dx[d]][j + dy[d]] = true;
                    } 
                }
            }
            
            if (!isErased) break;
        
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!erase[i][j]) stacks[j].add(blocks[i][j]);
                    else answer++;
                }
                Arrays.fill(blocks[i], ' ');
            }
            
            for (int i = 0; i < n; i++) {
                idx = m - 1;
                while (!stacks[i].isEmpty()) {
                    blocks[idx--][i] = stacks[i].pop();
                }
            }
        }
        
        return answer;
    }
}