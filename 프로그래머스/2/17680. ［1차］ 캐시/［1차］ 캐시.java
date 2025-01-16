import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<>();
        
        int answer = 0;

        for (String str : cities) {
            String city = str.toUpperCase();
            if (cache.contains(city)) {
                cache.remove(city);
                answer++;
            }
            else {
                if (cache.size() > 0 && cache.size() == cacheSize) cache.removeFirst();
                answer += 5;
            }
            if (cacheSize != 0) cache.addLast(city);
        }
        
        return answer;
    }
}
