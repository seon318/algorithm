import sys
input = sys.stdin.readline

def operand(c):
    global S
    if c[0] == 'add':
        S[int(c[1])] = 1
    elif c[0] == 'remove':
        S[int(c[1])] = 0
    elif c[0] == 'check':
        if S[int(c[1])]:
            print(1)
        else:
            print(0)
    elif c[0] == 'toggle':
        if S[int(c[1])]:
            S[int(c[1])] = 0
        else:
            S[int(c[1])] = 1
    elif c[0] == 'all':
        S = [1] * 21
    elif c[0] == 'empty':
        S = [0] * 21
        

m = int(input())
S = [0] * 21
for _ in range(m):
    operand(list(input().split()))