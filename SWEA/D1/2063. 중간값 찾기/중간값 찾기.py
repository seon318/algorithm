n = int(input())
score = sorted(list(map(int, input().split())))
print(score[n // 2])