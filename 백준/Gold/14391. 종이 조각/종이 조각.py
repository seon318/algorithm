def rip_paper():
    answer = 0
    # 비트마스크로 경우의 수 모두 따져보기
    for bitmask in range(1 << (n * m)):
        total = 0
        # 가로 합
        for i in range(n):
            sum1 = 0
            for j in range(m):
                idx = i * m + j
                if bitmask & (1 << idx) != 0: # 가로일 때
                    sum1 = sum1 * 10 + paper[i][j]
                else: # 세로일 때 초기화
                    total += sum1
                    sum1 = 0
            total += sum1
        
        # 세로 합
        for j in range(m):
            sum2 = 0
            for i in range(n):
                idx = i * m + j
                if bitmask & (1 << idx) == 0: # 세로일 때
                    sum2 = sum2 * 10 + paper[i][j]
                else: # 가로일 때 초기화
                    total += sum2
                    sum2 = 0
            total += sum2
        answer = max(answer, total)
    return answer
    
n, m = map(int, input().split())
paper = [list(map(int, input())) for _ in range(n)]
print(rip_paper())
