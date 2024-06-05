import sys
input = sys.stdin.readline

n = int(input())
arr = [tuple(map(int, input().split())) for _ in range(n)]

grade = []
for x, y in arr:
    g = 1
    for i in range(n):
        if x < arr[i][0] and y < arr[i][1]:
            g += 1
    grade.append(g)

print(' '.join(map(str, grade)))