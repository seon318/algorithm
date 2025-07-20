#include <iostream>
#include <algorithm>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int x, num = 100, sum = 0;
  for (int i = 0; i < 7; i++) {
    cin >> x;
    if (x % 2 == 1) {
      num = min(x, num);
      sum += x;
    }
  }
  if (sum == 0) cout << -1;
  else cout << sum << '\n' << num;
  return 0;
}