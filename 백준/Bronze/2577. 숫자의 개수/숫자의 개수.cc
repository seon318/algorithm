#include <iostream>
#include <string>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int A, B, C, cnt[10] = {0};
  cin >> A >> B >> C;
  string s = to_string(A * B * C);
  for (auto c : s)
    cnt[c - '0']++;
  for (int i = 0; i < 10; i++)
    cout << cnt[i] << '\n';
  return 0;
}