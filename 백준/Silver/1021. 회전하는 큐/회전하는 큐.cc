#include <iostream>
#include <deque>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, M, num, idx, ans = 0; cin >> N >> M;
  deque<int> dq;
  for (int i = 1; i <= N; i++) dq.push_back(i);
  while (M--) {
    cin >> num;
    for (int i = 0; i < dq.size(); i++) {
      if (dq[i] == num) {
        idx = i;
        break;
      }
    }
    if (dq.front() != num) {
      if (idx > dq.size() / 2) {
        while (dq.front() != num) {
          dq.push_front(dq.back());
          dq.pop_back();
          ans++;
        }
      } else {
        while (dq.front() != num) {
          dq.push_back(dq.front());
          dq.pop_front();
          ans++;
        }
      }
    }
    dq.pop_front();
  }
  cout << ans;
  return 0;
}