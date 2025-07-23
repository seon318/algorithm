#include <iostream>
#include <stack>
#include <vector>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N;
  cin >> N;
  vector<int> v(N);
  stack<int> s;
  for (int i = 0; i < N; i++) cin >> v[i];
  for (int i = 0; i < N; i++) {
    while (!s.empty() && v[s.top()] < v[i])
      s.pop();
    if (s.empty())
      cout << 0 << ' ';
    else
      cout << s.top() + 1 << ' ';
    s.push(i);
  }
  return 0;
}