#include <iostream>
#include <array>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, m, ans = 0;
    cin >> n >> m;
    int maze[101][101];
    bool visited[101][101] = {false};
    string line;
    for (int i = 0; i < n; i++) {
      cin >> line;
      for (int j = 0; j < m; j++) {
        maze[i][j] = line[j] == '1' ? 1 : 0;
      }
    }

    int dx[4] = {1, 0, -1, 0}; 
    int dy[4] = {0, 1, 0, -1};
    queue<array<int, 3>> q;
    q.push({0, 0, 1});
    visited[0][0] = true;
    while (!q.empty()) {
      int x = q.front()[0];
      int y = q.front()[1];
      int z = q.front()[2];
      if (x == n - 1 && y == m - 1) {
        cout << z; return 0;
      }
      q.pop();
      for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];
        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
        if (visited[nx][ny]) continue;
        if (maze[nx][ny] == 0) continue;
        q.push({nx, ny, z + 1});
        visited[nx][ny] = true;
      }
    }
}
