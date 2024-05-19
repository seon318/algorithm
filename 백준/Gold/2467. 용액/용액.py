import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

l, r = 0, n-1
ans = [abs(arr[0] + arr[-1]), arr[0], arr[-1]]

while l < r:
    x = arr[l] + arr[r]
    #절댓값이 더 작은 경우에만 갱신
    if abs(x) < ans[0]:
        ans = [abs(x), arr[l], arr[r]]
    elif x == 0:
        ans = [0, arr[l], arr[r]]
        break
    #두 수의 합이 0보다 큰지에 따라 포인터 위치 변경
    if x > 0:
        r -= 1
    else:
        l += 1
    
print(ans[1], ans[2])