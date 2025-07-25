#include <iostream>
#include <deque>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int T; cin >> T;
  while (T--) {
    string p; cin >> p;
    int n; cin >> n;
    deque<int> q;
    string s; cin >> s;

    string num;
    for (int i = 1; i < s.size(); i++) {
      if (isdigit(s[i])) {
        num += s[i];
      } else if (s[i] == ',' || s[i] == ']') {
        if (!num.empty()) {
          q.push_back(stoi(num));
          num.clear();
        }
      }
    }

    bool isReverse = false, isError = false;

    for (auto c : p) {
      if (c == 'R') isReverse = !isReverse;
      else if (c == 'D') {
        if (q.empty()) {
          isError = true;
          break;
        }
        if (isReverse) q.pop_back();
        else q.pop_front();
      }
    }

    if (isError) cout << "error\n";
    else {
      cout << '[';
      if (!q.empty()) {
        if (isReverse) {
          for (auto it = q.rbegin(); it != q.rend(); ++it) {
            if (it != q.rbegin()) cout << ',';
            cout << *it;
          }
        } else {
          for (auto it = q.begin(); it != q.end(); ++it) {
            if (it != q.begin()) cout << ',';
            cout << *it;
          }
        }
      }
      cout << "]\n";
    }
  }
  return 0;
}