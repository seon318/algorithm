#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    int T;
    string s;
    cin >> T;
  
    while (T--) {
      cin >> s;
      stack<char> st;
      for (char c : s) {
        if (st.empty()) st.push(c);
        else if (st.top() == '(' && c == ')') st.pop();
        else st.push(c);
      }
      cout << (st.empty() ? "YES\n" : "NO\n");
    }
    return 0;
}
