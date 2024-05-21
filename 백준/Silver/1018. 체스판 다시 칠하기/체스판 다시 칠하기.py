N, M = map(int,input().split())
board = []
result = []
for i in range(N):
    a = input()
    board.append(a)

for i in range(N-7):
    for j in range(M-7):
        error1 = 0
        error2 = 0
        for a in range(i, i+8):
            for b in range(j, j+8):
                if (a+b) %2 ==0:
                    if board[a][b] != "B":
                        error1 += 1
                    if board[a][b] != "W":
                        error2 += 1
                else:
                    if board[a][b] != "W":
                        error1 += 1
                    if board[a][b] != "B":
                        error2 += 1

        result.append(error1)
        result.append(error2)

print(min(result))