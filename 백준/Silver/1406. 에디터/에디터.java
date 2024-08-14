import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        LinkedList<Character> list = new LinkedList<>();
        for (char ch : str.toCharArray()) {
            list.add(ch);
        }

        int m = Integer.parseInt(br.readLine());
        ListIterator<Character> iter = list.listIterator(list.size());

        for (int i = 0; i < m; i++) {
            String command = br.readLine();

            if (command.charAt(0) == 'L') {
                if (iter.hasPrevious()) {
                    iter.previous();
                }
            } else if (command.charAt(0) == 'D') {
                if (iter.hasNext()) {
                    iter.next();
                }
            } else if (command.charAt(0) == 'B') {
                if (iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if (command.charAt(0) == 'P') {
                iter.add(command.charAt(2));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }

        System.out.println(sb.toString());
    }
}
