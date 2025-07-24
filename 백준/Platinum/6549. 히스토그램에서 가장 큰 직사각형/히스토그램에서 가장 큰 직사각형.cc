#include <iostream>
#include <stack>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, h, w, height[100001];
  while (1) {
    cin >> n;
    if (n == 0) break;
    for (int i = 0; i < n; i++) cin >> height[i];
    stack <int> s;
    long long area, ans = 0;
    for (int i = 0; i < n; i++) {
      while (!s.empty() && height[i] < height[s.top()]) {
        int top = s.top(); s.pop();
        long long h = height[top];
        long long w = s.empty() ? i : i - s.top() - 1;
        ans = max(ans, h * w);
      }
      s.push(i);
    }
    while (!s.empty()) {
      int top = s.top(); s.pop();
      long long h = height[top];
      long long w = s.empty() ? n : n - s.top() - 1;
      ans = max(ans, h * w);
    }
    cout << ans << '\n';
  }
  return 0;
}