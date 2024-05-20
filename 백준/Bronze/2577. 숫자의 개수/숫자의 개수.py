a = int(input())
b = int(input())
c = int(input())

result = a * b * c
for i in range(10):
    print(len([x for x in str(result) if x == str(i)]))