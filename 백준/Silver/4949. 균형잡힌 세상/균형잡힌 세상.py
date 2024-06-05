import sys
input = sys.stdin.readline

while True:
    s = input().rstrip()
    if s == '.':
        break

    x = ''
    balance = True
    for i in range(len(s)):
        if s[i] == '(' or s[i] == '[':
            x += s[i]
        elif s[i] == ')':
            if len(x) == 0 or x[-1] != '(':
                balance = False
                break
            else:
                x = x[:-1]
        elif s[i] == ']':
            if len(x) == 0 or x[-1] != '[':
                balance = False
                break
            else:
                x = x[:-1]
    if x != '':
        balance = False
    if balance:
        print('yes')
    else:
        print('no')