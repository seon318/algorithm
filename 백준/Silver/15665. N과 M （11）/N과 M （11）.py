import sys
input = sys.stdin.readline

def dfs(s):
    #만약 수열의 길이를 만족할 경우 출력하고 return
    if len(s) == m:
        print(' '.join(map(str, s)))
        return
    #같은 수 여러 번 고르도록 추가하고 dfs 실행 뒤 빼기
    for i in range(len(arr)):
        s.append(arr[i])
        dfs(s)
        s.pop()

n, m = map(int, input().split())
arr = list(set(list(map(int, input().split())))) #중복 제거한 배열 만들기
arr = sorted(arr)
s = []
dfs(s)