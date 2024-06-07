import sys
input = sys.stdin.readline

n = int(input())
stack, ans = [], []
now = 1

for _ in range(n):
    num = int(input())
    while now <= num:
        stack.append(now)
        ans.append('+')
        now += 1
    if stack[-1] == num:
        stack.pop()
        ans.append('-')
    else:
        print('NO')
        exit(0)

print('\n'.join(ans))