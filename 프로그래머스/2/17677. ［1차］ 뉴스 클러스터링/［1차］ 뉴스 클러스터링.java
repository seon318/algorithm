import java.util.*;

class Solution {
    Map<String, Integer> map1 = new HashMap<>();
    Map<String, Integer> map2 = new HashMap<>();

    public int solution(String str1, String str2) {
        seperate(str1, map1);
        seperate(str2, map2);

        int hap = 0, gyo = 0;
            
        for (String str : map1.keySet()) {
            if (map2.containsKey(str)) {
                hap += Math.max(map1.get(str), map2.get(str));
                gyo += Math.min(map1.get(str), map2.get(str));
            }
            else {
                hap += map1.get(str);
            }
        }
        
        for (String str : map2.keySet()) {
            if (!map1.containsKey(str)) hap += map2.get(str);
        }
        
        int answer = gyo + hap == 0 ? 65536 : (int) (65536 * gyo / hap);
        return answer;
    }
    
    void seperate(String str, Map<String, Integer> map) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);
            if (Character.isUpperCase(now)) list.add(now);
            else if (Character.isLowerCase(now)) list.add(Character.toUpperCase(now));
            else list.add(' ');
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == ' ' || list.get(i + 1) == ' ') continue;
            String pair = list.get(i) + "" + list.get(i + 1);
            if (map.containsKey(pair)) map.put(pair, map.get(pair) + 1);
            else map.put(pair, 1);
        }
    }
    
    
}