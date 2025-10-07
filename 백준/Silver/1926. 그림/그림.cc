#include <iostream>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int n, m;
    cin >> n >> m;
    int picture[501][501];
    bool visited[501][501] = {false};
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        cin >> picture[i][j];
      }
    } 

    int cnt = 0, size = 0, max_size = 0;
    int dx[] = {1, 0, -1, 0};
    int dy[] = {0, 1, 0, -1};
    queue<pair<int, int>> q;

    for (int i = 0; i < n; i++){
      for (int j = 0; j < m; j++) {
        if (picture[i][j] == 1 && !visited[i][j]) {
          q.push({i, j});
          visited[i][j] = true;
          size = 1, cnt++;
          while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            for (int k = 0; k < 4; k++) {
              int nx = x + dx[k];
              int ny = y + dy[k];
              if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
              if (picture[nx][ny] == 0) continue;
              if (visited[nx][ny]) continue;
              q.push({nx, ny});
              size++;
              visited[nx][ny] = true;
            }
          }
          max_size = max(max_size, size);
        }
      }
    }
    cout << cnt << '\n' << max_size;

    return 0;
}
