#include <iostream>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int N, time, Y = 0, M = 0;
  cin >> N;
  for (int i = 0; i < N; i++) {
    cin >> time;
    Y += time / 30 + ((time + 1) % 30 == 0 ? 0 : 1);
    M += time / 60 + ((time + 1) % 60 == 0 ? 0 : 1);
  }
  Y *= 10;
  M *= 15;
  if (Y < M) cout << "Y " << Y;
  else if (Y > M) cout << "M " << M;
  else cout << "Y M " << Y;
  return 0;
}