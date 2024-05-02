import sys

input = sys.stdin.readline

t = int(input())
for _ in range(t):
    h, w, n = map(int, input().split())
    a = (n - 1) // h + 1
    b = str((n - 1) % h + 1)
    if a < 10:
        a = '0' + str(a)
    print(b + str(a))
