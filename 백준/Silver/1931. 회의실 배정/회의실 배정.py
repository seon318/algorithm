import sys
input = sys.stdin.readline
            
n = int(input())
timetable = [tuple(map(int, input().split())) for _ in range(n)]

timetable.sort(key= lambda x: (x[1], x[0]))
result = 0
end_time = 0

for x, y in timetable:
    if x >= end_time:
        result += 1
        end_time = y

print(result)