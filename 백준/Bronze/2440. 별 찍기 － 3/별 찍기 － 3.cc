#include <iostream>
#include <string>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N; cin >> N;
  for (int i = 1; i <= N; i++) cout << string (N - i + 1, '*') << '\n';
  return 0;
}