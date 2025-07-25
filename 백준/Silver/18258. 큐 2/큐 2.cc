#include <iostream>
#include <queue>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, num; cin >> N;
  string command;
  queue<int> q;
  while (N--) {
    cin >> command;
    if (command == "push") {
      cin >> num;
      q.push(num);
    } else if (command == "pop") {
      if (q.empty()) cout << "-1\n";
      else {
        cout << q.front() << '\n';
        q.pop();
      }
    } else if (command == "size") cout << q.size() << '\n';
    else if (command == "empty") cout << (q.empty() ? 1 : 0) << '\n';
    else if (command == "front") cout << (q.empty() ? -1 : q.front()) << '\n';
    else if (command == "back") cout << (q.empty() ? -1 : q.back()) << '\n';
    }
  return 0;
}