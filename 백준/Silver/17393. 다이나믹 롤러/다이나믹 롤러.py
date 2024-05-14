n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
arr = []

for i in range(n):
    l, r = i+1, n-1 #이분탐색 left, right 변수
    t = i #최대 칠할 수 있는 타일 위치
    while l <= r:
        mid = (l+r) // 2 #중앙값 찾기
        if a[i] < b[mid]: #해당 칸 잉크지수가 더 작을 경우에는 right 값 갱신
            r = mid - 1
        else: #그 외 경우에는 left 값 갱신, 최대 위치 갱신
            l = mid + 1
            t = mid
    arr.append(t-i) #배열에 추가
        
print(' '.join(map(str, arr)))