n = int(input())
#배열 입력 받아서 길이에 따라 정렬하기
arr = sorted([input() for _ in range(n)], key=len)
ans = n #ans 초기화 (n을 바로 변화시키면 반복문에 문제가 생김)

#반복문을 실행하여 arr[i]와 같은 길이만큼 자른 arr[j] 값이 같을 경우 ans에서 1 빼기
for i in range(n):
    for j in range(i+1, n):
        if arr[i] == arr[j][:len(arr[i])]:
            ans -= 1
            break
print(ans)