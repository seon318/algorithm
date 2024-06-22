n = int(input())
students = []
for i in range(n):
    students.append(input().split())

#람다식을 이용한 다중조건 정렬
students.sort(key=lambda x:(-int(x[1]),int(x[2]), -int(x[3]), x[0]))

for students in students:
    print(students[0])