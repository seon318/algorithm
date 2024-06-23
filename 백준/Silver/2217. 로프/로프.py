n = int(input()) #로프 개수
arr = [] #중량 정보
#중량 정보 추가
for i in range(n):
    arr.append(int(input()))
arr.sort() #오름차순 정렬

answer = 0 #초기화
# i * i보다 큰 수의 개수와 answer 중의 최대값 비교
for i in range(n):
    answer = max(answer, arr[i] * (n-i))

print(answer)