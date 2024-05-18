n, m, r = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

num = min(n//2, m//2)  # 그룹의 개수
group = []

# 1차원 배열로 만들기
for i in range(num):
    top_row = arr[i][i:m-i]
    right_col = [arr[j][m-i-1] for j in range(i+1, n-i-1)]
    bottom_row = arr[n-i-1][i+1:m-i][::-1]
    left_col = [arr[j][i] for j in range(n-i-1, i, -1)]
    group.append(top_row + right_col + bottom_row + left_col)

# r회 돌리기
for i in range(num):
    a = r % len(group[i])
    group[i] = group[i][a:] + group[i][:a]

# 2차원 배열로 다시 만들기
for i in range(num):
    idx = 0
    # 위쪽 행
    for j in range(i, m-i):
        arr[i][j] = group[i][idx]
        idx += 1
    # 오른쪽 열
    for j in range(i+1, n-i-1):
        arr[j][m-i-1] = group[i][idx]
        idx += 1
    # 아래쪽 행
    for j in range(m-i-1, i-1, -1):
        arr[n-i-1][j] = group[i][idx]
        idx += 1
    # 왼쪽 열
    for j in range(n-i-2, i, -1):
        arr[j][i] = group[i][idx]
        idx += 1

# 출력
for row in arr:
    print(' '.join(map(str, row)))
