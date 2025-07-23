#include <iostream>
#include <stack>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, h;
  long long sum = 0;
  cin >> N;
  stack<int> s;
  while (N--) {
    cin >> h;
    while (!s.empty() && s.top() <= h) s.pop();
    sum += s.size();
    s.push(h);
  }
  cout << sum;
  return 0;
}