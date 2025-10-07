#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;
    stack<char> st;
    int ans = 0, temp = 1;
    bool valid = true;

    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '(') {
            temp *= 2;
            st.push('(');
        }
        else if (s[i] == '[') {
            temp *= 3;
            st.push('[');
        }
        else if (s[i] == ')') {
            if (st.empty() || st.top() != '(') {
                valid = false;
                break;
            }
            if (s[i - 1] == '(') ans += temp;
            st.pop();
            temp /= 2;
        }
        else if (s[i] == ']') {
            if (st.empty() || st.top() != '[') {
                valid = false;
                break;
            }
            if (s[i - 1] == '[') ans += temp;
            st.pop();
            temp /= 3;
        }
    }

    if (!valid || !st.empty()) cout << 0;
    else cout << ans;
}
