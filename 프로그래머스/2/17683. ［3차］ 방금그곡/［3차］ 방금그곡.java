import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxTime = 0;
        int len = m.length();
        List<Character> melody = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (i < len - 1 && m.charAt(i + 1) == '#') {
                melody.add(Character.toLowerCase(m.charAt(i)));
                i++;
            } else melody.add(m.charAt(i));
        }
        int mLen = melody.size();

        for (String info : musicinfos) {
            int startHour = Integer.parseInt(info.substring(0, 2));
            int startMinute = Integer.parseInt(info.substring(3, 5));
            int endHour = Integer.parseInt(info.substring(6, 8));
            int endMinute = Integer.parseInt(info.substring(9, 11));
            String[] music = info.substring(12).split(",");
            
            int time = (endHour - startHour) * 60 + (endMinute - startMinute);
            if (time < mLen || time <= maxTime) continue;
            
            List<Character> totalMelody = new ArrayList<>();
            for (int i = 0; i < music[1].length(); i++) {
                if (i < music[1].length() - 1 && music[1].charAt(i + 1) == '#') {
                    totalMelody.add(Character.toLowerCase(music[1].charAt(i)));
                    i++;
                } else totalMelody.add(music[1].charAt(i));
            } 
            
            int tLen = totalMelody.size();
            int mIdx = 0;
            for (int i = 0; i < time; i++) {
                if (totalMelody.get(i % tLen) == melody.get(mIdx)) {
                    if (++mIdx == mLen) {
                        answer = music[0];
                        maxTime = time;
                        break;
                    }
                } else {
                    i -= mIdx;
                    mIdx = 0;
                }
            }
        }
        
        return answer;
    }
}