#include <iostream>
#include <vector>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, v, ans = 0; cin >> N;
  vector<int> arr(N);
  for (int i = 0; i < N; i++) cin >> arr[i];
  cin >> v;
  for (int i = 0; i < N; i++) if (arr[i] == v) ans++;
  cout << ans;
  return 0;
}