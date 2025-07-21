#include <iostream>
#include <vector>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n, x, ans = 0, cnt[1000001] = {0};
  cin >> n;
  vector<int> arr(n);
  for (int i = 0; i < n; i++) cin >> arr[i];
  cin >> x;
  for (int i = 0; i < n; i++) {
    if (x - arr[i] >= 1 && x - arr[i] <= 1000000) ans += cnt[x - arr[i]];
    cnt[arr[i]]++;
  }
  cout << ans;
  return 0;
}