#include <iostream>
#include <utility>
#include <stack>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, h, cnt; cin >> N;
  long long ans = 0;
  stack <pair<int, int>> s;
  while (N--) {
    cin >> h;
    cnt = 1;
    while (!s.empty() && s.top().first <= h) {
      ans += s.top().second;
      if (s.top().first == h) cnt += s.top().second;
      s.pop();
    }
    if (!s.empty()) ans++;
    s.push({h, cnt});
  }
  cout << ans;
  return 0;
}