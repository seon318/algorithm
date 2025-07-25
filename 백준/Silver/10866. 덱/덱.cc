#include <iostream>
#include <deque>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, num; cin >> N;
  string command;
  deque<int> dq;
  while (N--) {
    cin >> command;
    if (command == "push_front") {
      cin >> num;
      dq.push_front(num);
    } else if (command == "push_back") {
      cin >> num;
      dq.push_back(num);
    } else if (command == "pop_front") {
      if (dq.empty()) cout << "-1\n";
      else {
        cout << dq.front() << '\n';
        dq.pop_front();
      }
    } else if (command == "pop_back") {
      if (dq.empty()) cout << "-1\n";
      else {
        cout << dq.back() << '\n';
        dq.pop_back();
      }
    } else if (command == "size") cout << dq.size() << '\n';
    else if (command == "empty") cout << (dq.empty() ? 1 : 0) << '\n';
    else if (command == "front") cout << (dq.empty() ? -1 : dq.front()) << '\n';
    else if (command == "back") cout << (dq.empty() ? -1 : dq.back()) << '\n';
  }
  return 0;
}