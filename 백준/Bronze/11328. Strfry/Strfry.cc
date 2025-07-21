#include <iostream>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, cnt[26]; cin >> N;
  string s1, s2;
  next: while (N--) {
    fill(cnt, cnt + 26, 0);
    cin >> s1 >> s2;
    for (auto c : s1) cnt[c - 'a']++;
    for (auto c : s2) cnt[c - 'a']--;
    for (int i = 0; i < 26; i++)
      if (cnt[i] != 0) {
        cout << "Impossible\n";
        goto next;
      }
    cout << "Possible\n";
  }
  return 0;
}