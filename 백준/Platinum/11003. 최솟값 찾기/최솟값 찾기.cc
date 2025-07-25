#include <iostream>
#include <deque>
#include <algorithm>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, L, x; cin >> N >> L;
  deque<pair<int, int>> dq;
  for (int i = 0; i < N; i++) {
    cin >> x;
    while (!dq.empty() && dq.back().first > x) dq.pop_back();
    dq.push_back({x, i});
    if (dq.front().second <= i - L) dq.pop_front();
    cout << dq.front().first << ' ';
  }
  return 0;
}