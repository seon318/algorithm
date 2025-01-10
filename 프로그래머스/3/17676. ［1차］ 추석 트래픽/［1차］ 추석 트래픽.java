import java.util.*;

class Solution {
    class Node {
        int start;
        int end;
        Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[] lines) {
        PriorityQueue<Node> startQueue = new PriorityQueue<>((o1, o2) -> o1.start - o2.start);
        PriorityQueue<Node> endQueue = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);

        String[] part;
        int start, time, end;
        int answer = 1;

        for (String line : lines) {
            part = line.split(" ");
            end = (Integer.parseInt(part[1].substring(0, 2)) * 3600 + Integer.parseInt(part[1].substring(3, 5)) * 60 +  Integer.parseInt(part[1].substring(6, 8))) * 1000 + Integer.parseInt(part[1].substring(9, 12));
            time = (int) (Double.parseDouble(part[2].substring(0, part[2].length() - 1)) * 1000);
            start = end - time + 1;
            startQueue.add(new Node(start, end));
        }
                
        while (!startQueue.isEmpty()) {
            Node now = startQueue.poll();
            endQueue.add(now);
            while (!endQueue.isEmpty() && endQueue.peek().end <= now.start - 1000) {
                endQueue.poll();
            }
            answer = Math.max(answer, endQueue.size());
        }
        
        return answer;
    }
}