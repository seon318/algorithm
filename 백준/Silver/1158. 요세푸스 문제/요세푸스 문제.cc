#include <iostream>
#include <list>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, K;
  cin >> N >> K;
  list<int> l;
  for (int i = 1; i <= N; i++) l.push_back(i);
  auto cur = l.begin();
  cout << '<';
  while (l.size() > 1) {
    for (int i = 0; i < K - 1; i++) {
      cur++;
      if (cur == l.end()) cur = l.begin();
    }
    cout << *cur << ", ";
    cur = l.erase(cur);
    if (cur == l.end()) {
      cur = l.begin();
    }
  }
  cout << *cur << '>';
  return 0;
}