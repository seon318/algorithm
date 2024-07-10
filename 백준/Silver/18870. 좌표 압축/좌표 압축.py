import sys
n = int(input())
x = list(map(int, sys.stdin.readline() .split()))
x_sort = list(sorted(set(x)))
x_sort = {x_sort[i]:i for i in range(len(x_sort))}
print(*[x_sort[i]for i in x])