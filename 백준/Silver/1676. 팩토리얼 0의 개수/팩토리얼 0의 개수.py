import sys
input = sys.stdin.readline

n = int(input())
x = 1
for i in range(2, n+1):
    x *= i

ans = 0
x = str(x)
for i in range(len(x)-1, 0, -1):
    if x[i] == '0':
        ans += 1
    else:
        break

print(ans)