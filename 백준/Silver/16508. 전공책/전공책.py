import sys
input = sys.stdin.readline

def word_making(x, p, a):
    global price
    result = True
    for i in range(26):
        if x[i] < word[i]:
            result = False
            break
    if result:
        price = min(price, p)
        return
    for i in range(a, n):
            new_x = [x[j] + arr[i][j] for j in range(26)] 
            word_making(new_x, p + int(books[i][0]), i+1)

t = input().rstrip()
n = int(input())
books = sorted([input().split() for _ in range(n)])

alpha = [chr(i) for i in range(65, 91)]
word = [0] * 26

for i in t:
    idx = alpha.index(i)
    word[idx] += 1

arr = []
for book in books:
    row = [0] * 26
    for i in book[1]:
        idx = alpha.index(i)
        row[idx] += 1
    arr.append(row)

price = float("inf")
x = [0] * 26
word_making(x, 0, 0)

if price == float("inf"):
    print(-1)
else:
    print(price)