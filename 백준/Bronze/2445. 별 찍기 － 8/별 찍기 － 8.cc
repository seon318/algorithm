#include <iostream>
#include <string>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N; cin >> N;
  for (int i = 1; i <= N; i++) cout << string(i, '*') << string(2 * (N - i), ' ') <<  string(i, '*') << '\n';
  for (int i = 1; i < N; i++) cout << string(N - i, '*')<< string(2 * i, ' ') << string(N - i, '*')<< '\n';
  return 0;
}