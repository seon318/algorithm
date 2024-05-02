#접근 1 - 시간초과
# #순열 라이브러리
# from itertools import permutations

# n = int(input()) #반복횟수
# for i in range(n):
#     word = str(input()) #단어 입력 받기
#     char = [i for i in word] #단어 구성 문자 분리
#     perm = set(map(''.join, permutations(char))) #순열, 중복제거
#     perm = list(perm) #리스트로 바꿔주기
#     perm.sort() #사전순 정렬
#     idx = perm.index(word) #입력 단어의 인덱스 찾기
#     if len(perm) == idx+1: #마지막 단어인 경우 그대로 출력
#         print(word)
#     else: #입력 단어 다음 단어 출력
#         print(perm[idx+1])

#접근 2
def next(w):
    #왼쪽에 있는 수보다 오른쪽에 있는 수가 더 큰 경우 찾음
    for i in range(len(w)-1, 0, -1):
        if w[i-1] < w[i]:
            #오른쪽에서부터 idx 보다 큰 숫자인 경우를 찾음
            for j in range(len(w)-1, i-1, -1):
                #두 수의 위치를 바꿔주고 i부터 마지막까지 원소 뒤집기
                if w[i-1] < w[j]:
                    w[i-1], w[j] = w[j], w[i-1]
                    return (w[:i] + (w[i:][::-1]))
    return w #해당 안 되는 경우 그대로 출력(마지막 순서인 경우)

n = int(input()) #반복횟수
for i in range(n):
    word = list(input().strip()) #단어 입력 받기
    result = ''.join(next(word))
    print(result)