#include <iostream>
#include <string>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  string N;
  int ans = 0, cnt[10] = {0};
  cin >> N;
  for (auto c : N)
    cnt[c - '0']++;
  cnt[6] = (cnt[6] + cnt[9]) / 2 + (cnt[6] + cnt[9]) % 2;
  for (int i = 0; i < 9; i++)
    if (cnt[i] > ans) ans = cnt[i];
  cout << ans;
  return 0;
}