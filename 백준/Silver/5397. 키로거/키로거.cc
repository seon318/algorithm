#include <iostream>
#include <string>
#include <list>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int t;
  string s;
  cin >> t;
  while (t--) {
    cin >> s;
    list<char> password;
    auto cur = password.begin();
    for (auto c : s) {
      if (c == '-') {
        if (cur != password.begin()) {
          cur--;
          password.erase(cur++);
        }
      } else if (c == '<') {
        if (cur != password.begin()) cur--;
      } else if (c == '>') {
        if (cur != password.end()) cur++;
      } else {
        password.insert(cur, c);
      }
    }
    cout << string(password.begin(), password.end()) << '\n';
  }
  return 0;
}