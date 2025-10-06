#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s;
    cin >> s;
    int cnt = 0;
    stack<char> st;
    for (int i = 0; i < s.size(); i++) {
      char c = s[i];
      if (i < s.size() - 1 && c == '(' && s[i + 1] == ')') cnt += st.size(), i++;
      else if (c == '(') st.push(c), cnt++;
      else st.pop();
    }
    cnt += st.size();
    cout << cnt;
    return 0;
}
