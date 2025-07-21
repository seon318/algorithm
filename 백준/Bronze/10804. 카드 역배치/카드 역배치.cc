#include <iostream>
using namespace std;
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int card[20], a, b;
  for (int i = 0; i < 20; i++) card[i] = i + 1;
  for (int i = 0; i < 10; i++) {
    cin >> a >> b;
    for (int i = a - 1; i < (a + b - 1) / 2; i++) {
      swap(card[i], card[a + b - 2 - i]);
    }
  }
  for (int i = 0; i < 20; i++) cout << card[i] << ' ';
  return 0;
}