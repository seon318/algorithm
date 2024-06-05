import sys
input = sys.stdin.readline

l = int(input())
str = input().rstrip()
ans = 0

for i in range(l):
    x = ord(str[i]) - 96
    ans += x * (31 ** i)

print(ans  % 1234567891)