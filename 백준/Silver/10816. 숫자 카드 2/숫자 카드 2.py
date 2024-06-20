import sys
input = sys.stdin.readline

count = [0] * 20000001

n = int(input().rstrip())
num = list(map(int, input().rstrip() .split()))
for i in num:
    count[i+10000000] += 1

m = int(input().rstrip())
check = list(map(int, input() .rstrip().split()))

for i in check:
    print(count[i+10000000], end =" ")