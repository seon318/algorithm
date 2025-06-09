import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        outer: for (int t = 0; t < T; t++) {
            Deque<Integer> deque = new LinkedList<>();
            boolean isReversed = false;

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String input = br.readLine();

            input = input.substring(1, input.length() - 1);
            if (n > 0) {
                String[] tokens = input.split(",");
                for (String token : tokens) {
                    deque.add(Integer.parseInt(token));
                }
            }

            for (char c : p.toCharArray()) {
                if (c == 'R') isReversed = !isReversed;
                else {
                    if (deque.isEmpty()) {
                        sb.append("error").append('\n');
                        continue outer;
                    }
                    if (isReversed) deque.removeLast();
                    else deque.removeFirst();
                }
            }

            sb.append('[');
            while (!deque.isEmpty()) {
                sb.append(isReversed ? deque.removeLast() : deque.removeFirst());
                if (!deque.isEmpty()) sb.append(',');
            }
            sb.append(']').append('\n');
        }
        System.out.println(sb);
    }
}
