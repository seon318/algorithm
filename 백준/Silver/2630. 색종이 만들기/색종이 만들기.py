import sys
input = sys.stdin.readline

def cut(paper, x):
    global white, blue
    hap = sum([sum(i) for i in paper])
    if hap == 0:
        white += 1
    elif hap == x*x:
        blue += 1
    else:
        cut([i[:x//2] for i in paper[:x//2]], x//2)
        cut([i[x//2:] for i in paper[:x//2]], x//2)
        cut([i[:x//2] for i in paper[x//2:]], x//2)
        cut([i[x//2:] for i in paper[x//2:]], x//2)

n = int(input())
paper = [list(map(int, input().split())) for _ in range(n)]
white = 0
blue = 0
cut(paper, n)
print(white)
print(blue)