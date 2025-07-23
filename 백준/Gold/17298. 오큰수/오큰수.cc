#include <iostream>
#include <stack>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, num, big = 0;
  cin >> N;
  stack<int> s;
  int a[1000001], nge[1000001];
  for (int i = 0; i < N; i++) cin >> a[i];
  for (int i = 0; i < N; i++) {
    while (!s.empty() && a[s.top()] < a[i]) {
      nge[s.top()] = a[i];
      s.pop();
    }
    s.push(i);
  }
  while (!s.empty()) {
    nge[s.top()] = -1;
    s.pop();
  }
  for (int i = 0; i < N; i++) cout << nge[i] << ' ';
  return 0;
}