t = int(input())
for _ in range(t):
    n = int(input())
    num = [(1, 0)] + [(0, 1)] + [(0, 0) for _ in range(n - 1)]

    for i in range(2, n+1):
        num[i] = (num[i-1][0] + num[i-2][0], num[i-1][1] + num[i-2][1])
    print(' '.join(map(str, num[n])))