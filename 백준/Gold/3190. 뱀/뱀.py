n = int(input())  # 보드의 크기
k = int(input())  # 사과의 개수
board = [[0] * n for _ in range(n)]
# 사과의 위치
for _ in range(k):
    a, b = map(int, input().split())
    board[a - 1][b - 1] = 1

l = int(input())  # 뱀의 방향 변환 횟수
rotate = []
# 뱀의 방향 변환 정보
for _ in range(l):
    x, c = input().split()
    rotate.append((int(x), c))

snake = [(0, 0)]  # 뱀의 현재 위치
move = [(0, 1), (1, 0), (0, -1), (-1, 0)]  # 우, 하, 좌, 상 순서
head = 0  # 머리 방향
count = 0  # 초
x, y = 0, 0  # 현재 뱀의 머리 위치
while True:  # 벽에 닿거나 자기 몸과 부딪힐 때까지
    count += 1
    # 머리 이동
    x, y = x + move[head][0], y + move[head][1]
    # 벽에 닿거나 자기 몸과 부딪히는지 확인
    if not (0 <= x < n and 0 <= y < n) or (x, y) in snake[1:]:
        break
    # 머리 이동한 위치에 사과가 있다면
    if board[x][y] == 1:
        board[x][y] = 0  # 사과를 먹고
    else:  # 사과가 없다면
        snake.pop()  # 꼬리 이동
    snake.insert(0, (x, y))  # 머리 이동
    # 방향 변환 시간인 경우 방향 변환
    if rotate and count == rotate[0][0]:
        _, direction = rotate.pop(0)
        if direction == 'D':
            head = (head + 1) % 4
        else:
            head = (head - 1) % 4

print(count)
