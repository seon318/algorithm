#include <iostream>
#include <list>
#include <stack>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, x = 1, num;
  cin >> n;
  stack<int> s;
  list<char> l;
  while (n--) {
    cin >> num;
    if (s.empty()) {
      s.push(x++);
      l.push_back('+');
    }
    if (s.top() > num) {
      cout << "NO";
      return 0;
    }
    while (s.top() < num) {
      s.push(x++);
      l.push_back('+');
    }
    s.pop();
    l.push_back('-');
  }
  for (auto c : l) {
    cout << c << '\n';
  }
  return 0;
}