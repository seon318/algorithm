import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int num = 0;
        int ord = 1;
        char prev = ' ';
        for (String word : words) {
            if (set.contains(word) || (prev != ' ' && prev != word.charAt(0))) return new int[] {num + 1, ord};
            set.add(word);
            prev = word.charAt(word.length() - 1);
            num = (num + 1) % n;
            if (num == 0) ord++;
        }
        return new int[] {0, 0};
    }
}