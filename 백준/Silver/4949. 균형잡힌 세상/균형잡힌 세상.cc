#include <iostream>
#include <string>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;

    while (true) {
        getline(cin, s);
        if (s == ".") break; 

        stack<char> st;
        bool balanced = true;

        for (char c : s) {
            if (c == '(' || c == '[') {
                st.push(c);
            }
            else if (c == ')') {
                if (st.empty() || st.top() != '(') {
                    balanced = false;
                    break;
                }
                st.pop();
            }
            else if (c == ']') {
                if (st.empty() || st.top() != '[') {
                    balanced = false;
                    break;
                }
                st.pop();
            }
        }

        if (!st.empty()) balanced = false;

        cout << (balanced ? "yes\n" : "no\n");
    }

    return 0;
}
