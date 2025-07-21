#include <iostream>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int ans = 0, cnt[26] = {0};
  string s1, s2;
  cin >> s1 >> s2;
  for (auto c : s1) cnt[c - 'a']++;
  for (auto c : s2) cnt[c - 'a']--;
  for (int i = 0; i < 26; i++) if (cnt[i] != 0) ans += abs(cnt[i]);
  cout << ans;
  return 0;
}