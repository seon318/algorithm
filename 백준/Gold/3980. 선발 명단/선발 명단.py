def lineup(a, score):
    global max_score
    #11명 다 더한 경우 max_score  갱신 후 return
    if a == 11:
        max_score = max(score, max_score)
        return
    for i in range(11):
        #이미 포지션이 있거나 능력치가 0일 때
        if checked[i] or not stat[a][i]:
            continue
        #방문처리 후 재귀함수 실행 후 방문처리 지우기
        checked[i] = 1
        lineup(a+1, score + stat[a][i])
        checked[i] = 0

c = int(input()) #테스트 케이스
for i in range(c):
    stat = [] #능력치 정보
    checked = [0] * 11 #포지션 정해졌는지 여부
    max_score = 0 #능력치 합 최댓값
    for i in range(11):
        stat.append(list(map(int, input().split())))
    lineup(0, 0)
    print(max_score)