import java.util.*;

class Solution {
    
    class Node {
        boolean terminal = false;
        Map<Character, Node> child = new HashMap<>();
        Node() {}
    }
    
    public boolean solution(String[] phone_book) {
        Node head = new Node();
        Node now;
        int len;
        char c;
        
        for (String str : phone_book) {
            now = head;
            len = str.length();
            for (int i = 0; i < len; i++) {
                c = str.charAt(i);
                if (!now.child.containsKey(c)) now.child.put(c, new Node());
                else if (i == len - 1) return false;
                now = now.child.get(c);
                if (now.terminal) return false;
            }
            now.terminal = true;
        }

        return true;
    }
}