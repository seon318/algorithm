#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N, cnt = 0;
    cin >> N;
    string s;
  
    while (N--) {
      cin >> s;
      stack<char> st;
      for (char c : s) {
        if (st.empty()) st.push(c);
        else {
          if (st.top() == c) st.pop();
          else st.push(c);
        }
      }
      if (st.empty()) cnt++;
    }
    
    cout << cnt;

    return 0;
}
