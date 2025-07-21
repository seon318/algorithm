#include <iostream>
#include <string>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int x, ans = 0, idx;
  for (int i = 1; i <= 9; i++) {
    cin >> x;
    if (x > ans) {
      ans = x;
      idx = i;
    }
  }
  cout << ans << '\n' << idx;
  return 0;
}