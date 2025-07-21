#include <iostream>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, K, S, Y, cnt = 0, room[2][6] = {0};
  cin >> N >> K;
  for (int i = 0; i < N; i++) {
    cin >> S >> Y;
    room[S][Y - 1]++;
  }
  for (int i = 0; i < 2; i++) {
    for (int j = 0; j < 6; j++) {
      cnt += room[i][j] / K + (room[i][j] % K > 0 ? 1 : 0);
    }
  }
  cout << cnt;
  return 0;
}