#include <iostream>
#include <string>
#include <list>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string s;
  int M;
  char command, c;
  cin >> s >> M;
  list<char> l(s.begin(), s.end());
  auto cur = l.end();

  for (int i = 0; i < M; i++) {
    cin >> command;
    switch (command) {
      case 'L' :
        if (cur != l.begin()) {
          cur--;
        }
        break;
      case 'D' :
        if (cur != l.end()) {
          cur++;
        }
        break;
      case 'B' :
        if (cur != l.begin()) {
          cur--;
          l.erase(cur++);
        }
        break;
      case 'P' :
        cin >> c;
        l.insert(cur, c);
        break;
    }
  }
  cout << string(l.begin(), l.end()) << endl;
  return 0;
}