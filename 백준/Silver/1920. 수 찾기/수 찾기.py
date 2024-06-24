n = int(input())
arr = list(map(int, input().split()))
m = int(input())
num = list(map(int, input().split()))
arr.sort()

for i in num:
    answer = False
    start = 0
    end = len(arr)-1
    while (start <= end):
        mid = (start + end) //2
        if arr[mid] == i:
            answer = True
            break
        elif arr[mid] > i:
            end = mid - 1
        elif arr[mid] < i:
            start = mid + 1
    if answer:
        print(1)
    else:
        print(0)