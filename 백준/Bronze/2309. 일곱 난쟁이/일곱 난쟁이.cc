#include <iostream>
#include <algorithm>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int dwarfs[9], sum = 0;
  for (int i = 0; i < 9; i++) {
    cin >> dwarfs[i];
    sum += dwarfs[i];
  }
  sort(dwarfs, dwarfs + 9);
  for (int i = 0; i < 9; i++) {
    for (int j = i + 1; j < 9; j++) {
      if (sum - dwarfs[i] - dwarfs[j] == 100) {
        for (int k = 0; k < 9; k++) if (k != i && k != j) cout << dwarfs[k] << '\n';
        goto fin;
      }
    }
  }
  fin:
    return 0;
}