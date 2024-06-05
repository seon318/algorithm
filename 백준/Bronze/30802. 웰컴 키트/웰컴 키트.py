import sys
input = sys.stdin.readline

n = int(input())
tshirt = list(map(int, input().split()))
t, p = map(int, input().split())

sum = 0
for i in tshirt:
    sum += i // t
    if i % t != 0:
        sum += 1
print(sum)
print(n//p, n%p) 