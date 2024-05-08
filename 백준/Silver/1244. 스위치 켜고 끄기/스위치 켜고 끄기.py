# 스위치 상태 바꾸기
def change(a):
    if switch[a] == 1:
        switch[a] = 0
    else:
        switch[a] = 1

# 입력 받기
n = int(input())
switch = list(map(int, input().split()))
s = int(input())
student = [tuple(map(int, input().split())) for _ in range(s)]

# 학생 배열에 대해 반복문 수행
for (gen, num) in student:
    # 남학생일 경우 num으로 나누어 덜어질 경우에 상태를 바꿈
    if gen == 1:
        for i in range(num-1, n, num):
            change(i)
    # 여학생의 경우 받은 번호 상태를 바꾸고 그 위치부터 양쪽을 비교해가며 상태를 바꾸다가 양쪽이 다른 경우가 나오거나 끝에 있는 원소를 확인한 뒤에는 멈춤
    else:
        num -= 1
        change(num)
        left, right = num - 1, num + 1
        while left >= 0 and right < n and switch[left] == switch[right]:
            change(left)
            change(right)
            left -= 1
            right += 1

# 20개씩 출력
for a in range((n + 19) // 20):
    print(' '.join(map(str, switch[a * 20:min((a + 1) * 20, n)])))
