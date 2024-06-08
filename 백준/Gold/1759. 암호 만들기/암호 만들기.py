l, c = map(int, input().split())
char = list(map(str, input().split()))
char.sort()
s = []
vowel = ['a', 'e', 'i', 'o', 'u']

def dfs(start):
    if len(s) == l:
        num = 0
        for i in vowel:
            if i in s:
                num += 1
        if num >= 1 and len(s)-num >= 2:
            print(''.join(s))
            return
        
    for i in range(start, c):
        if char[i] not in s:
            s.append(char[i])
            dfs(i+1)
            s.pop()
dfs(0)